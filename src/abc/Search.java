package abc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
					Search frame = new Search();
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
	public Search(int a) {
		try {
			Search frame = new Search();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Search() {
		setTitle("Search Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblId.setBounds(100, 107, 27, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(165, 105, 174, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main(0);
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnSave = new JButton("Search");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealsengineschema", "root", "admin");
					System.out.println("Driver Loaded!");
					st = con.createStatement();
					String query = "select * from dealengine ID=" + textField.getText();
					rs = st.executeQuery(query);
					while(rs.next()) {
						JOptionPane.showMessageDialog(null, "ID:"+ rs.getString(1)+ "\n" + "Name:" + rs.getString(2) + "\n" + "Type:" + rs.getString(3) + "\n" + "Price:" + rs.getString(4)+"\n");
					}
					

					
					
					
				}catch(Exception ex) {
					System.out.println(ex.toString());
				}
			}
		});
		btnSave.setBounds(236, 227, 89, 23);
		contentPane.add(btnSave);
	}

}
