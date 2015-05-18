/*
 * 2014-10-27 09:49:17
 * 标签控件例子
 */
package com.cgl.swing.demo4;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test_4_1 {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("测试程序");
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		JPanel contentPane = new JPanel();
		jf.setContentPane(contentPane);
		
		JLabel label1 = new JLabel("这是一个标签测试程序");
		
		JLabel label2 = new JLabel();
		label2.setText("标签是用来标示某个控件的控件");
		
		contentPane.add(label1);
		contentPane.add(label2);
	}
}
