/*
 * 2014-10-20 22:59:45
 * 使用网格布局的简单界面
 */
package com.cgl.swing.demo2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelloWorld_2_1 extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static final int WIDTH = 300;
	static final int HEIGHT = 150;
	
	JFrame loginframe;
	
	public void add(Component c, GridBagConstraints constraints, int x, int y, int w, int h){
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c, constraints);
	}
	
	HelloWorld_2_1(){
		loginframe = new JFrame("欢迎进入Java世界");
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//窗口空间在界面中的总体布局
		GridBagLayout lay = new GridBagLayout();
		setLayout(lay);
		loginframe.add(this, BorderLayout.WEST);
		loginframe.setSize(WIDTH, HEIGHT);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = (width - WIDTH)/2;
		int y = (height - HEIGHT)/2;
		loginframe.setLocation(x, y);
		
		JButton ok = new JButton("登陆");
		JButton cancel = new JButton("放弃");
		JLabel title = new JLabel("欢迎进入Java世界");
		JLabel name = new JLabel("用户名");
		JLabel password = new JLabel("密码");
		final JTextField nameinput = new JTextField(15);
		final JTextField passwordinput = new JTextField(15);
		
		GridBagConstraints constraints = new GridBagConstraints();
		//网格布局这两项具体用途
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.weightx = 3;
		constraints.weighty = 4;
		
		add(title, constraints, 0, 0, 4, 1);
		add(name, constraints, 0, 1, 1, 1);
		add(password, constraints, 0, 2, 1, 1);
		add(nameinput, constraints, 2, 1, 1, 1);
		add(passwordinput, constraints, 2, 2, 1, 1);
		add(ok, constraints, 0, 3, 1, 1);
		add(cancel, constraints, 2, 3, 1, 1);
		
		//窗口大小不可调整
		loginframe.setResizable(false);
		loginframe.setVisible(true);
	}
}
