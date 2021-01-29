package com.yaoyue.leetcode.dynamic;

/**
 * @description: 最长瑞流子数组
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/25 16:41
 **/
public class LeetCode978 {

    public int maxTurbulenceSize(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }

        int N = arr.length;
        // 将瑞流子数组分为两种：f为最后一段是上升的子数组，g为最后一段是下降的子数组
        int[] f = new int[N + 1];
        int[] g = new int[N + 1];
        f[1] = 1;
        g[1] = 1;
        int max = 1;

        for(int i = 2; i <= N; i++) {
            // 如果当前是上升，则它依赖于上一个的结果，如果是下降，则f[i] = g[i - 1] + 1，否则，则为上升或相等，因此为1
            if(arr[i - 1] > arr[i - 2]) {
                f[i] = g[i - 1] + 1;
            } else {
                f[i] = 1;
            }

            // 如果当前是下降，则它依赖于上一个的结果，如果是上升，则g[i] = f[i - 1] + 1，否则，则为下降或相等，因此为1
            if(arr[i - 1] < arr[i - 2]) {
                g[i] = f[i - 1] + 1;
            } else {
                g[i] = 1;
            }
            max = Math.max(max, f[i]);
            max = Math.max(max, g[i]);
        }
        return max;
    }
}
