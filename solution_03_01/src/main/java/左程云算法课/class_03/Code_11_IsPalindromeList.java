package 左程云算法课.class_03;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2021/1/7 20:58
 * version 1.0
 * Description: 测试
 */

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 */
public class Code_11_IsPalindromeList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    // n 的空间复杂度
    public static boolean isPalindromel1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * n/2 的空间复杂度
     * @param head
     * @return
     */
    public static boolean isPalindromel2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null){
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }



}
