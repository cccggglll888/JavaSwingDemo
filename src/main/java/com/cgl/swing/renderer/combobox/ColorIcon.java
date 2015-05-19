package com.cgl.swing.renderer.combobox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * 颜色图标
 * @author Administrator
 *
 */
public class ColorIcon implements Icon {
	static final int BOX = 10;
	private Color color ;
	public ColorIcon(Color c){
		this.color = c;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Color old = g.getColor();
		g.setColor(color);
		g.fillRect(x, y, BOX, BOX);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, BOX, BOX);
		g.setColor(old);
	}

	@Override
	public int getIconWidth() {
		return BOX;
	}

	@Override
	public int getIconHeight() {
		return BOX;
	}
	public static String getColorName(Color c) {
		
		return "颜色";
	}
	
}
