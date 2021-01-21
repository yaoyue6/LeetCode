package com.yaoyue.practice.dac;

/**
 * @description: 背包问题
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/21 21:07
 **/
public class DacTest06 {

    /**
     * 递归解法
     * @param weight 重量
     * @param value 价值
     * @param alreadyWeight 已经放进来的重量
     * @param index 当前下标
     * @param bag 背包容量
     * @return
     */
    public int process(int[] weight, int[] value, int alreadyWeight, int index, int bag) {
        // 重量超过袋子的容量，返回-1
        if (alreadyWeight > bag) {
            return -1;
        }
        // 此时遍历到最后，重量在袋子容量范围之内，返回0
        if (index == weight.length) {
            return 0;
        }

        // 没有选择当前货物
        int p1 = process(weight, value, alreadyWeight, index + 1, bag);
        // 选择当前货物
        int p2Next = process(weight, value, alreadyWeight + weight[index], index + 1, bag);
        int p2 = -1;
        if (p2Next != -1) {
            p2 = p2Next + value[index];
        }
        return Math.max(p1, p2);
    }

    /**
     * 递归解法
     * @param weight 重量
     * @param value 价值
     * @param index 当前下标
     * @param rest 背包剩余容量
     * @return
     */
    public int process2(int[] weight, int[] value, int index, int rest) {
        // 重量超过袋子的容量，返回-1
        if (rest < 0) {
            return -1;
        }
        // 此时遍历到最后，重量在袋子容量范围之内，返回0
        if (index == weight.length) {
            return 0;
        }

        // 没有选择当前货物
        int p1 = process2(weight, value, index + 1, rest);
        // 选择当前货物
        int p2 = -1;
        // 此时有货也有空间，可进行下一步递归比较判断
        if (rest >= weight[index]) {
            p2 = process2(weight, value, index + 1, rest - weight[index]) + value[index];
        }
        return Math.max(p1, p2);
    }
}
