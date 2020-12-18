package test_thread_udp;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/15 16:08
 * version 1.0
 * Description: 测试
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 */
public class ReceiveThread implements Runnable{

    private DatagramSocket ds;

    public ReceiveThread(DatagramSocket ds){
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            while (true){
                //创建数据包
                byte[] bys = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bys,bys.length);

                //接收数据
                ds.receive(dp);

                //解析数据
                String ip = dp.getAddress().getHostAddress();
                String data = new String(dp.getData(),0,dp.getLength());
                System.out.println("from" + ip + "data is" +data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
