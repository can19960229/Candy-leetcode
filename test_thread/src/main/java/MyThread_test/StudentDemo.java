package MyThread_test;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/17 10:12
 * version 1.0
 * Description: 学生类测试线程间通信
 *
 *      资源：Student
 *      设置线程：SetThread
 *      获取线程：GetThread
 *      测试类：StudentDemo
 *
 *      CPU的每一次操作应该是原子性操作
 *
 *      解决线程安全问题：
 *          分析真的是线程安全问题吗？
 *              A:是多线程环境吗？  是
 *              B：有共享数据吗？   有，s对象
 *              C：对共享数据有多条操作吗？  s.name,s.age..
 *           解决：把有问题的代码用同步块包起来
 *
 *      问题：加入同步后，出现了数据问题。
 *          A：多种线程操作的时候，要保证同步，必须是每一种类型的线程都必须加同步
 *          B：即使是给多种类型的线程加锁，也必须是同一把锁
 */

import java.io.IOException;

/**
 *
 */
public class StudentDemo {
    public static void main(String[] args) throws IOException {
        Student s = new Student();
        SetThread st = new SetThread(s);
        GetThread gt = new GetThread(s);

        Thread t1 = new Thread(st);
        Thread t2 = new Thread(gt);

        //线程随机性 有时候获取 有时候没获取
        t1.start();
        //饿汉模式 可以直接调出计算器
        Runtime r = Runtime.getRuntime();
        r.exec("calc");
    }
}
