package com.zrgk.test;

public class TestBubbleSort {

	
	public static void bubbleSort(int[] a) {
		// TODO Auto-generated method stub
		
		
		int tmp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 12, 32, 1, 123, 3434, 1213, 54,121333 };
		bubbleSort(a);
	
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}
}
