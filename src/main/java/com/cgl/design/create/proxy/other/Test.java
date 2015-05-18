package com.cgl.design.create.proxy.other;

/**
 * 测试类
 */
public class Test {
	//1.需要被代理的对象继承一个接口
	//2.由代理对象继承该接口并实现代理的方法（代理对象持有被代理对象）
	public static void main(String[] args) {
		Object obj = new ProxyObject();
		obj.action();
	}
}
