package collection;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/14 17:45
 * version 1.0
 * Description: 测试
 */

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        //键盘录入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        //创建一个TreeMap集合
        TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();

        //把字符串转成字符数组
        char[] chs = line.toCharArray();

        //遍历数组得到每一个字符
        for (char ch:chs
             ) {
            //拿这个字符到TreeMap集合中找值
            Integer i = tm.get(ch);

            //如果是null
            if (i==null){
                tm.put(ch,1);

            }else {
                i++;
                tm.put(ch,i);
            }
        }
        StringBuilder sb= new StringBuilder();
        //遍历TreeMap集合，拼接成一个字符串
        Set<Character> set = tm.keySet();
        for (Character key:set
             ) {
            Integer value = tm.get(key);
            sb.append(key).append("(").append(value).append(")");
        }
        String result = sb.toString();

        //输出结果
        System.out.println(result);
    }
}
