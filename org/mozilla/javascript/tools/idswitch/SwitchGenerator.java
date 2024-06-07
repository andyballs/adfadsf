//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.idswitch;

import org.mozilla.javascript.tools.*;
import org.mozilla.javascript.*;

public class SwitchGenerator
{
    String v_switch_label;
    String v_label;
    String v_s;
    String v_c;
    String v_guess;
    String v_id;
    String v_length_suffix;
    int use_if_threshold;
    int char_tail_test_threshold;
    private IdValuePair[] pairs;
    private String default_value;
    private int[] columns;
    private boolean c_was_defined;
    private CodePrinter P;
    private ToolErrorReporter R;
    private String source_file;
    
    public SwitchGenerator() {
        this.v_switch_label = "L0";
        this.v_label = "L";
        this.v_s = "s";
        this.v_c = "c";
        this.v_guess = "X";
        this.v_id = "id";
        this.v_length_suffix = "_length";
        this.use_if_threshold = 3;
        this.char_tail_test_threshold = 2;
    }
    
    public CodePrinter getCodePrinter() {
        return this.P;
    }
    
    public void setCodePrinter(final CodePrinter value) {
        this.P = value;
    }
    
    public ToolErrorReporter getReporter() {
        return this.R;
    }
    
    public void setReporter(final ToolErrorReporter value) {
        this.R = value;
    }
    
    public String getSourceFileName() {
        return this.source_file;
    }
    
    public void setSourceFileName(final String value) {
        this.source_file = value;
    }
    
    public void generateSwitch(final String[] pairs, final String default_value) {
        final int N = pairs.length / 2;
        final IdValuePair[] id_pairs = new IdValuePair[N];
        for (int i = 0; i != N; ++i) {
            id_pairs[i] = new IdValuePair(pairs[2 * i], pairs[2 * i + 1]);
        }
        this.generateSwitch(id_pairs, default_value);
    }
    
    public void generateSwitch(final IdValuePair[] pairs, final String default_value) {
        final int begin = 0;
        final int end = pairs.length;
        if (begin == end) {
            return;
        }
        this.pairs = pairs;
        this.default_value = default_value;
        this.generate_body(begin, end, 2);
    }
    
    private void generate_body(final int begin, final int end, final int indent_level) {
        this.P.indent(indent_level);
        this.P.p(this.v_switch_label);
        this.P.p(": { ");
        this.P.p(this.v_id);
        this.P.p(" = ");
        this.P.p(this.default_value);
        this.P.p("; String ");
        this.P.p(this.v_guess);
        this.P.p(" = null;");
        this.c_was_defined = false;
        final int c_def_begin = this.P.getOffset();
        this.P.p(" int ");
        this.P.p(this.v_c);
        this.P.p(';');
        final int c_def_end = this.P.getOffset();
        this.P.nl();
        this.generate_length_switch(begin, end, indent_level + 1);
        if (!this.c_was_defined) {
            this.P.erase(c_def_begin, c_def_end);
        }
        this.P.indent(indent_level + 1);
        this.P.p("if (");
        this.P.p(this.v_guess);
        this.P.p("!=null && ");
        this.P.p(this.v_guess);
        this.P.p("!=");
        this.P.p(this.v_s);
        this.P.p(" && !");
        this.P.p(this.v_guess);
        this.P.p(".equals(");
        this.P.p(this.v_s);
        this.P.p(")) ");
        this.P.p(this.v_id);
        this.P.p(" = ");
        this.P.p(this.default_value);
        this.P.p(";");
        this.P.nl();
        this.P.indent(indent_level + 1);
        this.P.p("break ");
        this.P.p(this.v_switch_label);
        this.P.p(";");
        this.P.nl();
        this.P.line(indent_level, "}");
    }
    
    private void generate_length_switch(final int begin, final int end, final int indent_level) {
        this.sort_pairs(begin, end, -1);
        this.check_all_is_different(begin, end);
        final int lengths_count = this.count_different_lengths(begin, end);
        this.columns = new int[this.pairs[end - 1].idLength];
        boolean use_if;
        if (lengths_count <= this.use_if_threshold) {
            use_if = true;
            if (lengths_count != 1) {
                this.P.indent(indent_level);
                this.P.p("int ");
                this.P.p(this.v_s);
                this.P.p(this.v_length_suffix);
                this.P.p(" = ");
                this.P.p(this.v_s);
                this.P.p(".length();");
                this.P.nl();
            }
        }
        else {
            use_if = false;
            this.P.indent(indent_level);
            this.P.p(this.v_label);
            this.P.p(": switch (");
            this.P.p(this.v_s);
            this.P.p(".length()) {");
            this.P.nl();
        }
        int same_length_begin = begin;
        int cur_l = this.pairs[begin].idLength;
        int l = 0;
        int i = begin;
        while (true) {
            if (++i == end || (l = this.pairs[i].idLength) != cur_l) {
                int next_indent;
                if (use_if) {
                    this.P.indent(indent_level);
                    if (same_length_begin != begin) {
                        this.P.p("else ");
                    }
                    this.P.p("if (");
                    if (lengths_count == 1) {
                        this.P.p(this.v_s);
                        this.P.p(".length()==");
                    }
                    else {
                        this.P.p(this.v_s);
                        this.P.p(this.v_length_suffix);
                        this.P.p("==");
                    }
                    this.P.p(cur_l);
                    this.P.p(") {");
                    next_indent = indent_level + 1;
                }
                else {
                    this.P.indent(indent_level);
                    this.P.p("case ");
                    this.P.p(cur_l);
                    this.P.p(":");
                    next_indent = indent_level + 1;
                }
                this.generate_letter_switch(same_length_begin, i, next_indent, !use_if, use_if);
                if (use_if) {
                    this.P.p("}");
                    this.P.nl();
                }
                else {
                    this.P.p("break ");
                    this.P.p(this.v_label);
                    this.P.p(";");
                    this.P.nl();
                }
                if (i == end) {
                    break;
                }
                same_length_begin = i;
                cur_l = l;
            }
        }
        if (!use_if) {
            this.P.indent(indent_level);
            this.P.p("}");
            this.P.nl();
        }
    }
    
    private void generate_letter_switch(final int begin, final int end, final int indent_level, final boolean label_was_defined, final boolean inside_if) {
        final int L = this.pairs[begin].idLength;
        for (int i = 0; i != L; ++i) {
            this.columns[i] = i;
        }
        this.generate_letter_switch_r(begin, end, L, indent_level, label_was_defined, inside_if);
    }
    
    private boolean generate_letter_switch_r(final int begin, final int end, final int L, final int indent_level, boolean label_was_defined, final boolean inside_if) {
        boolean next_is_unreachable = false;
        if (begin + 1 == end) {
            this.P.p(' ');
            final IdValuePair pair = this.pairs[begin];
            if (L > this.char_tail_test_threshold) {
                this.P.p(this.v_guess);
                this.P.p("=");
                this.P.qstring(pair.id);
                this.P.p(";");
                this.P.p(this.v_id);
                this.P.p("=");
                this.P.p(pair.value);
                this.P.p(";");
            }
            else if (L == 0) {
                next_is_unreachable = true;
                this.P.p(this.v_id);
                this.P.p("=");
                this.P.p(pair.value);
                this.P.p("; break ");
                this.P.p(this.v_switch_label);
                this.P.p(";");
            }
            else {
                this.P.p("if (");
                int column = this.columns[0];
                this.P.p(this.v_s);
                this.P.p(".charAt(");
                this.P.p(column);
                this.P.p(")==");
                this.P.qchar((int)pair.id.charAt(column));
                for (int i = 1; i != L; ++i) {
                    this.P.p(" && ");
                    column = this.columns[i];
                    this.P.p(this.v_s);
                    this.P.p(".charAt(");
                    this.P.p(column);
                    this.P.p(")==");
                    this.P.qchar((int)pair.id.charAt(column));
                }
                this.P.p(") {");
                this.P.p(this.v_id);
                this.P.p("=");
                this.P.p(pair.value);
                this.P.p("; break ");
                this.P.p(this.v_switch_label);
                this.P.p(";}");
            }
            this.P.p(' ');
            return next_is_unreachable;
        }
        final int max_column_index = this.find_max_different_column(begin, end, L);
        final int max_column = this.columns[max_column_index];
        final int count = this.count_different_chars(begin, end, max_column);
        this.columns[max_column_index] = this.columns[L - 1];
        if (inside_if) {
            this.P.nl();
            this.P.indent(indent_level);
        }
        else {
            this.P.p(' ');
        }
        boolean use_if;
        if (count <= this.use_if_threshold) {
            use_if = true;
            this.c_was_defined = true;
            this.P.p(this.v_c);
            this.P.p("=");
            this.P.p(this.v_s);
            this.P.p(".charAt(");
            this.P.p(max_column);
            this.P.p(");");
        }
        else {
            use_if = false;
            if (!label_was_defined) {
                label_was_defined = true;
                this.P.p(this.v_label);
                this.P.p(": ");
            }
            this.P.p("switch (");
            this.P.p(this.v_s);
            this.P.p(".charAt(");
            this.P.p(max_column);
            this.P.p(")) {");
        }
        int same_char_begin = begin;
        int cur_ch = this.pairs[begin].id.charAt(max_column);
        int ch = 0;
        int j = begin;
        while (true) {
            if (++j == end || (ch = this.pairs[j].id.charAt(max_column)) != cur_ch) {
                int next_indent;
                if (use_if) {
                    this.P.nl();
                    this.P.indent(indent_level);
                    if (same_char_begin != begin) {
                        this.P.p("else ");
                    }
                    this.P.p("if (");
                    this.P.p(this.v_c);
                    this.P.p("==");
                    this.P.qchar(cur_ch);
                    this.P.p(") {");
                    next_indent = indent_level + 1;
                }
                else {
                    this.P.nl();
                    this.P.indent(indent_level);
                    this.P.p("case ");
                    this.P.qchar(cur_ch);
                    this.P.p(":");
                    next_indent = indent_level + 1;
                }
                final boolean after_unreachable = this.generate_letter_switch_r(same_char_begin, j, L - 1, next_indent, label_was_defined, use_if);
                if (use_if) {
                    this.P.p("}");
                }
                else if (!after_unreachable) {
                    this.P.p("break ");
                    this.P.p(this.v_label);
                    this.P.p(";");
                }
                if (j == end) {
                    break;
                }
                same_char_begin = j;
                cur_ch = ch;
            }
        }
        if (use_if) {
            this.P.nl();
            if (inside_if) {
                this.P.indent(indent_level - 1);
            }
            else {
                this.P.indent(indent_level);
            }
        }
        else {
            this.P.nl();
            this.P.indent(indent_level);
            this.P.p("}");
            if (inside_if) {
                this.P.nl();
                this.P.indent(indent_level - 1);
            }
            else {
                this.P.p(' ');
            }
        }
        this.columns[max_column_index] = max_column;
        return next_is_unreachable;
    }
    
    private int count_different_lengths(int begin, final int end) {
        int lengths_count = 0;
        int cur_l = -1;
        while (begin != end) {
            final int l = this.pairs[begin].idLength;
            if (cur_l != l) {
                ++lengths_count;
                cur_l = l;
            }
            ++begin;
        }
        return lengths_count;
    }
    
    private int find_max_different_column(final int begin, final int end, final int L) {
        int max_count = 0;
        int max_index = 0;
        for (int i = 0; i != L; ++i) {
            final int column = this.columns[i];
            this.sort_pairs(begin, end, column);
            final int count = this.count_different_chars(begin, end, column);
            if (count == end - begin) {
                return i;
            }
            if (max_count < count) {
                max_count = count;
                max_index = i;
            }
        }
        if (max_index != L - 1) {
            this.sort_pairs(begin, end, this.columns[max_index]);
        }
        return max_index;
    }
    
    private int count_different_chars(int begin, final int end, final int column) {
        int chars_count = 0;
        int cur_ch = -1;
        while (begin != end) {
            final int ch = this.pairs[begin].id.charAt(column);
            if (ch != cur_ch) {
                ++chars_count;
                cur_ch = ch;
            }
            ++begin;
        }
        return chars_count;
    }
    
    private void check_all_is_different(int begin, final int end) {
        if (begin != end) {
            IdValuePair prev = this.pairs[begin];
            while (++begin != end) {
                final IdValuePair current = this.pairs[begin];
                if (prev.id.equals(current.id)) {
                    throw this.on_same_pair_fail(prev, current);
                }
                prev = current;
            }
        }
    }
    
    private EvaluatorException on_same_pair_fail(final IdValuePair a, final IdValuePair b) {
        int line1 = a.getLineNumber();
        int line2 = b.getLineNumber();
        if (line2 > line1) {
            final int tmp = line1;
            line1 = line2;
            line2 = tmp;
        }
        final String error_text = ToolErrorReporter.getMessage("msg.idswitch.same_string", a.id, new Integer(line2));
        return this.R.runtimeError(error_text, this.source_file, line1, null, 0);
    }
    
    private void sort_pairs(final int begin, final int end, final int comparator) {
        heap4Sort(this.pairs, begin, end - begin, comparator);
    }
    
    private static boolean bigger(final IdValuePair a, final IdValuePair b, final int comparator) {
        if (comparator >= 0) {
            return a.id.charAt(comparator) > b.id.charAt(comparator);
        }
        final int diff = a.idLength - b.idLength;
        if (diff != 0) {
            return diff > 0;
        }
        return a.id.compareTo(b.id) > 0;
    }
    
    private static void heap4Sort(final IdValuePair[] array, final int offset, int size, final int comparator) {
        if (size <= 1) {
            return;
        }
        makeHeap4(array, offset, size, comparator);
        while (size > 1) {
            --size;
            final IdValuePair v1 = array[offset + size];
            final IdValuePair v2 = array[offset + 0];
            array[offset + size] = v2;
            array[offset + 0] = v1;
            heapify4(array, offset, size, 0, comparator);
        }
    }
    
    private static void makeHeap4(final IdValuePair[] array, final int offset, final int size, final int comparator) {
        int i = size + 2 >> 2;
        while (i != 0) {
            --i;
            heapify4(array, offset, size, i, comparator);
        }
    }
    
    private static void heapify4(final IdValuePair[] array, final int offset, final int size, int i, final int comparator) {
        final IdValuePair i_val = array[offset + i];
        while (true) {
            final int base = i << 2;
            int new_i1 = base | 0x1;
            final int new_i2 = base | 0x2;
            int new_i3 = base | 0x3;
            final int new_i4 = base + 4;
            if (new_i4 >= size) {
                if (new_i1 < size) {
                    IdValuePair val1 = array[offset + new_i1];
                    if (new_i2 != size) {
                        final IdValuePair val2 = array[offset + new_i2];
                        if (bigger(val2, val1, comparator)) {
                            val1 = val2;
                            new_i1 = new_i2;
                        }
                        if (new_i3 != size) {
                            final IdValuePair val3 = array[offset + new_i3];
                            if (bigger(val3, val1, comparator)) {
                                val1 = val3;
                                new_i1 = new_i3;
                            }
                        }
                    }
                    if (bigger(val1, i_val, comparator)) {
                        array[offset + i] = val1;
                        array[offset + new_i1] = i_val;
                    }
                }
                return;
            }
            IdValuePair val4 = array[offset + new_i1];
            final IdValuePair val5 = array[offset + new_i2];
            IdValuePair val6 = array[offset + new_i3];
            final IdValuePair val7 = array[offset + new_i4];
            if (bigger(val5, val4, comparator)) {
                val4 = val5;
                new_i1 = new_i2;
            }
            if (bigger(val7, val6, comparator)) {
                val6 = val7;
                new_i3 = new_i4;
            }
            if (bigger(val6, val4, comparator)) {
                val4 = val6;
                new_i1 = new_i3;
            }
            if (bigger(i_val, val4, comparator)) {
                return;
            }
            array[offset + i] = val4;
            array[offset + new_i1] = i_val;
            i = new_i1;
        }
    }
}
