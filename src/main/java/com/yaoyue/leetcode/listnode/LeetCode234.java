package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

import java.util.Stack;

/**
 * @description: 回文链表
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/13 20:11
 **/
public class LeetCode234 {

    /**
     * 解题思路：使用数组存储链表的元素，判断数组是否是回文
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int count = 0;
        // 计算链表的长度
        while(cur != null){
            count++;
            cur = cur.next;
        }
        cur = head;
        // 定义一个和链表长度一样的数组
        int[] array = new int[count];
        // 将链表中的数据存放到数组中
        while(cur != null){
            array[--count] = cur.val;
            cur = cur.next;
        }
        // 判断数组第i个元素是否和数组倒数第i个元素相等
        boolean flag = true;
        for(int i = 0; i < array.length / 2; i++){
            if(array[i] != array[array.length - 1 - i]){
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 使用栈来存储链表的元素，再次遍历栈，不断与栈顶作比较，相同则弹出元素，不同则不是回文
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode temp = head;

        // 可以使用快慢指针优化，慢指针走到中点之后，将右半部分元素加入栈中，遍历链表，和栈中元素进行比较，如果栈为空，则true，否则为false
        Stack<Integer> stack = new Stack<>();
        while(temp != null) {
            stack.add(temp.val);
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(stack.pop() != temp.val) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    /**
     * 利用快慢指针，慢指针走到中点之后，将右半边元素指针方向逆序，之后从两端比对，如果最后为null，则true，否则false
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = null;
        ListNode next = slow;
        ListNode temp = null;
        while(next != null){
            temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }

        boolean flag = true;
        temp = head;

        while(temp != slow && pre != null){
            if(temp.val != pre.val){
                flag = false;
            }
            temp = temp.next;
            pre = pre.next;
        }
        return flag;
    }
}
