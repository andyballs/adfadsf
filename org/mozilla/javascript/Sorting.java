//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public final class Sorting
{
    private static final int SMALLSORT = 16;
    private static final Sorting sorting;
    
    private Sorting() {
    }
    
    public static Sorting get() {
        return Sorting.sorting;
    }
    
    public void insertionSort(final Object[] a, final Comparator<Object> cmp) {
        this.insertionSort(a, 0, a.length - 1, cmp);
    }
    
    private void insertionSort(final Object[] a, final int start, final int end, final Comparator<Object> cmp) {
        for (int i = start; i <= end; ++i) {
            Object x;
            int j;
            for (x = a[i], j = i - 1; j >= start && cmp.compare(a[j], x) > 0; --j) {
                a[j + 1] = a[j];
            }
            a[j + 1] = x;
        }
    }
    
    public void hybridSort(final Object[] a, final Comparator<Object> cmp) {
        this.hybridSort(a, 0, a.length - 1, cmp, this.log2(a.length) * 2);
    }
    
    private void hybridSort(final Object[] a, final int start, final int end, final Comparator<Object> cmp, final int maxdepth) {
        if (start < end) {
            if (maxdepth == 0 || end - start <= 16) {
                this.insertionSort(a, start, end, cmp);
            }
            else {
                final int p = this.partition(a, start, end, cmp);
                this.hybridSort(a, start, p, cmp, maxdepth - 1);
                this.hybridSort(a, p + 1, end, cmp, maxdepth - 1);
            }
        }
    }
    
    private int partition(final Object[] a, final int start, final int end, final Comparator<Object> cmp) {
        final int p = this.median(a, start, end, cmp);
        final Object pivot = a[p];
        a[p] = a[start];
        a[start] = pivot;
        int i = start;
        int j = end + 1;
        while (true) {
            if (cmp.compare(a[++i], pivot) >= 0 || i == end) {
                while (cmp.compare(a[--j], pivot) >= 0 && j != start) {}
                if (i >= j) {
                    break;
                }
                this.swap(a, i, j);
            }
        }
        this.swap(a, start, j);
        return j;
    }
    
    private void swap(final Object[] a, final int l, final int h) {
        final Object tmp = a[l];
        a[l] = a[h];
        a[h] = tmp;
    }
    
    private int log2(final int n) {
        return (int)(Math.log10(n) / Math.log10(2.0));
    }
    
    public int median(final Object[] a, final int start, final int end, final Comparator<Object> cmp) {
        final int m = start + (end - start) / 2;
        int smallest = start;
        if (cmp.compare(a[smallest], a[m]) > 0) {
            smallest = m;
        }
        if (cmp.compare(a[smallest], a[end]) > 0) {
            smallest = end;
        }
        if (smallest == start) {
            return (cmp.compare(a[m], a[end]) < 0) ? m : end;
        }
        if (smallest == m) {
            return (cmp.compare(a[start], a[end]) < 0) ? start : end;
        }
        return (cmp.compare(a[start], a[m]) < 0) ? start : m;
    }
    
    static {
        sorting = new Sorting();
    }
}
