package com.zrgk.demo;


/**
 * 线程共享数据
 * 多个线程同时访问同一个资源的时候，有可能会产生并发安全问题
 * 解决线程并发安全问题：同步代码块
 * 1同步代码块：
 * synchronized();  
 * 
 * 2 同步方法   互斥的方法
 * 
 * 
 * 
 * 同步：  不是同时，是多个线程按照一定的节奏执行的过程
 *例如一群人排队上公交车
 * 
 * 异步：多个线程同时执行，没有先后顺序。例如一群人一起上卡车，同时进行
 * 
 * 
 * 
 * 
 * 
 * 线程共享数据 多个线程同时访问同一个资源的时候，有可能会产生并发安全问题 解决线程并发安全问题：
 * 同步代码块 1同步代码块： synchronized();
 * 
 * 2 同步方法 互斥的方法
 * 
 * 
 * 同步： 不是同时，是多个线程按照一定的节奏执行的过程 例如一群人排队上公交车
 * 
 * 异步：多个线程同时执行，没有先后顺序。例如一群人一起上卡车，同时进行
 * 
 * */
public class TestAccount implements Runnable {
	private Account acc = new Account(); // 账户对象
	// static final Object obj = new Object(); 所对象

	public void run() {//线程体
		for (int i = 1; i <= 5; i++) {
			getMoney(100);
			if (acc.getBlance() < 0) {
				System.out.println("账户透支了!");
			}
		}
	}

	// 取钱方法 1) 检查账户余额是否够你支取的钱 2） 更新余额
	private synchronized void getMoney(int money) {
		//这么些跟同步代码块儿加当前类的对象this是等价的
		// 同步代码块 锁自动释放
		// synchronized (acc) {//synchronized 就是1同步代码块： 里边需要传一个参数，这个参数就是“锁”
		// 锁任何类型的对象都能作为锁 这个锁一定是同一把
		//君子锁
		try {
			// 如果余额大于money
			if (acc.getBlance() >= money) {// 判断余额和更新账户是同时的，原子化
				System.out.println(Thread.currentThread().getName() + "准备取款:");
				Thread.sleep(1000);
				//try catch  run方法是Runnable接口规定的，接口规定的方法没有异常 模拟喝咖啡
				//子类重写父类方法的异常要小于等于父类异常，父类没有异常，子类不能随便抛出异常
				acc.update(money);//
				System.out.println(Thread.currentThread().getName() + ",取"
						+ money + ",完成取款!");
			} else {
				System.out.println(Thread.currentThread().getName() + "取"
						+ money + ",余额：" + acc.getBlance() + "不足以支付!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// }
	}

}
