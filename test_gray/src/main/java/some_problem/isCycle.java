package some_problem;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/7/16 19:37
 * version 1.0
 * Description: 判断单向链表是否有环
 */

/**
 *
 */
public class isCycle {
    /**
     * 判断是否有环
     * @param head  链表头节点
     * @return
     */

    public static boolean isCycle(Node head){
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){  //一旦两环相遇 则说明链表有环
                return true;
            }
        }
        return false;
    }
    /**
     * 如果链表有环，如何求出环的长度
     */

    public static int getCycleLength(Node head){
        if (head ==null){
            return 0;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            while (fast == slow){
                int len = 1;
                fast = fast.next.next;
                slow = slow.next;
                while (fast!= slow){
                    len ++; //统计前进的循环次数
                    fast = fast.next.next;  //快的走两步 慢的走一步
                    slow = slow.next;
                }
                return len; //环长 = 每一次速度差 * 前进次数  （这里的速度差为1，则环长为前进次数）

            }
        }
        return 0;

    }

    /**
     *如果链表有环，求出入环节点
     */

    public static int getCycle(Node head){
        if (head ==null){
            return 0;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            while (fast == slow){   //判断第一次相遇
                fast = head;    //第一次相遇时 fast移到链表开头
                while (fast != slow){   //移到开头 但是入环点不在起点 并决定第二次相遇的点之前 都一步一步的走 第二次相遇时停止
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow.data;   //相遇后返回所在位置，即入环点

            }
        }
        return 0;

    }

    /**
     * 链表节点
     */
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        System.out.println(isCycle(node1));
        System.out.println(getCycleLength(node1));
        System.out.println(getCycle(node1));
    }
}
