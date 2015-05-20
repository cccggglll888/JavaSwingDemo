package com.cgl.swing.jtable.d0520;

import java.awt.Point;
import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class CellDemoTableModel extends DefaultTableModel implements CellDemoModelInterface, TableModelListener {
	private static final long serialVersionUID = 1L;
	/**
	 * 装在数据的表格模型
	 */
	protected AbstractTableModel model;
	/**
	 * 表格合并状态集合
	 */
	protected List<List<Point>> gridInfo;
	
	CellDemoTableModel(AbstractTableModel model) {
		gridInfo = new Vector<List<Point>>();
		setTableModel(model);
	}
	/**
	 * 设置表格模型，初始化表格状态
	 * @param model
	 */
	public void setTableModel(AbstractTableModel model) {
		if (model != null && model != this.model) {
			if (this.model != null)
				this.model.removeTableModelListener(this);
			// 防止多次添加监听器
			model.removeTableModelListener(this);
			model.addTableModelListener(this);
			this.model = model;
			clearMergence();
		}
	}
	/**
	 * 清除所有合并
	 */
	public void clearMergence() {
		if (gridInfo == null)
			gridInfo = new Vector<List<Point>>();
		else
			gridInfo.clear();

		if (model == null)
			return;

		// 初始化，每个格子占的格子数为(1,1);
		for (int row = model.getRowCount(); --row >= 0;) {
			List<Point> infos = new Vector<Point>();
			gridInfo.add(infos);
			for (int col = model.getColumnCount(); --col >= 0;) {
				infos.add(getDefaultPoint());
			}
		}
	}
	/**
	 * 返回初始化表格状态
	 * @return
	 */
	public Point getDefaultPoint() {
		return new Point(1, 1);
	}
	
	
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
//		 Vector rowVector = (Vector)dataVector.elementAt(row);
//	     return rowVector.elementAt(column);
		return super.getValueAt(row, column);
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		// TODO Auto-generated method stub
		super.setValueAt(aValue, row, column);
	}

	@Override
	public int[] span(int row, int column) {
		
		Point gp = gridInfo.get(row).get(column);
		
		// 行列有小于1的为隐藏单元格返回合并单元格坐标
		if (gp.x < 1 || gp.y < 1){
			int tx = 1 - gp.x;
			int x = row - tx;
			
			int ty = 1 - gp.y;
			int y = column - ty;
			
			return new int[]{x, y};
		}
		return new int[]{1, 1};
		
	}

	@Override
	public void setSpan(int[] span, int row, int column) {
		// 插入合并单元格偏移坐标相对于显示单元格
		for (int i = 0; i < span[0]; i++) {
			for (int j = 0; j < span[1]; j++) {
				// 要插入的坐标
				int x = 1 - i;
				int y = 1 - j;
				Point p = new Point(x, y);
				gridInfo.get(row).set(column, p);
			}
		}
		Point sp = new Point(span[0], span[1]);
		gridInfo.get(row).set(column, sp);
	}

	@Override
	public Point visibleCell(int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void combine(int[] rows, int[] columns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void split(int row, int column) {
		// TODO Auto-generated method stub
		
	}
	// TODO 预留表格删除时对合并单元格的监听
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
