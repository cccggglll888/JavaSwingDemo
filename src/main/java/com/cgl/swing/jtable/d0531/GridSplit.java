package com.cgl.swing.jtable.d0531;

interface GridSplit {
	int spanCol(int row, int column);

	int visibleColCell(int row, int column);

	int spanRow(int row, int column);

	int visibleRowCell(int row, int column);

	boolean isVisible(int row, int column);
}