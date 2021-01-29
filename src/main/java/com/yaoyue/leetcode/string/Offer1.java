package com.yaoyue.leetcode.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @description: 大数加法
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/29 14:05
 **/
@Slf4j(topic = "c.Offer1")
public class Offer1 {

    @Test
    public void test() {
        String s = "733064366";
        String t = "459309139";
        log.info(solve(s, t));
    }

    public String solve(String s, String t) {
        // write code here
        int carry = 0;
        int sum = 0;

        int s1 = s.length() - 1;
        int t1 = t.length() - 1;

        StringBuilder result = new StringBuilder();
        while(s1 >= 0 || t1 >= 0) {
            int num1 = s1 >= 0 ? s.charAt(s1--) - '0' : 0;
            int num2 = t1 >= 0 ? t.charAt(t1--) - '0' : 0;
            sum = num1 + num2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        if(carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
