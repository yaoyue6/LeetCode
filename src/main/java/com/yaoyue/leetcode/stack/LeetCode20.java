package com.yaoyue.leetcode.stack;

import java.util.Stack;

/**
 * @description: 有效的括号
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/23 14:57
 **/
public class LeetCode20 {

    public void test() {
        String s = "()))";
        System.out.println(isValid(s));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s == null || s.length() % 2 == 1) {
            return false;
        }

        // 存放左括号
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            String first = s.charAt(i) + "";
            // 添加左括号
            if("(".equals(first) || "[".equals(first) || "{".equals(first)) {
                stack.push(first);
            }
            if(")".equals(first) || "]".equals(first) || "}".equals(first)) {
                if(!stack.isEmpty()) {
                    // 左右括号互相抵消
                    String next = stack.peek();
                    if((")".equals(first) && "(".equals(next)) || ("]".equals(first) && "[".equals(next)) || ("}".equals(first) && "{".equals(next))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            } else {
                // 如果栈已空，则证明没有左括号和右括号抵消，直接返回false
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        if(s.isEmpty()) {
            return true;
        }
        // 辅助栈
        Stack<Character> stack = new Stack<>();

        // 如果为左括号，则向栈中添加右括号，否则，判断栈是否为空或者栈顶元素是否等于当前元素
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        // 栈未空，则返回false
        return stack.isEmpty();
    }
}
