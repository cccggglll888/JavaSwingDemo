package com.cgl.swing.renderer.demo.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.cgl.swing.renderer.demo.test.TableCellSupport;

public class TextFieldCell extends TableCellSupport<JTextField> {
	public TextFieldCell(JTextField cb) {
		super(cb);
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 被选中时需要触发编辑停止事件，一般直接调用父类的stopCellEditing即可，那儿已经负责了有效性检查，事件触发。
				stopCellEditing();
			}
		});
	}

	@Override
	protected void setValueTo(JTextField component, Object value) {
		// 认为value值是Boolean类型的，注意空值的处理
		component.setText((String) value);
	}

	@Override
	protected Object getValueFrom(JTextField component) {
		// 返回当前选中状态的布尔值，用Boolean封装
		return component.getText();
	}

}
