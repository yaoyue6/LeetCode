package com.yaoyue.practice.dac;

/**
 * @description: 选牌问题
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/21 21:34
 **/
public class DacTest07 {

    public int win(int[] arr) {
        if (arr == null || arr.length < 0) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    /**
     * 先手拿牌
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int first(int[] arr, int left, int right) {
        // 此时还剩一张牌，可以拿到
        if (left == right) {
            return arr[left];
        }
        // 否则，先手的人可以拿到最大，后手的人只能拿到最小
        return Math.max(arr[left] + second(arr, left + 1, right), arr[right] + second(arr, left, right - 1));
    }

    /**
     * 后手拿牌
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int second(int[] arr, int left, int right) {
        // 此时还剩一张牌，拿不到
        if (left == right) {
            return 0;
        }
        // 否则，先手的人可以拿到最大，后手的人只能拿到最小
        return Math.min(arr[left] + first(arr, left + 1, right), arr[right] + first(arr, left, right - 1));
    }
}
