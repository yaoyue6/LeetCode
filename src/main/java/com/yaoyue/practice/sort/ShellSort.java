package com.yaoyue.practice.sort;

/**
 * @description: 希尔排序
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/12 10:16
 **/
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 9, 8, 7, 10, 6};
        show(array);
        shiftSort(array);
        show(array);
    }

    /**
     * 希尔排序交换法
     * @param array
     */
    public static void sort(int[] array) {
        // 逐步推导
        int n = array.length;
        int temp = 0;
        int step = 0;
//        for(int i = 5; i < n; i++) {
//            for(int j = i - 5; j >= 0; j--) {
//                if(array[j] > array[j + 5]) {
//                    temp = array[j];
//                    array[j] = array[j + 5];
//                    array[j + 5] = temp;
//                }
//            }
//        }

        // 最外层循环控制分组数，array.length / 2   array.length / 2 / 2 ...
        for (step = n; step > 0; step /= 2) {
            // 次外层循环进行所有分组的遍历，array.length / 2 + 1   array.length / 2 + 2  ...
            for(int i = step; i < n; i++) {
                // 最里层循环进行分组间的遍历及交换
                for(int j = i - step; j >= 0; j -= step) {
                    if(array[j] > array[j + step]) {
                        temp = array[j];
                        array[j] = array[j + step];
                        array[j + step] = temp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序移位法
     * @param array
     */
    public static void shiftSort(int[] array) {
        int n = array.length;
        int temp = 0;
        int j = 0;
        // 最外层控制分组数，array.length / 2   array.length / 2 / 2 ...
        for(int step = n; step > 0; step /= 2) {
            // 次外层循环进行所有分组的遍历，array.length / 2 + 1   array.length / 2 + 2  ...
            for(int i = step; i < n; i++) {
                temp = array[i];
                j = i;
                // 如果当前分组的最后一个元素比其它元素小，则进行移位，否则位置不动
                while(j - step >= 0 && array[j - step] > temp) {
                    array[j] = array[j - step];
                    j -= step;
                }
                // 如果进行了移位，则j最后停留的位置即是原来最后一个元素应该在的位置
                array[j] = temp;
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
