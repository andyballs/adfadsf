//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import com.chattriggers.ctjs.engine.*;
import org.mozilla.javascript.regexp.*;
import kotlin.*;
import net.minecraftforge.client.event.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import kotlin.text.*;
import kotlin.ranges.*;
import kotlin.collections.*;
import kotlin.jvm.internal.*;
import java.util.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001.B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u001f\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0017\"\u00020\u0015¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0018\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0018\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\u0006\u0010\u001f\u001a\u00020\u0015H\u0002J\u0006\u0010 \u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0000J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0000J\u0006\u0010%\u001a\u00020\u0000J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u001f\u0010'\u001a\u00020\u00002\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0017\"\u00020\u0015¢\u0006\u0002\u0010\u0018J\u0006\u0010(\u001a\u00020\u0000J\u001f\u0010)\u001a\u00020*2\u0010\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0017H\u0016¢\u0006\u0002\u0010,J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/" }, d2 = { "Lcom/chattriggers/ctjs/triggers/ChatTrigger;", "Lcom/chattriggers/ctjs/triggers/Trigger;", "method", "", "type", "Lcom/chattriggers/ctjs/triggers/TriggerType;", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Ljava/lang/Object;Lcom/chattriggers/ctjs/triggers/TriggerType;Lcom/chattriggers/ctjs/engine/ILoader;)V", "caseInsensitive", "", "chatCriteria", "criteriaPattern", "Lkotlin/text/Regex;", "formatted", "parameters", "", "Lcom/chattriggers/ctjs/triggers/ChatTrigger$Parameter;", "triggerIfCanceled", "addParameter", "parameter", "", "addParameters", "", "([Ljava/lang/String;)Lcom/chattriggers/ctjs/triggers/ChatTrigger;", "getChatMessage", "chatEvent", "Lnet/minecraftforge/client/event/ClientChatReceivedEvent;", "chatMessage", "getVariables", "matchesChatCriteria", "chat", "setCaseInsensitive", "setChatCriteria", "setContains", "setCriteria", "setEnd", "setExact", "setParameter", "setParameters", "setStart", "trigger", "", "args", "([Ljava/lang/Object;)V", "bool", "Parameter", "ctjs" })
public final class ChatTrigger extends Trigger
{
    private Object chatCriteria;
    private boolean formatted;
    private boolean caseInsensitive;
    private Regex criteriaPattern;
    @NotNull
    private final List<Parameter> parameters;
    private boolean triggerIfCanceled;
    
    public ChatTrigger(@NotNull final Object method, @NotNull final TriggerType type, @NotNull final ILoader loader) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        super(method, type, loader);
        this.parameters = new ArrayList<Parameter>();
        this.triggerIfCanceled = true;
    }
    
    @NotNull
    public final ChatTrigger triggerIfCanceled(final boolean bool) {
        final ChatTrigger $this$triggerIfCanceled_u24lambda_u2d0 = this;
        final int n = 0;
        $this$triggerIfCanceled_u24lambda_u2d0.triggerIfCanceled = bool;
        return this;
    }
    
    @NotNull
    public final ChatTrigger setChatCriteria(@NotNull final Object chatCriteria) {
        Intrinsics.checkNotNullParameter(chatCriteria, "chatCriteria");
        final ChatTrigger $this$setChatCriteria_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setChatCriteria_u24lambda_u2d2.chatCriteria = chatCriteria;
        final Set flags = new LinkedHashSet();
        String source = ".+";
        if (chatCriteria instanceof String) {
            $this$setChatCriteria_u24lambda_u2d2.formatted = new Regex("[&§]").containsMatchIn((CharSequence)chatCriteria);
            final String replacedCriteria = new Regex("\\$\\{\\*?}").replace((CharSequence)new Regex("\\$\\{[^*]+?}").replace((CharSequence)Regex.Companion.escape(StringsKt.replace$default((String)chatCriteria, "\n", "->newLine<-", false, 4, (Object)null)), "\\\\E(.+)\\\\Q"), "\\\\E(?:.+)\\\\Q");
            if ($this$setChatCriteria_u24lambda_u2d2.caseInsensitive) {
                flags.add(RegexOption.IGNORE_CASE);
            }
            if (!Intrinsics.areEqual((Object)"", chatCriteria)) {
                source = replacedCriteria;
            }
        }
        else {
            if (!(chatCriteria instanceof NativeRegExp)) {
                throw new IllegalArgumentException("Expected String or Regexp Object");
            }
            final Object value = ((NativeRegExp)chatCriteria).get((Object)"ignoreCase");
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            if ((boolean)value || $this$setChatCriteria_u24lambda_u2d2.caseInsensitive) {
                flags.add(RegexOption.IGNORE_CASE);
            }
            final Object value2 = ((NativeRegExp)chatCriteria).get((Object)"multiline");
            if (value2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            if (value2) {
                flags.add(RegexOption.MULTILINE);
            }
            final Object value3 = ((NativeRegExp)chatCriteria).get((Object)"source");
            if (value3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            final String it = (String)value3;
            final int n2 = 0;
            source = (Intrinsics.areEqual((Object)"", (Object)it) ? ".+" : it);
            $this$setChatCriteria_u24lambda_u2d2.formatted = new Regex("[&§]").containsMatchIn((CharSequence)source);
        }
        $this$setChatCriteria_u24lambda_u2d2.criteriaPattern = new Regex(source, flags);
        return this;
    }
    
    @NotNull
    public final ChatTrigger setCriteria(@NotNull final Object chatCriteria) {
        Intrinsics.checkNotNullParameter(chatCriteria, "chatCriteria");
        return this.setChatCriteria(chatCriteria);
    }
    
    @NotNull
    public final ChatTrigger setParameter(@NotNull final String parameter) {
        Intrinsics.checkNotNullParameter((Object)parameter, "parameter");
        final ChatTrigger $this$setParameter_u24lambda_u2d3 = this;
        final int n = 0;
        $this$setParameter_u24lambda_u2d3.parameters.clear();
        $this$setParameter_u24lambda_u2d3.addParameter(parameter);
        return this;
    }
    
    @NotNull
    public final ChatTrigger setParameters(@NotNull final String... parameters) {
        Intrinsics.checkNotNullParameter((Object)parameters, "parameters");
        final ChatTrigger $this$setParameters_u24lambda_u2d4 = this;
        final int n = 0;
        $this$setParameters_u24lambda_u2d4.parameters.clear();
        $this$setParameters_u24lambda_u2d4.addParameters((String[])Arrays.copyOf(parameters, parameters.length));
        return this;
    }
    
    @NotNull
    public final ChatTrigger addParameter(@NotNull final String parameter) {
        Intrinsics.checkNotNullParameter((Object)parameter, "parameter");
        final ChatTrigger $this$addParameter_u24lambda_u2d5 = this;
        final int n = 0;
        $this$addParameter_u24lambda_u2d5.parameters.add(Parameter.Companion.getParameterByName(parameter));
        return this;
    }
    
    @NotNull
    public final ChatTrigger addParameters(@NotNull final String... parameters) {
        Intrinsics.checkNotNullParameter((Object)parameters, "parameters");
        final ChatTrigger $this$addParameters_u24lambda_u2d6 = this;
        final int n = 0;
        final Object[] $this$forEach$iv = parameters;
        final int $i$f$forEach = 0;
        for (int i = 0; i < $this$forEach$iv.length; ++i) {
            final String p0;
            final Object element$iv = p0 = (String)$this$forEach$iv[i];
            final int n2 = 0;
            $this$addParameters_u24lambda_u2d6.addParameter(p0);
        }
        return this;
    }
    
    @NotNull
    public final ChatTrigger setStart() {
        final ChatTrigger $this$setStart_u24lambda_u2d7 = this;
        final int n = 0;
        $this$setStart_u24lambda_u2d7.setParameter("start");
        return this;
    }
    
    @NotNull
    public final ChatTrigger setContains() {
        final ChatTrigger $this$setContains_u24lambda_u2d8 = this;
        final int n = 0;
        $this$setContains_u24lambda_u2d8.setParameter("contains");
        return this;
    }
    
    @NotNull
    public final ChatTrigger setEnd() {
        final ChatTrigger $this$setEnd_u24lambda_u2d9 = this;
        final int n = 0;
        $this$setEnd_u24lambda_u2d9.setParameter("end");
        return this;
    }
    
    @NotNull
    public final ChatTrigger setExact() {
        final ChatTrigger $this$setExact_u24lambda_u2d10 = this;
        final int n = 0;
        $this$setExact_u24lambda_u2d10.parameters.clear();
        return this;
    }
    
    @NotNull
    public final ChatTrigger setCaseInsensitive() {
        final ChatTrigger $this$setCaseInsensitive_u24lambda_u2d11 = this;
        final int n = 0;
        $this$setCaseInsensitive_u24lambda_u2d11.caseInsensitive = true;
        if ($this$setCaseInsensitive_u24lambda_u2d11.chatCriteria != null) {
            final ChatTrigger chatTrigger = $this$setCaseInsensitive_u24lambda_u2d11;
            Object criteria;
            if ((criteria = $this$setCaseInsensitive_u24lambda_u2d11.chatCriteria) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatCriteria");
                criteria = Unit.INSTANCE;
            }
            chatTrigger.setCriteria(criteria);
        }
        return this;
    }
    
    @Override
    public void trigger(@NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        if (!(args[0] instanceof String) || !(args[1] instanceof ClientChatReceivedEvent)) {
            final int n = 0;
            throw new IllegalArgumentException("Argument 1 must be a String, Argument 2 must be a ClientChatReceivedEvent".toString());
        }
        final Object o = args[1];
        if (o == null) {
            throw new NullPointerException("null cannot be cast to non-null type net.minecraftforge.client.event.ClientChatReceivedEvent");
        }
        final ClientChatReceivedEvent chatEvent = (ClientChatReceivedEvent)o;
        if (!this.triggerIfCanceled && chatEvent.isCanceled()) {
            return;
        }
        final ClientChatReceivedEvent chatEvent2 = chatEvent;
        final Object o2 = args[0];
        if (o2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        final String chatMessage = this.getChatMessage(chatEvent2, (String)o2);
        final List<Object> variables2 = this.getVariables(chatMessage);
        if (variables2 == null) {
            return;
        }
        final List variables = variables2;
        variables.add(chatEvent);
        final Collection $this$toTypedArray$iv = variables;
        final int $i$f$toTypedArray = 0;
        final Collection thisCollection$iv = $this$toTypedArray$iv;
        final Object[] array = thisCollection$iv.toArray(new Object[0]);
        Intrinsics.checkNotNull((Object)array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.callMethod(array);
    }
    
    private final String getChatMessage(final ClientChatReceivedEvent chatEvent, final String chatMessage) {
        String s;
        if (this.formatted) {
            final String getFormattedText = EventLib.getMessage(chatEvent).getFormattedText();
            Intrinsics.checkNotNullExpressionValue((Object)getFormattedText, "getMessage(chatEvent).formattedText");
            s = StringsKt.replace$default(getFormattedText, "§", "&", false, 4, (Object)null);
        }
        else {
            s = ChatLib.removeFormatting(chatMessage);
        }
        return s;
    }
    
    private final List<Object> getVariables(final String chatMessage) {
        return (this.criteriaPattern != null) ? this.matchesChatCriteria(StringsKt.replace$default(chatMessage, "\n", "->newLine<-", false, 4, (Object)null)) : ((ArrayList<Object>)new ArrayList<Object>());
    }
    
    private final List<Object> matchesChatCriteria(final String chat) {
        Regex criteriaPattern;
        if ((criteriaPattern = this.criteriaPattern) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("criteriaPattern");
            criteriaPattern = null;
        }
        final Regex regex = criteriaPattern;
        if (this.parameters.isEmpty()) {
            if (!regex.matches((CharSequence)chat)) {
                return null;
            }
        }
        else {
            final Iterable $this$forEach$iv = this.parameters;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final Parameter parameter = (Parameter)element$iv;
                final int n = 0;
                MatchGroup matchGroup2;
                try {
                    final MatchResult find$default = Regex.find$default(regex, (CharSequence)chat, 0, 2, (Object)null);
                    MatchGroup matchGroup;
                    if (find$default == null) {
                        matchGroup = null;
                    }
                    else {
                        final MatchGroupCollection groups = find$default.getGroups();
                        matchGroup = ((groups == null) ? null : groups.get(0));
                    }
                    matchGroup2 = matchGroup;
                }
                catch (IndexOutOfBoundsException e) {
                    return null;
                }
                final MatchGroup first = matchGroup2;
                final Parameter parameter2 = parameter;
                switch ((parameter2 == null) ? -1 : WhenMappings.$EnumSwitchMapping$0[parameter2.ordinal()]) {
                    case 1: {
                        if (first == null) {
                            return null;
                        }
                        continue;
                    }
                    case 2: {
                        if (first == null || first.getRange().getFirst() != 0) {
                            return null;
                        }
                        continue;
                    }
                    case 3: {
                        final MatchGroup matchGroup3 = first;
                        boolean b;
                        if (matchGroup3 == null) {
                            b = false;
                        }
                        else {
                            final IntRange range = matchGroup3.getRange();
                            b = (range != null && range.getLast() == chat.length());
                        }
                        if (!b) {
                            return null;
                        }
                        continue;
                    }
                    case -1: {
                        if (!regex.matches((CharSequence)chat)) {
                            return null;
                        }
                        continue;
                    }
                }
            }
        }
        final MatchResult find$default2 = Regex.find$default(regex, (CharSequence)chat, 0, 2, (Object)null);
        List<Object> list;
        if (find$default2 == null) {
            list = null;
        }
        else {
            final List groupValues = find$default2.getGroupValues();
            if (groupValues == null) {
                list = null;
            }
            else {
                final List drop = CollectionsKt.drop((Iterable)groupValues, 1);
                list = (List<Object>)((drop == null) ? null : CollectionsKt.toMutableList((Collection)drop));
            }
        }
        return list;
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u001b\b\u0002\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f" }, d2 = { "Lcom/chattriggers/ctjs/triggers/ChatTrigger$Parameter;", "", "names", "", "", "(Ljava/lang/String;I[Ljava/lang/String;)V", "", "getNames", "()Ljava/util/List;", "setNames", "(Ljava/util/List;)V", "CONTAINS", "START", "END", "Companion", "ctjs" })
    public enum Parameter
    {
        @NotNull
        public static final Companion Companion;
        @NotNull
        private List<String> names;
        
        CONTAINS(new String[] { "<c>", "<contains>", "c", "contains" }), 
        START(new String[] { "<s>", "<start>", "s", "start" }), 
        END(new String[] { "<e>", "<end>", "e", "end" });
        
        private Parameter(final String[] names) {
            this.names = (List<String>)ArraysKt.asList((Object[])names);
        }
        
        @NotNull
        public final List<String> getNames() {
            return this.names;
        }
        
        public final void setNames(@NotNull final List<String> <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.names = <set-?>;
        }
        
        private static final /* synthetic */ Parameter[] $values() {
            return new Parameter[] { Parameter.CONTAINS, Parameter.START, Parameter.END };
        }
        
        static {
            $VALUES = $values();
            Companion = new Companion(null);
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007" }, d2 = { "Lcom/chattriggers/ctjs/triggers/ChatTrigger$Parameter$Companion;", "", "()V", "getParameterByName", "Lcom/chattriggers/ctjs/triggers/ChatTrigger$Parameter;", "name", "", "ctjs" })
        public static final class Companion
        {
            private Companion() {
            }
            
            @Nullable
            public final Parameter getParameterByName(@NotNull final String name) {
                Intrinsics.checkNotNullParameter((Object)name, "name");
                final Parameter[] values = Parameter.values();
                for (int i = 0; i < values.length; ++i) {
                    final Parameter param = values[i];
                    final int n = 0;
                    final Iterable $this$any$iv = param.getNames();
                    final int $i$f$any = 0;
                    boolean b = false;
                    Label_0136: {
                        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                            b = false;
                        }
                        else {
                            for (final Object element$iv : $this$any$iv) {
                                final String it = (String)element$iv;
                                final int n2 = 0;
                                final String lowerCase = it.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue((Object)lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                if (Intrinsics.areEqual((Object)lowerCase, (Object)name)) {
                                    b = true;
                                    break Label_0136;
                                }
                            }
                            b = false;
                        }
                    }
                    if (b) {
                        return param;
                    }
                }
                return null;
            }
        }
    }
}
