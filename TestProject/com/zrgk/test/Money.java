package com.zrgk.test;

public class Money {

	private int count = 1000;

	public synchronized void updateCount(int money) {
		if (count >= 0 && (count - money) >= 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count -= money;
			System.out.println(Thread.currentThread().getName() + "取款" + money
					+ "成功。。。");
		} else {
			System.out.println(Thread.currentThread().getName() + "余额不足.....");
		}
	}

}
