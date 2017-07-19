package com.zrgk.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestRcp {
	public static void main(String[] args) {

		int[] aa = { 101, 102, 103, 104, 105 };

		File file = new File("D://test.txt"); // 定义D盘的test.txt文件

		// ***答案编写开始位置***
		FileWriter out = null;
		StringBuffer str = new StringBuffer();
		try {
			out = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = aa.length - 1; i >= 0; i--) {
			str.append(aa[i]);
			str.append(' ');
		}
		try {
			out.write(str.toString(), 0, str.length());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// ***答案编写结束位置***

	}

}
