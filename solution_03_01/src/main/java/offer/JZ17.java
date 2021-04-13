package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/12 9:49
 *
 * @Classname JZ17
 * Description: 树的子结构
 */

/**
 * 若根节点相等，利用递归比较他们的子树是否相等，若根节点不相等，则利用递归分别判断是否在左右子树中
        */
public class JZ17 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (hasSubtree(root1,root2))
            return true;
        //查找root2是否在root1的左右子树中
        return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    private boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return hasSubtree(root1.left,root2.left) && hasSubtree(root1.right,root2.right);
    }

}
