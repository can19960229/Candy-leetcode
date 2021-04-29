package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/29 17:05
 *
 * @Classname JZ59
 * Description: 按之字形顺序打印二叉树
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 */
public class JZ59 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return result;
        Stack<TreeNode> tmp = new Stack<>();
        Stack<TreeNode> tmp1 = new Stack<>();
        tmp.add(pRoot);
        while(tmp.size() > 0 || tmp1.size() > 0) {
            ArrayList<Integer> flood = new ArrayList<>();
            if(tmp.size() > 0) {
                int size = tmp.size();
                for(int i=0; i<size; i++) {
                    TreeNode pop = tmp.pop();
                    flood.add(pop.val);
                    if(pop.left != null) {
                        tmp1.add(pop.left);
                    }
                    if(pop.right != null) {
                        tmp1.add(pop.right);
                    }

                }
                result.add(flood);
                continue;
            }
            if(tmp1.size() > 0) {
                int size = tmp1.size();
                for(int i=0; i<size; i++) {
                    TreeNode pop = tmp1.pop();
                    flood.add(pop.val);
                    if(pop.right != null) {
                        tmp.add(pop.right);
                    }
                    if(pop.left != null) {
                        tmp.add(pop.left);
                    }
                }
                result.add(flood);
                continue;
            }
        }
        return result;
    }

}
