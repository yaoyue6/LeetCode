package com.yaoyue.leetcode.string;

/**
 * @description: 进制转换
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/29 13:48
 **/
public class Offer112 {

    public String solve (int M, int N) {
        // write code here
        // 避免除0异常
        if(N == 0) {
            return null;
        }
        boolean flag = false;
        if(M < 0) {
            M = -M;
            flag = true;
        }
        StringBuilder result = new StringBuilder();
        // 相当于字典映射
        String s = "0123456789ABCDEF";
        while(M != 0) {
            result.append(s.charAt(M % N));
            M /= N;
        }
        if(flag) {
            result.append("-");
        }
        return result.reverse().toString();
    }
}
