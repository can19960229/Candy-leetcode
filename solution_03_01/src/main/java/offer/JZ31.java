package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/21 11:23
 *
 * @Classname JZ31
 * Description: 整数中1出现的次数
 */

/**
 *
 */
public class JZ31 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        StringBuilder temp = new StringBuilder();
        for (int i = 1;i <= n;i++){
            temp.append(i);
            //System.out.println(temp);//输出temp的值
        }
        int count = 0;
        //System.out.println(temp.getClass().toString());//查看temp的数据类型
        for (int i = 0;i < temp.length();i++){
            System.out.println(temp.charAt(0));
            if(temp.charAt(i) == '1')
                count++;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(1));
    }
}
