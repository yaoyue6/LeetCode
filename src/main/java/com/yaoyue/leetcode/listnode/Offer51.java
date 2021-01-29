package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

import java.util.ArrayList;

/**
 * @description: 合并k个排序链表
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/26 16:19
 **/
public class Offer51 {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) {
            return null;
        }
        return mergeList(0, lists.size() - 1, lists);
    }

    /**
     * 使用分治法划分
     * @param left
     * @param right
     * @param lists
     * @return
     */
    public ListNode mergeList(int left, int right, ArrayList<ListNode> lists) {
        if(left >= right) {
            return lists.get(left);
        }
        int mid = (left + right) / 2;
        ListNode l1 = mergeList(left, mid, lists);
        ListNode l2 = mergeList(mid + 1, right, lists);
        return merge(l1, l2);
    }

    /**
     * 合并两链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode head = l1.val > l2.val ? l2 : l1;
        ListNode cur = head;
        l1 = l1 == head ? l1.next : l1;
        l2 = l2 == head ? l2.next : l2;
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head;
    }
}
