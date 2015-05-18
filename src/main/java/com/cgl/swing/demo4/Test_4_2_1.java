package com.cgl.swing.demo4;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Test_4_2_1 {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("测试程序");
		jf.setSize(WIDTH, HEIGHT);
		jf.setLocation(500, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setResizable(false);//窗口不可调
		
		JPanel contentPane = new JPanel();
		jf.setContentPane(contentPane);
		
		//按钮
		JButton b1 = new JButton("按钮");
		contentPane.add(b1);
		
		//单选按钮
		JRadioButton jr1 = new JRadioButton("单选项1");
		JRadioButton jr2 = new JRadioButton("单选项2");
		contentPane.add(jr1);
		contentPane.add(jr2);
		
		JRadioButton jr3 = new JRadioButton("单选项3");
		JRadioButton jr4 = new JRadioButton("单选项4");
		//jr4.setEnabled(false);//控件不可用
		ButtonGroup bg = new ButtonGroup();
		bg.add(jr3);
		bg.add(jr4);
		contentPane.add(jr3);
		contentPane.add(jr4);
		
		//复选框
		JCheckBox jc1 = new JCheckBox("复选1");
		JCheckBox jc2 = new JCheckBox("复选2");
		contentPane.add(jc1);
		contentPane.add(jc2);
	}
}
