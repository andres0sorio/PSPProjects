package uniandes.ecos.psp.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LocCounter {

	private JFrame frame;
	private JTextField txtEnterHereThe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocCounter window = new LocCounter();
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
	public LocCounter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtEnterHereThe = new JTextField();
		txtEnterHereThe.setText("Enter here the directory");
		txtEnterHereThe.setBounds(66, 57, 287, 20);
		frame.getContentPane().add(txtEnterHereThe);
		txtEnterHereThe.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(172, 119, 89, 23);
		frame.getContentPane().add(btnOk);
	}
}
