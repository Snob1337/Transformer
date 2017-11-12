package com.marc.excelTransformer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton jbtnStart = new JButton();
	JButton jbtnChooseSourceFolder = new JButton();
	JButton jbtnChooseTargetFolder = new JButton();
	JDialog dialogChooser = new JDialog(this, "Choose", false);

	JFileChooser chooser;
	JTextField jtextFieldsource = new JTextField(10);
	JTextField jtextFieldtarget = new JTextField(10);

	public void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(/* 3 */ 0, 2, 6, 3));

		/*
		 * Label Source
		 */
		JLabel lblPathSourceFolder = new JLabel("Ordner-Pfad(Quelle)");
		getContentPane().add(lblPathSourceFolder);
		getContentPane().add(jbtnChooseSourceFolder);
		getContentPane().add(jtextFieldsource);
	

				

	JLabel lblPathTargetFolder = new JLabel("Ordner-Pfad(Ziel)");


		// chooser = new JFileChooser();
		// chooser.setCurrentDirectory(new java.io.File("."));
		// chooser.setDialogTitle("asdasdasd");
		// chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// getContentPane().add(chooser);
		// jtextFieldsource.setEditable(true);
		//// jtextFieldsource.setSize(new Dimension(100,50));
		// getContentPane().add(jtextFieldsource);

		/*
		 * Label Target
		 */

		/*
		 * Button start converting
		 */
		jbtnStart.setText("Umwandlung starten");
		getContentPane().add(jbtnStart);

		jbtnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Starten der Umwandlung -> Pfad: " + chooser.getCurrentDirectory());

			}
		});

		pack();
	}
}
