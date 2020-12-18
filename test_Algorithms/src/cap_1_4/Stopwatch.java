package cap_1_4;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/19 19:14
 * version 1.0
 * Description: P110   计时器用于记录程序运行的时间
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 *  P110
 *  统计所有和为0的三整数元组的数量
 *  增长的数量级N3  （N的3次方）
 */
public class Stopwatch {
    private final long start;
    public Stopwatch(){
        start = System.currentTimeMillis();//获取系统当前时间以毫秒为单位
    }
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000,1000000);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + " triples " + time + " seconds ");

    }
}
