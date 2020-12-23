package com.yaoyue.primary.listnode;

/**
 * @description: 反转链表
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/26 22:00
 **/
public class ListNode03Test {

    /**
     * 反转一个单链表。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
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

    /**
     * 解题思路：直接将指向下一个节点的指针指向上一个节点
     */
}
