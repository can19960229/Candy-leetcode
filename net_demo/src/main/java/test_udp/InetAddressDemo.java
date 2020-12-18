package test_udp; /**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/15 9:23
 * version 1.0
 * Description: 测试
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        getAdress();

    }

    public static void getAdress() throws UnknownHostException {
        //根据主机名获取到IP地址对象
        InetAddress address = InetAddress.getByName("10.170.31.91");

        //获取主机名
        String name = address.getHostName();
        //获取ip地址
        String ip = address.getHostAddress();

        System.out.println(name + "-----" + ip);
    }
}
