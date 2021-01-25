package com.yaoyue.leetcode.dynamic;

/**
 * @description: 判断子序列
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/24 14:44
 **/
public class LeetCode392 {

    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null || s.length() > t.length()) {
            return false;
        }

        int left = 0, right = 0;
        while(left < s.length() && right < t.length()) {
            if(s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }

        return left == s.length();
    }

    /**
     * 动态规划解法
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        int slen = s.length(), tlen = t.length();

        if(slen > tlen) {
            return false;
        }
        if(slen == 0) {
            return true;
        }

        boolean[][] dp = new boolean[slen + 1][tlen + 1];
        for(int i = 0; i < tlen; i++) {
            dp[0][i] = true;
        }

        for(int i = 1; i <= slen; i++) {
            for(int j = 1; j <= tlen; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[slen][tlen];
    }

    /**
     * 暴力递归解法
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        if(s == null || t == null || s.length() > t.length()) {
            return false;
        }
        return process(s, t, 0, 0);
    }

    public boolean process(String s, String t, int i, int j) {
        if(i == s.length()) {
            return true;
        }
        if(j == t.length()) {
            return false;
        }

        if(s.charAt(i) == t.charAt(j)) {
            return process(s, t, i + 1, j + 1);
        } else {
            return process(s, t, i, j + 1);
        }
    }
}
