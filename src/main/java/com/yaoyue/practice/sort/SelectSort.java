package com.yaoyue.practice.sort;

/**
 * @description: 选择排序
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/11 10:20
 **/
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        show(array);
        sort(array);
        show(array);
    }

    /**
     * 选择排序
     * @param array
     */
    public static void sort(int[] array) {
        // 最小值下标
        int min = 0;
        // 中间结果
        int temp = 0;
        for(int i = 0; i < array.length; i++) {
            // 初始化
            min = i;
            // 查找最小值的下标
            for(int j = i; j < array.length; j++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }
            // 证明最小值下标变化，即当前i不是最小值
            if(i != min) {
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    /**
     * 遍历数组
     * @param array
     */
    public static void show(int[] array) {
        for (int num : array) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }
}
