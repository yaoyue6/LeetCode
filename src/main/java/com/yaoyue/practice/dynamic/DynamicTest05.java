package com.yaoyue.practice.dynamic;

/**
 * @description: 换零钱问题
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/23 19:55
 **/
public class DynamicTest05 {

    /**
     * 暴力递归解法
     * @param array
     * @param aim
     * @return
     */
    public int way1(int[] array, int aim) {
        if (array == null || array.length == 0 || aim <= 0) {
            return 0;
        }
        return process1(array, 0, aim);
    }

    public int process1(int[] array, int index, int rest) {
        // 必定不可能小于0，所以可以省略
        if (rest < 0) {
            return 0;
        }

        // 如果此时达到零钱种类的最后，判断剩余空间是否为0
        if (index == array.length) {
            return rest == 0 ? 1 : 0;
        }

        int ways = 0;
        // 可换零钱数：rest / array[index]
        for (int i = 0; i <= rest / array[index]; i++) {
            ways += process1(array, index + 1, rest - array[i] * i);
        }
        return ways;
    }

    /**
     * 分支限界递归解法
     * @param array
     * @param aim
     * @return
     */
    public int way2(int[] array, int aim) {
        if (array == null || array.length == 0 || aim <= 0) {
            return 0;
        }
        int[][] dp = new int[array.length + 1][aim + 1];
        // 初始化
        for (int i = 0; i < array.length + 1; i++) {
            for (int j = 0; j < aim + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(array, 0, aim, dp);
    }

    public int process2(int[] array, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }

        // 如果此时达到零钱种类的最后，判断剩余空间是否为0
        if (index == array.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }

        int ways = 0;
        // 可换零钱数：rest / array[index]
        for (int i = 0; i <= rest / array[index]; i++) {
            ways += process1(array, index + 1, rest - array[i] * i);
        }
        dp[index][rest] = ways;
        return ways;
    }

    /**
     * 动态规划粗糙版
     * @param array
     * @param aim
     * @return
     */
    public int way4(int[] array, int aim) {
        if (array == null || array.length == 0 || aim <= 0) {
            return 0;
        }
        int[][] dp = new int[array.length + 1][aim + 1];
        for (int index = 0; index < array.length + 1; index++) {
            for (int rest = 0; rest < aim + 1; rest++) {
                int ways = 0;
                // i为当前面值的零钱数
                for (int i = 0; i <= rest / array[index]; i++) {
                    ways += dp[index + 1] [rest - array[i] * i];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    /**
     * 动态规划经典版
     * @param array
     * @param aim
     * @return
     */
    public int way5(int[] array, int aim) {
        if (array == null || array.length == 0 || aim <= 0) {
            return 0;
        }
        int[][] dp = new int[array.length + 1][aim + 1];
        for (int index = 0; index < array.length + 1; index++) {
            for (int rest = 0; rest < aim + 1; rest++) {
                // 当前位置可能性实质等于左边rest - array[index]位置处的位置以及下方index + 1位置可能性的和
                dp[index][rest] = dp[index + 1][rest];
                if (rest - array[index] >= 0) {
                    dp[index][rest] += dp[index][rest - array[index]];
                }
            }
        }
        return dp[0][aim];
    }
}
