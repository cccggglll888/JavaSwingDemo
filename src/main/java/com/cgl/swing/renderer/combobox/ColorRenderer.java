package com.cgl.swing.renderer.combobox;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 * 定义一个列表渲染器
 * @author Administrator
 *
 */
public class ColorRenderer extends BasicComboBoxRenderer {
	private static final long serialVersionUID = 1L;
	private JComboBox<Color> combo ;
	
	public ColorRenderer(JComboBox<Color> cb){
		this.combo = cb;
		setFont(this.combo.getFont());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		JLabel lbl = this;
		if (null != value) {
			Color c = (Color) value;
			lbl.setText(ColorIcon.getColorName(c));
			lbl.setIcon(new ColorIcon(c));
		}
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComboBox<Color> colorCombo = new JComboBox<Color>();
		ColorRenderer renderer = new ColorRenderer(colorCombo);
		colorCombo.setRenderer(renderer);
		colorCombo.addItem(Color.red);
		colorCombo.addItem(Color.blue);
		colorCombo.addItem(Color.yellow);
		f.getContentPane().add(colorCombo);
		f.pack();
		f.setVisible(true);
	}
}
