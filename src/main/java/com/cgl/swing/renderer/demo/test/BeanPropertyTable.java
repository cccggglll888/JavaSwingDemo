package com.cgl.swing.renderer.demo.test;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * 属性表格类
 * @author Administrator
 *
 */
public class BeanPropertyTable extends JTable {
	private static final long serialVersionUID = 1L;

	// ...
	private ArrayList<BeanProperty> properties;

	public BeanPropertyTable() {
		properties = new ArrayList<BeanProperty>();
		// ...
	}

	public void setProperties(ArrayList<BeanProperty> properties) {
		if (properties != null) {
			this.properties = properties;
			setModel(new BeanModel());
		}
	}

	// 自定义的TableModel
	private class BeanModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;

		public int getRowCount() {
			// 属性表的行数
			return properties.size();
		}

		public int getColumnCount() {
			// 属性表的列数
			return 2;
		}

		public String getColumnName(int columnIndex) {
			// 属性表的列名：property, value
			return columnIndex == 0 ? "property" : "value";
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// 第二列属性值可编辑
			return columnIndex == 1;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			// 获取值，第一列用属性显示名，第二列用属性值
			BeanProperty property = properties.get(rowIndex);
			return columnIndex == 0 ? property.getDisplayName() : property
					.getValue();
		}

		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			if (columnIndex == 1)// 只有第二列可编辑，设置第二列到属性值
				properties.get(rowIndex).setValue(aValue);
		}
	}

	// 覆盖父类的getCellRenderer提供个性化的渲染器
	public TableCellRenderer getCellRenderer(int row, int column) {
		if (column == 0)// 第一列使用继承的渲染器
			return super.getCellRenderer(row, column);
		else
			// 第二列使用属性对象自己提供的渲染器，注意Support类实现了TableCellRenderer
			return properties.get(row).getSupport();
	}

	// 覆盖父类的getCellEditor提供个性化的编辑器
	public TableCellEditor getCellEditor(int row, int column) {
		if (column == 0)// 第一列使用继承的编辑器
			return super.getCellEditor(row, column);
		else
			// 第二列使用属性对象自己提供的编辑器，注意Support类实现了TableCellEditor
			return properties.get(row).getSupport();
	}
}