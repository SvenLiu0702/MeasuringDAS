package com.mdas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;

import com.mdas.MyColorUtils.MyColor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;

public class MainWindow {

	private static JFrame frame;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		JFrame.setDefaultLookAndFeelDecorated(true);
		
		installLnF();
//		try {
//            UIManager.setLookAndFeel(new SubstanceLookAndFeel());
////            SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
////          SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
////          SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
////          SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
////          SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
////            SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
////            SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitePainter());
//        } catch (Exception e) {
//            System.err.println("Something went wrong!");
//        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 798, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(MyColorUtils.getColor(MyColor.MAIN_DARK));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"a", "b", "c", "d", "e", "f"}));
		comboBox.setBounds(55, 134, 81, 21);
		comboBox.setBackground(MyColorUtils.getColor(MyColor.MAIN_GREY_PANEL));
		comboBox.setOpaque(true);
		comboBox.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		comboBox.setForeground(Color.WHITE);
		comboBox.setUI(new MyComboBoxUI());
		panel.add(comboBox);
	}
}
