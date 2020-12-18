package some_problem;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/5 20:08
 * version 1.0
 * Description: LRU算法实现
 */

import java.util.HashMap;

/**
 *  删除最近最少使用 一种内存管理算法 内存不够用时，从哈希表中移除一部分最少被访问的用户
 */
public class LRUCache {
    /**
     * 定义节点信息
     */
    class Node{
        Node(String key,String value){
            this.key = key;
            this.value = value;
        }
        public Node pre;
        public Node next;
        public String key;
        public String value;
    }
    private Node head;
    private Node end;
    //缓存存储上限
    private int limit;
    private HashMap<String,Node> hashMap;


    public LRUCache(int limit){
        this.limit = limit;
        hashMap = new HashMap<String,Node>();
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if (node == null){
            return null;
        }
        //刷新被访问的节点
        refreshNode(node);
        return node.value;
    }



    public void put(String key,String value){
        Node node = hashMap.get(key);
        if (node  == null){
            //如果key不存在，则插入key-value
            if (hashMap.size() >= limit){
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key,value);
            addNode(node);
            hashMap.put(key,node);
        }else{
            //如果key存在，则刷新key-value
            node.value = value;
            refreshNode(node);
        }
    }
    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    /**
     * 刷新被访问的节点位置
     * @param node  被访问的节点位置
     */
    private void refreshNode(Node node) {
        //如果访问的是尾节点，则无须移动节点
        if (node == end){
            return;
        }
        //移除节点
        removeNode(node);
        //重新插入节点
        addNode(node);
    }




    /**
     * 删除节点
     * @param node  要删除的节点
     * @return
     */
    private String removeNode(Node node) {
        if (node == head && node == end){
            //移除唯一的节点
            head = null;
            end = null;
        }else if (node == end){
            //移除尾节点
            end= end.pre;
            end.next = null;
        }else if (node == head){
            //移除头节点
            head = head.next;
            head.pre = null;
        }else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    /**
     * 尾部插入节点
     * @param node  要插入的节点
     */
    private void addNode(Node node){
        if (end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null){
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001","用户1信息");
        lruCache.put("002","用户1信息");
        lruCache.put("003","用户1信息");
        lruCache.put("004","用户1信息");
        lruCache.put("005","用户1信息");
        lruCache.get("002");
        lruCache.put("004","用户2信息更新");
        lruCache.put("006","用户6信息");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }


}
