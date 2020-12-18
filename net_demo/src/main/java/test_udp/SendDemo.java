package test_udp; /**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/15 10:38
 * version 1.0
 * Description: 测试
 */

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.net.DatagramPacket;
        import java.net.DatagramSocket;
        import java.net.InetAddress;

/**
 *UDP发送数据的步骤：
 *      A：创建发送端的Socket服务对象
 *      B：创建数据，并把数据打包
 *      C：通过Socket对象的发送功能发送数据包
 *      D：释放资源
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端的Socket服务对象
        DatagramSocket ds = new DatagramSocket();
        //发送的数据由键盘录入
        //键盘封装录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = br.readLine())!= null){
            if ("over".equals(line)){
                break;
            }


            // 创建数据，并把数据打包。
            // public DatagramPacket(byte[] buf,int length,InetAddress address,int
            // port)
            // buf其实就是要发送的数据信息
            // length表示要发送的数据长度
            // address数据要发到哪里去。对应的那个IP地址对象
            // port端口号
            //byte[] bys = "hello,udp,I am coming".getBytes();
            byte[] bys = line.getBytes();
            int length = bys.length;
            InetAddress address = InetAddress.getByName("10.170.31.255");
            int port = 10086;
            DatagramPacket p = new DatagramPacket(bys,length,address,port);

            //通过Socket对象的发送功能发送数据包
            ds.send(p);
        }
        //释放资源
        ds.close();
    }

}
