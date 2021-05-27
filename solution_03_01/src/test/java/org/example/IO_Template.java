package org.example;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/20 10:39
 *
 * @Classname IO_Template
 * Description: 测试
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class IO_Template {
    public static void main(String[] args) {
        IO();
        test4();
    }
    /**
     * 多行输入元素，其中第一行几个数字表示下面几行的个数。
     * // 输入如下
     * 输入的数据分别表示的是的数组的大小
     * 3 4
     * 10 2 3
     * 11 4 5 6
    */
    public static void test1(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] num1 = new int[m];
            int[] num2 = new int[n];
            for (int i = 0; i < m; i++) {
                num1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                num2[i] = sc.nextInt();
            }

            //显示结果的代码
            System.out.println("输出：");
            System.out.println(Arrays.toString(num1));
            System.out.println(Arrays.toString(num2));

        }
    }

    /**
     * 在一行输入多个参数
     * ABB CCC DDD  EEE 123 435
     */
    public static void test2(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();  //读取一行
            String[] strIn = str.trim().split(" ");   //以空格分割
            System.out.println(Arrays.toString(strIn));    //显示结果
        }
    }

    /**
     * java中从控制台输入多行数据 按回车键输入空行结束
     * 4
     * 5
     * 6
     * 空格
     */

    public static void test3(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        do{
            //读取到的每一行的字符串
            String string = sc.nextLine();
            if (string.equals("")){
                break;
            }
            list.add(Integer.valueOf(string));
        }while (true);
        //显示结果
        for (int v : list) {
            System.out.println(v);
        }
    }

    /** 这样是有非法信息的输入 怎么防止的数据的正常输入
     * 有异常的输入结果  1, 2, 3
     */

    public static void IO(){
        Scanner sc = new Scanner(System.in);
        String oldstr = sc.nextLine().trim();
        String str = "";
        for (int i = 0; i < oldstr.length(); i++) {
            if (oldstr.charAt(i) != ' '){
                str += oldstr.charAt(i);
            }
        }
        System.out.println(str);
    }

    public static void bf() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().split(",");
        //读取一行进行的类型的转换
        long n = Long.valueOf(bf.readLine());
        for (String s : split) {
            System.out.println(s + " ");
        }
        System.out.println();
        System.out.println(n + "============");
    }

    /**
     * 输入  保存的是hashmap的存储结构  list的每一个int[] 的数组
     */
    public static void test4(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().trim().split(" ");
            int[] array = new int[str.length];
            for (int j = 0; j < array.length; j++) {
                array[j] = Integer.valueOf(str[j]);
            }
            list.add(array);
        }
        for (int[] array : list) {
            for (int value : array) {
                System.out.println(value + " ");
            }
            System.out.println();
        }
    }


}
