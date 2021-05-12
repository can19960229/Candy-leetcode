package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/7 21:40
 *
 * @Classname HJ49
 * Description: 多线程交替打印
 */

import java.util.Scanner;

/**
 *
 */
public class HJ49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            Object a = new Object();
            Object b = new Object();
            Object c = new Object();
            Object d = new Object();
            Thread thread1 = new Thread(new ThreadPrintAbcd("A",a,b,num));
            Thread thread2 = new Thread(new ThreadPrintAbcd("B",a,b,num));
            Thread thread3 = new Thread(new ThreadPrintAbcd("C",a,b,num));
            Thread thread4 = new Thread(new ThreadPrintAbcd("D",a,b,num));
            
        }
    }

    private static class ThreadPrintAbcd implements Runnable {
        private static int newIndex = 0;
        private static int runIndex = 0;
        private boolean isFirstRun = true;
        private Object self;
        private Object next;
        private String name;
        private int id;
        private int num;
        public ThreadPrintAbcd(String name, Object self, Object next, int num) {
            id = newIndex++;
            this.name = name;
            this.self = self;
            this.next = next;
            this.num = num;
        }

        @Override
        public void run() {

        }
    }
}
