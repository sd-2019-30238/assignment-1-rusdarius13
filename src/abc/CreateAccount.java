package abc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	 public CreateAccount(int a) {
		 try {
				CreateAccount frame = new CreateAccount();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
	public CreateAccount() {
		setTitle("Create an account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAnAccount = new JLabel("Create an account");
		lblCreateAnAccount.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCreateAnAccount.setBounds(147, 25, 154, 14);
		contentPane.add(lblCreateAnAccount);
		
		JLabel lblUser = new JLabel("Username:");
		lblUser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUser.setBounds(92, 81, 60, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBounds(92, 132, 60, 14);
		contentPane.add(lblPassword);
		
		JButton btnCreateAnAccount = new JButton("Create");
		btnCreateAnAccount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCreateAnAccount.setBounds(155, 187, 146, 23);
		contentPane.add(btnCreateAnAccount);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
		
		textField = new JTextField();
		textField.setBounds(162, 79, 146, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passwordField.setBounds(162, 130, 146, 20);
		contentPane.add(passwordField);
	}
}
