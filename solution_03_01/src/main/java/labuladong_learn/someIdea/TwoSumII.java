package labuladong_learn.someIdea;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/26 15:27
 *
 * @Classname TwoSumII
 * Description: 两数之和
 */

import java.util.*;

/**
 * 返回nums中能够凑出target的两个元素的值
 * nums=[1,3,5,6],target=9
 * 返回两个元素[3,6]
 */
public class TwoSumII {

    Map<Integer,Integer> freq = new HashMap<>();
    //向数据结构中添加一个数 number
    public void add(int number){
        //记录number出现的次数
        freq.put(number,freq.getOrDefault(number,0) + 1);
    }
    //寻找当前数据结构中是否存在两个数的和为value
    public boolean find(int value){
        for (Integer key : freq.keySet()){
            int other = value - key;
            //情况一
            if (other == key && freq.get(key) > 1){
                return true;
            }
            //情况二
            if (other != key && freq.containsKey(other)){
                return true;
            }
        }
        return false;
    }

    /**
     * 如果频繁操作find方法，则每次都要O(N)的时间
     */
    Set<Integer> sum = new HashSet<>();
    List<Integer> nums = new ArrayList<>();
    public void Add(int number){
        //记录所有可能组成的和
        for (int n : nums){
            sum.add(n + number);
        }
        nums.add(number);
    }
    public boolean Find(int value){
        return sum.contains(value);
    }
}
