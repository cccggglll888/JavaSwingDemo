/*
 * 2014-10-23 17:07:10
 */
package com.cgl.swing.demo3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorld_3_1 {
	public static void main(String[] args) {
		//顶层窗口
		JFrame frame = new JFrame("测试窗口");
		//中间容器
		JPanel pane = new JPanel();
		//将中间容器置于顶层容器
		frame.setContentPane(pane);
		//基本组件
		JButton button = new JButton("这是一个测试按钮");
		//将基本组件置于中间容器
		pane.add(button);
		//frame.add(button);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}