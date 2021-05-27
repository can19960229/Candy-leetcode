package org.example;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/21 9:55
 *
 * @Classname Main
 * Description:
 */


import java.io.IOException;

/**
 *
 */
public class Main {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args) throws IOException {

    }
    //两个链表上的数字进行相加
    public ListNode add(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode p = l1,q = l2,curr = dummy;
        //flag为进位数
        int flag = 0;
        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = flag + x + y;
            //进位数
            flag = sum / 10;
            //新节点的数值为sum % 10
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(q != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (flag > 0){
            curr.next = new ListNode(flag);
        }
        return dummy.next;

    }
    //翻转链表
    public ListNode reverseList(ListNode head){
        ListNode next = null;
        ListNode pre = null;
        while (head != null){
            //保存要反转到头的那个节点
            next = head.next;
            //要反转的那个节点指向已经反转的上一个节点
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
