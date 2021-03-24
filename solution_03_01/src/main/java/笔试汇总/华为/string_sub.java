package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/24 19:07
 *
 * @Classname string_sub
 * Description: 给你一个纯数字字符串s，请返回连续单一数字子串的个数
 * 提示：
 *  1 <= s.length <= 100
 *  输入描述：
 *      “11121”
 *  解释：
 *      只含单一字母的子串分别是：“111” 、“11”， “1” “2”
 *
 *  “111” 出现1次
 *  “11”  出现2次
 *  “1”   出现4次
 *  “2”  出现1次
 *  共  1 + 2 + 4 + 1 = 8
 */

import java.util.HashMap;

/**
 *
 */
public class string_sub {

    /**
     * 错误代码
     * @param str
     * @return
     */
    public static int test(String str){
        char[] chars = str.toCharArray();
        int left = 0;
        int right = 0;
        int res = str.length();
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            while (left < str.length() - 1 || right < str.length() - 1){
                if (chars[left] == chars[right + 1]){
                    right ++;
                    String s = str.substring(left,right);
                    map.put(s, map.getOrDefault(s,0)+1);
                    // System.out.println(map.toString());
                }else {
                    left++;

                    right = left;

                    map.put(str.substring(left,right),map.get(str.substring(left,right)));
                    // System.out.println(map.toString());

                    }
            }
        }

        System.out.println(map.toString());

        for (Integer value : map.values()) {
            if (value == null)
                continue;
            res = res + value;
            //System.out.println(value);
        }
        return res;
    }

    /**
     * 暴力法
     * @param str
     * @return
     */
    public static int test_1(String str) {
        int res = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            for (int j = i+1; j<=str.length(); j++){
                map.put(str.substring(i,j),map.getOrDefault(str.substring(i,j),0)+ 1);
            }
        }
        System.out.println(map.toString());
        //遍历map的所有key
        for (String key:map.keySet()){
            //System.out.println("key= "+key+" and value= "+map.get(key));
            //判断key中的字符是否都是相同字符
            if (isSameChars(key)){
                System.out.println("key= "+key+" and value= "+map.get(key));
                res = res +map.get(key);
            }

        }

        return res;
    }

    public static boolean isSameChars (String str) throws IllegalArgumentException {
        if (str == null)
            throw new IllegalArgumentException("Input string should not be null.");
        else if (str.length() < 2)
            return true;
        char first = str.charAt(0);
        for (int i=1; i<str.length(); i++)
            if (str.charAt(i) != first)
                return false;
        return true;
    }


    public static void main(String[] args) {
        System.out.println(test("111121"));
    }
}
