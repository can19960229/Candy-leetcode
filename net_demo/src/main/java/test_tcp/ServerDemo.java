package test_tcp;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/15 16:35
 * version 1.0
 * Description: 测试
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *TCP协议接收数据的步骤：
 * A:创建接收数据的Socket对象。
 * 		创建对象的时候要指定端口。
 * B:监听客户端连接。
 * 		等待客户端的连接。
 * C:获取Socket对象的输入流。
 * 		是字节流还是字符流? 字节流。
 * D:读取数据,并显示在控制台。
 * E:释放资源。
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建接收数据的Socket对象
        ServerSocket ss = new ServerSocket(8081);

        //监听客户端连接
        Socket s = ss.accept();//阻塞式方法

        //把通道内的输入流进行包装
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
       //把数据写到文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("copy.txt"));
        String line = null;
        while ((line = br.readLine())!= null){//阻塞式
//            if ("over".equals(line)){
//                break;
//            }
            bw.write(line);
            bw.newLine();
            bw.flush();

        }
        //给客户端一个反馈
        //把通道内的输出流包装
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        writer.write("文件上传成功！");
        writer.newLine();
        writer.flush();

        bw.close();
        s.close();
        ss.close();
/*
        //获取输入流
        InputStream is = s.getInputStream();

        //读取数据，显示在控制台上
        byte[] bys = new byte[1024];
        int len = is.read(bys);//阻塞式方法
        String data = new String(bys,0,len);
        System.out.println("data:" + data);

        //获取输出流
        OutputStream os = s.getOutputStream();
        os.write("数据已经收到".getBytes());

        //释放资源
        s.close();
        ss.close();


 */
    }
}
