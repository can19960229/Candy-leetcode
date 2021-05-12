package leetcode;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/8 22:57
 *
 * @Classname leetcode_395
 * Description: 测试
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class leetcode_395 {
    public static int longestSubstring(String s, int k) {
        if (s.length() < k)
            return 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) < k){
                int res = 0;
                System.out.println(Arrays.toString(s.split(String.valueOf(c))));
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res,longestSubstring(t,k));
                }
                return res;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("baabbc",3));
    }
}
