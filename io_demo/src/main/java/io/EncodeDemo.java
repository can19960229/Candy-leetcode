package io;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/10 17:05
 * version 1.0
 * Description: 测试
 */

import java.io.UnsupportedEncodingException;

/**
 *
 */
public class EncodeDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "陈灿ABC";
        byte[] bytes1 = s.getBytes();//用的默认的编码格式进行编码

        for (byte b:bytes1) {
            System.out.print(Integer.toHexString(b &0xff) + " ");

        }
        System.out.println();
        byte[] bytes2 = s.getBytes("UTF-8");
       /*
        UTF-8中中文占用3个字节，英文占用1个字节
        gbk中中文占用2个字节，英文占用1个字节
        java是双字节编码 utf-16be 中文占用2个字节，英文占用2个字节
        */
        for (byte b :bytes2
             ) {
            System.out.print(Integer.toHexString(b &0xff) + " ");

        }
        System.out.println();
    }
}
