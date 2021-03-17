package org.example;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/13 14:52
 *
 * @Classname Tester_02
 * Description: 测试
 */

import java.util.*;

/**
 *
 */
public class Main {
    //l i n k e

    public static List<List<Integer>> res = new ArrayList<>();


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int[] nums = new int[r];

        // 定义全局变量保存结果
        StringBuffer sb = new StringBuffer();

        //1既不是质数也不是和数，使用i从2开始。
        for (int i = 2; i <= r; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;//到了1000内的质数，就跳出循环，并输出结果。
                }
            }
            if (flag) {
                nums[i] = i;
                int k = nums.length;
                res.add(Collections.singletonList(nums[i]));

                //sb.append(combine(nums[i],k));




                System.out.println(sb.append(res.toString()).toString());

            }


        }

    }

    //全排列问题

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }


    }
}
