package cap_1_3;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/18 13:51
 * version 1.0
 * Description: 测试
 */

import java.util.Iterator;

/**
 *
 */
public class Bag<Item> implements Iterable<Item> {

    private Node frist; // 链表的首结点
    private class Node{
        Item item;
        Node next;
    }
    public void add(Item item){
        //和Stack的push()方法完全相同
        Node oldfrist = frist;
        frist = new Node();
        frist.item = item;
        frist.next = oldfrist;
    }


    @Override
    public Iterator<Item> iterator() {
        return (Iterator<Item>) new ListIterator();
    }
    private class ListIterator implements Iterable<Item>{
        private Node current = frist;
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){

        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }


        @Override
        public Iterator<Item> iterator() {
            return null;
        }
    }
}
