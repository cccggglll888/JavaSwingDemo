package com.cgl.swing.jcombobox;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class JComboboxDemo extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JComboboxDemo(){
		String[] petStrings = {"aa", "bb", "cc"};
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComboBox<String> colorCombo = new JComboBox<String>(petStrings);
		
		MyComboBoxRenderer renderer = new MyComboBoxRenderer();
		// 设置列表宽高
		renderer.setPreferredSize(new Dimension(200, 100));
		
		// 设置渲染器
//		colorCombo.setRenderer(renderer);
		// 设置默认选择项
		colorCombo.setSelectedIndex(1);
		// 通过UI设置样式
		colorCombo.setUI((ComboBoxUI)MyComboBoxUI.createUI(colorCombo));
		
		f.getContentPane().add(colorCombo);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new JComboboxDemo();
	}
	
	/**
	 * 渲染器
	 * @author Administrator
	 */
	private class MyComboBoxRenderer extends JLabel implements ListCellRenderer<String>{
		private static final long serialVersionUID = 1L;
		
		@Override
		public Component getListCellRendererComponent(
				JList<? extends String> list, String value, int index,
				boolean isSelected, boolean cellHasFocus) {
			// TODO Auto-generated method stub
			return this;
		}
		
	}
	
	/**
	 * 重写UI
	 * @author Administrator
	 */
	private static class MyComboBoxUI extends BasicComboBoxUI{
		public static ComponentUI createUI(JComponent c){
			return (ComponentUI)new MyComboBoxUI();
		}

		@Override
		protected JButton createArrowButton() {
			JButton button = new BasicArrowButton(BasicArrowButton.EAST);
			return button;
		}
		
	}
	
	@SuppressWarnings({ "unused", "serial" })
	private class MyModel extends DefaultComboBoxModel<Object>{
		String[] fruit = {"aaa", "bbb", "", "ccc"};
		
	}
	
}




