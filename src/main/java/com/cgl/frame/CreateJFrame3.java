package com.cgl.frame;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FocusTraversalPolicy;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CreateJFrame3 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateJFrame3 frame = new CreateJFrame3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateJFrame3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//textField = new JTextField();
		
		textField = new JTextField();
		textField.setLocation(new Point(37, 30));
		textField.setSize(new Dimension(200, 22));
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(new Rectangle(37, 60, 200, 22));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(new Rectangle(37, 90, 200, 22));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(new Rectangle(37, 120, 200, 22));
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(new Rectangle(37, 150, 200, 22));
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		Vector<Component> order = new Vector<Component>(10);
		order.add(textField);
		order.add(textField_3);
		order.add(textField_1);
		order.add(textField_2);
		order.add(textField_4);
		
		MyOwnFocusTraversalPolicy aa = new MyOwnFocusTraversalPolicy(order);
		this.setFocusTraversalPolicy(aa);
	}
	// 内置类，实现TAB按照指定规则设置
	public static class MyOwnFocusTraversalPolicy extends FocusTraversalPolicy {
		Vector<Component> order;
		
		public MyOwnFocusTraversalPolicy(Vector<Component> order) {
			//this.order = new Vector<Component>(order.size());
			//this.order.addAll(order);
			this.order = order;
		}
		@Override
		public Component getComponentAfter(Container focusCycleRoot,
				Component aComponent) {
			int idx = (order.indexOf(aComponent) + 1) % order.size();
			System.out.println("(order.indexOf(aComponent) + 1)==="+(order.indexOf(aComponent) + 1));
			System.out.println("order.size()==="+order.size());
			System.out.println("idx==="+idx);
			return order.get(idx);
		}
		@Override
		public Component getComponentBefore(Container focusCycleRoot,
				Component aComponent) {
			int idx = order.indexOf(aComponent) - 1;
			if (idx < 0) {
				idx = order.size() - 1;
			}
			return order.get(idx);
		}
		@Override
		public Component getDefaultComponent(Container focusCycleRoot) {
			return order.get(0);
		}
		@Override
		public Component getLastComponent(Container focusCycleRoot) {
			return order.lastElement();
		}
		@Override
		public Component getFirstComponent(Container focusCycleRoot) {
			return order.get(0);
		}
	}
}
