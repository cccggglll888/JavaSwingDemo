/*
 * 2014-10-25 09:59:11
 * 在顶层容器中添加菜单栏
 */
package com.cgl.swing.demo3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menutest_3_2_3 {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("学生管理系统");
		
		JMenuBar menubar1 = new JMenuBar();
		jf.setJMenuBar(menubar1);
		
		JMenu menu1 = new JMenu("文件");
		JMenu menu2 = new JMenu("编辑");
		JMenu menu3 = new JMenu("视图");
		
		menubar1.add(menu1);
		menubar1.add(menu2);
		menubar1.add(menu3);
		
		JMenuItem item1 = new JMenuItem("打开");
		JMenuItem item2 = new JMenuItem("保存");
		JMenuItem item3 = new JMenuItem("打印");
		JMenuItem item4 = new JMenuItem("退出");
		
		menu1.add(item1);
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		menu1.addSeparator();
		menu1.add(item4);
		
		jf.setVisible(true);
		
		//菜单空白处添加基本组件
		JButton button = new JButton("这是一个测试按钮组件");
		JPanel pane = new JPanel();
		pane.add(button);
		jf.setContentPane(pane);
		/* JComponent类的常用子类
		 * JButton			创建按钮对象，而且可以创建带图标的按钮
		 * JTree			创建树对象
		 * JComboBox		创建组合框对象，和Choice相似
		 * JCheckBox		创建复选框对象
		 * JFileChooser		创建文件选择器
		 * JInternalFrame	创建内部窗体
		 * JLabel			创建标签
		 * JMenu			创建菜单对象
		 * JMenuBar			创建菜单条对象
		 * JPanel			创建面板对象
		 * JPasswordField	创建口令文本对象
		 * JPopupMenu		创建弹出式菜单
		 * JProgressBar		创建进程条
		 * JScrollBar		创建滚动条
		 * JTextArea		创建文本区
		 * JTable			创建表格
		 * JSplitPane		创建拆分窗格
		 * JToolTip			创建工具提示对象
		 * JToolBar			创建工具条
		 * JTexPane			创建文本窗格
		 * JRadioButton		创建单选按钮
		 * JScrollPane		创建滚动窗格
		 * JSlider			创建滚动条
		 */
	}
}
