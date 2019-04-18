package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.CartAccess;
import controller.CartController;
import controller.DealController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class UserWindow extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private String name, cantitate;
	private JButton btnAddToCart;
	private String username;
	
	public UserWindow(String username) {
		this.username = username;
		setTitle("User Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(537, 371, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnYourCart = new JButton("Your cart");
		btnYourCart.setBounds(462, 232, 103, 23);
		contentPane.add(btnYourCart);
		
		JLabel lblSelectTheProduct = new JLabel("Select the product and press Add to cart!");
		lblSelectTheProduct.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectTheProduct.setBounds(10, 11, 255, 14);
		contentPane.add(lblSelectTheProduct);
		
		JButton btnHistory = new JButton("History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderHistoryWindow historyWindow = new OrderHistoryWindow(username);
				historyWindow.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnHistory.setBounds(462, 128, 103, 23);
		contentPane.add(btnHistory);
		
		JLabel lblSortBy = new JLabel("Sort by:");
		lblSortBy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSortBy.setBounds(395, 12, 46, 14);
		contentPane.add(lblSortBy);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Type", "Name", "Price"}));
		comboBox.setBounds(445, 9, 69, 20);
		contentPane.add(comboBox);
		
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBounds(10, 36, 352, 306);
		contentPane.add(table);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				name=table.getValueAt(row, 0).toString();
				cantitate = table.getValueAt(row,2).toString();
				btnAddToCart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CartController cartController = new CartController();
						try {
							Boolean verificare = cartController.addCart(name, username);
							controller.Factory.DiscountMain.getDiscount(cantitate).applyDiscount(name);
							
							if (verificare==false)
								JOptionPane.showMessageDialog(frame, "Can't add this product!");
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.setBounds(462, 178, 103, 23);
		contentPane.add(btnAddToCart);
		
		JButton btnShowProducts = new JButton("Show products");
		btnShowProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DealController dealController = new DealController();
				ArrayList<String[]>rows= new ArrayList<String[]>();
				try {
					rows = dealController.showDeals("nume");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				DefaultTableModel tableModel = new DefaultTableModel();
				String[] col = {"name", "price", "discount", "type"};
				for(String s: col) {
					tableModel.addColumn(s);
				}
				for(String[] r: rows) {
					tableModel.addColumn(r);
				}
				
				table.setModel(tableModel);
				
			}
		});
		
		btnShowProducts.setBounds(462, 75, 103, 23);
		contentPane.add(btnShowProducts);
		
		JButton btnSor = new JButton("Sort");
		btnSor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DealController dealController = new DealController();
				ArrayList<String[]>rows= new ArrayList<String[]>();
				try {
					rows= dealController.showDeals(comboBox.getSelectedItem().toString());
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				DefaultTableModel tableModel = new DefaultTableModel();
				String[]col = {"name", "price", "discount", "type"};
				for(String s: col) {
					tableModel.addColumn(s);
				}
				for(String[] r: rows) {
					tableModel.addColumn(r);
				}
				
				table.setModel(tableModel);
			}
			
		});
		btnSor.setBounds(524, 8, 89, 23);
		contentPane.add(btnSor);
	}
}
