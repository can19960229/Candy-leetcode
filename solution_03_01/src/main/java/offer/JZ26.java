package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/2 10:29
 *
 * @Classname JZ26
 * Description: 二叉搜索树与双向链表
 */

/**
 * 将二叉搜索树转换成一个“排序的循环双向链表”
 * 1. 排序链表：节点从小到大排序，应该使用中序遍历，则是从小到大访问树的节点
 * 2. 双向链表：构建节点之间的关系时，设前驱节点pre和当前节点cur，不仅应构建pre.right = cur，也应构建cur.left = pre
 * 3. 循环链表：设链表头节点head和尾节点tail，head.left = tail , tail.right = head
 */
public class JZ26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode pre,head;
    public TreeNode Convert(TreeNode root){
        if (root == null)
            return null;
        dfs(root);

        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(TreeNode cur) {
        if (cur == null)
            return;
        dfs(cur.left);
        //访问首个节点cur
        if (pre != null)
            pre.right = cur;
        else
            //记录头节点
            head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

}
