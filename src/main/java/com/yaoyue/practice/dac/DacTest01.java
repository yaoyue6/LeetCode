package com.yaoyue.practice.dac;

/**
 * @description: 汉诺塔问题
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/18 21:40
 **/
public class DacTest01 {

    public void func(int N, String from, String to, String other) {
        if(N == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
            return;
        }

        // 三个步骤：
        // 1、将 1-N 从左边移到中间
        func(N - 1, from, other, to);
        // 2、将 N 从左边移到右边
        System.out.println("Move N from " + from + " to " + other);
        // 3、将 1-N从中间移动右边
        func(N - 1, other, to, from);
    }
}
