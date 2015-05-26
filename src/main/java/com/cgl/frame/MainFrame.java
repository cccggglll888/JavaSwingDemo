package com.cgl.frame;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FocusTraversalPolicy;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * 焦点循环的例子
 * @author Administrator
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JTextField jTextField5 = null;
	private JTextField jTextField6 = null;
	private JTextField jTextField7 = null;
	private JTextField jTextField8 = null;
	private JTextField jTextField9 = null;
	static MyOwnFocusTraversalPolicy newPolicy;

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setLocation(new Point(37, 30));
			jTextField.setSize(new Dimension(200, 22));
			jTextField.addActionListener(new MyActionListener());
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(37, 60, 200, 22));
			jTextField1.addActionListener(new MyActionListener());
		}
		return jTextField1;
	}

	/**
	 * This method initializes jTextField2
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(37, 90, 200, 22));
			jTextField2.addActionListener(new MyActionListener());
		}
		return jTextField2;
	}

	/**
	 * This method initializes jTextField3
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(37, 120, 200, 22));
			jTextField3.addActionListener(new MyActionListener());
		}
		return jTextField3;
	}

	/**
	 * This method initializes jTextField4
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setBounds(new Rectangle(37, 150, 200, 22));
			jTextField4.addActionListener(new MyActionListener());
		}
		return jTextField4;
	}

	/**
	 * This method initializes jTextField5
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setBounds(new Rectangle(255, 30, 200, 22));
			jTextField5.addActionListener(new MyActionListener());
		}
		return jTextField5;
	}

	/**
	 * This method initializes jTextField6
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setBounds(new Rectangle(255, 60, 200, 22));
			jTextField6.addActionListener(new MyActionListener());
		}
		return jTextField6;
	}

	/**
	 * This method initializes jTextField7
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new Rectangle(255, 90, 200, 22));
			jTextField7.addActionListener(new MyActionListener());
		}
		return jTextField7;
	}

	/**
	 * This method initializes jTextField8
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField8() {
		if (jTextField8 == null) {
			jTextField8 = new JTextField();
			jTextField8.setBounds(new Rectangle(255, 120, 200, 22));
			jTextField8.addActionListener(new MyActionListener());
		}
		return jTextField8;
	}

	/**
	 * This method initializes jTextField9
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField9() {
		if (jTextField9 == null) {
			jTextField9 = new JTextField();
			jTextField9.setBounds(new Rectangle(255, 150, 200, 22));
			jTextField9.addActionListener(new MyActionListener());
		}
		return jTextField9;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass = new MainFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				thisClass.setFocusTraversalPolicy(newPolicy);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public MainFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(491, 259);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJTextField3(), null);
			jContentPane.add(getJTextField4(), null);
			jContentPane.add(getJTextField5(), null);
			jContentPane.add(getJTextField6(), null);
			jContentPane.add(getJTextField7(), null);
			jContentPane.add(getJTextField8(), null);
			jContentPane.add(getJTextField9(), null);
			Vector<Component> order = new Vector<Component>(10);
			order.add(getJTextField());
			order.add(getJTextField2());
			order.add(getJTextField1());
			order.add(getJTextField3());
			order.add(getJTextField4());
			order.add(getJTextField5());
			order.add(getJTextField6());
			order.add(getJTextField7());
			order.add(getJTextField8());
			order.add(getJTextField9());
			newPolicy = new MyOwnFocusTraversalPolicy(order);
		}
		return jContentPane;
	}
	//文本框按Enter焦点移动至下一个
	class MyActionListener implements ActionListener { // 所有文本框都加入此ActionListener
		public void actionPerformed(ActionEvent e) {
			((JTextField) e.getSource()).transferFocus();// 按【Enter】键,focus往下一个组件
		}
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