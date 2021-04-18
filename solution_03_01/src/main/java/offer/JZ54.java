package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/18 17:00
 *
 * @Classname JZ54
 * Description: 字符流中第一个不重复的字符
 */

/**
 *
 */
public class JZ54 {
    int[] hashArray = new int[256];
    StringBuffer sb = new StringBuffer();
    public void Insert(char ch){
        sb.append(ch);
        if (hashArray[ch] == 0){
            hashArray[ch] = 1;
        }else {
            hashArray[ch] += 1;
        }
    }
    public char FirstAppearingOnce(){
        char[] strs = sb.toString().toCharArray();
        for (char c : strs) {
            if (hashArray[c] == 1){
                return c;
            }
        }
        return '#'; //如果当前字符流没有存在出现一次的字，返回#字符
    }

}
