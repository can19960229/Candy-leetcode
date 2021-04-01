package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/31 19:36
 *
 * @Classname HJ3
 * Description: 随机数
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){

            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);//对输入的数组进行排序
            System.out.println(arr[0]);//对排好序的数组中重复的数组进行选择输出，首先输出第一个数
            for (int i = 1; i < n; i++) {
                if (arr[i] != arr[i - 1]){
                    System.out.println(arr[i]);
                }
            }


            //方法二
            /*
            TreeSet<Integer> set = new TreeSet<>();
            int n = sc.nextInt();
            if (n > 0){
                for (int i = 0; i < n; i++) {
                    set.add(sc.nextInt());
                }
            }
            for (Integer i : set) {
                System.out.println(i);
            }

             */
        }
    }
}
