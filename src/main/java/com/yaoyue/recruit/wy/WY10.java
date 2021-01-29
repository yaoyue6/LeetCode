package com.yaoyue.recruit.wy;

import java.util.Scanner;

/**
 * @description: 网易：分苹果
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/27 18:23
 **/
public class WY10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];

        int sum = 0;
        for(int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }

        // 如果平均数不是正数，则必定无法分均匀
        if(sum % num != 0) {
            System.out.println(-1);
            return;
        }

        int avg = sum / num;
        int count = 0;
        for(int i : array) {
            if(i > avg) {
                // 如果多余的苹果是奇数，则必定无法分均匀
                if((i - avg) % 2 != 0) {
                    System.out.println(-1);
                    return;
                } else {
                    count += (i - avg) / 2;
                }
            }
        }

        System.out.println(count);
    }
}
