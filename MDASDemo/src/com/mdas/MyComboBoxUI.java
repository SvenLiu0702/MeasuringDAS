package com.mdas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;

import com.mdas.MyColorUtils.MyColor;

public class MyComboBoxUI extends BasicComboBoxUI {
	@Override
	protected JButton createArrowButton() {
//		JButton button = super.createArrowButton();
//		ImageIcon ico=new ImageIcon("ico/77.png");
//		ico.setImage(ico.getImage().getScaledInstance(22,22,Image.SCALE_DEFAULT));
//		button.setIcon(ico);
		JButton button = new MyBasicArrowButton(BasicArrowButton.SOUTH);
		button.setBorder(null);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		return button;
	}
	@Override
	protected ComboPopup createPopup() {
		// TODO Auto-generated method stub
		return new MyBasicComboPopup( comboBox );
	}
	
	@Override
	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
        ListCellRenderer renderer = comboBox.getRenderer();
        Component c;

        if ( hasFocus && !isPopupVisible(comboBox) ) {
            c = renderer.getListCellRendererComponent( listBox,
                                                       comboBox.getSelectedItem(),
                                                       -1,
                                                       true,
                                                       false );
        }
        else {
            c = renderer.getListCellRendererComponent( listBox,
                                                       comboBox.getSelectedItem(),
                                                       -1,
                                                       false,
                                                       false );
            c.setBackground(UIManager.getColor("ComboBox.background"));
        }
        c.setFont(comboBox.getFont());
        if ( hasFocus && !isPopupVisible(comboBox) ) {
            c.setForeground(listBox.getForeground());
            c.setBackground(listBox.getBackground());
        }
        else {
            if ( comboBox.isEnabled() ) {
                c.setForeground(comboBox.getForeground());
                c.setBackground(comboBox.getBackground());
            }
            else {
                c.setForeground(MyColorUtils.getColor(MyColor.MAIN_DISABLE_FOR));
                c.setBackground(MyColorUtils.getColor(MyColor.MAIN_DISABLE_GROUND));
            }
        }

        // Fix for 4238829: should lay out the JPanel.
        boolean shouldValidate = false;
        if (c instanceof JPanel)  {
            shouldValidate = true;
        }

        int x = bounds.x, y = bounds.y, w = bounds.width, h = bounds.height;
        if (padding != null) {
            x = bounds.x + padding.left;
            y = bounds.y + padding.top;
            w = bounds.width - (padding.left + padding.right);
            h = bounds.height - (padding.top + padding.bottom);
        }

        currentValuePane.paintComponent(g,c,comboBox,x,y,w,h,shouldValidate);
    }
	
	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds,
			boolean hasFocus) {
        Color t = g.getColor();
        if ( comboBox.isEnabled() )
            g.setColor(comboBox.getBackground());
        else
            g.setColor(MyColorUtils.getColor(MyColor.MAIN_DISABLE_GROUND));
        g.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
        g.setColor(t);
    }
}
