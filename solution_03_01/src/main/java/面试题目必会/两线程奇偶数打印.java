package 面试题目必会;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/6 15:45
 *
 * @Classname 两线程奇偶数打印
 * Description: 测试
 */

/**
 * 通过notify和wait用来控制我们线程的执行
 */
class 两个线程打印奇偶数 {
    static class SolutionTask implements Runnable{

        static int value = 0;
        @Override
        public void run() {
            synchronized (SolutionTask.class){//while (value <= 100) 判断没有加锁的话，两个线程会同时进来，会多打印一遍，也就是可能执行101次的情况
                while (value <= 100){
                    System.out.println(Thread.currentThread().getName() + " ：" + value++);
                    SolutionTask.class.notify();//通知
                    try {
                        SolutionTask.class.wait();//通知后等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new SolutionTask(),"偶数").start();
        new Thread(new SolutionTask(),"奇数").start();
    }
}

