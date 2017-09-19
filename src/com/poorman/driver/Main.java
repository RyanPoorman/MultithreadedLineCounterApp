package com.poorman.driver;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Main {

	private JFrame frame;
	private JTextField tfDirectory;
	private JTextField tfSaveTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCountFrom = new JLabel("Directory to count:");
		lblCountFrom.setBounds(6, 11, 131, 16);
		frame.getContentPane().add(lblCountFrom);

		JButton btnDirectorySearch = new JButton("Search");
		btnDirectorySearch.setBounds(125, 6, 117, 29);
		frame.getContentPane().add(btnDirectorySearch);

		JLabel lblSaveResultsTo = new JLabel("Save results to:");
		lblSaveResultsTo.setBounds(6, 70, 101, 16);
		frame.getContentPane().add(lblSaveResultsTo);

		JButton btnSaveTo = new JButton("Search");
		btnSaveTo.setBounds(125, 65, 117, 29);
		frame.getContentPane().add(btnSaveTo);
		// btnSaveTo.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		//
		// }
		// });

		JLabel lblTimeToProcess = new JLabel("Time to process:");
		lblTimeToProcess.setBounds(6, 172, 117, 16);
		frame.getContentPane().add(lblTimeToProcess);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(6, 147, 236, 16);
		frame.getContentPane().add(progressBar);

		JButton btnCountLines = new JButton("Count Lines");
		btnCountLines.setBounds(27, 118, 178, 29);
		frame.getContentPane().add(btnCountLines);

		JLabel lblFilesCounted = new JLabel("Files counted:");
		lblFilesCounted.setBounds(6, 200, 101, 16);
		frame.getContentPane().add(lblFilesCounted);

		JLabel lblTotalLines = new JLabel("Total lines: ");
		lblTotalLines.setBounds(6, 228, 93, 16);
		frame.getContentPane().add(lblTotalLines);

		tfDirectory = new JTextField();
		tfDirectory.setBounds(6, 32, 235, 26);
		frame.getContentPane().add(tfDirectory);
		tfDirectory.setColumns(10);

		tfSaveTo = new JTextField();
		tfSaveTo.setColumns(10);
		tfSaveTo.setBounds(7, 90, 235, 26);
		frame.getContentPane().add(tfSaveTo);

		JLabel lblTimeResult = new JLabel("");
		lblTimeResult.setBounds(115, 172, 126, 16);
		frame.getContentPane().add(lblTimeResult);

		JLabel lblFilesResult = new JLabel("");
		lblFilesResult.setBounds(97, 200, 126, 16);
		frame.getContentPane().add(lblFilesResult);

		JLabel lblTotalResults = new JLabel("");
		lblTotalResults.setBounds(79, 228, 126, 16);
		frame.getContentPane().add(lblTotalResults);
	}
}
