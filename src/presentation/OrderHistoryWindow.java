package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.OrderController;

public class OrderHistoryWindow extends JFrame {
	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private String username;
	
	public OrderHistoryWindow(String username) {
		this.username = username;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Order History");
		
		getContentPane().setPreferredSize(new Dimension(450, 300));
		getContentPane().setLayout(null);
		
		JLabel lblComenziInCurs = new JLabel("Comenzi in curs de livrare:");
		lblComenziInCurs.setBounds(45,11,200,14);
		getContentPane().add(lblComenziInCurs);
		
		JLabel lblComenziLivrate = new JLabel("Comenzi livrate:");
		lblComenziLivrate.setBounds(45, 219, 157, 14);
		getContentPane().add(lblComenziLivrate);
		
		table = new JTable();
		table.setBounds(45, 40, 272, 168);
		getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(45, 244, 272, 168);
		getContentPane().add(table_1);
		
		JButton btnAfisare = new JButton("Show");
		btnAfisare.setBounds(410,46, 123, 23);
		getContentPane().add(btnAfisare);
		btnAfisare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderController orderController = new OrderController();
				ArrayList<String[]> rows = new ArrayList <String[]>();
				try {
					rows= orderController.getAllNotDeliveredOrders(username);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				DefaultTableModel tableModel = new DefaultTableModel();
				String[] col = {"ClientName", "Total"};
				for(String s:col) {
					tableModel.addColumn(s);
				}
				tableModel.addRow(col);
				for(String[] r:rows) {
					tableModel.addRow(r);
				}
				table.setModel(tableModel);
			}
		});
		
		JButton btnAfisareLivrate = new JButton("Show Delivered");
		btnAfisareLivrate.setBounds(410,272, 123,23);
		getContentPane().add(btnAfisareLivrate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(522, 425, 89, 23);
		getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	UserWindow userWind = new UserWindow(username);
	            }
	        });
		
		
		btnAfisare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderController orderController = new OrderController();
				ArrayList<String[]> rows = new ArrayList <String[]>();
				try {
					rows= orderController.getAllDeliveredOrders(username);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				DefaultTableModel tableModel = new DefaultTableModel();
				String[] col = {"ClientName", "Total"};
				for(String s:col) {
					tableModel.addColumn(s);
				}
				tableModel.addRow(col);
				for(String[] r:rows) {
					tableModel.addRow(r);
				}
				table.setModel(tableModel);
			}
		});
		
	}

}
