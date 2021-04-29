package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/27 15:50
 *
 * @Classname JZ56
 * Description: 删除链表中重复的结点
 */

/**
 *
 */
public class JZ56 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //递归的方法进行删除有序链表中重复的元素
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        if (pHead.val == pHead.next.val){
            while (pHead.next != null && pHead.val == pHead.next.val){
                pHead = pHead.next;
            }
            return deleteDuplication(pHead.next);
        }
        else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
    //非递归的方式
    public static ListNode deleteDuplication_1(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode fast = head.next,slow = head;
        while (fast != null && fast.next != null){
            if (fast.val == fast.next.val){
                while (fast.next != null && fast.val == fast.next.val){
                    fast = fast.next;
                }
                slow.next = fast.next;
                fast = fast.next;
            }else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return head.next;
    }
}
