package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 22:56
 *
 * @Classname reverseList
 * Description: 递归反转整个链表
 *
 */

/**
 *
 */
public class reverseList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /*
    递归反转整个链表
     */
    ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    /*
    迭代的思路反转整个链表
     */
    ListNode reverse_1(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode p = null;
        while (head != null){
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
