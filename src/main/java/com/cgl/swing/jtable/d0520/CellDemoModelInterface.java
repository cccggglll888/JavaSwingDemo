package com.cgl.swing.jtable.d0520;

import java.awt.Point;

interface CellDemoModelInterface {
	/**
	 * 获取单元格所夸行列数
	 * @param row
	 * @param column
	 * @return
	 */
	public int[] span(int row, int column);
	/**
	 * 设置单元格所跨行列数
	 * @param span
	 * @param row
	 * @param column
	 */
	public void setSpan(int[] span, int row, int column);
	/**
	 * 单元格是否被覆盖，被哪个单元格覆盖
	 * @param row
	 * @param column
	 * @return
	 */
	public Point visibleCell(int row, int column);
	/**
	 * 合并单元格
	 * @param rows
	 * @param columns
	 */
	public void combine(int[] rows, int[] columns);
	/**
	 * 拆分单元格
	 * @param row
	 * @param column
	 */
	public void split(int row, int column);
}
