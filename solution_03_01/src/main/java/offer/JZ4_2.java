package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/7 16:16
 *
 * @Classname JZ4
 * Description: 由中序和后序遍历重建二叉树
 */


import java.util.Arrays;

/**
 * 中序遍历：找到根节点，根节点左边是左子树，右边是右子树
 * 后序遍历：最后遍历的节点是根节点，和前序不一样的是，根节点在序列的最尾端
 */

public class JZ4_2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode reConstructBinaryTree(int [] inorder, int [] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0){
            return null;
        }
        if (postorder.length != inorder.length){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        //在中序中找到前序的根
        for (int i = postorder.length - 1; i > 0; i--) {
            if (postorder[postorder.length - 1] == inorder[i]){
                //左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
                //右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(inorder,i + 1,inorder.length),Arrays.copyOfRange(postorder,1,i + 1));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        JZ4_2 t = new JZ4_2();
        int[] inorder = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] postorder = new int[]{3, 2, 4, 1, 6, 5, 7};
        TreeNode root = reConstructBinaryTree(inorder, postorder);
        System.out.println(root);

    }
}
