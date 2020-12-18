package test_udp; /**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/15 10:53
 * version 1.0
 * Description: 测试
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *UDP协议接收数据步骤：
 * A:创建接收端的Socket服务对象
 * B:创建一个数据包，用于接收数据的。
 * C:接收数据。
 * D:解析数据，并显示在控制台。
 * E:释放资源
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //创建接收端的Socket服务对象，并且制定端口号
        DatagramSocket ds = new DatagramSocket(10086);
        //服务器一直处于接收状态
        while (true) {
            //创建一个数据包，用于接收数据的
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);

            //接收数据
            ds.receive(dp);//阻塞式方法

            //解析数据并在控制台显示
            InetAddress address = dp.getAddress();
            String ip = address.getHostAddress();

            //返回缓冲区数据
            byte[] byss = dp.getData();
            //返回实际长度
            int len = dp.getLength();
            String s = new String(byss, 0, len);
            System.out.println(ip + "------" + s);
        }
        //释放资源
        //ds.close();
    }
}
