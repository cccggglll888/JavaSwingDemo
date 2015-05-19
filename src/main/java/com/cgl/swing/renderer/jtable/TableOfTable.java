package com.cgl.swing.renderer.jtable;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
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
	
	JTable subTable = new JTable(new DefaultTableModel(4,4));
	
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
	
	
	@Override
	public TableCellEditor getCellEditor(int row, int column) {
		System.out.println(this.getValueAt(1, 2));
		System.out.println(this.getValueAt(0, 0));
		// 为一行二列提供编辑器
		if (row == 1 && column == 2) {
			return new TableCellEditor() {
				/**
				 * 停止编辑器编辑，如果不能停止返回false
				 */
				@Override
				public boolean stopCellEditing() {
					// TODO Auto-generated method stub
					return true;
				}
				/**
				 * 是否可以被选中
				 */
				@Override
				public boolean shouldSelectCell(EventObject anEvent) {
					// TODO Auto-generated method stub
					return true;
				}
				/**
				 * 删除CellEditorListener
				 */
				@Override
				public void removeCellEditorListener(CellEditorListener l) {
					// TODO Auto-generated method stub
					
				}
				/**
				 * 判断是否能激活编辑操作
				 */
				@Override
				public boolean isCellEditable(EventObject anEvent) {
					// TODO Auto-generated method stub
					return true;
				}
				/**
				 * 返回编辑后的有效值
				 */
				@Override
				public Object getCellEditorValue() {
					// TODO Auto-generated method stub
					return "getCellEditorValue";
				}
				/**
				 * 取消编辑，不使用任何编辑过的值
				 */
				@Override
				public void cancelCellEditing() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void addCellEditorListener(CellEditorListener l) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public Component getTableCellEditorComponent(JTable table, Object value,
						boolean isSelected, int row, int column) {
					return subTable;
				}
			};
		}
		return super.getCellEditor(row, column);
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
