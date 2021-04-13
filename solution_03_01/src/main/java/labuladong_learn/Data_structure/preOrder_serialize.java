package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/13 20:02
 *
 * @Classname preOrder_serialize
 * Description: 前序遍历序列化 与 反序列化
 */


import java.util.LinkedList;

/**
 *
 */

public class preOrder_serialize {
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
    String serialize_pre(TreeNode root){
        //用于拼接字符串
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    /**
     * 将二叉树打平为字符串
     */
    void serialize(TreeNode root,StringBuilder sb){
        if (root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        /**
         * 前序遍历
         */
        sb.append(root.val).append(SEP);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }


    /**
     * 主函数，将字符串反序列化为二叉树结构
     * @param data
     * @return
     */
    TreeNode deserialize_pre(String data){
        //将字符串转化为列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /**
     * 辅助函数，通过nodes列表构造二叉树
     * @param nodes
     * @return
     */
    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;
        /**
         * 前序遍历
         */
        //列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
