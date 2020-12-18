package cap_2_1;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/22 17:33
 * version 1.0
 * Description: 测试
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 排序算法模板
 */
public class Example {
    public static void sort(Comparable[] a){
        //实现排序算法
    }

    /**
     * 对元素进行比较
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) <0;
    }

    /**
     * 将元素交换位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + "");
        StdOut.println();
        }
    }

    public static boolean isSorted(Comparable[] a) {
        //测试数组元素是否有序
        for (int i = 0; i < a.length; i++) {
            if (less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //从标准输入读取字符串，将它们排序并输出

        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);

    }

}
