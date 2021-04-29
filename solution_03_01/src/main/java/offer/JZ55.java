package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/27 15:41
 *
 * @Classname JZ55
 * Description: 链表中环的入口结点
 */

/**
 *
 */
public class JZ55 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                fast = pHead;
                while (fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
