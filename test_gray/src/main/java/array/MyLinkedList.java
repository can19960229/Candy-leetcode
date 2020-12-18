package array;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/18 21:36
 * version 1.0
 * Description: 单链表的增删改查
 */

/**
 *
 */
public class MyLinkedList {


    //头节点指针
    private Node head;
    //尾节点指针
    private Node last;
    //链表实际长度
    private int size;

    /**
     * 链表插入元素
     * @param data  插入元素
     * @param index 插入位置
     */
    public void insert(int data,int index) throws Exception {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node insertedNode = new Node(data);
        if (size == 0){
            head = insertedNode;
            last = insertedNode;
        }else if (index == 0) {
            //插入头部   把新节点的next指针指向原先的头节点
            //                把新节点变成链表的头节点
            insertedNode.next = head;
            head = insertedNode;
        }else if (size == index){
            //插入尾部  把最后一个节点的next指针指向新插入的节点
            last.next = insertedNode;
            last = insertedNode;
        }else{
            //插入中间   插入位置的前置节点的next指针指向插入的新节点
            //                将新节点的next指针指向前置节点的next指针原先所指向的节点
            Node prevNode = get(index -1);
            Node nextNode = prevNode.next;
            prevNode.next = insertedNode;
            insertedNode.next = nextNode;
        }
        //插入元素后需要给链表长度加一
        size++;
    }

    /**
     * 链表删除元素
     * @param index 删除的位置
     * @return removeNode 返回删除的节点
     */
    public Node remove(int index){
        if (index < 0||index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围！！");
        }
        Node removeNode = null;
        if (index == 0){
            //删除头节点 链表的头节点设为原先头节点的next指针即可
            removeNode = head;
            head = head.next;
        }else if (index == size-1){
            //删除尾节点 直接将倒数第二个节点的next指针指向空即可
            Node prevNode = get(index -1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else {
            //删除中间节点 把删除及诶单的前置节点的next指针指向要删除元素的下一个节点
            Node prevNode = get(index -1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removeNode;
    }

    /**
     * 查找链表元素
     * @param index 查找的位置
     * @return temp
     */

    private Node get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for (int i = 0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */

    public void output(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * 链表节点
     */
    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }


    }

    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(3,0);
        myLinkedList.insert(7,1);
        myLinkedList.insert(9,2);
        myLinkedList.insert(5,3);
        myLinkedList.output();
        System.out.println("------------------");
        myLinkedList.insert(6,1);
        myLinkedList.output();
        System.out.println("------------------");

        myLinkedList.remove(0);

        myLinkedList.output();
        System.out.println("------------------");

    }
}
