package leetcode; /**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/9/22 14:36
 * version 1.0
 * Description: DFA 有限状态机
 */

/**
 *
 */
public class leetcode_08 {
    public static int myAtoi(String str){
        //去掉str前后的空格
        str = str.trim();
        //如果字符串的长度为0
        if (str.length() == 0){
            return 0;
        }
        //输入种类（+, -, 0-9以及其他）
        if (!Character.isDigit(str.charAt(0))
        && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        /**
         * 把字符串转换成字符数组
         */

        Character[] arr = new Character[str.length()];
        //定义应该输出的答案，ans
        long ans = 0L;
        //把字符串分成字符存到数组中
        for (int i = 0; i < str.length(); i++) {
            char kk = str.charAt(i);
            arr[i] = kk;
            //System.out.print(arr[i]);
            //判断数组中元素的类型
            //System.out.println( "      类型：" + arr[i].getClass().toString());
        }
        //判断数组的第一个字符是否是‘-’，定义一个flag，之后可以用三元表达式进行正负数的反转
        boolean neg = arr[0].equals('-');

        //不是‘-’开头，则判断之后的数字是否是数字
        //判断第一个数数字是否是数字，是数字则返回0 ，不是数字则为1
        int i = !Character.isDigit(str.charAt(0))? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            //把字符的数字转换成integer类型的数字，可以减去‘0’;
            ans = ans * 10 + (str.charAt(i++) - '0');
            //不是负数，数值比int大，则返回int的最长长度
            if (!arr[0].equals('-') && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            //是负数，并且超过范围了，返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31)
            if (arr[0].equals('-') && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }


        if (arr[0].equals('-')){
            ans = ans * (-1);
        }

        return (int) ans;

    }






    public static void main(String[] args) {
        System.out.println(myAtoi("-454eeg"));
    }
}
