package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/25 16:56
 *
 * @Classname JZ44
 * Description: 翻转单词顺序列
 */

/**
 *
 */
public class JZ44 {
    public static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        int j = chars.length - 1;
        int k = chars.length - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' '){
                j--;
            }else {
                String substring = str.substring(j + 1 , k + 1);
                System.out.println(substring);
                sb.append(substring);
                j--;
                k = j;
                sb.append(" ");
            }
        }
        sb.append(str, j + 1, k +1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence("nowcoder. a am I"));
    }
}
