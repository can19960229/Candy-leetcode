package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/13 20:02
 *
 * @Classname preOrder_serialize
 * Description: 后序遍历序列化 与 反序列化
 */


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */

public class LevelOrder_serialize {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    //代表分割符的字符
    String SEP = ",";
    //代表null空指针的字符
    String NULL = "#";
    /**
     * 主函数，将二叉树序列化为字符串
     */
    String serialize_level(TreeNode root){
        //用于拼接字符串
        StringBuilder sb = new StringBuilder();
        //初始化队列，将root加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            //层序遍历
            if (cur == null){
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }



    /**
     * 主函数，将字符串反序列化为二叉树结构
     * @param data
     * @return
     */
    TreeNode deserialize_level(String data){
        if (data.isEmpty())
            return null;
        String[] nodes = data.split(SEP);
        //第一个元素就是root的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        //队列q记录父节点，将root加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < nodes.length ; i++) {
            //队列中存的是父节点
            TreeNode parent = q.poll();
            //父节点对应的左侧子节点的值
            String left = nodes[i++];
            if (!left.equals(NULL)){
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            }else {
                parent.left = null;
            }
            //父节点对应的右侧子节点的值
            String right = nodes[i++];
            if (!right.equals(NULL)){
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            }else {
                parent.right = null;
            }
        }
        return root;
    }


}
