package com.yaoyue.primary.array;

/**
 * @description: 买卖股票的最佳时机 II
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/24 20:52
 **/
public class Array02Test {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int count = 0;
        for(int i = 1; i < prices.length; i++) {
            count += Math.max(0, prices[i] - prices[i - 1]);
        }
        return count;
    }
    /**
     * 解题思路：贪心算法
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
     * 由于股票的购买没有限制，因此整个问题等价于寻找 xx 个不相交的区间(l,r],使得如下的等式最大化，同时对于(l,r]区间贡献的价值a[r]-a[l]其实等价于(l,l+1],(l+1,l+2]...(r-1,r]的价值和
     * 因此只需要找差值大于0的区间，即可以找到局部最优解，加和之后即为全局最优解
     */
}
