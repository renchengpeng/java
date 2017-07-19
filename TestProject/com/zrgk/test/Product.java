package com.zrgk.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(date));
		
	}

}
