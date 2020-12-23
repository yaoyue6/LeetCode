package com.yaoyue.primary.listnode;

/**
 * @description: 合并两个有序链表
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/26 22:10
 **/
public class ListNode04Test {

    /**
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while(temp1 != null && temp2 != null) {
            if(temp1.val > temp2.val) {
                temp.next = temp2;
                temp2 = temp2.next;
            } else {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 == null ? temp2 : temp1;
        return result.next;
    }
}
