/*
 * 2014-10-22 16:46:46
 * 窗口tab页演示
 */
package com.cgl.swing.demo2;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class HelloWorld_2_3 extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static final int WIDTH = 600;
	static final int HEIGHT = 400;
	
	public HelloWorld_2_3() {
		JFrame f = new JFrame("测试窗口");
		JPanel p = new JPanel();
		f.setContentPane(p);
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		//标签页排版
		//panel1.setLayout(new BorderLayout());
		panel1.add(new JButton("button"));
		addTab("panel1", panel1);
		//标签页是否可选
		setEnabledAt(0, true);
		setTitleAt(0, "测试页1");
		
		addTab("panel2", panel2);
		setEnabledAt(1, true);
		setTitleAt(1, "测试页2");
		
		addTab("panel3", panel3);
		setEnabledAt(2, true);
		setTitleAt(2, "测试页3");
		
		addTab("panel4", panel4);
		setEnabledAt(3, true);
		setTitleAt(3, "测试页4");
		
		addTab("panel5", panel5);
		setEnabledAt(4, true);
		setTitleAt(4, "测试页5");
		
		setPreferredSize(new Dimension(500, 200));
		setTabPlacement(JTabbedPane.TOP);
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		p.add("Center", this);
		//setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new HelloWorld_2_3();
		
	}
	
}
