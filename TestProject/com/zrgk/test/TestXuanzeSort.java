package com.zrgk.test;

public class TestXuanzeSort {
	
	String s = "Gone with the wind";

	//String k = s+t;

	String t = "good";
	int _3_ = 2;

		public static void bubbleSort(int[] a) {
			// TODO Auto-generated method stub
			
			for (int i = 0; i < a.length-1; i++) {
				int tmp = 0;
				for (int j = i; j < a.length; j++) {
					if (a[j] < a[i]) {
						tmp = a[i];
						a[i] = a[j];
						a[j] = tmp;
					}
				}
			}
		}

		public static void main(String[] args) {
			int[] a = { 12, 32, 1, 123, 3434, 1213, 54,121333,0 };
			bubbleSort(a);
			
		
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
			}

		}
	

}
