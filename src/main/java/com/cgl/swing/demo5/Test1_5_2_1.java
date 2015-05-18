/*
 * 2014-10-28 01:06:20
 * BorderLayout布局管理器使用
 * 布局管理器把容器分为东、南西、北、中5个区域，每个组件占据某个区域
 * NORTH、WEST、EAST、CENTER、SOUTH
 * 它们都被定义成静态常量
 * North、West、East、Center、South
 */
package com.cgl.swing.demo5;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test1_5_2_1 {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("测试程序");
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		JPanel contentPane = new JPanel();
		jf.setContentPane(contentPane);
		
		List<String> a = new ArrayList<String>();
		a.add(0,"aa");
		a.add(2,"bb");
		a.add(3,"cc");

		JComboBox<List<String>> b1 = new JComboBox<List<String>>();
		b1.addItem(a);
		b1.getItemAt(0);
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		
		
		
		BorderLayout lay = new BorderLayout();
		
		jf.setLayout(lay);
		
		contentPane.add(b1, BorderLayout.NORTH);
		contentPane.add(b2, BorderLayout.SOUTH);
		contentPane.add(b3, BorderLayout.EAST);
		contentPane.add(b4, BorderLayout.WEST);
		contentPane.add(b5, BorderLayout.CENTER);
		
	}
}
