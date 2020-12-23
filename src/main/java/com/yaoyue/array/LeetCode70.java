package com.yaoyue.array;

/**
 * @description: 爬楼梯
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/23 20:07
 **/
public class LeetCode70 {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int f1 = 1, f2 = 1;
        for(int i = 2; i <= n; i++) {
            int f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f2;
    }

    /**
     * 解题思路：斐波那契数列
     */
}
