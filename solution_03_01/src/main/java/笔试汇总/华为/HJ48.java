package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/18 17:21
 *
 * @Classname HJ48
 * Description: 从单链表中删除指定值的节点
 */

import java.util.Scanner;

/**
 *
 */
public class HJ48 {
    private ListNode head;

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public HJ48(int val) {
        head = new ListNode(val);
    }
    public void insert(int val,int node){
        ListNode p = head;
        while (p.val != node){
            p = p.next;
        }
        p.next = new ListNode(val, p.next);
    }
    public void delete(int node){
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        while (p.next != null && p.next.val != node){
            p = p.next;
        }
        if (p.next != null){
            p.next = p.next.next;
        }
        head = dummy.next;
    }
    public ListNode head(){
        return this.head;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int val = Integer.parseInt(in.next());
            HJ48 solution = new HJ48(val);
            for (int i = 1; i < n; i++) {
                val = Integer.parseInt(in.next());
                int node = Integer.parseInt(in.next());
                solution.insert(val, node);
            }
            val = Integer.parseInt(in.next());
            solution.delete(val);
            ListNode p = solution.head();
            while (p != null) {
                System.out.print(p.val + " ");
                p = p.next;
            }
            System.out.println();
        }
    }

}
