package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 23:15
 *
 * @Classname reversePreNList
 * Description: 反转链表的一部分
 */

/**
 *
 */
public class reversePreNList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    ListNode successor = null;
    //将链表的前n个节点反转
    public ListNode reverseN(ListNode head, int n){
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
    ListNode reverseBetween(ListNode head,int m,int n){
        //base case
        if(m == 1){
            return reverseN(head,n);
        }
        //对于head.next来说，就是反转区间[m - 1,n - 1]
        head.next = reverseBetween(head.next,m - 1,n - 1);
        return head;
    }



    public static void main(String[] args) {

    }
}
