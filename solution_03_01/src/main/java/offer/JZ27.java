package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/25 10:12
 *
 * @Classname JZ27
 * Description: 字符串的排列
 */

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 把字符串分为两部分，一部分是字符串的第一个字符；另一部分是第一个字符以后的字符，
 * 第一步：求所有可能出现在第一个位置的字符，即把第一个字符和后面所有字符进行逐个交换
 * 第二步：固定第一个字符，求后面所有字符的排列，此时仍要后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符
 */
public class JZ27 {
    
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        Permutation(chars,0,res);
        //利用TreeSet进行排序和去除重复元素
        TreeSet set = new TreeSet(res);
        res.clear();
        res.addAll(set);
        return res;

    }

    private static void Permutation(char[] chars, int beginIndex, ArrayList<String> res) {
        //如果已经交换到最后一位，那么将这个字符串添加进结果集合
        if (beginIndex == chars.length - 1){
            res.add(new String(chars));
        }else {
            for (int i = beginIndex;i < chars.length;i++){
                //如果第i个元素和开始的元素相同，则两个元素就不交换
                if (i != beginIndex && chars[i] == chars[beginIndex])
                    continue;
                //交换
                char temp = chars[beginIndex];
                chars[beginIndex] = chars[i];
                chars[i] = temp;
                //递归
                Permutation(chars,beginIndex + 1,res);
                //再换回来
                temp = chars[beginIndex];
                chars[beginIndex] = chars[i];
                chars[i] = temp;
            }
        }
    }
}
