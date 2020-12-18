package cap_1_4;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/19 19:35
 * version 1.0
 * Description: P120 计算和为0的三元组的数目
 */

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 问题的规模为：N²lgN
 */
public class ThreeSumFast {

        public static int count(int a[]) {
            int N = a.length;
            Arrays.sort(a);
            int cun = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (BinarySearch.indexOf(a, -a[i] - a[j]) > j) {
                        cun++;
                    }
                }
            }

            return cun;
        }

        public static void main(String[] args) {
            int N=1000;
            int a[]=new int[N];
            for(int i=0;i<N;i++){
                a[i]= StdRandom.uniform(-10000,10000);
            }
            System.out.println(count(a));
        }



}
