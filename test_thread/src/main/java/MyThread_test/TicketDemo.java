package MyThread_test;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/16 15:59
 * version 1.0
 * Description: 模拟售票程序
 */

/**
 *多线程的两种方法：
 *  A：继承Thread类
 *  B：实现Runnable接口
 *
 *  继承Thread类的步骤：
 *      A：自定义类MyThread继承自Thread类
 *      B：在自定义类中重写run()方法,run()方法中的代码才可以被线程执行
 *      C：创建自定义类的对象
 *      D：启动线程并使用
 *              线程对象创建后，调用的是run()方法中的代码，但是得通过start()方法启动
 *      run()和start()方法的区别？
 *          run()：封装了被线程执行的代码
 *          start()：让线程启动，并由jvm调用run()方法
 *
 *   获取当前线程的名字：getName()
 *
 *  实现Runnable接口的方式：
 *      A：自定义类MyRunnable实现Runnable接口
 *      B：重写run()方法
 *      C：创建自定义类的对象
 *      D：创建Thread类的对象，把MyRunnable类的对象作为构造参数传递
 *      E：调用Thread类的start()方法即可
 *
 *   获取当前线程的名字：Thread.currentThread().getName()
 */
public class TicketDemo {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread t1 = new Thread(t,"窗口1");
        Thread t2 = new Thread(t,"窗口2");
        Thread t3 = new Thread(t,"窗口3");
        Thread t4 = new Thread(t,"窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }


}
