package com.mipo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestABCAlternate {

	public static void main(String[] args) {
		AlternateDemo ad = new AlternateDemo();

		new Thread(() -> {

			for (int i = 1; i <= 20; i++) {
				ad.loopA(i);
			}

		}, "A").start();

		new Thread(() -> {

			for (int i = 1; i <= 20; i++) {
				ad.loopB(i);
			}

		}, "B").start();

		new Thread(() -> {

			for (int i = 1; i <= 20; i++) {
				ad.loopC(i);

				System.out.println("-----------------------------------");
			}

		}, "C").start();
	}

}

class AlternateDemo{

	private int number = 1; //当前正在执行线程的标记

	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();

	/**
	 * @param totalLoop : 循环第几轮
	 */
	public void loopA(int totalLoop){
		lock.lock();

		try {
			//1. 判断
			if(number != 1){
				condition1.await();   //线程A等待
			}

			//2. 打印
			for (int i = 1; i <= 1; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}

			//3. 唤醒
			number = 2;
			condition2.signal();  //唤醒B线程
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void loopB(int totalLoop){
		lock.lock();

		try {
			//1. 判断
			if(number != 2){
				condition2.await();		//线程B等待
			}

			//2. 打印
			for (int i = 1; i <= 1; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}

			//3. 唤醒
			number = 3;
			condition3.signal();		//唤醒C线程
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void loopC(int totalLoop){
		lock.lock();

		try {
			//1. 判断
			if(number != 3){
				condition3.await();		//C线程等待
			}

			//2. 打印
			for (int i = 1; i <= 1; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}

			//3. 唤醒
			number = 1;
			condition1.signal();		//唤醒A线程
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
