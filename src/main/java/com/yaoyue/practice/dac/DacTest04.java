package com.yaoyue.practice.dac;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 打印字符串的全排列
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/21 18:49
 **/
public class DacTest04 {

    List<String> list = new ArrayList<>();

    /**
     * 可重复的全排列
     * @param chars
     * @param index
     */
    public void process(char[] chars, int index) {
        if (index == chars.length) {
            list.add(chars.toString());
            return;
        }
        for (int i = index; i < chars.length; i++) {
            // 交换两元素
            swap(i, index, chars);
            // 递归处理
            process(chars, index);
            // 还原现场
            swap(i, index, chars);
        }
    }

    /**
     * 不重复的全排列
     * @param chars
     * @param index
     */
    public void process1(char[] chars, int index) {
        if (index == chars.length) {
            list.add(chars.toString());
            return;
        }
        boolean[] flag = new boolean[26];
        for (int i = index; i < chars.length; i++) {
            // 分支限界
            if (!flag[chars[i] - 'a']) {
                flag[chars[i] - 'a'] = true;
                // 交换两元素
                swap(i, index, chars);
                // 递归处理
                process1(chars, index);
                // 还原现场
                swap(i, index, chars);
            }
        }
    }

    public void swap(int i, int j, char[] chars) {
        if (i == j || i >= chars.length || j >= chars.length || i < 0 || j < 0) {
            return;
        }
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
