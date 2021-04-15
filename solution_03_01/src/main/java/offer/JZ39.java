package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/15 11:37
 *
 * @Classname JZ39
 * Description: 平衡二叉树
 */

/**
 * 平衡二叉树的左右子树高度不超过1
 */
public class JZ39 {
    public boolean IsBalanced_Solution(JZ62.TreeNode root){
        return recur(root) != -1;
    }

    private int recur(JZ62.TreeNode root) {
        if (root == null)
            return 0;
        int left = recur(root.left);
        if (left == -1)
            return -1;
        int right = recur(root.right);
        if (right == - 1)
            return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }

}
