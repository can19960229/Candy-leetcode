package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 23:22
 *
 * @Classname reverseKGroup
 * Description: k个一组反转链表
 */

/**
 *
 */
public class reverseKGroup {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    ListNode reverseKGroup(ListNode head,int k){
        if (head == null)
            return null;
        //区间[a,b）包含k个待反转元素
        ListNode a,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            //不足k个，不需要反转，base case
            if (b == null)
                return head;
            b = b.next;
        }
        //反转前k个元素
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    ListNode reverse(ListNode head, ListNode b){
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

}
