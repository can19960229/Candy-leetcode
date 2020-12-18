package list_demo;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/13 14:34
 * version 1.0
 * Description: 测试
 */

/**
 *用户基本描述类
 */
public class User {
    //用户名
    private String username;
    //密码
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
