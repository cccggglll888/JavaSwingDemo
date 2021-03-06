package com.cgl.swing.jtable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JViewport;
import javax.swing.KeyStroke;

public class MoveViewSample {

	public static final int INCREASE = 0; // direction
	public static final int DECREASE = 1; // direction
	public static final int X_AXIS = 0; // axis
	public static final int Y_AXIS = 1; // axis
	public static final int UNIT = 0; // type
	public static final int BLOCK = 1; // type

	static class MoveAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		JViewport viewport;
		int direction;
		int axis;
		int type;

		public MoveAction(JViewport viewport, int direction, int axis, int type) {
			if (viewport == null) {
				throw new IllegalArgumentException(
						"null viewport not permitted");
			}
			this.viewport = viewport;
			this.direction = direction;
			this.axis = axis;
			this.type = type;
		}

		public void actionPerformed(ActionEvent event) {
			Dimension extentSize = viewport.getExtentSize();
			int horizontalMoveSize = 0;
			int verticalMoveSize = 0;
			if (axis == X_AXIS) {
				if (type == UNIT) {
					horizontalMoveSize = 1;
				} else {
					// type == BLOCK
					horizontalMoveSize = extentSize.width;
				}
			} else {
				// axis == Y_AXIS
				if (type == UNIT) {
					verticalMoveSize = 1;
				} else {
					// type = BLOCK
					verticalMoveSize = extentSize.height;
				}
			}
			if (direction == DECREASE) {
				horizontalMoveSize = -horizontalMoveSize;
				verticalMoveSize = -verticalMoveSize;
			}
			// translate origin by some amount
			Point origin = viewport.getViewPosition();
			origin.x += horizontalMoveSize;
			origin.y += verticalMoveSize;
			// set new viewing origin
			viewport.setViewPosition(origin);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable runner = new Runnable() {
			public void run() {
				JFrame frame = new JFrame("JViewport Sample");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Icon icon = new ImageIcon(getClass().getResource("/com/cgl/swing/jtable/loading.gif"));
				JLabel dogLabel = new JLabel(icon);
				JViewport viewport = new JViewport();
				viewport.setView(dogLabel);

				InputMap inputMap = viewport.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
				ActionMap actionMap = viewport.getActionMap();

				// up key moves view up unit
				Action upKeyAction = new MoveAction(viewport, DECREASE, Y_AXIS, UNIT);
				KeyStroke upKey = KeyStroke.getKeyStroke("UP");
				inputMap.put(upKey, "up");
				actionMap.put("up", upKeyAction);

				// down key moves view down unit
				Action downKeyAction = new MoveAction(viewport, INCREASE, Y_AXIS, UNIT);
				KeyStroke downKey = KeyStroke.getKeyStroke("DOWN");
				inputMap.put(downKey, "down");
				actionMap.put("down", downKeyAction);

				// left key moves view left unit
				Action leftKeyAction = new MoveAction(viewport, DECREASE, X_AXIS, UNIT);
				KeyStroke leftKey = KeyStroke.getKeyStroke("LEFT");
				inputMap.put(leftKey, "left");
				actionMap.put("left", leftKeyAction);

				// right key mvoes view right unit
				Action rightKeyAction = new MoveAction(viewport, INCREASE, X_AXIS, UNIT);
				KeyStroke rightKey = KeyStroke.getKeyStroke("RIGHT");
				inputMap.put(rightKey, "right");
				actionMap.put("right", rightKeyAction);

				// pgup key moves view up block
				Action pgUpKeyAction = new MoveAction(viewport, DECREASE, Y_AXIS, BLOCK);
				KeyStroke pgUpKey = KeyStroke.getKeyStroke("PAGE_UP");
				inputMap.put(pgUpKey, "pgUp");
				actionMap.put("pgUp", pgUpKeyAction);

				// pgdn key moves view down block
				Action pgDnKeyAction = new MoveAction(viewport, INCREASE, Y_AXIS, BLOCK);
				KeyStroke pgDnKey = KeyStroke.getKeyStroke("PAGE_DOWN");
				inputMap.put(pgDnKey, "pgDn");
				actionMap.put("pgDn", pgDnKeyAction);

				// shift-pgup key moves view left block
				Action shiftPgUpKeyAction = new MoveAction(viewport, DECREASE, X_AXIS, BLOCK);
				KeyStroke shiftPgUpKey = KeyStroke.getKeyStroke("shift PAGE_UP");
				inputMap.put(shiftPgUpKey, "shiftPgUp");
				actionMap.put("shiftPgUp", shiftPgUpKeyAction);

				// shift-pgdn key moves view right block
				Action shiftPgDnKeyAction = new MoveAction(viewport, INCREASE, X_AXIS, BLOCK);
				KeyStroke shiftPgDnKey = KeyStroke.getKeyStroke("shift PAGE_DOWN");
				inputMap.put(shiftPgDnKey, "shiftPgDn");
				actionMap.put("shiftPgDn", shiftPgDnKeyAction);

				frame.add(viewport, BorderLayout.CENTER);
				frame.setSize(300, 200);
				frame.setVisible(true);
			}
		};
		EventQueue.invokeLater(runner);
	}

}