package com.yaoyue.listnode;

import com.yaoyue.listnode.base.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 环形链表 II
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/29 9:59
 **/
public class LeetCode142 {

    @Test
    public void test() {
        ListNode root = new ListNode(3);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(0);
        ListNode next3 = new ListNode(-4);
        root.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next1;

        ListNode listNode = detectCycle(root);
        System.out.println(listNode.toString());
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // 为什么是true，不是fast != slow?  因为fast != slow 的话，无法进入循环
        while(true) {
            if(fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }

        fast = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /**
     * 解题思路：设无环部分长度为a，有环部分长度为b，由于双指针同一节点出发，快指针每次比慢指针多走一步，则设慢指针走s步，则快指针走2s步。假设快指针比慢指针多走n圈
     * 则 2s = nb + s，因此 s = nb，此时slow指针走的是环的n倍步长，因此若加上无环部分的长度a，则刚好到达环的起始位置
     */

    /**
     * 解题思路：使用Set存储ListNode节点，当碰到重复节点时，即代表链表有环，该重复节点是环的起始节点
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if(head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur != null) {
            if(set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
