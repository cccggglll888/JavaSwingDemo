package com.cgl.swing.jrediobutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

/**
 * 右键浮动面板的单选菜单组件
 * @author Administrator
 */
public class JrediobuttonDemo {

	static boolean gender;

	public static void main(String[] args) {
		JFrame frame = new JFrame("单选");
		JPanel panel = new JPanel();

		final JPopupMenu pm = new JPopupMenu("gender");
		JRadioButtonMenuItem mrButton = new JRadioButtonMenuItem("男", gender);
		JRadioButtonMenuItem missButton = new JRadioButtonMenuItem("女", !gender);

		ButtonGroup color = new ButtonGroup();
		color.add(mrButton);
		color.add(missButton);

		pm.add(mrButton);
		pm.add(missButton);

		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					pm.show(null, e.getPoint().x, e.getPoint().y);
				}
			}

			// @Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					pm.show(null, e.getPoint().x, e.getPoint().y);
				}
			}
		});

		mrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = true;
			}
		});
		missButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = false;
			}
		});
		panel.add(pm);

		frame.add(panel);
		frame.pack();
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
