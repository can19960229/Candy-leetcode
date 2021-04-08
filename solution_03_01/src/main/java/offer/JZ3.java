package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/7 16:07
 *
 * @Classname JZ3
 * Description: 从尾到头打印链表
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 */
public class JZ3 {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    //使用栈
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop().val);
        }
        return list;
    }

    //递归
    public static ArrayList<Integer> printListReverse2(ListNode headNode){
        ArrayList<Integer> list = new ArrayList<>();
        if (headNode != null){
            if (headNode.next != null){
                list = printListReverse2(headNode.next);
            }
            list.add(headNode.val);
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
