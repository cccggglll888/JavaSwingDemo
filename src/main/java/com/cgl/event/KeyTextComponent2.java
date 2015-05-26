package com.cgl.event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.JComponent;
import javax.swing.event.EventListenerList;

public class KeyTextComponent2 extends JComponent{
	private static final long serialVersionUID = 1L;
	
	public EventListenerList actionliListenerList = new EventListenerList();
	
	public KeyTextComponent2(){
		setBackground(Color.CYAN);
		KeyListener internalKeyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (actionliListenerList != null) {
					int keyCode = event.getKeyCode();
					String keyText = KeyEvent.getKeyText(keyCode);
					ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, keyText);
					fireActionPerformed(actionEvent);
				}
			}
		};
		
		MouseListener internalMouseListener = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				requestFocusInWindow();
			}
		};
		addKeyListener(internalKeyListener);
		addMouseListener(internalMouseListener);
	}
	
	public void addActionListener(ActionListener actionlListener) {
		actionliListenerList.add(ActionListener.class, actionlListener);
	}
	
	public void removeActionListener(ActionListener actionListener){
		actionliListenerList.remove(ActionListener.class, actionListener);
	}
	
	public void fireActionPerformed(ActionEvent event) {
		EventListener[] listenerList = actionliListenerList.getListeners(ActionListener.class);
		for (int i = 0, n = listenerList.length; i < n; i++) {
			((ActionListener)listenerList[i]).actionPerformed(event);
		}
	}
	
	@Override
	public boolean isFocusable() {
		return true;
	}

}
