package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/29 15:17
 *
 * @Classname JZ23
 * Description: 二叉搜索树的后序遍历序列
 */

/**
 * 后序遍历的序列，最后一个数字是树的根节点的值
 * 数组前面的数组可以分为两部分：第一部分是左子树节点的值，它们都比根节点的值小；第二部分是右子树节点的值，它们都比根节点的值大
 *
 */
public class JZ23 {
    public boolean helpVerify(int [] sequence, int start, int root){
        if(start >= root)return true;
        //根节点为数组的最后一个数字
        int key = sequence[root];
        int i;
        //二叉树左节点值小于根节点的值，找到左右子数的分界点
        for(i=start; i < root; i++)
            if(sequence[i] > key)
                break;
        //右子树节点的值大于根节点的值，在右子树中判断是否含有小于root的值，如果有返回false
        for(int j = i; j < root; j++)
            if(sequence[j] < key)
                return false;
        //判断左右子树是否是二叉搜索树
        return helpVerify(sequence, start, i-1) && helpVerify(sequence, i, root-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)return false;
        return  helpVerify(sequence, 0, sequence.length-1);
    }
}
