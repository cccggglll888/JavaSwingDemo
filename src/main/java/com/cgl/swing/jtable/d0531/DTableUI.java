package com.cgl.swing.jtable.d0531;

import javax.swing.table.*;
import javax.swing.plaf.basic.*;
import java.awt.*;
import javax.swing.*;

class DTableUI extends BasicTableUI {
	public void paint(Graphics g, JComponent c) {
		for (int i = 0; i < table.getRowCount(); i++) {
			paintRow(i, g);
		}
	}

	private void paintRow(int row, Graphics g) {
		Rectangle clipBounds = g.getClipBounds();
		GridSplit gridSplit = ((DTable) table).getGridSplit();
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (gridSplit.isVisible(row, i)) {
				Rectangle rec = table.getCellRect(row, i, true);
				if (rec.intersects(clipBounds)) {
					paintCell(row, i, g, rec);
				}
			}
		}
	}

	private void paintCell(int row, int column, Graphics g, Rectangle area) {
		int verticalMargin = table.getRowMargin();
		int horizontalMargin = table.getColumnModel().getColumnMargin();

		Color c = g.getColor();
		g.setColor(table.getGridColor());
		g.drawRect(area.x, area.y, area.width - 1, area.height - 1);
		g.setColor(c);

		area.setBounds(area.x + horizontalMargin / 2, area.y + verticalMargin
				/ 2, area.width - horizontalMargin, area.height
				- verticalMargin);

		if (table.isEditing() && table.getEditingRow() == row
				&& table.getEditingColumn() == column) {
			Component component = table.getEditorComponent();
			component.setBounds(area);
			component.validate();
		} else {
			TableCellRenderer renderer = table.getCellRenderer(row, column);
			Component component = table.prepareRenderer(renderer, row, column);
			if (component.getParent() == null)
				rendererPane.add(component);
			rendererPane.paintComponent(g, component, table, area.x, area.y,
					area.width, area.height, true);
		}
	}

}