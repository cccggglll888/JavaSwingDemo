/*
 * 2014-10-24 18:29:03
 */
package com.cgl.swing.demo3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Containers_3_2_2 {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("添加内容面板测试程序");
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		//创建中间层面板
		JPanel contentPane = new JPanel();
		//将中间层添加到顶层
		jf.setContentPane(contentPane);
		
		JButton b1 = new JButton("确定");
		JButton b2 = new JButton("取消");
		
		contentPane.add(b1);
		contentPane.add(b2);
		
		/*
		JFrame jf = new JFrame("添加内容面板测试程序");
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		JPanel contentPane = new JPanel();
		
		jf.getContentPane().add(contentPane);
		
		JButton b1 = new JButton("确定");
		JButton b2 = new JButton("取消");
		
		contentPane.add(b1);
		contentPane.add(b2);
		 */
	}
}
