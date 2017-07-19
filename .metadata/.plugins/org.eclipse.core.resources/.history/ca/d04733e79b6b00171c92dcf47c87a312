package com.zrgk.test;

public class ThreadSyn implements Runnable {
	private Money mon = new Money();

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			mon.updateCount(200);
		}
	}

}
