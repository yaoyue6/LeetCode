package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

/**
 * @description: 环形链表
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/29 9:32
 **/
public class LeetCode141 {

    /**
     * 给定一个链表，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪next指针再次到达，则链表中存在环。为了表示给定链表中的环，我们使用整数pos来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果pos是 -1，则在该链表中没有环。注意：pos不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 如果链表中存在环，则返回true。否则，返回false。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != slow) {
            if(fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 解题思路：利用快慢指针解法，快指针每次走2步，慢指针每次走1步，如果链表有环，则不会到达链表数据为null的位置，因此结束条件为 fast == null || fast.next == null，当快慢指针指向相同时，即代表快指针比慢指针多转，因此链表有环
     */
}
