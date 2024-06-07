//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.utils;

import kotlin.*;
import org.jetbrains.annotations.*;
import java.util.*;
import gg.essential.vigilance.data.*;
import kotlin.collections.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\b0\u0007j\n\u0012\u0006\b\u0000\u0012\u00020\b`\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n" }, d2 = { "Lcom/chattriggers/ctjs/utils/CategorySorting;", "Lgg/essential/vigilance/data/SortingBehavior;", "()V", "categories", "", "", "getCategoryComparator", "Ljava/util/Comparator;", "Lgg/essential/vigilance/data/Category;", "Lkotlin/Comparator;", "ctjs" })
public final class CategorySorting extends SortingBehavior
{
    @NotNull
    public static final CategorySorting INSTANCE;
    @NotNull
    private static final List<String> categories;
    
    private CategorySorting() {
    }
    
    @NotNull
    public Comparator<? super Category> getCategoryComparator() {
        return CategorySorting::getCategoryComparator$lambda-1;
    }
    
    private static final int getCategoryComparator$lambda-1(final Category o1, final Category o2) {
        if (!CategorySorting.categories.contains(o1.getName()) || !CategorySorting.categories.contains(o2.getName())) {
            final int n = 0;
            throw new IllegalArgumentException("All categories must be in the list of categories".toString());
        }
        return CategorySorting.categories.indexOf(o1.getName()) - CategorySorting.categories.indexOf(o2.getName());
    }
    
    static {
        INSTANCE = new CategorySorting();
        categories = CollectionsKt.listOf((Object[])new String[] { "General", "Console" });
    }
}
