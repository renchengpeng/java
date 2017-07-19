package com.zrgk.test;

public class TestThread {


	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ThreadOne());
		Thread t2 = new Thread(new ThreadTwo());
		
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		
		System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority());
	}
}
