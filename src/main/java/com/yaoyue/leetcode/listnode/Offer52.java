package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

/**
 * @description: 两个链表的第一个公共节点
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/13 20:59
 **/
public class Offer52 {

    /**
     * 解题思路：当前链表遍历结束之后，遍历另一条链表，最终两个指针都会遍历两个链表，因此最后会相交于链表的相交点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA != null ? nodeA.next : headB;
            nodeB = nodeB != null ? nodeB.next : headA;
        }
        return nodeA;
    }
}
