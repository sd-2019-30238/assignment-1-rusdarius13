package presentation;

import DAO.UserAccess;
import controller.LoginController;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateWindow extends JFrame {
    private JTextArea textArea;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JTextField textField_1;
    private UserAccess userAccess = new UserAccess();
    private LoginController loginController=new LoginController(userAccess);
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateWindow frame = new CreateWindow();
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
    public CreateWindow(int a) {
        try {
            CreateWindow frame = new CreateWindow();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public CreateWindow() {
        setTitle("Create an account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCreateAnAccount = new JLabel("Create an account");
        lblCreateAnAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblCreateAnAccount.setBounds(162, 30, 182, 14);
        contentPane.add(lblCreateAnAccount);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUser.setBounds(81, 81, 71, 14);
        contentPane.add(lblUser);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(81, 132, 71, 14);
        contentPane.add(lblPassword);

        JButton btnCreateAnAccount = new JButton("Create your account");
        btnCreateAnAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCreateAnAccount.setBounds(162, 313, 167, 23);
        btnCreateAnAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username= textField.getText();
                String password=passwordField.getText();
                String phone=textField_1.getText();
                String address=textArea.getText();
                loginController.addUser(username,password,phone,address);
                
            }
        });
        contentPane.add(btnCreateAnAccount);


        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(385, 327, 89, 23);
        contentPane.add(btnExit);

        textField = new JTextField();
        textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField.setBounds(162, 79, 182, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        passwordField.setBounds(162, 126, 182, 20);
        contentPane.add(passwordField);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPhone.setBounds(81, 178, 57, 14);
        contentPane.add(lblPhone);

        textField_1 = new JTextField();
        textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField_1.setBounds(162, 177, 182, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAddress.setBounds(81, 232, 57, 14);
        contentPane.add(lblAddress);

        textArea = new JTextArea();
        textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textArea.setRows(4);
        textArea.setBounds(162, 229, 182, 59);
        contentPane.add(textArea);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginWindow login = new LoginWindow(0);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(10, 329, 89, 23);
        contentPane.add(btnNewButton);
        
    }
}
