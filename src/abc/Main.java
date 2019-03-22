package abc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main(int a) {
		try {
			Main frame = new Main();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Main() {
		setTitle("Furniture deal search engine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFurnitureDealSearch = new JLabel("Furniture deal search engine");
		lblFurnitureDealSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFurnitureDealSearch.setBounds(108, 25, 219, 22);
		contentPane.add(lblFurnitureDealSearch);
		
		JButton btnNewButton = new JButton("Insert Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert ins = new Insert(0); 
			}
		});
		btnNewButton.setBounds(31, 98, 106, 23);
		contentPane.add(btnNewButton);
		
		JButton btnUpdateData = new JButton("Update Data");
		btnUpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Update up = new Update(0);
			}
		});
		btnUpdateData.setBounds(161, 98, 106, 23);
		contentPane.add(btnUpdateData);
		
		JButton btnNewButton_1 = new JButton("Delete Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete del = new Delete(0);
			}
		});
		btnNewButton_1.setBounds(297, 98, 106, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search Data");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search se = new Search(0);
			}
		});
		btnNewButton_2.setBounds(31, 158, 106, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Data");
		btnNewButton_3.setBounds(161, 158, 106, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
	}
}
