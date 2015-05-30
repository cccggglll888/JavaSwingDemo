package com.cgl.swing.jtable.d0531;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestTable {
	public static void main(String[] args) {
		final JTable table = createTable();
		JFrame frame = new JFrame("duoJTable");
		frame.setSize(600, 350);
		frame.setLayout(new GridBagLayout());
		frame.add(new JScrollPane(table), new GBC(0, 0).setWeight(100, 100)
				.setFill(GBC.BOTH));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static JTable createTable() {
		TableContent tableContent = new TableContent();
		tableContent.append("1", 1, 3);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("2", 1, 3);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("プロジェクト3", 1, 3);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("4", 1, 3);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("5", 1, 3);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("6", 1, 3);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("7", 1, 3);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();
		tableContent.append("", 1, 1);
		tableContent.println();

		List<GroupHeader> list = new ArrayList<GroupHeader>();
		list.add(new GroupHeader("08年1月", 1, 31));
		list.add(new GroupHeader("08年2月", 32, 60));
		return DTable.create(tableContent, new Object[] { "プロジェクト", "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31", "1", "2", "3",
				"4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29" }, list);

	}

}

class GBC extends GridBagConstraints {
	public GBC(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
	}

	public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}

	public GBC setAnchor(int anchor) {
		this.anchor = anchor;
		return this;
	}

	/**
	 * Sets the fill direction.
	 * 
	 * @param fill
	 *            the fill direction
	 * @return this object for further modification
	 */
	public GBC setFill(int fill) {
		this.fill = fill;
		return this;
	}

	/**
	 * Sets the cell weights.
	 * 
	 * @param weightx
	 *            the cell weight in x-direction
	 * @param weighty
	 *            the cell weight in y-direction
	 * @return this object for further modification
	 */
	public GBC setWeight(double weightx, double weighty) {
		// super.w
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}

	/**
	 * Sets the insets of this cell.
	 * 
	 * @param distance
	 *            the spacing to use in all directions
	 * @return this object for further modification
	 */
	public GBC setInsets(int distance) {
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}

	/**
	 * Sets the insets of this cell.
	 * 
	 * @param top
	 *            the spacing to use on top
	 * @param left
	 *            the spacing to use to the left
	 * @param bottom
	 *            the spacing to use on the bottom
	 * @param right
	 *            the spacing to use to the right
	 * @return this object for further modification
	 */
	public GBC setInsets(int top, int left, int bottom, int right) {
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}

	/**
	 * Sets the internal padding
	 * 
	 * @param ipadx
	 *            the internal padding in x-direction
	 * @param ipady
	 *            the internal padding in y-direction
	 * @return this object for further modification
	 */
	public GBC setIpad(int ipadx, int ipady) {
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}
}