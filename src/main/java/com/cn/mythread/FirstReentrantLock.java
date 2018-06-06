package com.cn.mythread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FirstReentrantLock {
	public static void main(String args[]) {
		Runnable run = new   ReentrantLockThread();
		new Thread(run,"a").start();
		new Thread(run,"b").start();
	}	
}
 
class ReentrantLockThread implements Runnable{
	private ReentrantLock Lock = new ReentrantLock();
    @Override
    public void run() {
    	Lock.lock();
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "输出了：  " + i);
        }
        Lock.unlock();
        
    }
}