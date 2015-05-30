package com.cgl.swing.jtable.d0530;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class TableHeaderLayout implements LayoutManager2 {
	private HashMap<Component, TableHeaderCellConstraints> compCellMap = new HashMap<Component, TableHeaderCellConstraints>();

	private int rowCount = 0;

	public void addLayoutComponent(Component comp, Object constraints) {
		if (constraints == null
				|| !(constraints instanceof TableHeaderCellConstraints)) {
			return;
		}

		TableHeaderCellConstraints cell = (TableHeaderCellConstraints) constraints;
		compCellMap.put(comp, cell);
		rowCount = Math.max(rowCount, cell.y + cell.rowSpan);
	}

	public int getRowCount() {
		return rowCount;
	}

	public float getLayoutAlignmentX(Container target) {
		return 0;
	}

	public float getLayoutAlignmentY(Container target) {
		return 0;
	}

	public void invalidateLayout(Container target) {
	}

	public Dimension maximumLayoutSize(Container target) {
		return preferredLayoutSize(target);
	}

	public void addLayoutComponent(String name, Component comp) {
		throw new IllegalArgumentException();
	}

	public void layoutContainer(Container parent) {
		JTableHeader header = (JTableHeader) parent;
		JTable table = header.getTable();

		TableColumnModel columnModel = table.getColumnModel();
		int rowHeight = header.getHeight() / rowCount;

		Component[] cellComps = parent.getComponents();
		for (Component cellComp : cellComps) {
			TableHeaderCellConstraints cell = compCellMap.get(cellComp);
			if (cell == null) {
				continue;
			}

			int cellX = 0;
			for (int i = 0; i < cell.x; i++) {
				cellX += columnModel.getColumn(i).getWidth();
			}

			int cellWid = 0;
			for (int i = 0; i < cell.colSpan; i++) {
				cellWid += columnModel.getColumn(cell.x + i).getWidth();
			}

			int cellY = rowHeight * cell.y;
			int cellHei = rowHeight * cell.rowSpan;

			cellComp.setBounds(cellX, cellY, cellWid, cellHei);
		}
	}

	public Dimension minimumLayoutSize(Container parent) {
		return preferredLayoutSize(parent);
	}

	public Dimension preferredLayoutSize(Container parent) {
		return new Dimension(1, 1);
	}

	public void removeLayoutComponent(Component comp) {
		compCellMap.remove(comp);
		rowCount = 0;

		for (TableHeaderCellConstraints cell : compCellMap.values()) {
			rowCount = Math.max(rowCount, cell.y + cell.rowSpan);
		}
	}
}