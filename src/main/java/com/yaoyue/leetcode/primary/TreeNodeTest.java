package com.yaoyue.leetcode.primary;

import java.util.*;

/**
 * @description: 
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/6 21:10
 **/
public class TreeNodeTest {

    /**
     * 根节点
     */
    private TreeNode root;

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNodeTest object = new TreeNodeTest();

        while (true) {
            System.out.println("1：添加节点\t" + "2：删除节点\t" + "3：前序遍历\t" + "4：中序遍历\t" + "5：后序遍历\t" + "6：查询节点\t" + "7：退出系统");
            System.out.println("请选择待进行的操作：");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    object.addNode();
                    break;
                case 2:
                    object.delNode();
                    break;
                case 3:
                    object.preOrder();
                    break;
                case 4:
                    object.infixOrder();
                    break;
                case 5:
                    object.nextOrder();
                    break;
                case 6:
                    object.searchNode();
                    break;
                case 7:
                    System.exit(0);
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
        System.out.println("请输入数值：");
        int num = sc.nextInt();
        // 对根节点进行处理
        if (root == null) {
            root = new TreeNode(num);
            return;
        } else {
            addNode(num, root);
        }

    }

    /**
     * 添加节点具体实现
     *
     * @param num  待插入的数
     * @param node 父节点
     */
    public void addNode(int num, TreeNode node) {
        // 判断父节点是否为null
        if (node == null) {
            return;
        }

        // 判断输入的数与当前子树的根节点的关系
        if (num < node.val) {
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

    /**
     * 查找节点
     *
     * @return
     */
    public TreeNode searchNode() {
        if (root == null) {
            System.out.println("当前二叉排序树为空，请添加数据");
            return null;
        }
        System.out.println("请输入待查询的节点：");
        int num = sc.nextInt();

        TreeNode node = search(root, num);

        if (node == null) {
            System.out.println("不存在该节点");
            return null;
        } else {
            System.out.println("存在该节点");
            return node;
        }
    }

    /**
     * 查找需要删除的节点
     *
     * @param root：
     * @param val：需要删除的节点的值
     * @return 如果找到，返回该节点，否则返回null
     */
    public TreeNode search(TreeNode root, int val) {
        // 如果查找到的值小于当前节点的值
        if (root.val > val) {
            // 如果左子节点为空，则返回null
            if (root.left == null) {
                return null;
            }
            // 向左递归查找
            return search(root.left, val);
        } else if (root.val < val) {
            // 如果查找到的值大于当前节点的值
            if (root.right == null) {
                // 如果右子节点为空，则返回null
                return null;
            }
            // 向右递归查找
            return search(root.right, val);
        } else { // 找到该节点
            return root;
        }
    }

    public TreeNode searchParent(int val) {
        if (root != null) {
            return searchParent(root, val);
        } else {
            return null;
        }
    }

    /**
     * 找到要删除节点的父节点
     *
     * @param node:要删除节点的父节点
     * @param val:要删除节点的值
     * @return 如果找到, 返回该节点的父节点, 否则, 返回null
     */
    public TreeNode searchParent(TreeNode node, int val) {
        // 如果当前节点就是要删除节点的父节点,就返回当前节点
        if (node.left != null && node.left.val == val) {
            return node;
        } else if (node.right != null && node.right.val == val) {
            return node;
        } else {
            // 如果查找的值小于当前节点的值,并且当前节点的左子节点不为空，向左子树递归
            if (node.left != null && node.val > val) {
                return searchParent(node.left, val);
            } else if (node.right != null && node.val <= val) {
                // 如果查找的值大于当前节点的值,并且当前节点的右子节点不为空，向右子树递归
                return searchParent(node.right, val);
            } else { // 没有找到父节点
                return null;
            }
        }
    }

    public void delNode() {
        if (root != null) {
            System.out.println("请输入待删除的节点：");
            int val = sc.nextInt();
            delNode(root, val);
        } else {
            System.out.println("二叉树为空,无法删除节点");
            return;
        }
    }

    /**
     * 删除node节点右子树的最小值
     * 功能：1.返回以node为根节点的二叉排序树的最小节点的值；2.删除node为根节点的二叉排序树的最小节点
     *
     * @param node：传入的节点，即二叉排序树的根节点
     * @return 返回以node为根节点的二叉排序树的最小节点的值
     */
    public int delMinRightTree(TreeNode node) {
        TreeNode temp = node;
        // 循环的查找左子节点，直到找到最小值
        while (temp.left != null) {
            temp = temp.left;
        }
        // 此时target指向最小节点，删除最小节点
        delNode(root, temp.val);
        return temp.val;
    }

    /**
     * 删除node节点左子树的最大值
     * 功能：1.返回以node为根节点的二叉排序树的最大节点的值；2.删除node为根节点的二叉排序树的最大节点
     *
     * @param node：传入的节点，即二叉排序树的根节点
     * @return 返回以node为根节点的二叉排序树的最大节点的值
     */
    public int delMaxLeftTree(TreeNode node) {
        TreeNode temp = node;
        // 循环的查找右子节点，直到找到最大值
        while (temp.right != null) {
            temp = temp.right;
        }
        // 此时target指向最大节点，删除最大节点
        delNode(root, temp.val);
        return temp.val;
    }

    /**
     * 删除节点
     *
     * @param node
     * @param val:待删除节点的值
     */
    public void delNode(TreeNode node, int val) {
        // 先找到需要删除的节点targetNode
        TreeNode targetNode = search(node, val);
        // 如果没有找到要删除的节点
        if (targetNode == null) {
            System.out.println("二叉树中不含有值为" + val + "的节点");
            return;
        }
        // 如果发现当前的二叉排序树只有一个节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }

        // 再找到targetNode的父节点parentNode
        TreeNode parentNode = searchParent(node, val);
        // 如果要删除的节点是叶子节点
        if (targetNode.left == null && targetNode.right == null) {
            // 判断要删除的是左子节点还是右子节点
            if (parentNode.left != null && parentNode.left.val == val) {
                parentNode.left = null;
            } else if (parentNode.right != null && parentNode.right.val == val) {
                parentNode.right = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) {
            // 删除有两颗子树的节点
            // 方法1：从右子树找最小
            int target = delMinRightTree(targetNode.right);
            targetNode.val = target;

            // 方法2：从左子树找最大
//			int target = delMaxLeftTree(targetNode.left);
//			targetNode.setVal(target);
        } else { // 删除有一颗子树的节点       如果只有一颗根节点和一个左/右子节点时,删除root节点时会报错(空指针异常)  解决办法:判断parentNode节点是否为空,若为空,则直接将根节点替换为左/右子节点
            if (targetNode.left != null) {
                // 如果想要删除的节点在左子节点
                if (parentNode != null) {
                    if (parentNode.left == targetNode) {
                        // 如果targetNode是parentNode的左子节点  比较条件可以改为parentNode.left.val == val
                        parentNode.left = targetNode.left;
                    } else { // 如果targetNode是parentNode的右子节点
                        parentNode.right = targetNode.left;
                    }
                } else {
                    root.left = targetNode.left;
                }
            } else { // 如果想要删除的节点在右子节点
                if (parentNode != null) {
                    if (parentNode.left == targetNode) {
                        // 如果targetNode是parentNode的左子节点
                        parentNode.left = targetNode.right;
                    } else {  // 如果targetNode是parentNode的右子节点
                        parentNode.right = targetNode.right;
                    }
                } else {
                    root.right = targetNode.right;
                }
            }
        }
    }

    /**
     * 非递归前序遍历
     *
     * @return
     */
    public void preOrder() {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            System.out.println("当前二叉排序树为空，请添加数据");
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        // 添加根结点
        stack.push(root);

        // 迭代添加节点
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            res.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
        // 遍历list中节点
        displayStack(res);
    }

    /**
     * 非递归中序遍历
     *
     * @return
     */
    public void infixOrder() {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            System.out.println("当前二叉排序树为空，请添加数据");
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;
        //迭代添加节点
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                res.add(temp.val);
                temp = temp.right;
            }
        }

        // 遍历list中节点
        displayStack(res);
    }

    /**
     * 非递归后序遍历
     *
     * @return
     */
    public void nextOrder() {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            System.out.println("当前二叉排序树为空，请添加数据");
            return;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        displayStack(res);
    }

    /**
     * 遍历栈
     *
     * @param list
     */
    public void displayStack(List<Integer> list) {
        System.out.println("遍历结果如下：");
       for (Integer num : list) {
           System.out.print(num + "\t");
       }
        System.out.println();
    }
}

class TreeNode {
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