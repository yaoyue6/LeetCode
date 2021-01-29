package com.yaoyue.leetcode.listnode;

import com.alibaba.fastjson.JSON;
import com.yaoyue.leetcode.listnode.base.ListNode;
import com.yaoyue.leetcode.listnode.base.ListNodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @description: 重排链表
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/14 18:47
 **/
@Slf4j(topic = "c.LeetCode143")
public class LeetCode143 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ListNodeUtils.buildListNode(nums);
        reorderList(head);
        log.info("{}", JSON.toJSONString(head));
    }


    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode middle = middleNode(head);
        ListNode l1 = head;

        ListNode node = middle.next;
        middle.next = null;

        ListNode l2 = reverse(node);

        merge(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void merge(ListNode node1, ListNode node2) {
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
