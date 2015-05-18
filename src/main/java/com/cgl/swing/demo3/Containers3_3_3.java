/*
 * 2014-10-25 14:11:37
 * 绘图和边框演示
 */
package com.cgl.swing.demo3;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Containers3_3_3 {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("添加内容面板测试程序");
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		JPanel contentPane = new JPanel();
		jf.setContentPane(contentPane);
		
		JButton b1 = new JButton("确定");
		JButton b2 = new JButton("取消");
		contentPane.add(b1);
		contentPane.add(b2);
		
		b1.setBorder(BorderFactory.createLineBorder(Color.red));
	}
}
