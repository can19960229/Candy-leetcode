package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/9 22:12
 *
 * @Classname JZ14
 * Description: 链表中倒数第k个结点
 */

/**
 *
 */
public class JZ14 {
    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;
        for (int i = 0; i < k; i++) {
            if (fast == null){
                return null;
            }
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
