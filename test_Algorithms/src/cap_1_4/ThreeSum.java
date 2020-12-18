package cap_1_4;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/18 17:13
 * version 1.0
 * Description:
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 统计一个而文件中所有和为0的三整数元组的数量  N³
 */
public class ThreeSum {
    public static int count(int [] a){
        //统计和为0的元素
        int N = a.length;
        int cnr = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (a[i] + a[j] +a[k] == 0){
                        cnr ++;
                    }
                }
            }
        }
        return cnr;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
}
