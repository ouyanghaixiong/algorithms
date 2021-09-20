package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/19
 * @desc
 */
public class RobinKarp {
    public static int search(String s, String p) {
        if (s == null || p == null) {
            return -1;
        }
        int m = s.length();
        int n = p.length();
        if (m == 0 || n == 0) {
            return -1;
        }

        int hashP = hash(p);
        int hashCur = hash(s.substring(0, n));
        for (int i = 0; i <= m - n; i++) {
            String curStr = s.substring(i, i + n);
            if (i > 0) {
                hashCur = hashCur - s.charAt(i - 1) + s.charAt(i - 1 + n);
            }
            if (hashCur != hashP) {
                continue;
            }
            boolean equal = true;
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) != curStr.charAt(j)) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                return i;
            }
        }

        return -1;
    }

    private static int hash(String s) {
        char[] chars = s.toCharArray();
        int hashCode = 0;
        for (char aChar : chars) {
            hashCode += aChar - 'a';
        }

        return hashCode;
    }
}
