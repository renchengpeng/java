package com.zrgk.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestWriter {

	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("F:\\test.txt", true);
			char[] chars = new char[] { 'a', 'b', 'c' };
			writer.write(chars);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
