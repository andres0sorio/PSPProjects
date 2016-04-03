/** Copyright or License
 *
 */

package uniandes.ecos.psp.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

import uniandes.ecos.psp.FileChaser;
import uniandes.ecos.psp.JavaCodeAnalyzer;

/**
 * Package: ecos.uniandes.psp.interfaz
 *
 * Class: InterfazLocCounter InterfazLocCounter.java
 * 
 * Original Author: @author AOSORIO
 * 
 * Description: [one line class summary]
 * 
 * Implementation: [Notes on implementation]
 *
 * Created: Apr 3, 2016 1:18:21 AM
 * 
 */
public class InterfazLocCounter {

	private JFrame frmLocCounter;
	private JTextField txtPath;
	static final String OUTPUT_FILE = "D:\\Users\\AOSORIO\\Desktop\\LOCcounter-Output.txt";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazLocCounter window = new InterfazLocCounter();
					window.frmLocCounter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazLocCounter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLocCounter = new JFrame();
		frmLocCounter.setTitle("LOC Counter");
		frmLocCounter.setBounds(100, 100, 450, 169);
		frmLocCounter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLocCounter.getContentPane().setLayout(null);

		txtPath = new JTextField();
		txtPath.setText("Path");
		txtPath.setBounds(61, 60, 315, 23);
		frmLocCounter.getContentPane().add(txtPath);
		txtPath.setColumns(10);

		JButton btnNewButton = new JButton("Get LOC");
		btnNewButton.setBounds(172, 94, 89, 23);
		frmLocCounter.getContentPane().add(btnNewButton);

		JLabel lblLocCounter = new JLabel("LOC Counter");
		lblLocCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocCounter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocCounter.setBounds(61, 11, 315, 38);
		frmLocCounter.getContentPane().add(lblLocCounter);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String textFieldValue = txtPath.getText();
				executeLocCounter(textFieldValue,OUTPUT_FILE);
				JOptionPane.showMessageDialog(frmLocCounter, "Results saved to desktop.");
			}
		});

	}

	public void executeLocCounter(String path, String output) {

		FileChaser finder = new FileChaser(path);

		try {

			finder.processRoot();
			ArrayList<String> java_files = finder.getAllFiles();
			JavaCodeAnalyzer analyzer = new JavaCodeAnalyzer(java_files);
			analyzer.beginJob();
			analyzer.analyze();
			analyzer.endJob();
			analyzer.saveResults(output);
			
		} catch (NullPointerException e) {

			System.out.println("You have a nullpointer exception! please check");
			System.exit(1);

		}

	}

}
