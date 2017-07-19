package com.zrgk.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * 文件拷贝（字节流实现）
 */
public class TestFileCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("F:\\资料\\test1.txt");
			out = new FileOutputStream("F:\\资料\\test2.txt");
			byte [] by = new byte[1024];
			int len = 0;
			try {
				while ((len = in.read(by)) != -1 ) {
					out.write(by, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("文件复制成功....");
	}
}
