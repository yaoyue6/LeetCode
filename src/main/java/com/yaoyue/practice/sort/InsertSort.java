package com.yaoyue.practice.sort;

/**
 * @description: 插入排序
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/11 15:45
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        show(array);
        sort(array);
        show(array);
    }

    /**
     * 插入排序移位法
     * @param array
     */
    public static void sort(int[] array) {
        // 待插入的值
        int insertValue = 0;
        // 待插入的索引
        int insertIndex = 0;
        for(int i = 1; i < array.length; i++) {
            // 此处应用上一个位置开始
            insertIndex = i - 1;
            // 此处应从当前位置开始
            insertValue = array[i];
            // 相当于依次向右移1位，之后向该插入的位置填充
            while(insertIndex >= 0 && insertValue < array[insertIndex]) {
                // 为什么使用insertValue来进行比较，因为待插入之前的数组已经有序，所以只需要比较待插入的元素应处的位置即可，因此使用insertValue比较
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                array[insertIndex + 1] = insertValue;
            }
        }
    }

    /**
     * 插入排序交换式
     * @param array
     */
    public static void exchangeSort(int[] array) {
        int temp = 0;
        for(int i = 0; i < array.length; i++) {
            for(int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                temp = array[j - 1];
                array[j - 1] = array[j];
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
