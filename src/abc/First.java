package abc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class First extends JFrame {

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
					First frame = new First();
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
	public First() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Log in to your account");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblLogin.setBounds(147, 23, 198, 23);
		contentPane.add(lblLogin);
		
		JLabel lblUser = new JLabel("Username:");
		lblUser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUser.setBounds(92, 81, 60, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBounds(92, 132, 60, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField.setBounds(162, 78, 146, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCreateAnAccount = new JButton("Create an account");
		btnCreateAnAccount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCreateAnAccount.setBounds(150, 212, 146, 23);
		contentPane.add(btnCreateAnAccount);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLogin.setBounds(177, 172, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 130, 146, 20);
		contentPane.add(passwordField);
	}

}
