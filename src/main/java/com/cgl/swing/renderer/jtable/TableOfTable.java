package com.cgl.swing.renderer.jtable;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * 表格嵌套例子
 * @author Administrator
 *
 */
public class TableOfTable extends JTable {
	private static final long serialVersionUID = 1L;
	
	public TableOfTable(){
		// 添加缺省表格数据模型
		setModel(new DefaultTableModel(10, 10));
		// 设第二行行高
		setRowHeight(1, super.getRowHeight()*4);
	}
	/**
	 * 重载父类获取渲染器的方法，提供自己的渲染器
	 */
	@Override
	public TableCellRenderer getCellRenderer(int row, int column) {
		// 为一行二列提供渲染器
		if (row == 1 && column == 2) {
			return new TableCellRenderer() {
				// 嵌套字表
				JTable subTable = new JTable(new DefaultTableModel(4,4));
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value,
						boolean isSelected, boolean hasFocus, int row, int column) {
					return subTable;
				}
			};
		}
		return super.getCellRenderer(row, column);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TableOfTable t = new TableOfTable();
		f.getContentPane().add(t);
		f.pack();
		f.setVisible(true);
		
	}
}
