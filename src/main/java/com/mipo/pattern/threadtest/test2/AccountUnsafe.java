package com.mipo.pattern.threadtest.test2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AccountUnsafe
 * @Description TODO
 * @Date 2021/2/19 10:06
 * @Created by li.yy
 */
public class AccountUnsafe implements Account {

    private AtomicInteger balance;

    public AccountUnsafe(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public  Integer getBalance() {
        return balance.get();
    }

    @Override
    public  void withdraw(Integer amount) {
        while (true) {
            int prev = balance.get();
            int next = prev - amount;
            if(balance.compareAndSet(prev, next)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Account.demo(new AccountUnsafe(10000));
    }
}
