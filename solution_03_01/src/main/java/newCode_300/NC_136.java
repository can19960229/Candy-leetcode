package newCode_300;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/12 10:07
 *
 * @Classname NC_136
 * Description: 输出二叉树的右视图
 */

import java.util.*;

/**
 *
 */
public class NC_136 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public int[] solve(int[] xianxu,int[] zhongxu){
        TreeNode root = reBuild(xianxu,zhongxu);
        return dfs(root);
    }

    //层序遍历，广度优先dfs
    //队列存储节点，先左后右。list记录每层最后出队元素
    private int[] dfs(TreeNode root) {

        if (root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            list.add(queue.peekLast().val);
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }



    //先确定根节点，中序遍历确定左右子树
    private TreeNode reBuild(int[] xianxu, int[] zhongxu) {
        if (xianxu == null || xianxu.length == 0){
            return null;
        }
        int val = xianxu[0],pos = 0,len = xianxu.length;
        TreeNode root = new TreeNode(val);
        //找到中序数组根节点位置
        for (;pos < len;pos++){
            if (zhongxu[pos] == val)
                break;
        }
        root.left = reBuild(Arrays.copyOfRange(xianxu,1,pos+1),
                Arrays.copyOfRange(zhongxu,0,pos));
        root.right = reBuild(Arrays.copyOfRange(xianxu,pos+1,len),
                Arrays.copyOfRange(zhongxu,pos+1,len));
        return root;
    }
}
