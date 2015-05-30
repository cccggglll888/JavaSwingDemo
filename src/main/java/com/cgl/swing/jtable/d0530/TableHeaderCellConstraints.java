package com.cgl.swing.jtable.d0530;

public class TableHeaderCellConstraints {
	public final int x;

	public final int y;

	public final int colSpan;

	public final int rowSpan;

	public TableHeaderCellConstraints(final int x, final int y,
			final int colSpan, final int rowSpan) {
		this.x = x;
		this.y = y;
		this.colSpan = colSpan;
		this.rowSpan = rowSpan;
	}

	public TableHeaderCellConstraints(final int x, final int y,
			final int colSpan) {
		this(x, y, colSpan, 1);
	}

	public TableHeaderCellConstraints(final int x, final int y) {
		this(x, y, 1, 1);
	}
}
