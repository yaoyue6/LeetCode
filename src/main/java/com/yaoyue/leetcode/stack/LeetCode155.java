package com.yaoyue.leetcode.stack;

import java.util.Stack;

/**
 * @description: 最小栈
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/28 14:34
 **/
public class LeetCode155 {

    public Stack<Integer> stack;
    public Stack<Integer> min;

    /** initialize your data structure here. */
    public LeetCode155() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        if(min.peek() >= x) {
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int result = stack.pop();
        if(result == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
