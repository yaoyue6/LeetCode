package com.yaoyue.primary;

import java.util.Scanner;

public class TreeNodeTest {

    /**
     * 根节点
     */
    private TreeNode root;

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNodeTest object = new TreeNodeTest();

        while(true) {
            System.out.println("1：添加节点\t" + "2：删除节点\t" + "3：前序遍历\t" + "4：中序遍历" + "5：后序遍历" + "6：查询节点");
            System.out.println("请选择待进行的操作：");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    object.addNode();
                    break;
                case 2:
                    object.deleteNode();
                    break;
                case 3:
                    object.preOrder();
                    break;
                case 4:
                    object.InfixOrder();
                    break;
                case 5:
                    object.nextOrder();
                    break;
                case 6:
                    object.searchNode();
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
        int num = sc.nextInt();
        // 对根节点进行处理
        if(root == null) {
            root = new TreeNode(num);
            return;
        } else {
            addNode(num, root);
        }

    }

    /**
     * 添加节点具体实现
     * @param num 待插入的数
     * @param node 父节点
     */
    public void addNode(int num, TreeNode node) {
        // 判断父节点是否为null
        if(node == null) {
            return;
        }

        // 判断输入的数与当前子树的根节点的关系
        if(num < node.val) {
            if (node.left == null) {
                // 如果当前父节点的左子节点是null，则直接将num添加到当前父节点的左子节点
                node.left = new TreeNode(num);
            } else {
                // 否则递归向左查找
                addNode(num, node.left);
            }
        } else {
            if (node.right == null) {
                // 如果当前父节点的右子节点是null，则直接将num添加到当前父节点的右子节点
                node.right = new TreeNode(num);
            } else {
                // 否则递归向左查找
                addNode(num, node.right);
            }
        }
    }

    public void deleteNode() {
        if(root == null) {
            System.out.println("当前二叉排序树为空，请添加数据");
            return;
        }
        System.out.println("请输入待删除的数据：");
        int num = sc.nextInt();
    }
}

class TreeNode{
    int val;
    TreeNode left;

    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}