package com.mipo.pattern.threadtest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

/**
 * @Classname Test1
 * @Description TODO
 * @Date 2021/1/27 10:49
 * @Created by li.yy
 */
@Slf4j
public class Test1 {

    private Test1 () {

    }

    public static void main(String[] args) throws Exception{
        Test1.getInstance().test5();
    }

    private void test1() {
        // 要执行的任务
        Thread t = new Thread("t1") {
            @Override
            public void run() {
                log.debug("hello");
            }
        };
        t.start();
    }

    private void test2() {
        Runnable runnable = () -> log.debug("hello");
        Thread thread = new Thread(runnable, "t2");
        thread.start();
    }

    private void test3() throws Exception {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            log.debug("task");
            return 100;
        });
        new Thread(task, "t3").start();
        Integer integer = task.get();
        log.debug(String.valueOf(integer));
    }

    private void test4() {
        Runnable task1 = () -> {
            int count = 0;
            for(;;) {
                System.out.println("------->1" + count++);
            }
        };
        Runnable task2 = () -> {
            int count = 0;
            for(;;) {
                Thread.yield();
                System.out.println("------->2" + count++);
            }
        };
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }

    static  int count1 = 0;
    static final Object room = new Object();
    private void test5() throws Exception{
        Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 122000; i++) {
                    synchronized (room) {
                    count1++;
                    System.out.println("a");
                }
            }
        }, "t1");
        Thread thread2 = new Thread(() -> {
            System.out.println("我进来了");
                for (int i = 0; i < 122000; i++) {
                    synchronized (room) {
                    count1--;
                    System.out.println("b");
                }
            }
        }, "t2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.debug("{}", count1);
    }

    private static Test1 getInstance() {
        return new Test1();
    }
}
