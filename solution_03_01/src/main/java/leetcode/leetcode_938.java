package leetcode;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/8 21:55
 *
 * @Classname leetcode_938
 * Description: 二叉搜索树的范围和
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class leetcode_938 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }
    List<Integer> list = new ArrayList<>();
    public int rangeSunBST(TreeNode root,int low,int high){
        //二叉搜索树的中序遍历是升序
        dfs(root);
        int sum = 0;
        for (Integer integer : list) {
            if (integer > low && integer < high) {
                sum += integer;
            }
        }
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            dfs(root.left);
        list.add(root.val);
        if (root.right != null)
            dfs(root.right);
    }

    //方法二：不需要全部遍历
    int res = 0;
    public int rangeSumBST(TreeNode root,int L,int R){
        if (root != null){
            if (root.val < L){ //如果当前小于L，只需要遍历右子树即可
                rangeSumBST(root.right,L,R);
            }else if (root.val > R){
                rangeSumBST(root.left,L,R);
            }else { //如果当前值在L，R之间，则两个子树都要遍历
                res += root.val;
                rangeSumBST(root.left,L,R);
                rangeSumBST(root.right,L,R);
            }
        }
        return res;
    }
}
