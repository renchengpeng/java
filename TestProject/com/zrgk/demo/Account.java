package com.zrgk.demo;

// 银行账户
public class Account {
	private int blance = 500;//余额私有的，如果外部类想获取余额的话
	//提供get方法
	//模拟多个线程操作同一个账户才可能出现安全问题
	
	/**
	 * 这个方法就是取钱更新余额
	 * 
	 * @param    money 取多少钱
	 */
	public void update(int money){
		blance = blance -money;//余额
	}
	// 外部类获取账户余额的方法
	public int getBlance() {
		return blance;
	}
}
