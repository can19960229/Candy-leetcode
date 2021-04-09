package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/9 10:07
 *
 * @Classname LRU
 * Description: 采用双向链表和哈希表实现LRU算法
 */

import java.util.HashMap;

/**
 *
 */
public class LRU {

    /**
     * 定义双链表的节点类
     */
    class Node{
        public int key,val;
        public Node next,prev;
        public Node(int k,int v){
            this.key = k;
            this.val = v;
        }
    }
    /**
     * 依靠Node构建一个双链表
     */
    class DoubleList{
        //头尾虚节点
        private Node head,tail;
        //链表元素数
        private int size;

        public DoubleList(){
            //初始化双向链表的数据
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        //在链表尾部添加节点x,时间复杂度为O（1）
        public void addLast(Node x){
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }
        //删除链表中x节点（x一定存在）
        //由于是双链表且给的是目标Node节点，时间复杂度为O（1）
        public void remove(Node x){
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }
        //删除链表中第一个节点，并返回该节点，时间复杂度为O(1)
        public Node removeFirst(){
            if (head.next == tail)
                return null;
            Node first = head.next;
            remove(first);
            return first;
        }
        //返回链表长度，时间复杂度O（1）
        public int size(){
            return size;
        }

    }

    /**
     * 构建LRU cache，把双向链表和哈希表结合起来
     */
    class LRUCache{
        //key -> Node(key,val)
        private HashMap<Integer,Node> map;
        //Node(k1,v1) <-> Node(k2,v2)....
        private DoubleList cache;
        //最大容量
        private int cap;
        public LRUCache(int capacity){
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }
        /**
         * 将某个key提升为最近使用
         */
        private void makeRecently(int key){
            Node x = map.get(key);
            //先从链表中删除这个节点
            cache.remove(x);
            //重新插到队尾
            cache.addLast(x);
        }
        /**
         * 添加最近使用的元素
         */
        private void addRecently(int key,int val){
            Node x = new Node(key,val);
            //链表尾部就是最近使用的元素
            cache.addLast(x);
            //别忘了在map中添加key的映射
            map.put(key,x);
        }
        /**
         * 删除某一个key
         */
        private void deleteKey(int key){
            Node x = map.get(key);
            //从链表中删除
            cache.remove(x);
            //从map中删除
            map.remove(key);
        }
        /**
         * 删除最久未使用的元素
         */
        private void removeLeastRecently(){
            //链表头部的第一个元素就是最久未使用的
            Node deleteNode = cache.removeFirst();
            //别忘了从map中删除它的key
            map.remove(deleteNode.key);
        }
        /**
         * 实现LRU的get方法
         */
        public int get(int key){
            if (!map.containsKey(key)){
                return -1;
            }
            //将数据提升为最近使用的
            makeRecently(key);
            return map.get(key).val;
        }
        /**
         * 实现 LRU的put方法
         */
        public void put(int key,int val){
            if (map.containsKey(key)){
                //删除旧的数据
                deleteKey(key);
                //新插入的数据为最近使用的数据
                addRecently(key,val);
                return;
            }
            //如果容量已满
            if (cap == cache.size){
                //删除最久未使用的元素
                removeLeastRecently();
            }
            //添加为最近使用的元素
            addRecently(key,val);
        }

    }


}
