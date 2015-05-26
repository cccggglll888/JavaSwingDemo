package com.cgl.frame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

/**
 * 居中显示及默认字体修改
 * 
 * @author Administrator
 *
 */
public class FirstFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public FirstFrame() {

		// UIDefaults aa = UIManager.getDefaults();
		// for ( Entry<Object, Object> a : aa.entrySet()) {
		// System.out.println("key==="+a.getKey());
		// System.out.println("val==="+a.getValue());
		// }

		Font vFont = new Font("Dialog", Font.PLAIN, 50);
		UIManager.put("TabbedPane.font", vFont);
		UIManager.put("ProgressBar.font", vFont);
		UIManager.put("RadioButtonMenuItem.acceleratorFont", vFont);
		UIManager.put("CheckBoxMenuItem.acceleratorFont", vFont);
		UIManager.put("Slider.font", vFont);
		UIManager.put("ToggleButton.font", vFont);
		UIManager.put("CheckBox.font", vFont);
		UIManager.put("FormattedTextField.font", vFont);
		UIManager.put("List.font", vFont);
		UIManager.put("TextField.font", vFont);
		UIManager.put("OptionPane.font", vFont);
		UIManager.put("Menu.font", vFont);
		UIManager.put("EditorPane.font", vFont);
		UIManager.put("CheckBoxMenuItem.font", vFont);
		UIManager.put("TitledBorder.font", vFont);
		UIManager.put("Tree.font", vFont);
		UIManager.put("ToolTip.font", vFont);
		UIManager.put("TextArea.font", vFont);
		UIManager.put("ToolBar.font", vFont);
		UIManager.put("Viewport.font", vFont);
		UIManager.put("MenuBar.font", vFont);
		UIManager.put("Spinner.font", vFont);
		UIManager.put("ComboBox.font", vFont);
		UIManager.put("Label.font", vFont);
		UIManager.put("ColorChooser.font", vFont);
		UIManager.put("Button.font", vFont);
		UIManager.put("ScrollPane.font", vFont);
		UIManager.put("Menu.acceleratorFont", vFont);
		UIManager.put("InternalFrame.titleFont", vFont);
		UIManager.put("DesktopIcon.font", vFont);
		UIManager.put("MenuItem.acceleratorFont", vFont);
		UIManager.put("TableHeader.font", vFont);
		UIManager.put("TextPane.font", vFont);
		UIManager.put("PasswordField.font", vFont);
		UIManager.put("MenuItem.font", vFont);
		UIManager.put("RadioButtonMenuItem.font", vFont);
		UIManager.put("PopupMenu.font", vFont);
		UIManager.put("Panel.font", vFont);
		UIManager.put("Table.font", vFont);
		UIManager.put("RadioButton.font", vFont);

		// UIManager.put("ToolTip.font", vFont);
		// UIManager.put("Table.font", vFont);
		// UIManager.put("TableHeader.font", vFont);
		// UIManager.put("TextField.font", vFont);
		// UIManager.put("ComboBox.font", vFont);
		// UIManager.put("TextField.font", vFont);
		// UIManager.put("PasswordField.font", vFont);
		// UIManager.put("TextArea.font", vFont);
		// UIManager.put("TextPane.font", vFont);
		// UIManager.put("EditorPane.font", vFont);
		// UIManager.put("FormattedTextField.font", vFont);
		// UIManager.put("Button.font", vFont);
		// UIManager.put("CheckBox.font", vFont);
		// UIManager.put("RadioButton.font", vFont);
		// UIManager.put("ToggleButton.font", vFont);
		// UIManager.put("ProgressBar.font", vFont);
		// UIManager.put("DesktopIcon.font", vFont);
		// UIManager.put("TitledBorder.font", vFont);
		// UIManager.put("Label.font", vFont);
		// UIManager.put("List.font", vFont);
		// UIManager.put("TabbedPane.font", vFont);
		// UIManager.put("MenuBar.font", vFont);
		// UIManager.put("Menu.font", vFont);
		// UIManager.put("MenuItem.font", vFont);
		// UIManager.put("PopupMenu.font", vFont);
		// UIManager.put("CheckBoxMenuItem.font", vFont);
		// UIManager.put("RadioButtonMenuItem.font", vFont);
		// UIManager.put("Spinner.font", vFont);
		// UIManager.put("Tree.font", vFont);
		// UIManager.put("ToolBar.font", vFont);
		// UIManager.put("OptionPane.messageFont", vFont);
		// UIManager.put("OptionPane.buttonFont", vFont);

		UIDefaults aa = UIManager.getDefaults();
		for (Entry<Object, Object> a : aa.entrySet()) {
			System.out.println("key===" + a.getKey());
			System.out.println("val===" + a.getValue());
		}
	}

	public static void main(String[] args) {
		FirstFrame f = new FirstFrame();
		f.setTitle("aaaaa");
		f.setSize(500, 300);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b = new JButton("bbbbb");
		f.getContentPane().add(b);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		f.setPreferredSize(new Dimension(512, 300));
		int frameWidth = f.getPreferredSize().width;
		int frameHeight = f.getPreferredSize().height;
		f.setSize(frameWidth, frameHeight);
		f.setLocation((screenSize.width - frameWidth) / 2,
				(screenSize.height - frameHeight) / 2);

		f.setVisible(true);
	}

}
