package test_thread_udp;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/15 16:03
 * version 1.0
 * Description: 测试
 */

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *多线程改进聊天
 */
public class ChatThread {
    public static void main(String[] args) throws SocketException {
        DatagramSocket dsSend = new DatagramSocket();
        DatagramSocket dsReceive = new DatagramSocket(12358);

        SendThread st = new SendThread(dsSend);
        ReceiveThread rt = new ReceiveThread(dsReceive);

        Thread t1 = new Thread(st);
        Thread t2 = new Thread(rt);

        t1.start();
        t2.start();
    }
}
