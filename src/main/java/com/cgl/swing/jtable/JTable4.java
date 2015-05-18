package com.cgl.swing.jtable;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;

/**
 * Provide a fixed column in a table
 * 
 * @author Gaowen
 * 
 */

public class JTable4 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 805308369080023303L;

	public JTable4() {
		super();
		setTitle("提供行标题栏的表格");
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Vector<String> columnNameV = new Vector<String>();
		columnNameV.add("日期");
		for (int i = 1; i < 21; i++) {
			columnNameV.add("商品" + i);
		}
		Vector<Vector<Object>> tableValueV = new Vector<Vector<Object>>();
		for (int row = 1; row < 31; row++) {
			Vector<Object> rowV = new Vector<Object>();
			rowV.add(row);
			for (int col = 0; col < 20; col++) {
				rowV.add((int) (Math.random() * 1000));
			}
			tableValueV.add(rowV);
		}
		final MFixedColumnTable panel = new MFixedColumnTable(columnNameV,
				tableValueV, 2);
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTable4 frame = new JTable4();
		frame.setVisible(true);
	}
}
