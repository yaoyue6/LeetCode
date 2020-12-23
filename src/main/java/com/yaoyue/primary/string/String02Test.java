package com.yaoyue.primary.string;

/**
 * @description: 整数反转
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/26 19:29
 **/
public class String02Test {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @param x
     * @return
     */
    public int reverse(int x) {
        long temp = 0;

        while(x != 0) {
            temp = temp * 10 + x % 10;
            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) temp;
    }

    /**
     * 解题思路：对x进行循环取余，将余数以及进1位的temp赋值为temp，如果temp的值超出int的极限，则返回0，否则一直进行x/10的操作，直到x为0
     */
}
