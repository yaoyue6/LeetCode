package com.yaoyue.leetcode.primary;

import java.util.Arrays;

public class KMPTest {

    public static void main(String[] args) {
        String str1 = "abaabaabacacaabaabcc";
        String str2 = "abaabc";

        System.out.println(Arrays.toString(kmpNext(str2)));
        System.out.println(kmpSearch(str1, str2, kmpNext(str2)));
    }

    // 获取到一个子串的部分匹配表
    public static int[] kmpNext(String str) {
        // 创建next数组保存部分匹配项
        int[] next = new int[str.length()];

        // 如果字符串的长度为1，则部分匹配值为0
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < next.length; i++) {
            if(str.charAt(j) == str.charAt(i)) {
                // 当str.charAt(j) == str.charAt(i)满足时，部分匹配值 + 1
                j++;
            } else {
                if(j > 0) {
                    // 当str.charAt(j) == str.charAt(i)满足时，从next[j - 1]处获取部分匹配值
                    j = next[j - 1];
                }
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * @param str1：原字符串
     * @param str2：子串
     * @param next：子串对应的部分匹配表
     * @return
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        int j = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) == str2.charAt(j)) {
                j++;
            } else {
                if(j > 0) {
                    j = next[j - 1];
                }
            }

            if(j == str2.length()) {
                System.out.println(j + " " + i);
                return i - j + 1;
            }
        }

        return -1;
    }
}
