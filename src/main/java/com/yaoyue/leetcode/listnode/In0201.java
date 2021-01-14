package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 移除重复节点
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/14 10:44
 **/
public class In0201 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);

        removeDuplicateNodes(head);
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode cur = temp.next;
        ListNode prev = temp;
        Set<Integer> set = new HashSet<>();

        while(cur != null) {
            if(!set.add(cur.val)) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }


        return temp.next;
    }
}
