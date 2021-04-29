package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 14:14
 *
 * @Classname JZ43
 * Description: 左旋转字符串
 */

/**
 *
 */
public class JZ43 {

    //方法一：利用额外数组，进行反转，并拼接成字符串
    public static String test1(String str,int n){
        if (str == null || n > str.length())
            return str;
        char[] chars = str.toCharArray();
        Character[] num = new Character[str.length()];
        int j = chars.length - n;
        for (int i = 0; i < chars.length; i++) {
            if (i >= n) //如果下标比要反转的参数要大，则直接复制到num数组中
                num[i - n] = chars[i];
            else{

                num[j] = chars[i];
                if (j < chars.length - 1){
                    j++;
                }
            }
        }
        StringBuilder s = new StringBuilder();
        for (Character nn : num) {
            s.append(nn);
        }
        return s.toString();
    }

    //方法二：利用字符串切片
    public static String test2(String str,int n){
        return str.substring(n,str.length()) + str.substring(0,n);
    }
    //方法三：列表遍历拼接 + 求余预算
    public static String test3(String str,int n){
        StringBuilder res = new StringBuilder();
        for (int i = n;i < n + str.length();i++){
            res.append(str.charAt(i % str.length()));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(test2("sdfsdfirf",2));
    }

}
