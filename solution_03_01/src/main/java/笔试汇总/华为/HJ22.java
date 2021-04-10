package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/10 19:30
 *
 * @Classname HJ22
 * Description: 测试
 */

import java.util.Scanner;

/**
 * 知道这题优秀的解法，我真是裂开了。
 * 题目描述中有讲到：剩2个空瓶子时，可以先找老板借一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
 * 也就是说2个空瓶子即可换一瓶汽水喝，而且喝完之后手里也没有空瓶子。求解时直接把空瓶数除以2，即可得到正解。
 */
public class HJ22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            if (num == 0){
                break;
            }
            System.out.println(getResult(num));
        }
    }

    private static int getResult(int number) {

        if (number >= 3){
            number = number - 3 + 1;
            return 1 + getResult(number);
        }else if(number == 2){
            number = number - 1;
            return 1 + getResult(number);
        }
        else {
            return 0;
        }

        /*
        int bottoms = 0;
        while (number >= 3) {
            bottoms += number/3;
            number = number%3 + number/3;
        }
        if (number == 2) {
            bottoms++;
        }
        return bottoms;
         */
    }

}
