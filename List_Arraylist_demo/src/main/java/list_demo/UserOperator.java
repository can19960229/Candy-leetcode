package list_demo;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/13 14:36
 * version 1.0
 * Description: 测试
 */

import java.util.ArrayList;

/**
 *用户操作类
 */
public class UserOperator {
    //为了保证多个方法中使用的是用一个集合，集合要保证定义为成员变量
    //为了保证多个对象用的是同一个成员变量，成员变量用静态修饰
    private static ArrayList<User> array = new ArrayList<User>();

    /**
     * 这是用户登录功能
     * @param username  用户名
     * @param password  密码
     * @return  是否登录成功
     */
    public boolean login(String username,String password){
        boolean flag = false;
        for (User u:array) {
            if (u.getUsername().equals(username)&&u.getPassword().equals(password)){
                flag = true;
                break;
            }
        }
        return flag;

    }

    /**
     * 这是用户注册工程
     * @param user 被注册的用户信息
     */
    public void regist(User user){
        array.add(user);
    }


}
