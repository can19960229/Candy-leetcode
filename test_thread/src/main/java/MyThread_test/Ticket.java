package MyThread_test;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/16 16:14
 * version 1.0
 * Description: 测试
 */

/**
 *锁对象：
 *      同步代码块锁对象：任意对象 obj
 *      同步方法锁对象：synchronize(this)
 *      静态方法的锁对象：当前类字节码文件锁对象synchronize(Ticket.class)
 *
 * JDK5 新特性:
 *      Lock锁对象
 */
public class Ticket extends Thread{

    private int tickets = 100;
    private  Object obj = new Object();
    public Ticket(){}

    public Ticket(String name){
        super(name);
    }

    @Override
    public void run() {

        while (true) {
            synchronized (obj) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第 " + (tickets--) + "张票");
                }
            }
        }
    }
}
