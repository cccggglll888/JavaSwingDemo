/*
 * 2014-10-20 22:33:45
 * 简单的窗口例子
 * 
 */
package com.cgl.swing.domo1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Swingtest_1_3 {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("helloSwing");
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		//jf.setLayout(null);
		JButton b = new JButton("123");
		b.setBounds(30, 30, 80, 25);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		jf.setContentPane(p);
		p.add(b);
		//jf.getContentPane().add(b);
	}
}