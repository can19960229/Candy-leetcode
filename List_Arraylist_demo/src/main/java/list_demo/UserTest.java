package list_demo;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/13 14:48
 * version 1.0
 * Description: 测试
 */

import java.util.Scanner;

/**
 *用户测试类
 */
public class UserTest {
    public static void main(String[] args) {
        while (true) {
            System.out.println("-------------欢迎光临---------------");
            System.out.println("1 登录");
            System.out.println("2 注册");
            System.out.println("3 退出");

            // 要选择数据
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的选择：");
            String numberString = sc.nextLine();
            int number = Integer.parseInt(numberString);

            UserOperator uo = new UserOperator();

            switch (number) {
                case 1:
                    System.out.println("-------------欢迎来到登录界面---------------");
                    // 键盘录入获取用户名和密码
                    System.out.println("请输入用户名：");
                    String username = sc.nextLine();
                    System.out.println("请输入密码：");
                    String password = sc.nextLine();

                    // 调用操作类的功能
                    // UserOperator uo = new UserOperator();
                    boolean flag = uo.login(username, password);
                    if (flag) {
                        System.out.println("登录成功，可以开始玩猜数字小游戏了");
                        Game.playGame();
                    } else {
                        System.out.println("登录失败，请重新登录");
                    }
                    break;
                case 2:
                    System.out.println("-------------欢迎来到注册界面---------------");
                    // 键盘录入获取用户名和密码
                    System.out.println("请输入用户名：");
                    String newUsername = sc.nextLine();
                    System.out.println("请输入密码：");
                    String newPassword = sc.nextLine();

                    // 把数据封装到User对象中
                    // 通过构造
                    // User user = new User(username, password);
                    // 通过setXxx()
                    User user = new User();
                    user.setUsername(newUsername);
                    user.setPassword(newPassword);

                    // 调用操作类的功能
                    // UserOperator uo = new UserOperator();
                    uo.regist( user);
                    System.out.println("恭喜你，注册成功");
                    break;
                case 3:
                    // break;
                default:
                    System.out.println("谢谢使用。欢迎下次再来");
                    System.exit(0);
                    break;
            }
        }
    }

}
