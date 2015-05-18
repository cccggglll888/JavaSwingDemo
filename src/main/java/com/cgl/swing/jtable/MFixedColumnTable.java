package com.cgl.swing.jtable;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class MFixedColumnTable extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8001758880985479654L;
	private Vector<String> columnNameV; // declare the table column name vector
	private Vector<Vector<Object>> tableValueV; // declare the table value
												// vector
	private int fixedColumn = 1; // the fixed column number
	private JTable fixedColumnTable;
	private FixedColumnTableModel fixedColumnTableModel;
	private JTable floatingColumnTable;
	private FloatingColumnTableModel floatingColumnTableModel;

	private class FixedColumnTableModel extends AbstractTableModel { // inner class

		/**
		 * 
		 */
		private static final long serialVersionUID = 3935656415101599023L;

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return tableValueV.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return fixedColumn;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return tableValueV.get(rowIndex).get(columnIndex);
		}

		@Override
		public String getColumnName(int columnIndex) {
			return columnNameV.get(columnIndex);
		}
	}

	private class FloatingColumnTableModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2481466672947191281L;

		@Override
		public int getRowCount() {
			return tableValueV.size();
		}

		@Override
		public int getColumnCount() {
			return columnNameV.size() - fixedColumn;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return tableValueV.get(rowIndex).get(columnIndex + fixedColumn);
		}

		@Override
		public String getColumnName(int columnIndex) {
			return columnNameV.get(columnIndex + fixedColumn);
		}
	}

	private class MListSelectionListener implements ListSelectionListener {
		boolean isFixedColumnTable = true;

		public MListSelectionListener(boolean isFixedColumnTable) {
			this.isFixedColumnTable = isFixedColumnTable;
		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if (isFixedColumnTable) {
				int row = fixedColumnTable.getSelectedRow();
				floatingColumnTable.setRowSelectionInterval(row, row);
			} else {
				int row = floatingColumnTable.getSelectedRow();
				fixedColumnTable.setRowSelectionInterval(row, row);
			}
		}
	}

	public MFixedColumnTable(Vector<String> columnNameV, Vector<Vector<Object>> tableValueV, int fixedColumn) {
		super();
		setLayout(new BorderLayout());
		this.columnNameV = columnNameV;
		this.tableValueV = tableValueV;
		this.fixedColumn = fixedColumn;
		// create fixedColumnTable
		fixedColumnTableModel = new FixedColumnTableModel();
		fixedColumnTable = new JTable(fixedColumnTableModel);
		ListSelectionModel fixed = fixedColumnTable.getSelectionModel();
		fixed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fixed.addListSelectionListener(new MListSelectionListener(true));
		// create floatingColumnTable
		floatingColumnTableModel = new FloatingColumnTableModel();
		floatingColumnTable = new JTable(floatingColumnTableModel);
		floatingColumnTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ListSelectionModel floating = floatingColumnTable.getSelectionModel();
		floating.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		floating.addListSelectionListener(new MListSelectionListener(false));
		// create scrollPane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedColumnTable.getTableHeader());
		JViewport viewport = new JViewport();
		viewport.setView(fixedColumnTable);
		viewport.setPreferredSize(fixedColumnTable.getPreferredSize());
		scrollPane.setRowHeaderView(viewport); // viewport 视口
		scrollPane.setViewportView(floatingColumnTable);
		add(scrollPane, BorderLayout.CENTER);
	}
}
