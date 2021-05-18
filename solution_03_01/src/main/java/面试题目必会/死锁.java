package 面试题目必会;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/17 20:15
 *
 * @Classname 死锁
 * Description: 测试
 */

/**
 *
 */
public class 死锁 {
    private static Object resource1 = new Object(); //资源1
    private static Object resource2 = new Object(); //资源2

    public static void main(String[] args) {
        new Thread(() ->{
            synchronized (resource1){
                System.out.println(Thread.currentThread() + "get resources1");
                try{
                    // 线程 A 通过 synchronized (resource1) 获得 resource1 的监视器锁，
                    // 然后通过Thread.sleep(1000);
                    // 让线程 A 休眠 1s 为的是让线程 B 得到执行然后获取到 resource2 的监视器锁。
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resources2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        },"线程1").start();
        new Thread(() ->{
            synchronized (resource2){
                System.out.println(Thread.currentThread() + "get resources2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        },"线程2").start();
    }
}
