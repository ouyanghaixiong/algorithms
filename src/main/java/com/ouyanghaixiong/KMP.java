package com.ouyanghaixiong;

import java.util.Arrays;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/20
 * @desc
 */
public class KMP {
    public static int search(String s, String p) {
        if (s == null || p == null) {
            return -1;
        }
        int m = s.length();
        int n = p.length();
        if (m == 0 || n == 0) {
            return -1;
        }

        int[] next = getNext(p);
        int i = 0;
        int j = 0;
        while (i < m) {
            if (s.charAt(i) == p.charAt(j)) {
                if (j == n - 1) {
                    return i - n + 1;
                }
                i++; j++;
                continue;
            }
            if (j > 0) {
                j = next[j - 1] + 1;
                continue;
            }
            i++;
        }

        return -1;
    }

    protected static int[] getNext(String p) {
        int[] next = new int[p.length()];
        Arrays.fill(next, -1);
        int j = 0;
        for (int i = 1; i < next.length; i++) {
            if (p.charAt(i) == p.charAt(j)) {
                next[i] = j++;
                continue;
            }
            while (next[j] >= 0) {
                j = next[j];
                if (p.charAt(i) == p.charAt(j)) {
                    next[i] = j++;
                }
            }
        }

        return next;
    }
}
