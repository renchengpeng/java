package com.zrgk.test;

import java.util.ArrayList;
import java.util.List;

public class RcpTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		java.lang.ClassLoader s = list.getClass().getClassLoader();
		System.out.println(s+"fads");
	}
}
