package com.yaoyue.practice.dynamic;

/**
 * @description: 一共有N个位置，机器人起始位置在M处，要到达P处，必须走K步，一共有多少种解法
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/22 17:18
 **/
public class DynamicTest01 {

    /**
     * 暴力递归解法
     * @param N 总位置
     * @param P 目的地
     * @param M 起始位置
     * @param K 步数
     * @return
     */
    public int ways1(int N, int P, int M, int K) {
        if (N < 2 || K < 1 || M < 1 || P < 1 || N < P || N < M) {
            return 0;
        }

        return walk1(N, P, M, K);
    }

    public int walk1(int N, int P, int cur, int res) {
        if (res == 0) {
            return cur == P ? 1 : 0;
        }

        // 当前位置在1时，只能往2位置走
        if (cur == 1) {
            return walk1(N, P, 2, res - 1);
        }

        // 当前位置在最后时，只能往N - 1位置走
        if (cur == N) {
            return walk1(N, P, N - 1, res - 1);
        }
        return walk1(N, P, cur + 1, res - 1) + walk1(N, P, cur - 1, res - 1);
    }

    /**
     * 使用缓存来记录递归结果，避免重复计算
     * @param N
     * @param P
     * @param M
     * @param K
     * @return
     */
    public int ways2(int N, int P, int M, int K) {
        if (N < 2 || K < 1 || M < 1 || P < 1 || N < P || N < M) {
            return 0;
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for(int j = 0; j <= K; j++) {
                dp[i][j] = 0;
            }
        }
        return walk2(N, P, M, K, dp);
    }

    public int walk2(int N, int P, int cur, int res, int[][] dp) {
        if (res == 0) {
            dp[cur][res] = cur == P ? 1 : 0;
            return dp[cur][res];
        }

        if (cur == 1) {
            dp[cur][res] = walk2(N, P, 2, res - 1, dp);
            return dp[cur][res];
        }

        if (cur == N) {
            dp[cur][res] = walk2(N, P, N - 1, res - 1, dp);
            return dp[cur][res];
        }
        dp[cur][res] = walk2(N, P, cur + 1, res - 1, dp) + walk2(N, P, cur - 1, res - 1, dp);
        return dp[cur][res];
    }

    /**
     * 动态规划解法
     * @param N
     * @param P
     * @param M
     * @param K
     * @return
     */
    public int ways3(int N, int P, int M, int K) {
        if (N < 2 || K < 1 || M < 1 || P < 1 || N < P || N < M) {
            return 0;
        }

        int[][] dp = new int[K + 1][N + 1];
        dp[K][M] = 1;
        for (int i = K; i >= 0; i--) {
            for(int j = 0; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[0][N + 1];
    }
}
