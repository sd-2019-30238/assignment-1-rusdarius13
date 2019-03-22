package abc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

public class SeachUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeachUser frame = new SeachUser();
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
	
	public SeachUser(int a) {
		try {
			SeachUser frame = new SeachUser();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public SeachUser() {
		setTitle("Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblType.setBounds(105, 91, 46, 23);
		contentPane.add(lblType);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSearch.setBounds(182, 151, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnBack.setBounds(236, 228, 89, 23);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(151, 93, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
