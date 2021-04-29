package labuladong_learn.someIdea.Conquer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/23 15:23
 *
 * @Classname combine
 * Description: 组合
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k)
            return res;
        //从1开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        //递归终止条件是path的长度等于k
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        //遍历可能的搜索起点
        for (int i = begin;i <= n;i++){
            //向路径变量里添加一个数
            path.addLast(i);
            //下一轮搜索，设置的搜索起点要加1，因为组合数里不允许出现重复的元素
            dfs(n,k,i+1,path,res);
            //回溯
            path.removeLast();
        }
    }
}
