package 面试题目必会.招银;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/25 22:54
 *
 * @Classname 字符串反转
 * Description: 测试
 */

import java.util.Arrays;

/**
 *
 */
public class 字符串反转 {
    public static String reverse(String str){
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < str.length();i++){
            res.insert(0, str.charAt(i));
        }
        return res.toString();
    }
    public static String reve(String s){
        char[] c = s.toCharArray();
        for(int left = 0,right = c.length - 1; left < right ;left++,right--){
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
        }
        return Arrays.toString(c);
    }
}
