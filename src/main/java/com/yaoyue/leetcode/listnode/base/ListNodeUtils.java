package com.yaoyue.leetcode.listnode.base;

/**
 * @description: 链表工具类
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/29 10:10
 **/
public class ListNodeUtils {

    /**
     * 由数组构建链表
     * @param nums
     * @return
     */
    public static ListNode buildListNode(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int num : nums) {
            ListNode node = new ListNode(num);
            cur.next = node;
            cur = cur.next;
        }
        return head.next;
    }
}
