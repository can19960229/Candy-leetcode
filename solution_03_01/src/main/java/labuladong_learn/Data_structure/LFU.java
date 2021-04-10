package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/10 9:36
 *
 * @Classname LFU
 * Description: LFU 淘汰那些使用次数最少的数据
 */

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 *
 */
public class LFU {
    static class LFUCache{
        //key到val的映射，后面称为KV表
        HashMap<Integer,Integer> keyToVal;
        //key到freq的映射，后面称为KF表
        HashMap<Integer,Integer>keyToFreq;
        //freq到key列表的映射，后面称为FK表
        HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
        //记录最小的频次
        int minFreq;
        //记录LFU缓存的最大容量
        int cap;

        //构造容量为capacity的缓存
        public LFUCache(int capacity){
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
            this.cap = capacity;
            this.minFreq = 0;
        }
        //在缓存中查询key
        public int get(int key){
            if (!keyToVal.containsKey(key)){
                return -1;
            }
            //增加key对应的freq
            increaseFreq(key);
            return keyToVal.get(key);
        }

        //将key和val存入缓存
        public void put(int key,int val){
            if (this.cap <= 0)
                return;
            //若key已存在，修改对应的val即可
            if(keyToVal.containsKey(key)){
                keyToVal.put(key,val);
                //key对应的freq加一
                increaseFreq(key);
                return;
            }
            //key不存在，需要插入
            //容量已满的话需要淘汰一个freq最小的key
            if (this.cap <= keyToVal.size()){
                removeMinFreqKey();
            }
            //插入key和val，对应的freq为1
            //容量已满的话需要淘汰一个freq最小的key
            if (this.cap <= keyToVal.size()){
                removeMinFreqKey();
            }
            //插入key和val，对应的freq为1
            //插入KV表
            keyToVal.put(key,val);
            //插入KF表
            keyToFreq.put(key,1);
            //插入FK表
            freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            //插入新key后最小的freq肯定是1
            this.minFreq = 1;
        }

        /**
         * 移除最少使用频次的键
         */
        private void removeMinFreqKey() {
            //freq最小的key列表
            LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
            //其中最先被插入的那个key就是该被淘汰的key
            int deleteKey = keyList.iterator().next(); //
            //更新FK表
            keyList.remove(deleteKey);
            if (keyList.isEmpty()){
                freqToKeys.remove(this.minFreq);
                //不需要更新minFreq

            }
            //更新KV表
            keyToVal.remove(deleteKey);
            //更新KF表
            keyToFreq.remove(deleteKey);
        }


        private void increaseFreq(int key) {
            int freq = keyToFreq.get(key);
            //更新KF表
            keyToFreq.put(key,freq + 1);
            //更新FK表
            //将key从freq对应的列表中删除
            freqToKeys.get(freq).remove(key);
            //将key加入freq + 1对应的列表中
            /*
            put在放入数据时，如果放入数据的key已经存在与Map中，最后放入的数据会覆盖之前存在的数据，

            而putIfAbsent在放入数据时，如果存在重复的key，那么putIfAbsent不会放入值。
            putIfAbsent   如果传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null

             */
            freqToKeys.putIfAbsent(freq + 1,new LinkedHashSet<>());
            freqToKeys.get(freq + 1).add(key);

            //如果freq对应的列表空了，移除这个freq
            if (freqToKeys.get(freq).isEmpty()){
                freqToKeys.remove(freq);
                //如果这个freq恰好是minFreq，更新minFreq
                if (freq == this.minFreq){
                    this.minFreq++;
                }
            }
        }
    }

}
