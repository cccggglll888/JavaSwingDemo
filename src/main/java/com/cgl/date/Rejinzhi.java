package com.cgl.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Rejinzhi {
	public static void main(String[] args) throws ParseException {
		int a = 10;
		System.out.println(a>>2);
		
		System.out.println(10/(2*2));
		
		
		System.out.println(a<<2);
		System.out.println(10*2*2);
		//大神们：求java字符串[03/Dec/2014:17:28:39 +0800]转化为日期标准yyyy-MM-dd HH:mm:ss格式
		
		String str = "03/Dec/2014:17:28:39 +0800";//接收参数
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss",Locale.ENGLISH);
	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 EEEEE",Locale.ENGLISH);
	    Date date = sdf.parse(str);//提取格式中的日期
	    String str1 = sdf1.format(date);
	    System.out.println(date);
	    System.out.println(str1);
		
	}
}
