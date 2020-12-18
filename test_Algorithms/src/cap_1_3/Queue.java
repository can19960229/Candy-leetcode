package cap_1_3;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/18 10:47
 * version 1.0
 * Description: 先进先出队列（链表实现
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 *
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first; //指向最早添加的结点的链接
    private Node last;  //指向最近添加的结点的链接
    private int N;  //队列中的元素数量
    private class Node{
        //定义了结点的嵌套类
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return N;
    }
    public void enqueue(Item item){
        //向表尾添加元素
        Node oldfirst = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        }else{
            oldfirst.next = last;
        }
        N++;
    }
    public Item dequeue(){
        //从表头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }

    /**
     * 支持迭代
     * 迭代器会遍历链表并将当前节点保存在current变量中
     * @return
     */

    @Override
    public Iterator<Item> iterator() {
        return  new listIterator();
    }
    private class listIterator implements Iterator<Item> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        //创建一个队列并操作字符串入队或者出队
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty())
                StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }



}
