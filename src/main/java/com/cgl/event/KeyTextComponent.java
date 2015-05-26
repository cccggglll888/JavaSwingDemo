package com.cgl.event;

import java.awt.AWTEventMulticaster;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class KeyTextComponent extends JComponent{
	private static final long serialVersionUID = 1L;
	
	private ActionListener actionListenerList = null;
	
	public KeyTextComponent(){
		setBackground(Color.CYAN);
		KeyListener internalKeyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (actionListenerList != null) {
					int keyCode = event.getKeyCode();
					String keyText = KeyEvent.getKeyText(keyCode);
					ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, keyText);
					actionListenerList.actionPerformed(actionEvent);
				}
			}
		};
		MouseListener listenerMouseListener = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				requestFocusInWindow();
			}
		};
		addKeyListener(internalKeyListener);
		addMouseListener(listenerMouseListener);
	}
	
	public void addActionListener(ActionListener actionListener) {
		actionListenerList = AWTEventMulticaster.add(actionListenerList, actionListener);
	}
	
	public void removeActionListener(ActionListener actionListener){
		actionListenerList = AWTEventMulticaster.remove(actionListenerList, actionListener);
	}
	@Override
	public boolean isFocusable(){
		return true;
	}
}
