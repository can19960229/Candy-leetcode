package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/9 11:20
 *
 * @Classname JZ16
 * Description: 合并两个排序的链表
 */

/**
 *
 */
public class JZ16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;

        }
        if ( list2 != null){
            return list2;
        }
        if (list1 != null){
            return list1;
        }
        return dummy.next;
    }
}
