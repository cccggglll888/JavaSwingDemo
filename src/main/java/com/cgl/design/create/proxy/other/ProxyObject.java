package com.cgl.design.create.proxy.other;

/**
 * 代理类对象
 */
public class ProxyObject implements Object{
	Object obj;
	
	public ProxyObject() {
		System.out.println("这是代理类");
		obj = new ObjectImpl();
	}

	@Override
	public void action() {
		System.out.println("代理开始");
		obj.action();
		System.out.println("代理结束");
	}
	
}
