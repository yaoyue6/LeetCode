package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

/**
 * @description: 从尾到头打印链表
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/14 17:48
 **/
public class Offer06 {

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if(head == null) {
            return new int[]{};
        }
        ListNode node = head;

        int k = 1;
        while(node.next != null) {
            node = node.next;
            k++;
        }

        int[] nums = new int[k];
        node = head;
        for(int i = k - 1; node != null; i--) {
            nums[i] = node.val;
            node = node.next;
        }

        return nums;
    }
}
