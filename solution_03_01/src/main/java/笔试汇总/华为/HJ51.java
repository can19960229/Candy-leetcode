package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/29 20:21
 *
 * @Classname HJ51
 * Description: 输出单向链表中倒数第k个结点
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class HJ51 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        /*
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if (n == 0){
                System.out.println(0);
                continue;
            }
            //建立头结点
            int n0 = sc.nextInt();
            ListNode head = new ListNode(n0);
            ListNode rear = head;
            //尾插法
            for (int i = 1; i < n; i++) {
                ListNode node = new ListNode(sc.nextInt());
                node.next = rear.next;
                rear.next = node.next;
                rear = node;
            }
            int k = sc.nextInt();
            ListNode fast = head;
            ListNode slow = head;
            //让fast先走k步
            while (k > 0){
                fast = fast.next;
                k--;
            }
            while (fast != null && n > 0){
                fast = fast.next;
                slow = slow.next;
                n--;
            }
            System.out.println(slow == null ? 0 : slow.val);
        }
         */

        //直接利用输入的数字的形式进行取巧
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null){
            int num = Integer.parseInt(str);
            String[] s = br.readLine().split(" ");
            int num2 = Integer.parseInt(br.readLine().trim());
            if (num2 <= 0 || num2 > s.length){
                System.out.println(num2);
            }else {
                System.out.println(s[s.length - num2]);
            }
        }
    }
}
