package com.yaoyue.practice.dac;

import java.util.Stack;

/**
 * @description: 不使用多余数据结构进行栈逆序
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/21 17:05
 **/
public class DacTest02 {

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int val = func(stack);
        reverse(stack);
        stack.push(val);
    }

    public int func(Stack<Integer> stack) {
        int result = stack.pop();
        if(stack.isEmpty()) {
            return result;
        } else {
            int last = func(stack);
            stack.push(result);
            return last;
        }
    }
}
