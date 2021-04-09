package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/9 10:49
 *
 * @Classname LRU_2
 * Description: 使用java内置类型LinkedHashMap来实现LRU算法
 */

import java.util.LinkedHashMap;

/**
 *
 */
public class LRU_2 {
    static class LRUCache{
        int cap;
        LinkedHashMap<Integer,Integer> cahce = new LinkedHashMap<>();
        public LRUCache(int capacity){
            this.cap = capacity;
        }
        public int get(int key){
            if (!cahce.containsKey(key)){
                return -1;
            }
            //将key变为最近使用
            makeRecently(key);
            return cahce.get(key);
        }

        public void put(int key,int val){
            if (cahce.containsKey(key)){
                //修改key值
                cahce.put(key,val);
                //将key变为最近使用
                makeRecently(key);
                return;
            }
            if (cahce.size() >= this.cap){
                //链表头部就是最久未使用的key
                int oldestKey = cahce.keySet().iterator().next();
                cahce.remove(oldestKey);
            }
            //将新的key添加到链表尾部
            cahce.put(key,val);
        }

        private void makeRecently(int key) {
            int val = cahce.get(key);
            //删除key，重新插入到队尾
            cahce.remove(key);
            cahce.put(key,val);
        }
    }
}
