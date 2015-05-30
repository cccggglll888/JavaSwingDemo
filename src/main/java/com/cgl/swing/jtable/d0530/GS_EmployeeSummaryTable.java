package com.cgl.swing.jtable.d0530;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class GS_EmployeeSummaryTable extends JTable {
	private static final long serialVersionUID = 1L;

	GS_EmployeeSummaryTableModel model;

	TableHeaderCellLabel balanceLabel, averageLabel;

	public GS_EmployeeSummaryTable(GS_EmployeeSummaryTableModel model) {
		super(model);

		this.model = model;

		TableColumnModel tcm = getColumnModel();
		int[] widths = { 90, 100, 120, 120, 120, 140, 140, 140, 140, 140, 140, 140, 140 };// 各列列宽设定
		for (int i = 0; i < widths.length; i++) {
			TableColumn tc = tcm.getColumn(i);
			
			tc.setPreferredWidth(widths[i]);
		}
	}

	@Override
	protected JTableHeader createDefaultTableHeader() {
		TableHeader header = new TableHeader(20);

		balanceLabel = new TableHeaderCellLabel("2007年1月", 0, 0, 1, 1);
		averageLabel = new TableHeaderCellLabel("2007年2月", 0, 0, 1, 1);

		header.add(new TableHeaderCellLabel("label1", 0, 0, 1, 1),
				new TableHeaderCellConstraints(0, 0, 1, 2));
		header.add(new TableHeaderCellLabel("label2", 0, 0, 1, 1),
				new TableHeaderCellConstraints(1, 0, 1, 2));
		header.add(new TableHeaderCellLabel("label3", 0, 0, 1, 1),
				new TableHeaderCellConstraints(2, 0, 1, 2));
		header.add(new TableHeaderCellLabel("label4", 0, 0, 1, 1),
				new TableHeaderCellConstraints(3, 0, 1, 2));
		header.add(new TableHeaderCellLabel("label5", 0, 0, 1, 1),
				new TableHeaderCellConstraints(4, 0, 1, 2));
		header.add(balanceLabel, new TableHeaderCellConstraints(5, 0, 4, 1));
		header.add(new TableHeaderCellLabel("value1", 0, 0, 1, 1),
				new TableHeaderCellConstraints(5, 1, 1, 1));
		header.add(new TableHeaderCellLabel("value2", 0, 0, 1, 1),
				new TableHeaderCellConstraints(6, 1, 1, 1));
		header.add(new TableHeaderCellLabel("value3", 0, 0, 1, 1),
				new TableHeaderCellConstraints(7, 1, 1, 1));
		header.add(new TableHeaderCellLabel("value4", 0, 0, 1, 1),
				new TableHeaderCellConstraints(8, 1, 1, 1));
		
		header.add(averageLabel, new TableHeaderCellConstraints(9, 0, 4, 1));
		header.add(new TableHeaderCellLabel("value5", 0, 0, 1, 1),
				new TableHeaderCellConstraints(9, 1, 1, 1));
		header.add(new TableHeaderCellLabel("value6", 0, 0, 1, 1),
				new TableHeaderCellConstraints(10, 1, 1, 1));
		header.add(new TableHeaderCellLabel("value7", 0, 0, 1, 1),
				new TableHeaderCellConstraints(11, 1, 1, 1));
		header.add(new TableHeaderCellLabel("value8", 0, 0, 1, 1),
				new TableHeaderCellConstraints(12, 1, 1, 1));

		return header;
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GS_EmployeeSummaryTable table = new GS_EmployeeSummaryTable(new GS_EmployeeSummaryTableModel(20,13));
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setVisible(true);
		
		
		
	}
        //todo...
	
	
}
class GS_EmployeeSummaryTableModel extends DefaultTableModel{
	GS_EmployeeSummaryTableModel(int row, int col){
		super(row, col);
	}
}