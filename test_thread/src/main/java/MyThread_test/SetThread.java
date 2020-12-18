package MyThread_test;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/17 10:14
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public class SetThread implements Runnable {

    private Student s;
    private int x = 0;

    public SetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        //Student s = new Student();
        while (true) {
            synchronized (s) {
                //判断如果有值就等待
                if (s.flag){
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //设置值
                if (x % 2 == 0) {
                    s.name = "Candy";
                    s.age = 22;
                } else {
                    s.name = "candy_chen";
                    s.age = 18;
                }
                x++;
                //有值后就修改标记
                s.flag = true;
                s.notify();//唤醒等待的线程
            }
        }
    }
}
