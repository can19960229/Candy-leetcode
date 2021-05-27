package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/20 19:59
 *
 * @Classname LRU_3
 * Description: HashMap LinkedList 实现LRUCache
 */

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 */
public class LRUCache {
    private int capacity;
    private HashMap<Integer,Integer> map;
    private LinkedList<Integer> list;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    public int get(int key){
        if (map.containsKey(key)){
            list.remove(key);
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }
    public void put(int key,int value){
        //如果包含这个key
        if(map.containsKey(key)){
            list.remove(key);
            list.addLast(key);
            map.put(key,value);
            return;
        }
        //不包含这个key
        if (list.size() == capacity){
            //移除
            Integer integer = list.removeFirst();
            map.remove(integer);
            list.addLast(key);
            map.put(key,value);
        }else {
            list.addLast(key);
            map.put(key,value);
        }
    }
}
