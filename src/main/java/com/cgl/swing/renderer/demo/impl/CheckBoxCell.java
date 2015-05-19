package com.cgl.swing.renderer.demo.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import com.cgl.swing.renderer.demo.test.TableCellSupport;

public class CheckBoxCell extends TableCellSupport<JCheckBox> {
	public CheckBoxCell(JCheckBox cb) {
		super(cb);
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 被选中时需要触发编辑停止事件，一般直接调用父类的stopCellEditing即可，那儿已经负责了有效性检查，事件触发。
				stopCellEditing();
			}
		});
	}
	@Override
	protected void setValueTo(JCheckBox component, Object value) {
		// 认为value值是Boolean类型的，注意空值的处理
		component.setSelected(value == null ? false : ((Boolean) value)
				.booleanValue());
	}
	@Override
	protected Object getValueFrom(JCheckBox component) {
		// 返回当前选中状态的布尔值，用Boolean封装
		return new Boolean(component.isSelected());
	}
}