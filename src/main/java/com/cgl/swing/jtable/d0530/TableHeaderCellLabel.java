package com.cgl.swing.jtable.d0530;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;

public class TableHeaderCellLabel extends JLabel {

	public TableHeaderCellLabel(Icon icon, int top, int left, int bottom,
			int right) {
		this("", icon, top, left, bottom, right);
	}

	public TableHeaderCellLabel(String text, Icon icon, int top, int left,
			int bottom, int right) {
		super(text, icon, JLabel.CENTER);

		setBorder(BorderFactory.createMatteBorder(top, left, bottom, right,
				Color.gray));
	}

	public TableHeaderCellLabel(String text, int top, int left, int bottom,
			int right) {
		this(text, null, top, left, bottom, right);
	}
}