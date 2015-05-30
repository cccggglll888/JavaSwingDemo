package com.cgl.swing.jtable.d0530;

import java.awt.Dimension;

import javax.swing.table.JTableHeader;

public class TableHeader extends JTableHeader {
	private int rowHeight = 20;

	public TableHeader(int rowHeight) {
		setLayout(new TableHeaderLayout());

		this.rowHeight = rowHeight;
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension d = super.getPreferredSize();
		TableHeaderLayout layout = (TableHeaderLayout) getLayout();
		d.height = layout.getRowCount() * rowHeight;

		return d;
	}
}
