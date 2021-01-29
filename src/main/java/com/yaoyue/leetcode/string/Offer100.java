package com.yaoyue.leetcode.string;

/**
 * @description: 将字符串转化为整数
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/26 15:44
 **/
public class Offer100 {

    public int atoi (String str) {
        // write code here
        if(str == null || str.length() == 0) {
            return 0;
        }

        // 1、截取掉空字符串
        str = str.replaceAll(" ", "");

        char[] chars = str.toCharArray();
        int symbol = 1;
        long sum = 0;
        int count = 0;
        for(char ch : chars) {
            // 2、确定数值范围0-9
            if(ch - '0' >= 0 && ch - '0' <= 9) {
                sum = sum * 10 + (ch - '0');
            } else if(count == 0 && (ch == '+' || ch == '-')) {
                // 3、处理 + - 正负号
                if(ch == '-') {
                    symbol = -1;
                } else if(ch == '+') {
                    symbol = 1;
                }
            } else {
                break;
            }
        }

        sum = sum * symbol;

        // 4、处理溢出数据
        if (sum >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (sum <= Integer.MIN_VALUE ){
            return Integer.MIN_VALUE;
        }

        return (int) sum;
    }
}
