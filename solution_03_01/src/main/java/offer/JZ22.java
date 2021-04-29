package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/29 14:57
 *
 * @Classname JZ22
 * Description: 从上往下打印二叉树
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左往右打印
 */
public class JZ22 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //利用二叉树的广度遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //result用来保存输出的节点
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        //queue用来保存当前遍历到了哪个节点，一次性把一个节点的左右子都入队
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);//吧节点加入队列
        //遍历队列
        //只要队列中还有节点就说明还没遍历完，继续。
        //每次从队列出队，然后将这个节点左右子入队列（FIFO，故能完成广度/层级遍历），再将这个节点记录在list中即可。
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if ((temp.left != null))
                queue.offer(temp.left);
            if ((temp.right != null)){
                queue.offer(temp.right);
            }
        }
        return result;
    }
}
/*
在Java中Queue是和List、Map同等级别的接口，LinkedList中也实现了Queue接口，该接口中的主要函数有：

容量不够或队列为空时不会抛异常：offer（添加队尾元素）、peek（访问队头元素）、poll（访问队头元素并移除）
容量不够或队列为空时抛异常：add、element（访问队列元素）、remove（访问队头元素并移除）
 */
