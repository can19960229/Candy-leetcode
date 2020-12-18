package test;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/13 10:15
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public class Run3 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(500000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
            }.start();
        }
    }
}
