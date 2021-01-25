package com.yaoyue.practice.dynamic;

/**
 * @description: 选牌问题
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/23 16:26
 **/
public class DynamicTest04 {

    public int win(int[] arr) {
        if (arr == null || arr.length < 0) {
            return 0;
        }

        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];

        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
        }
        // 默认为0，因此不需要为s[i][i]重新赋值

        for (int i = 1; i < N; i++) {
            int L = 0;
            int R = i;
            while (L < N && R < N) {
                f[L][R] = Math.max(arr[L] + s[L + 1][R], arr[R] + s[L][R - 1]);
                s[L][R] = Math.max(arr[L] + f[L + 1][R], arr[R] + s[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(f[0][N - 1], s[0][N - 1]);
    }
}
