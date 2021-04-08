package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/7 16:16
 *
 * @Classname JZ4
 * Description: 由前序和中序遍历重建二叉树
 */


/**
 * 递归（传入子数组的边界索引）
 */

public class JZ4_1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0)
            return null;
        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode helper(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL > preR || inL > inR){
            return null;
        }
        int rootVal = pre[preL];
        int index = 0;
        while (index <= inR && in[index] != rootVal){
            index++;
        }
        TreeNode root = new TreeNode(rootVal);

        root.left = helper(pre,preL + 1,preL - inL + index, in, inL, index);
        root.right = helper(pre,preL - inL + index +1, preR, in, index + 1, inR);
        return root;
    }

    public static void main(String[] args) {

    }

}
