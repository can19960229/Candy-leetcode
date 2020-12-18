package test_thread_udp;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/15 16:07
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
 *
 */
public class SendThread implements Runnable{

    private DatagramSocket ds;

    public SendThread(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
        //发送的数据由键盘录入
        //键盘封装录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = br.readLine())!= null){
            if ("over".equals(line)){
                break;
            }
            byte[] bys = line.getBytes();
            DatagramPacket p = new DatagramPacket(bys,bys.length,InetAddress.getByName("10.170.31.91"),12358);

            //通过Socket对象的发送功能发送数据包
            ds.send(p);
        }
        //释放资源
        ds.close();
    }catch (IOException e){
            e.printStackTrace();
        }
    }
}
