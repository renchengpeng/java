package com.zrgk.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class TestZip {
	
	static ZipOutputStream zops = null;
	static{
		try {
			zops = new ZipOutputStream(new FileOutputStream("F:\\zipTest.zip"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void Zip(File file){
		File[] files = file.listFiles();
		for (File fe : files) {
			if (fe.isDirectory()) {
				Zip(fe);
			}else {
				ZipFile(fe);
			}
		}
	}
	
	public static void ZipFile(File file){
		
		System.out.println(file.getPath());
		try {
			zops.putNextEntry(new ZipEntry(file.getPath().substring(3)));//保留目录结构
			InputStream in = new FileInputStream(file);
			byte [] by = new byte[1024];
			int len = 0;
			while ((len = in.read(by)) != -1) {
				zops.write(by, 0, len);
			}
			zops.closeEntry();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void close() {
		try {
			zops.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		File file = new File("F:\\桌面资料");
		Zip(file);
		close();
		System.out.println("ok......");
	}
}
