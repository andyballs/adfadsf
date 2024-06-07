//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.idswitch;

import org.mozilla.javascript.tools.*;
import java.io.*;
import java.text.*;
import java.util.*;
import org.mozilla.javascript.*;

public class Main
{
    private static final String SWITCH_TAG_STR = "string_id_map";
    private static final String GENERATED_TAG_STR = "generated";
    private static final String STRING_TAG_STR = "string";
    private static final int NORMAL_LINE = 0;
    private static final int SWITCH_TAG = 1;
    private static final int GENERATED_TAG = 2;
    private static final int STRING_TAG = 3;
    private final List<IdValuePair> all_pairs;
    private ToolErrorReporter R;
    private CodePrinter P;
    private FileBody body;
    private String source_file;
    private int tag_definition_end;
    private int tag_value_start;
    private int tag_value_end;
    
    public Main() {
        this.all_pairs = new ArrayList<IdValuePair>();
    }
    
    private static boolean is_value_type(final int id) {
        return id == 3;
    }
    
    private static String tag_name(final int id) {
        switch (id) {
            case 1: {
                return "string_id_map";
            }
            case -1: {
                return "/string_id_map";
            }
            case 2: {
                return "generated";
            }
            case -2: {
                return "/generated";
            }
            default: {
                return "";
            }
        }
    }
    
    void process_file(final String file_path) throws IOException {
        this.source_file = file_path;
        this.body = new FileBody();
        InputStream is;
        if (file_path.equals("-")) {
            is = System.in;
        }
        else {
            is = new FileInputStream(file_path);
        }
        try {
            final Reader r = new InputStreamReader(is, "ASCII");
            this.body.readData(r);
        }
        finally {
            is.close();
        }
        this.process_file();
        if (this.body.wasModified()) {
            OutputStream os;
            if (file_path.equals("-")) {
                os = System.out;
            }
            else {
                os = new FileOutputStream(file_path);
            }
            try {
                final Writer w = new OutputStreamWriter(os);
                this.body.writeData(w);
                w.flush();
            }
            finally {
                os.close();
            }
        }
    }
    
    private void process_file() {
        int cur_state = 0;
        final char[] buffer = this.body.getBuffer();
        int generated_begin = -1;
        int generated_end = -1;
        int time_stamp_begin = -1;
        int time_stamp_end = -1;
        this.body.startLineLoop();
        while (this.body.nextLine()) {
            final int begin = this.body.getLineBegin();
            final int end = this.body.getLineEnd();
            final int tag_id = this.extract_line_tag_id(buffer, begin, end);
            boolean bad_tag = false;
            switch (cur_state) {
                case 0: {
                    if (tag_id == 1) {
                        cur_state = 1;
                        this.all_pairs.clear();
                        generated_begin = -1;
                        break;
                    }
                    if (tag_id == -1) {
                        bad_tag = true;
                        break;
                    }
                    break;
                }
                case 1: {
                    if (tag_id == 0) {
                        this.look_for_id_definitions(buffer, begin, end, false);
                        break;
                    }
                    if (tag_id == 3) {
                        this.look_for_id_definitions(buffer, begin, end, true);
                        break;
                    }
                    if (tag_id == 2) {
                        if (generated_begin >= 0) {
                            bad_tag = true;
                            break;
                        }
                        cur_state = 2;
                        time_stamp_begin = this.tag_definition_end;
                        time_stamp_end = end;
                        break;
                    }
                    else {
                        if (tag_id != -1) {
                            bad_tag = true;
                            break;
                        }
                        cur_state = 0;
                        if (generated_begin >= 0 && !this.all_pairs.isEmpty()) {
                            this.generate_java_code();
                            final String code = this.P.toString();
                            final boolean different = this.body.setReplacement(generated_begin, generated_end, code);
                            if (different) {
                                final String stamp = this.get_time_stamp();
                                this.body.setReplacement(time_stamp_begin, time_stamp_end, stamp);
                            }
                            break;
                        }
                        break;
                    }
                    break;
                }
                case 2: {
                    if (tag_id == 0) {
                        if (generated_begin < 0) {
                            generated_begin = begin;
                            break;
                        }
                        break;
                    }
                    else {
                        if (tag_id == -2) {
                            if (generated_begin < 0) {
                                generated_begin = begin;
                            }
                            cur_state = 1;
                            generated_end = begin;
                            break;
                        }
                        bad_tag = true;
                        break;
                    }
                    break;
                }
            }
            if (bad_tag) {
                final String text = ToolErrorReporter.getMessage("msg.idswitch.bad_tag_order", tag_name(tag_id));
                throw this.R.runtimeError(text, this.source_file, this.body.getLineNumber(), null, 0);
            }
        }
        if (cur_state != 0) {
            final String text2 = ToolErrorReporter.getMessage("msg.idswitch.file_end_in_switch", tag_name(cur_state));
            throw this.R.runtimeError(text2, this.source_file, this.body.getLineNumber(), null, 0);
        }
    }
    
    private String get_time_stamp() {
        final SimpleDateFormat f = new SimpleDateFormat(" 'Last update:' yyyy-MM-dd HH:mm:ss z");
        return f.format(new Date());
    }
    
    private void generate_java_code() {
        this.P.clear();
        final IdValuePair[] pairs = new IdValuePair[this.all_pairs.size()];
        this.all_pairs.toArray(pairs);
        final SwitchGenerator g = new SwitchGenerator();
        g.char_tail_test_threshold = 2;
        g.setReporter(this.R);
        g.setCodePrinter(this.P);
        g.generateSwitch(pairs, "0");
    }
    
    private int extract_line_tag_id(final char[] array, int cursor, final int end) {
        int id = 0;
        final int after_leading_white_space;
        cursor = (after_leading_white_space = skip_white_space(array, cursor, end));
        cursor = this.look_for_slash_slash(array, cursor, end);
        if (cursor != end) {
            final boolean at_line_start = after_leading_white_space + 2 == cursor;
            cursor = skip_white_space(array, cursor, end);
            if (cursor != end && array[cursor] == '#') {
                ++cursor;
                boolean end_tag = false;
                if (cursor != end && array[cursor] == '/') {
                    ++cursor;
                    end_tag = true;
                }
                final int tag_start = cursor;
                while (cursor != end) {
                    final int c = array[cursor];
                    if (c == 35 || c == 61) {
                        break;
                    }
                    if (is_white_space(c)) {
                        break;
                    }
                    ++cursor;
                }
                if (cursor != end) {
                    final int tag_end = cursor;
                    cursor = skip_white_space(array, cursor, end);
                    if (cursor != end) {
                        final int c2 = array[cursor];
                        if (c2 == 61 || c2 == 35) {
                            id = this.get_tag_id(array, tag_start, tag_end, at_line_start);
                            if (id != 0) {
                                String bad = null;
                                if (c2 == 35) {
                                    if (end_tag) {
                                        id = -id;
                                        if (is_value_type(id)) {
                                            bad = "msg.idswitch.no_end_usage";
                                        }
                                    }
                                    this.tag_definition_end = cursor + 1;
                                }
                                else {
                                    if (end_tag) {
                                        bad = "msg.idswitch.no_end_with_value";
                                    }
                                    else if (!is_value_type(id)) {
                                        bad = "msg.idswitch.no_value_allowed";
                                    }
                                    id = this.extract_tag_value(array, cursor + 1, end, id);
                                }
                                if (bad != null) {
                                    final String s = ToolErrorReporter.getMessage(bad, tag_name(id));
                                    throw this.R.runtimeError(s, this.source_file, this.body.getLineNumber(), null, 0);
                                }
                            }
                        }
                    }
                }
            }
        }
        return id;
    }
    
    private int look_for_slash_slash(final char[] array, int cursor, final int end) {
        while (cursor + 2 <= end) {
            int c = array[cursor++];
            if (c == 47) {
                c = array[cursor++];
                if (c == 47) {
                    return cursor;
                }
                continue;
            }
        }
        return end;
    }
    
    private int extract_tag_value(final char[] array, int cursor, final int end, final int id) {
        boolean found = false;
        cursor = skip_white_space(array, cursor, end);
        if (cursor != end) {
            final int value_start = cursor;
            int value_end = cursor;
            while (cursor != end) {
                final int c = array[cursor];
                if (is_white_space(c)) {
                    final int after_space = skip_white_space(array, cursor + 1, end);
                    if (after_space != end && array[after_space] == '#') {
                        value_end = cursor;
                        cursor = after_space;
                        break;
                    }
                    cursor = after_space + 1;
                }
                else {
                    if (c == 35) {
                        value_end = cursor;
                        break;
                    }
                    ++cursor;
                }
            }
            if (cursor != end) {
                found = true;
                this.tag_value_start = value_start;
                this.tag_value_end = value_end;
                this.tag_definition_end = cursor + 1;
            }
        }
        return found ? id : 0;
    }
    
    private int get_tag_id(final char[] array, final int begin, final int end, final boolean at_line_start) {
        if (at_line_start) {
            if (equals("string_id_map", array, begin, end)) {
                return 1;
            }
            if (equals("generated", array, begin, end)) {
                return 2;
            }
        }
        if (equals("string", array, begin, end)) {
            return 3;
        }
        return 0;
    }
    
    private void look_for_id_definitions(final char[] array, final int begin, final int end, final boolean use_tag_value_as_string) {
        int cursor = begin;
        final int id_start;
        cursor = (id_start = skip_white_space(array, cursor, end));
        int name_start = skip_matched_prefix("Id_", array, cursor, end);
        if (name_start >= 0) {
            cursor = name_start;
            int name_end;
            cursor = (name_end = skip_name_char(array, cursor, end));
            if (name_start != name_end) {
                cursor = skip_white_space(array, cursor, end);
                if (cursor != end && array[cursor] == '=') {
                    final int id_end = name_end;
                    if (use_tag_value_as_string) {
                        name_start = this.tag_value_start;
                        name_end = this.tag_value_end;
                    }
                    this.add_id(array, id_start, id_end, name_start, name_end);
                }
            }
        }
    }
    
    private void add_id(final char[] array, final int id_start, final int id_end, final int name_start, final int name_end) {
        final String name = new String(array, name_start, name_end - name_start);
        final String value = new String(array, id_start, id_end - id_start);
        final IdValuePair pair = new IdValuePair(name, value);
        pair.setLineNumber(this.body.getLineNumber());
        this.all_pairs.add(pair);
    }
    
    private static boolean is_white_space(final int c) {
        return c == 32 || c == 9;
    }
    
    private static int skip_white_space(final char[] array, final int begin, final int end) {
        int cursor;
        for (cursor = begin; cursor != end; ++cursor) {
            final int c = array[cursor];
            if (!is_white_space(c)) {
                break;
            }
        }
        return cursor;
    }
    
    private static int skip_matched_prefix(final String prefix, final char[] array, final int begin, final int end) {
        int cursor = -1;
        final int prefix_length = prefix.length();
        if (prefix_length <= end - begin) {
            cursor = begin;
            for (int i = 0; i != prefix_length; ++i, ++cursor) {
                if (prefix.charAt(i) != array[cursor]) {
                    cursor = -1;
                    break;
                }
            }
        }
        return cursor;
    }
    
    private static boolean equals(final String str, final char[] array, final int begin, final int end) {
        if (str.length() == end - begin) {
            for (int i = begin, j = 0; i != end; ++i, ++j) {
                if (array[i] != str.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private static int skip_name_char(final char[] array, final int begin, final int end) {
        int cursor;
        for (cursor = begin; cursor != end; ++cursor) {
            final int c = array[cursor];
            if ((97 > c || c > 122) && (65 > c || c > 90) && (48 > c || c > 57) && c != 95) {
                break;
            }
        }
        return cursor;
    }
    
    public static void main(final String[] args) {
        final Main self = new Main();
        final int status = self.exec(args);
        System.exit(status);
    }
    
    private int exec(final String[] args) {
        this.R = new ToolErrorReporter(true, System.err);
        final int arg_count = this.process_options(args);
        if (arg_count == 0) {
            this.option_error(ToolErrorReporter.getMessage("msg.idswitch.no_file_argument"));
            return -1;
        }
        if (arg_count > 1) {
            this.option_error(ToolErrorReporter.getMessage("msg.idswitch.too_many_arguments"));
            return -1;
        }
        (this.P = new CodePrinter()).setIndentStep(4);
        this.P.setIndentTabSize(0);
        try {
            this.process_file(args[0]);
        }
        catch (IOException ex) {
            this.print_error(ToolErrorReporter.getMessage("msg.idswitch.io_error", ex.toString()));
            return -1;
        }
        catch (EvaluatorException ex2) {
            return -1;
        }
        return 0;
    }
    
    private int process_options(final String[] args) {
        int status = 1;
        boolean show_usage = false;
        boolean show_version = false;
    Label_0206:
        for (int N = args.length, i = 0; i != N; ++i) {
            final String arg = args[i];
            final int arg_length = arg.length();
            if (arg_length >= 2 && arg.charAt(0) == '-') {
                if (arg.charAt(1) == '-') {
                    if (arg_length == 2) {
                        args[i] = null;
                        break;
                    }
                    if (arg.equals("--help")) {
                        show_usage = true;
                    }
                    else {
                        if (!arg.equals("--version")) {
                            this.option_error(ToolErrorReporter.getMessage("msg.idswitch.bad_option", arg));
                            status = -1;
                            break;
                        }
                        show_version = true;
                    }
                }
                else {
                    int j = 1;
                    while (j != arg_length) {
                        final char c = arg.charAt(j);
                        switch (c) {
                            case 'h': {
                                show_usage = true;
                                ++j;
                                continue;
                            }
                            default: {
                                this.option_error(ToolErrorReporter.getMessage("msg.idswitch.bad_option_char", String.valueOf(c)));
                                status = -1;
                                break Label_0206;
                            }
                        }
                    }
                }
                args[i] = null;
            }
        }
        if (status == 1) {
            if (show_usage) {
                this.show_usage();
                status = 0;
            }
            if (show_version) {
                this.show_version();
                status = 0;
            }
        }
        if (status != 1) {
            System.exit(status);
        }
        return this.remove_nulls(args);
    }
    
    private void show_usage() {
        System.out.println(ToolErrorReporter.getMessage("msg.idswitch.usage"));
        System.out.println();
    }
    
    private void show_version() {
        System.out.println(ToolErrorReporter.getMessage("msg.idswitch.version"));
    }
    
    private void option_error(final String str) {
        this.print_error(ToolErrorReporter.getMessage("msg.idswitch.bad_invocation", str));
    }
    
    private void print_error(final String text) {
        System.err.println(text);
    }
    
    private int remove_nulls(final String[] array) {
        int N;
        int cursor;
        for (N = array.length, cursor = 0; cursor != N && array[cursor] != null; ++cursor) {}
        int destination;
        if ((destination = cursor) != N) {
            ++cursor;
            while (cursor != N) {
                final String elem = array[cursor];
                if (elem != null) {
                    array[destination] = elem;
                    ++destination;
                }
                ++cursor;
            }
        }
        return destination;
    }
}
