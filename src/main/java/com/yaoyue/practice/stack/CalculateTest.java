package com.yaoyue.practice.stack;

import java.util.Stack;

/**
 * @description: 使用栈来计算表达式的结果，模拟计算器
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/7 16:22
 **/
public class CalculateTest {

    public void test() {
        String str = "( 1 + ( ( 2 + 4 ) * ( 4 * 5 ) ) )";
        double calculate = calculate(str);
        System.out.println(calculate);
    }

    /**
     * 计算方法
     * @param str
     * @return
     */
    public double calculate(String str) {
        Stack<Character> ops = new Stack<>();
        Stack<Double> nums = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                ops.push(ch);
            } else if(ch - 48 >= 0 && ch - 49 <= 9) {
                nums.push(ch - 48.0);
            } else if(ch == ')') {
                char operation = ops.pop();
                Double nums1 = nums.pop();
                Double nums2 = nums.pop();
                double num = 0;
                switch(operation) {
                    case '+':
                        num = nums1 + nums2;
                        break;
                    case '-':
                        num = nums1 - nums2;
                        break;
                    case '*':
                        num = nums1 * nums2;
                        break;
                    case '/':
                        num = nums1 / nums2;
                        break;
                    default:
                        break;
                }
                nums.push(num);
            }
        }
        return nums.pop();
    }
}