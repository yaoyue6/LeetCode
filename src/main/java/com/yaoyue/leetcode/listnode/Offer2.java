package com.yaoyue.leetcode.listnode;

import com.alibaba.fastjson.JSON;
import com.yaoyue.leetcode.listnode.base.ListNode;
import com.yaoyue.leetcode.listnode.base.ListNodeUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 重排链表
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/29 10:04
 **/
@Slf4j(topic = "c.Offer2")
public class Offer2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ListNodeUtils.buildListNode(nums);
        reorderList(head);
        log.info("{}", JSON.toJSONString(head));
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode middle = middleNode(head);

        // 原来的一截正向链表
        ListNode l1 = head;

        // 截断链表，生成两个链表
        ListNode node = middle.next;
        middle.next = null;
        // 另一截反转链表
        ListNode l2 = reverseNode(node);

        mergeList(l1, l2);
    }

    /**
     * 寻找中间节点
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 双指针
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表
     * @param node
     * @return
     */
    public static ListNode reverseNode(ListNode node) {
        // 反转链表
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 合并两链表
     * @param node1
     * @param node2
     */
    public static void mergeList(ListNode node1, ListNode node2) {
        ListNode l1 = null;
        ListNode l2 = null;
        while(node1 != null && node2 != null) {
            l1 = node1.next;
            l2 = node2.next;

            node1.next = node2;
            node1 = l1;
            node2.next = node1;
            node2 = l2;
        }
    }
}
