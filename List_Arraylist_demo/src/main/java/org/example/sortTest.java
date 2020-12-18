package org.example;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/8 16:18
 * version 1.0
 * Description:
 * 创建String泛型的List,放入10条随机的字符串
 * 每条字符串的长度为10以内的随机整数
 * 每条字符串的字符都是随机生成的字符，字符可以重复
 * 每条随机生成的字符串不可以重复
 */

import java.util.*;
public class sortTest {
    public List<String> ls = new ArrayList();
    public String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ012345678";
    Random randomInt = new Random();
    Integer k;



    public List<String> creatList(){
        for (int i=0; i<10; i++){
            StringBuffer sb = new StringBuffer();
            do {
                k = randomInt.nextInt(10);
                for (int j=0; j<k+1; j++){
                    sb.append(str.charAt(randomInt.nextInt(str.length())));
                }
            }while (ls.contains(sb));
            ls.add(sb.toString());
        }
        return ls;
    }

    public void sort(List ls){
        System.out.println("-----------排序前输出：-----------");
        for(Object str:ls){
            System.out.println(str);
        }

        Collections.sort(ls);

        System.out.println("-----------排序后输出：-----------");
        for(Object str:ls){
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        sortTest st = new sortTest();
        st.sort(st.creatList());
    }

}