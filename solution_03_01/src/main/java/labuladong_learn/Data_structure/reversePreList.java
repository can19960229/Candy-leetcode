package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 23:03
 *
 * @Classname reversepreList
 * Description:反转链表前 N 个节点
 */

/**
 *
 */
public class reversePreList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    ListNode successor = null;
    //将链表的前n个节点反转
    public ListNode reverseN(ListNode head,int n){
        if (n == 1){
            //记录第n+1个节点，后面要用
            successor = head.next;
            return head;
        }
        //以head.next为起点，需要反转前 n - 1个节点
        ListNode last = reverseN(head,n - 1);
        head.next.next = head;
        //让反转之后的head节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    /*
    迭代的思路反转链表的前N个节点
     */
    ListNode reverseN_1(ListNode head,ListNode b){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode p = null;
        //反转整个链表，把终止条件改一下就行
        while (head != b){
            p = head.next;
            head.next = pre;
            pre = head;
            head = p;
        }
        return pre;
    }


    public static void main(String[] args) {

    }
}
