package com.cgl.swing.jtable.d0519;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 * 表格分割例子
 * @author Administrator
 *
 */
public class CLTreeTable extends JTable {
	private static final long serialVersionUID = 1L;
	
	private static final int SEPARATOR = 2;
	/**
	 * 表格渲染器
	 * @author Administrator
	 */
	class MyCellRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {

			if (column == SEPARATOR) {
				JButton renderer = new JButton();
				renderer.setBorder(new MyBorder(renderer.getBorder()));
				return renderer;
			} else {
				return super.getTableCellRendererComponent(table, value,
						isSelected, hasFocus, row, column);
			}
		}
	}
	/**
	 * 表头渲染器
	 * @author Administrator
	 */
	class MyHeaderRenderer extends DefaultTableCellHeaderRenderer {
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {

			if (column == SEPARATOR) {
				JButton renderer = new JButton();
				renderer.setBorder(new MyBorder(renderer.getBorder()));
				return renderer;

			} else {
				return super.getTableCellRendererComponent(table, value,
						isSelected, hasFocus, row, column);
			}
		}

		public void paintComponent(Graphics graphic) {

			super.paintComponent(graphic);
		}

	}
	/**
	 * 表格编辑器
	 * @author Administrator
	 */
	class MyCellEditor extends DefaultCellEditor {
		private static final long serialVersionUID = 1L;

		public MyCellEditor(JTextField textField) {
			super(textField);
		}

		public boolean isCellEditable(EventObject anEvent) {
			if (anEvent instanceof MouseEvent) {
				MouseEvent event = (MouseEvent) anEvent;
				int column = CLTreeTable.this.columnAtPoint(event.getPoint());
				if (column == SEPARATOR) {
					return false;
				}
			}

			return super.isCellEditable(anEvent);
		}

	}

	class MyBorder implements Border {
		private Border delegate;

		MyBorder(Border delegate) {
			this.delegate = delegate;
		}

		public void paintBorder(Component c, Graphics g, int x, int y,
				int width, int height) {

			this.delegate.paintBorder(c, g, x, y, width, height);
		}

		public Insets getBorderInsets(Component c) {
			return new Insets(0, 1, 0, 1);
		}

		public boolean isBorderOpaque() {
			return this.delegate.isBorderOpaque();
		}

	}

	public CLTreeTable(Object[][] data, Object[] header) {
		super(data, header);

		super.setDefaultRenderer(Object.class, new MyCellRenderer());
		super.setDefaultEditor(Object.class, new MyCellEditor(new JTextField()));
		super.getTableHeader().setDefaultRenderer(new MyHeaderRenderer());

		if (header.length > SEPARATOR) {
			TableColumnModel model = super.getColumnModel();
			TableColumn column = model.getColumn(SEPARATOR);

			column.setMaxWidth(16); // Swing's default minimum width;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[][] data = new String[][] {
				{ "A1", "B1", "", "C1", "D1", "E1" },
				{ "A2", "B2", "", "C2", "D2", "E2" } };
		String[] header = new String[] { "A", "B", "", "C", "D", "E" };

		JScrollPane box = new JScrollPane(new CLTreeTable(data, header));

		frame.getContentPane().add(box);
		frame.setBounds(100, 100, 400, 400);

		frame.setTitle("My CL Tree Table");

		frame.setVisible(true);
	}
}
