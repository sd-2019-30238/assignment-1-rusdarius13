package abc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Insert extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static Connection con;
	public static Statement st;
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
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
	public Insert(int a) {
		try {
			Insert frame = new Insert();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Insert() {
		setTitle("Insert Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPrice.setBounds(90, 124, 39, 37);
		contentPane.add(lblPrice);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(90, 73, 39, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblType.setBounds(90, 22, 39, 37);
		contentPane.add(lblType);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField.setBounds(139, 30, 195, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_1.setBounds(139, 81, 195, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_2.setBounds(139, 132, 195, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main(0);
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealsengineschema", "root", "admin");
					System.out.println("Driver Loaded!");
					ps = con.prepareStatement("Insert into dealengine (`ID`, `Name`, `Type`, `Price`) values (?, ?, ?, ?)");
					ps.setString(1, textField_3.getText());
					ps.setString(2, textField.getText());
					ps.setString(3, textField_1.getText());
					ps.setString(4, textField_2.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null, "Data saved succesfully!");
					ps.close();
					
					
				}catch(Exception ex) {
					System.out.println(ex.toString());
				}
			}
		});
		btnSave.setBounds(236, 227, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblId.setBounds(90, 185, 39, 14);
		contentPane.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(139, 183, 195, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
