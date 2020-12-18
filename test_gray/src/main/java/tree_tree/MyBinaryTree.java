package tree_tree;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/23 9:38
 * version 1.0
 * Description: 测试
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 */
public class MyBinaryTree {

    /**
     * 二叉树节点
     */

    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }

    }
    public static TreeNode creatBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if (inputList ==null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null){
            node = new TreeNode(data);
            node.leftChild = creatBinaryTree(inputList);
            node.rightChild = creatBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树前序遍历
     * @param node 二叉树节点
     */
    public static void preOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     * @param node 二叉树节点
     */
    public static void inOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     * @param node  二叉树节点
     */

    public static void postOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 二叉树非递归前序遍历
     * @param root 二叉树根节点
     */
    public static void preOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问右孩子
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树层序遍历
     * @param root 二叉树层序遍历
     */
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //将指定的元素插入此队列（如果立即可行且不会违反容量限制），当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。
        queue.offer(root);
        while (!queue.isEmpty()){
            // poll()获取并移除此队列的头，如果此队列为空，则返回 null。
            // remove()获取并移除此队列的头。此方法与 poll 唯一的不同在于：此队列为空时将抛出一个异常。
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode treeNode =creatBinaryTree(inputList);
        System.out.println("前序遍历： ");
        preOrderTraveral(treeNode);
        System.out.println("**************************************");
        preOrderTraveralWithStack(treeNode);
        System.out.println("中序遍历： ");
        inOrderTraveral(treeNode);
        System.out.println("后序遍历： ");
        postOrderTraveral(treeNode);
        System.out.println("层序遍历： ");
        levelOrderTraversal(treeNode);
    }
}
