package com.zrgk.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtil {
	static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
	//把一个字符串转成时间类型
	public static Date strToDate(String str){
		Date d=null;
		try {
			d= sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	//把一个时间转成字符串
	public static String dateToStr(Date d){
		String str =null;
		str =sdf.format(d);
		return str;
	}
}
