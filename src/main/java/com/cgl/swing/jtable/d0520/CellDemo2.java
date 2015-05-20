package com.cgl.swing.jtable.d0520;

import java.awt.Point;
import java.util.List;
import java.util.Vector;

public class CellDemo2 {
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
	 * 合并单元格-通过起始坐标与结束坐标
	 * @param startRow
	 * @param endRow
	 * @param startColumn
	 * @param endColumn
	 */
	public void combine(int startRow, int endRow, int startColumn, int endColumn){
		// 合并跨行跨列
		int sprow = endRow - startRow + 1;
		int spcol = endColumn - startColumn + 1;
		
		setSpan(new int[]{sprow,spcol}, startRow, startColumn);
	}
	/**
	 * 设置单元格所跨行列-通过合并单元格范围与合并单元格坐标
	 * @param span 设置范围
	 * @param row 设置行坐标
	 * @param column 设置列坐标
	 */
	public void setSpan(int[] span, int row, int column) {
		// 插入合并单元格偏移坐标相对于显示单元格
		for (int i = 0; i < span[0]; i++) {
			for (int j = 0; j < span[1]; j++) {
				// 要插入的坐标
				int x = 1 - i;
				int y = 1 - j;
				Point p = new Point(x, y);
				setGrid(i + row, j + column, p);
			}
		}
		Point sp = new Point(span[0], span[1]);
		setGrid(row, column, sp);
	}
	public int[] span(int row, int column) {
		// 获取输入坐标的状态
		Point gp = cells.get(row).get(column);
		
		// 行列有小于1的为隐藏单元格返回合并单元格坐标
		if (gp.x < 1 || gp.y < 1){
			int tx = 1 - gp.x;
			int x = row - tx;
			
			int ty = 1 - gp.y;
			int y = column - ty;
			
			Point sp = cells.get(x).get(y);
			
			return new int[]{sp.x, sp.y};
		// 如果是合并单元格显示单元格
		}else if (gp.x > 1 || gp.y > 1) {
			return new int[]{gp.x, gp.y};
		}
		return new int[]{1, 1};
		
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
		CellDemo2 a = new CellDemo2();
		a.initCell(8, 9);
		System.out.println(a.toString());
		System.out.println("=========");
		Point p = new Point(2, 2);
		System.out.println(a.rowAtPoint(p));
		System.out.println(a.columnAtPoint(p));
		
		a.combine(2, 5, 2, 4);
//		a.combine(1, 3, 1, 3);
//		a.setSpan(new int[]{4,3}, 3, 3);
		System.out.println(a.toString());
		
		p = new Point(2, 3);
		System.out.println(a.rowAtPoint(p));
		System.out.println(a.columnAtPoint(p));
		System.out.println(a.span(3, 3)[0]+","+a.span(3, 3)[1]);
	}
}
