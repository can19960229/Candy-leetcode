package cap_1_3;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/18 10:22
 * version 1.0
 * Description: 下压堆栈（链表实现）
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 *
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first; //栈顶（最近添加的元素
    private int N;  //元素数量
    private class Node{
        //定义了节点的嵌套类
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        //向栈顶添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop(){
        //从栈顶删除元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new listIterator();
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
        //创建一个栈并根据StdIn中的指示压入或弹出字符串
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty())
                StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
