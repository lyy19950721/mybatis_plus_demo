package com.mipo.pattern.threadtest.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Classname Account
 * @Description TODO
 * @Date 2021/2/19 10:05
 * @Created by li.yy
 */
public interface Account {
    // 获取余额
    Integer getBalance();

    // 取款
    void withdraw(Integer amount);

    static void demo(Account account) {
        List<Thread> ts = new ArrayList<>();
        long start = System.nanoTime();
        IntStream.range(0, 1000).forEach(t ->
                ts.add(new Thread(() -> account.withdraw(10))));
        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(account.getBalance() + "cost" + (end-start)/1000_000 + "ms");
    }
}
