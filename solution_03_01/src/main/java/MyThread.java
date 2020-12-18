/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/9/21 20:01
 * version 1.0
 * Description: 测试
 */

import java.util.concurrent.Semaphore;

/**
 *
 */
public class MyThread extends Thread {
    private volatile Semaphore sem;
    private int count;
    MyThread(Semaphore sem,int count){
        this.sem = sem;
        this.count = count;
    }
    public void run(){
        try {
            sem.acquire(count);
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+ "acquire count=" + count);

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            sem.release(count);
            System.out.println(Thread.currentThread().getName() + "release" + count +"");
        }
    }
}
