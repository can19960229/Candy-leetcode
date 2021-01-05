package leetcode; /**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/9/19 19:59
 * version 1.0
 * Description: 测试
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class leetcode_05 {
    public static String longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Character[] arr = new Character[s.length()];
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char kk = s.charAt(i);
            arr[i] = kk;
            System.out.println("测试······" + arr[i]);

            if (map.containsKey(kk)) {//查看集合中时候包含相同的字母，有相同字母则为回文数
                int count = i;//如果数组中发现相同字母，则记录第二次出现的字母的下标
                ans = ans+ kk;
                System.out.println(ans);
                for (int j = map.get(s.charAt(i)); j <= count; j++) {
                    //输出从一开始的字母到又重复字母的字符串
                    System.out.println("========" + arr[j + 1]);
                    //ans += String.valueOf(arr[j+1]);
                    break;
                }
            }
            map.put(s.charAt(i), i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbadbad"));
    }

}
