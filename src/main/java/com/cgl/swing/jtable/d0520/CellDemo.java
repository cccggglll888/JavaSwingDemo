package com.cgl.swing.jtable.d0520;

import java.awt.Point;
import java.util.List;
import java.util.Vector;

public class CellDemo {
	/**
	 * 表格状态
	 */
	static List<List<Point>> cells = new Vector<List<Point>>();
	/**
	 * 初始化表格状态
	 * @param row
	 * @param column
	 */
	public void initCell(int row, int column){
		Vector<Point> cols ;
		Point c ;
		for (int i = 0; i < row; i++) {
			cols = new Vector<Point>();
			for (int j = 0; j < column; j++) {
				c = new Point(1, 1);
				cols.add(c);
			}
			cells.add(cols);
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (List<Point> list : cells) {
			for (Point point : list) {
				sb.append("[");
				sb.append((int)point.getX());
				sb.append(",");
				sb.append((int)point.getY());
				sb.append("]\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * 如果当前列隐藏，返回合并列，否则返回原来的值
	 * @param p 单元格实际坐标
	 * @return
	 */
	public int columnAtPoint(Point p){
		List<Point> a = cells.get(p.x);
		Point b = a.get(p.y);
		// 行列有小于1的为隐藏单元格返回合并单元格坐标
		System.out.println(b);
		if (b.x < 1 || b.y < 1){
			int xx = 1 - b.y;
			int xxx = p.y - xx;
			
			return xxx;
		}
		return p.y;
	}
	/**
	 * 如果当前行隐藏，返回合并行，否则返回原来的值
	 * @param p 单元格实际坐标
	 * @return
	 */
	public int rowAtPoint(Point p){
		List<Point> a = cells.get(p.x);
		Point b = a.get(p.y);
		// 行列有小于1的为隐藏单元格返回合并单元格坐标
		System.out.println(b);
		if (b.x < 1 || b.y < 1){
			int xx = 1 - b.x;
			int xxx = p.x - xx;
			
			return xxx;
		}
		return p.x;
	}
	/**
	 * 合并单元格
	 * @param startRow
	 * @param endRow
	 * @param startColumn
	 * @param endColumn
	 */
	public void combine(int startRow, int endRow, int startColumn, int endColumn){
		
		// 合并跨行跨列
		int sprow = endRow - startRow;
		int spcol = endColumn - startColumn;
		// 插入合并单元格偏移坐标相对于显示单元格
		for (int i = 0; i <= sprow; i++) {
			for (int j = 0; j <= spcol; j++) {
				// 要插入的坐标
				int x = 1 - i;
				int y = 1 - j;
				Point p = new Point(x, y);
				setGrid(i+startRow, j+startColumn, p);
			}
		}
		// 合并显示单元格坐标
		Point sp = new Point(endRow, endColumn);
		setGrid(startRow, startColumn, sp);
	}
	/**
	 * 表格状态坐标设置
	 * @param row
	 * @param column
	 * @param p
	 */
	public void setGrid(int row, int column, Point p){
		cells.get(row).set(column, p);
	}
	
	public static void main(String[] args) {
		CellDemo a = new CellDemo();
		a.initCell(8, 9);
		System.out.println(a.toString());
		System.out.println("=========");
		Point p = new Point(2, 2);
		System.out.println(a.rowAtPoint(p));
		System.out.println(a.columnAtPoint(p));
		
//		a.combine(2, 5, 2, 4);
		a.combine(1, 3, 1, 3);
		System.out.println(a.toString());
		
		p = new Point(1, 1);
		System.out.println(a.rowAtPoint(p));
		System.out.println(a.columnAtPoint(p));
	}
}
