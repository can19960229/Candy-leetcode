package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/13 9:59
 *
 * @Classname JZ62
 * Description: 二叉搜索树的第k个结点
 */

import java.util.ArrayList;

/**
 *
 */
public class JZ62 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 二叉搜索树的中序遍历是升序，将中序遍历的值存入数组中，然后遍历数组返回第k个
     * @param pRoot
     * @param k
     * @return
     */
    ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode KthNode_1(TreeNode pRoot, int k){
        if (pRoot == null) {
            return null;
        }
        helper(pRoot);
        if (list.size() >= k &&k > 0){
            return list.get(k - 1);
        }
        return null;

    }
    public void helper(TreeNode root){
        helper(root.left);
        list.add(root);
        helper(root.right);
    }

    /**
     * 中序遍历，不用额外的数组来存储遍历后的结果，直接在遍历的时候进行判断
     */
    private TreeNode target = null;
    private int k1 = 0;
    TreeNode KthNode(TreeNode pRoot,int k){
        k1 = k;
        getKthNode(pRoot);
        return target;
    }
    private void getKthNode(TreeNode pRoot){
        if (pRoot == null || k1 <= 0){
            return;
        }
        getKthNode(pRoot.left);
        k1--;
        if (k1 == 0){
            target = pRoot;
            return;
        }
        getKthNode(pRoot.right);
    }
}
