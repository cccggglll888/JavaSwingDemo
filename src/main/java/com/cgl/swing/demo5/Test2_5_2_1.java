/*
 * 2014-10-31 20:50:19
 * 复杂的BorderLayout布局演示
 */
package com.cgl.swing.demo5;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test2_5_2_1 {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("测试程序");
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		JPanel contentPane = new JPanel();
		jf.setContentPane(contentPane);
		
		JButton b1 = new JButton("港元");
		JButton b2 = new JButton("人民币");
		JButton b3 = new JButton("美元");
		JButton b4 = new JButton("欧元");
		JButton b5 = new JButton("英镑");
		JButton b6 = new JButton("主板");
		JButton b7 = new JButton("内存");
		JButton b8 = new JButton("硬盘");
		JButton b9 = new JButton("显示器");
		JButton b10 = new JButton("鼠标");
		JButton b11 = new JButton("大米");
		JButton b12 = new JButton("蔬菜");
		JButton b13 = new JButton("稻子");
		JButton b14 = new JButton("猪肉");
		JButton b15 = new JButton("牛肉");
		JButton b16 = new JButton("面包");
		JButton b17 = new JButton("蛋糕");
		JButton b18 = new JButton("巧克力");
		JButton b19 = new JButton("奶酪");
		JButton b20 = new JButton("苹果派");
		JButton b21 = new JButton("笔记本");
		JButton b22 = new JButton("电话");
		JButton b23 = new JButton("办公桌");
		JButton b24 = new JButton("钢笔");
		JButton b25 = new JButton("文件夹");
		
		jf.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		
		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
		p3.setLayout(new BorderLayout());
		p4.setLayout(new BorderLayout());
		p5.setLayout(new BorderLayout());
		
		contentPane.add(p1, BorderLayout.NORTH);
		contentPane.add(p2, BorderLayout.SOUTH);
		contentPane.add(p3, BorderLayout.EAST);
		contentPane.add(p4, BorderLayout.WEST);
		contentPane.add(p5, BorderLayout.CENTER);
		
		p1.add(b1, BorderLayout.NORTH);
		p1.add(b2, BorderLayout.WEST);
		p1.add(b3, BorderLayout.SOUTH);
		p1.add(b4, BorderLayout.EAST);
		p1.add(b5, BorderLayout.CENTER);
		
		p2.add(b6, BorderLayout.NORTH);
		p2.add(b7, BorderLayout.WEST);
		p2.add(b8, BorderLayout.SOUTH);
		p2.add(b9, BorderLayout.EAST);
		p2.add(b10, BorderLayout.CENTER);
		
		p3.add(b11, BorderLayout.NORTH);
		p3.add(b12, BorderLayout.WEST);
		p3.add(b13, BorderLayout.SOUTH);
		p3.add(b14, BorderLayout.EAST);
		p3.add(b15, BorderLayout.CENTER);
		
		p4.add(b16, BorderLayout.NORTH);
		p4.add(b17, BorderLayout.WEST);
		p4.add(b18, BorderLayout.SOUTH);
		p4.add(b19, BorderLayout.EAST);
		p4.add(b20, BorderLayout.CENTER);
		
		p5.add(b21, BorderLayout.NORTH);
		p5.add(b22, BorderLayout.WEST);
		p5.add(b23, BorderLayout.SOUTH);
		p5.add(b24, BorderLayout.EAST);
		p5.add(b25, BorderLayout.CENTER);
		
		//jf.setVisible(true);
	}
	
}
