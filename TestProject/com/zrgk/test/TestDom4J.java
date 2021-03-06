package com.zrgk.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class TestDom4J {

	@Test
	public void test() throws DocumentException, UnsupportedEncodingException,
			FileNotFoundException {
		// 创建解析器
		SAXReader sar = new SAXReader();
		Document document = sar.read("src/student.xml");
		// 找出根节点
		Element root = document.getRootElement();
		Element student = (Element) root.elements("student").get(1);
//		
//		//增加节点《sex》
//		student.addElement("sex").setText("rcp");
//		//修改节点
//		student.element("name").setText("rrrrrrrrrrrrr");
//		//删除节点
//		student.remove(student.element("name"));
		Element br = DocumentHelper.createElement("rcp");
		br.setText("123");

		
		student.elements().add(1, br);
		// 回写
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(
				new FileOutputStream("src/student.xml"), format);
		try {
			writer.write(document);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
