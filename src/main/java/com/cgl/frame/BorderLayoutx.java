package com.cgl.frame;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class BorderLayoutx {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 300);
		
		JPanel panel = new JPanel();
		JTextField jt1 = new JTextField("aaaaaaaaaa");
		JTextField jt2 = new JTextField("bbbbbbbbbb");
		JTextField jt3 = new JTextField("cccccccccc");
		
		panel.add(jt1);
		panel.add(jt2);
		panel.add(jt3);
		
		f.getContentPane().setLayout(new FlowLayout());
		f.getContentPane().add(panel);
		f.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{jt2, jt3, jt1}));
		
		//f.pack();
		//jt3.requestFocusInWindow();
		
//		Set forwardKeys = getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS);
//		Set newForwardKeys = new HashSet(forwardKeys);
//		newForwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
//		setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,newForwardKeys);
		
		f.setVisible(true);
		
//		f.addWindowFocusListener(new WindowAdapter() {
//			@Override
//			public void windowGainedFocus(WindowEvent e) {
//				super.windowGainedFocus(e);
//				jt3.requestFocusInWindow();
//			}
//		});
		
		
		SwingUtilities.invokeLater(new Runnable(){
		    public void run() {
		    	//底层调用JComponent.requestFocus();->Component.requestFocus();
		    	//->Component.requestFocusHelper(false, true);
		    	//jt2.grabFocus();
		    	//底层调用Component.requestFocus();->requestFocusHelper(false, true);
				//jt2.requestFocus();
				//底层调用requestFocusHelper(false, false);
		    	jt3.requestFocusInWindow();
		    }
		});
		
		
	}
}
