package com.cgl.design.create.proxy;

import java.util.List;

/**
 * 测试类
 */
public class MyMain {
	public static void main(String[] args) {
		System.out.println("加载配置信息......");
		System.out.println("通过加载配置信息加载一个代理工厂Map：");
		System.out.println("这个Map存放的是接口Class与对应的代理工厂");
		SqlSession sqlSession = new SqlSession();
		MyInterface myInterface = sqlSession.getMapper(MyInterface.class);
		List<Object> list = myInterface.query(new Object());
		System.out.println(list.size());
	}
}
