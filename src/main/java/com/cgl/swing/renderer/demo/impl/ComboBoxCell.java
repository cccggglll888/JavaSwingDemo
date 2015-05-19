package com.cgl.swing.renderer.demo.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import com.cgl.swing.renderer.demo.test.TableCellSupport;

public class ComboBoxCell extends TableCellSupport<JComboBox<String>> {
	public ComboBoxCell(JComboBox<String> cb) {
		super(cb);
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 被选中时需要触发编辑停止事件，一般直接调用父类的stopCellEditing即可，那儿已经负责了有效性检查，事件触发。
				stopCellEditing();
			}
		});
	}
	@Override
	protected void setValueTo(JComboBox<String> component, Object value) {
		// 认为value值是Boolean类型的，注意空值的处理
		component.setSelectedItem(value == null ? "true" : value);
		
	}
	@Override
	protected Object getValueFrom(JComboBox<String> component) {
		// 返回当前选中状态的布尔值，用Boolean封装
		return component.getSelectedItem();
	}
}