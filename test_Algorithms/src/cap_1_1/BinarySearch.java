package cap_1_1;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/7 21:45
 * version 1.0
 * Description: 二分查找
 *  重定向的输件为 tinyT.txt tinyW.txt
 *  对比两个文件中的数是否相同 把不同的数通过二分查找的方式找出，并输出在控制台上
 *
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {
    public static int rank(int key,int[] a){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                {
                    hi = mid - 1;
                }
            else if (key > a[mid])
                {
                    lo = mid + 1;
                }
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if (rank(key,whitelist) == -1){
                StdOut.println(key);
            }
        }
        System.out.println("load");
    }
}
