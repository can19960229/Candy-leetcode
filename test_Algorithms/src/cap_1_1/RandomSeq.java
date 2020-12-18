package cap_1_1;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/17 16:59
 * version 1.0
 * Description: 产生随机数 把产生的随机数重定向输出到命名为randomresult.txt的文件中
 * 重定向输出文件需要在run->edit configurations里面设置需要重定向输出的文件路径和程序参数
 */


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 */
public class RandomSeq {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(lo,hi);
            StdOut.printf("%.2f\n",x);
        }
    }
}
