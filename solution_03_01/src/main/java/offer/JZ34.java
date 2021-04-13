package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/12 11:25
 *
 * @Classname JZ34
 * Description: 第一个只出现一次的字符
 */

import java.util.HashMap;

/**
 *
 */
public class JZ34 {

    /**
     * 数组统计出现的次数
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int time = 0;
            for (int j = 0; j < c.length; j++) {
                if (c[i] == c[j] && i != j) {//保证排除自己与自己相等
                    time++;
                    break;
                }
            }
            if (time == 0) {
                return c[i];
            }
        }
        return ' ';
    }
    public int firstUniqChar_1(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        int[] res = new int[60];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            res[c-'A']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (res[arr[i] - 'A'] == 1)
                return i;
        }
        return -1;
    }


        /**
         * hashMap存储字符出现的次数
         * @param str
         * @return
         */
    public int FirstNotRepeatingChar(String str) {
        if(str.length() == 0){
            return -1;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length();i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
            }else{
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }
        }

        for(int i = 0; i < str.length();i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}

