package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/29 16:39
 *
 * @Classname JZ60
 * Description: 分行从上往下打印二叉树
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class JZ60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> thelist = new ArrayList<>();
        if (pRoot == null)
            return thelist;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0;i < size;i++){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            thelist.add(list);
        }
        return thelist;
    }
}
