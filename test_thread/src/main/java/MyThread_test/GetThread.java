package MyThread_test;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/17 10:15
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public class GetThread implements Runnable {

    private Student s;

    public GetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        // Student s = new Student();
        while (true) {
            synchronized (s){
                if (!s.flag){
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(s.name + "----" + s.age);
                s.flag =false;
                s.notify();
            }
        }
    }
}
