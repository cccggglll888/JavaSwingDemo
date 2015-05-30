package com.cgl.swing.jtable.d0531;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class DTable extends JTable {
	private GridSplit gridSplit;

	public static DTable create(TableContent tableContent,
			Object[] columnHeaders, List<GroupHeader> goupColumnHeaderList) {
		DTable table = tableContent.createTable(columnHeaders);

		table.addGroupColumnHeaderList(goupColumnHeaderList);
		return table;
	}

	public DTable(TableModel tableModel) {
		super(tableModel);
	}

	public DTable(GridSplit gridSplit, TableModel tbl) {
		super(tbl);
		this.gridSplit = gridSplit;
		setUI(new DTableUI());// ﾉ靹ﾃJtableｵﾄ葷ﾈｾUI
	}

	protected JTableHeader createDefaultTableHeader() {
		return new GroupableTableHeader(columnModel);
	}

	public void addGroupColumnHeaderList(List<GroupHeader> goupColumnHeaderList) {
		GroupableTableHeader header = (GroupableTableHeader) getTableHeader();
		TableColumnModel tableColumnModel = getColumnModel();
		for (GroupHeader groupHeader : goupColumnHeaderList) {
			header.addColumnGroup(groupHeader
					.createColumnGroup(tableColumnModel));
		}
		for (int i = 0; i < tableColumnModel.getColumnCount(); i++) {
			tableColumnModel.getColumn(i)
					.setHeaderRenderer(new GroupRenderer());
		}
		getTableHeader().setUI(new GroupableTableHeaderUI(getTableHeader()));
	}

	public Rectangle getCellRect(int row, int column, boolean includeSpacing) {
		if (gridSplit == null) {
			return super.getCellRect(row, column, includeSpacing);
		}

		int colCell = gridSplit.visibleColCell(row, column);
		int rowCell = gridSplit.visibleRowCell(row, column);

		Rectangle rec = super.getCellRect(rowCell, colCell, includeSpacing);
		for (int i = 1; i < gridSplit.spanCol(rowCell, colCell); i++) {
			rec.width += getColumnModel().getColumn(colCell + i).getWidth();
		}
		for (int i = 1; i < gridSplit.spanRow(rowCell, colCell); i++) {
			rec.height += getRowHeight(rowCell + i);
		}
		return rec;
	}

	public int columnAtPoint(Point p) {
		int y = super.columnAtPoint(p);
		if (gridSplit == null) {
			return y;
		}
		if (y < 0)
			return y;
		int x = super.rowAtPoint(p);
		return gridSplit.visibleColCell(x, y);

	}

	public int rowAtPoint(Point p) {
		int x = super.rowAtPoint(p);
		if (gridSplit == null) {
			return x;
		}
		if (x < 0)
			return x;
		int y = super.columnAtPoint(p);
		return gridSplit.visibleRowCell(x, y);
	}

	public boolean isCellSelected(int row, int col) {
		return getSelectedColumn() == col && getSelectedRow() == row;
	}

	public GridSplit getGridSplit() {
		return gridSplit;
	}
}