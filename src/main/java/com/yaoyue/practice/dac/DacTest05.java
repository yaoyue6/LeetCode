package com.yaoyue.practice.dac;

/**
 * @description: 数字字符串到字母的转化方式
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/21 20:47
 **/
public class DacTest05 {

    public int process(char[] chars, int index) {
        // 递归达到终点位置
        if (index == chars.length) {
            return 1;
        }

        // 0没有对应的转化方式，返回0
        if (chars[index] == '0') {
            return 0;
        }

        if (chars[index] == '1') {
            // index作为独立位置时的转化方式
            int result = process(chars, index + 1);
            if (index + 1 < chars.length) {
                // index和index + 1作为独立位置时的转化方式
                result += process(chars, index + 2);
            }
            return result;
        }

        if (chars[index] == '2') {
            // index作为独立位置时的转化方式
            int result = process(chars, index + 1);
            if (chars[index + 1] - '0' >= 0 && chars[index + 1] - '0' <= 6) {
                // index和index + 1作为独立位置时的转化方式
                result += process(chars, index + 2);
            }
            return result;
        }
        // 比3大的数只能作为独立位置进行转化
        return process(chars, index + 1);
    }
}
