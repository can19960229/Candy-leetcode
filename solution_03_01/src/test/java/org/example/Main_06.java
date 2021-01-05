package org.example;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/20 12:41
 * version 1.0
 * Description: 测试
 */

import java.util.*;

public class Main_06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int target = sc.nextInt();
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> arrayLists = combinationSum2(num, target);
        System.out.println(arrayLists.size());
    }

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (num == null || num.length == 0) {
            return list;
        }
        Arrays.sort(num);
        dfs(num, 0, target, ls);
        return list;
    }

    private static void dfs(int[] arr, int index, int sum, ArrayList<Integer> ls) {
        if (sum < 0) {
            return;
        }

        if (sum == 0) {
            if (!list.contains(ls)) {
                list.add(new ArrayList<>(ls));
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {
            ls.add(arr[i]);
            //此处从i+1开始
            dfs(arr, i + 1, sum - arr[i], ls);
            ls.remove(ls.size() - 1);
        }
    }
}
