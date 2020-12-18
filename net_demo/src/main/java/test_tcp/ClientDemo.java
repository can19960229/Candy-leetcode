package test_tcp;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/15 16:25
 * version 1.0
 * Description: 测试
 */

import java.io.*;
import java.net.Socket;

/**
 *TCP协议发送数据的步骤：
 *  A:创建发送数据的Socket对象。
 *		创建对象的时候要指定目标主机和端口。
 *  B:获取Socket对象的输出流。
 *		是字节流还是字符流? 字节流。
 *  C:写数据。
 *  D:释放资源。
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建发送数据的Socket对象。
        // Socket(InetAddress address, int port)
        // Socket(String host, int port)
        // java.net.ConnectException: Connection refused: connect
        // 因为服务器没有开启。TCP协议的程序，必须先开启服务器。
        Socket s = new Socket("10.170.31.91",8081);

        //封装键盘录入
        BufferedReader br = new BufferedReader(new FileReader("bw.txt"));
        //把通道内的输出流封装成字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null){
            //读文件时不需要判断
//            if ("over".equals(line)){
//                break;
//            }
            bw.write(line);
            bw.newLine();
            bw.flush();

        }
        //自己写的判断文件读取结束
//        bw.write("over");
//        bw.newLine();
//        bw.flush();
        //Socket提供的方案,禁用输出流
        s.shutdownOutput();
        //获取服务器的反馈
        //把通道内的输入流包装
        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = reader.readLine();
        System.out.println("client:" + data);

        br.close();
        s.close();

        /*
        //获取Socket对象的输出流
        OutputStream os = s.getOutputStream(); //多态

        //写数据
        os.write("TCP i am coming".getBytes());

        //获取输入流
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys,0,len);
        System.out.println("client:" + data);


        //释放资源
        s.close();

         */
    }
}
