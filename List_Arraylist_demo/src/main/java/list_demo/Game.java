package list_demo;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/13 14:52
 * version 1.0
 * Description: 测试
 */

import java.util.Scanner;

/**
 *猜数字小游戏程序
 */
public class Game {
    private Game() {
    }

    public static void playGame() {
        // 系统产生一个随机数据。
        int number = (int) (Math.random() * 100) + 1;

        // 定义统计变量
        int count = 0;

        // 定义起始变量
        int start = 1;
        // 定义结束变量
        int end = 100;

        while (true) {
            // 键盘录入数据。用Scanner实现。
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个数据(" + start + "-" + end + ")：");
            int guessNumber = sc.nextInt();

            // 统计一次
            count++;

            // 比较
            if (guessNumber > number) {
                System.out.println("你猜的数据" + guessNumber + "大了");
                end = guessNumber;
            } else if (guessNumber < number) {
                System.out.println("你猜的数据" + guessNumber + "小了");
                start = guessNumber;
            } else {
                System.out.println("恭喜你" + count + "次就猜中了");
                break;
            }
        }
    }
}
