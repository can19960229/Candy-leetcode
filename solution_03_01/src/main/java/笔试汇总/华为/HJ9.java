package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/30 15:29
 *
 * @Classname HJ9
 * Description: 提取不重复的整数
 */

import java.util.*;

/**
 *  题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 *
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 *
 * 9876673
 * 输出
 *
 * 37689
 */
public class HJ9 {
    /**
     *
     * @param a
     * @return
     */
    public static StringBuilder test(int a){
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int b;
        while (a != 0){
            b = a % 10;
            if (set.add(b)){
                sb.append(b);
            }
            a = a / 10;
        }
        return sb;
    }

    /**
     *
     * @param a
     * @return
     */
    public static StringBuilder test01(int a){
        Set<Integer> set = new LinkedHashSet<>();
        int b;
        while (a != 0){
            b = a % 10;
            set.add(b);
            a = a / 10;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer c = iterator.next();
            sb.append(c);
        }
        return sb;
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(test(a));
        System.out.println(test01(a));
        sc.close();
    }

}
