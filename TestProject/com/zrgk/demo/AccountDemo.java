package com.zrgk.demo;

public class AccountDemo {
	public static void main(String[] args) {
		TestAccount ta = new TestAccount();
		Thread husbend = new Thread(ta);
		husbend.setName("张三");
		
		
		Thread wife = new Thread(ta);
		wife.setName("张三媳妇");
		husbend.start();
		wife.start();
	}

}
