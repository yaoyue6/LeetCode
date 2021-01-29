package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

import java.util.Stack;

/**
 * @description: 两个链表生成相加链表
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/28 14:39
 **/
public class Offer40 {

    /**
     * 头节点
     * @param head1
     * @param head2
     * @return
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if(head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Stack<Integer> stack1 = buildStack(head1);
        Stack<Integer> stack2 = buildStack(head2);
        ListNode node = init(stack1, stack2);
        return node;
    }

    /**
     * 使用栈存储链表的元素
     * @param node
     * @return
     */
    public Stack<Integer> buildStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while(node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }

    /**
     * 合并两个栈中的元素
     * @param stack1
     * @param stack2
     * @return
     */
    public ListNode init(Stack<Integer> stack1, Stack<Integer> stack2) {
        ListNode node = null;
        int num1 = 0, num2 = 0, val = 0, carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            // 如果栈为空，则补0
            num1 = stack1.isEmpty() ? 0 : stack1.pop();
            num2 = stack2.isEmpty() ? 0 : stack2.pop();
            // 当前节点的值
            val = (num1 + num2 + carry) % 10;
            // 进位
            carry = (num1 + num2 + carry) / 10;
            ListNode cur = new ListNode(val);
            if(node == null) {
                node = cur;
            } else {
                cur.next = node;
                node = cur;
            }
        }
        // 如果还存在进位，则新创建1个节点进行存储
        if(carry != 0) {
            ListNode cur = new ListNode(carry);
            cur.next = node;
            node = cur;
        }
        return node;
    }
}
