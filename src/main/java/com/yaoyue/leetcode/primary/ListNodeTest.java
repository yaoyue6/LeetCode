package com.yaoyue.leetcode.primary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListNodeTest {
    Scanner sc = new Scanner(System.in);
    /**
     * 虚拟头节点
     */
    ListNode root = new ListNode(-1);

    /**
     * 记录链表中的值，便于去重
     */
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNodeTest object = new ListNodeTest();

        while(true) {
            System.out.println("1：添加节点\t" + "2：查找节点\t" + "3：删除节点\t" + "4：删除重复节点");
            System.out.println("请选择待进行的操作：");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    object.addNode();
                    break;
                case 2:
                    object.searchNode();
                    break;
                case 3:
                    object.deleteNode();
                    break;
                case 4:
                    object.deleteSameNode();
                    break;
                default:
                    System.out.println("输入无效，请重新输入！");
                    break;
            }
        }
    }

    /**
     * 添加节点
     */
    public void addNode() {
        System.out.println("请输入待添加的节点：");
        int num = sc.nextInt();
        // 判断跳出循环的条件
        if(num <= 0) {
            displayNode();
            System.exit(0);
        }

        // 向hash表中添加节点  getOrDefault：此API表示如果存在则返回value，不存在则返回0
        map.put(num, map.getOrDefault(num, 0) + 1);


        // 头节点的指针（目的：保证不动用头节点进行遍历）
        ListNode temp = root;
        // 遍历到链表尾部
        while(temp.next != null) {
            temp = temp.next;
        }
        // 添加节点
        temp.next = new ListNode(num);
    }

    /**
     * 删除节点
     */
    public void deleteNode() {
        System.out.println("请输入待删除的节点：");
        int num = sc.nextInt();

        // 头节点的指针（目的：保证不动用头节点进行遍历）
        ListNode temp = root;
        // 遍历链表
        while(temp.next != null) {
            if(num == temp.next.val) {
                // 删除节点
                temp.next = temp.next.next;
                System.out.println("已经删除");
                return;
            }
            temp = temp.next;
        }

        // 如果没有查找到该节点，则输出信息
        if(temp.next == null) {
            System.out.println("链表中没有此节点，无法删除");
        }
    }

    /**
     * 查找节点
     */
    public void searchNode() {
        System.out.println("请输入待查找的节点：");
        int num = sc.nextInt();

        // 头节点的指针（目的：保证不动用头节点进行遍历）
        ListNode temp = root.next;
        int index = 0;
        // 遍历链表
        while(temp != null) {
            index++;
            if(num == temp.val) {
                System.out.println("该节点是链表第" + index + "个节点");
                return;
            }
            temp = temp.next;
        }

        // 如果没有查找到该节点，则输出信息
        if(temp == null) {
            System.out.println("找不到此节点");
        }
    }

    /**
     * 删除重复节点
     */
    public void deleteSameNode() {
        // 如果hash表为空，则没有重复数据
        if (map.isEmpty()) {
            displayNode();
            return;
        }

        for(int key : map.keySet()) {
            int count = map.get(key);
            ListNode temp = root;
            // 通过判断hash表中存储的节点次数是否大于1，来进行删除
            while(count > 1 && temp.next != null) {
                if(temp.next.val == key) {
                    temp.next = temp.next.next;
                    count--;
                }
                temp = temp.next;
            }
        }
        displayNode();
    }

    /**
     * 遍历节点
     */
    public void displayNode() {
        ListNode temp = root.next;
        if(temp == null) {
            System.out.println("当前链表不存在节点，无法遍历");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(temp != null) {
            stringBuilder.append(temp.val + "->");
            temp = temp.next;
        }
        // 截取掉多余的"->"
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        System.out.println("遍历结果如下：");
        System.out.println(stringBuilder.toString());
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}