package com.cgl.swing.jtable.d0519;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

public class TestFixTable2 {

	public static JScrollPane createAJScrollPane(JTable sideTb,
			int sideViewWidth, JTable Tb) {
		JScrollPane result = new JScrollPane(Tb);

		JViewport dataviewport = new JViewport();

		result.getViewport().setBackground(Color.white);
		result.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		// 添加左边表格
		dataviewport.setView(sideTb);
		dataviewport.setBackground(Color.white);
		dataviewport.setPreferredSize(new Dimension(sideViewWidth, 100));
		result.setRowHeader(dataviewport);
		result.setCorner(JScrollPane.UPPER_LEFT_CORNER, sideTb.getTableHeader());

		return result;
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(createAJScrollPane(new JTable(2, 2),500,new JTable(2, 5)));
		jf.pack();
		jf.setVisible(true);
		
		
	}

}
