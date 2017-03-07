package com.mdas;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private static JFrame frame;
	private JTextField textField;
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
	
	private void switchLnF(String LnF){	
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(LnF);
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Cannot install " + LnF
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
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(69, 60, 162, 26);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(320, 73, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(55, 134, 81, 21);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchLnF("com.jtattoo.plaf.noire.NoireLookAndFeel");
			}
		});
		btnNewButton.setBounds(213, 133, 93, 23);
		panel.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(421, 133, 121, 23);
		panel.add(rdbtnNewRadioButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(200, 20, 280, 21);
		panel.add(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setBounds(140, 233, 135, 22);
		panel.add(mntmNewMenuItem);
	}
}
