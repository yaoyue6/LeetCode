package com.yaoyue.practice.dynamic;

/**
 * @description: 数字字符串到字母的转化方式
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/23 15:42
 **/
public class DynamicTest03 {

    /**
     * 动态规划解法
     * @param str
     * @return
     */
    public int process(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int N = chars.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;

        for (int i = N - 1; i >= 0; i--) {
            // 0没有对应的转化方式，返回0
            if (chars[i] == '0') {
                dp[i] = dp[i + 1];
            } else if (chars[i] == '1') {
                // index作为独立位置时的转化方式
                dp[i] = dp[i + 1];
                if (i + 1 < chars.length) {
                    // index和index + 1作为独立位置时的转化方式
                    dp[i] += dp[i + 2];
                }
            } else if (chars[i] == '2') {
                // index作为独立位置时的转化方式
                dp[i] = dp[i + 1];
                if (chars[i + 1] - '0' >= 0 && chars[i + 1] - '0' <= 6) {
                    // index和index + 1作为独立位置时的转化方式
                    dp[i] += dp[i + 2];
                }
            } else {
                // 比3大的数只能作为独立位置进行转化
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
