package presentation;


import DAO.StaffAccess;
import DAO.UserAccess;
import controller.LoginController;
import controller.LoginControllerS;
import model.Staff;
import model.User;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
	
	private JPasswordField passwordField;
    private JPanel contentPane;
    private JTextField textField;
    private UserAccess userAccess=new UserAccess();
    private LoginController loginController=new LoginController(userAccess);
    private StaffAccess staffAccess = new StaffAccess();
    private LoginControllerS loginControllerS=new LoginControllerS(staffAccess);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginWindow frame = new LoginWindow();
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
    public LoginWindow(int a) {
    	try {
            LoginWindow frame = new LoginWindow();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public LoginWindow() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblLogin.setBounds(201, 54, 79, 25);
        contentPane.add(lblLogin);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setBounds(87, 121, 79, 14);
        contentPane.add(lblUsername);

        textField = new JTextField();
        textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textField.setBounds(177, 120, 167, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword.setBounds(87, 170, 79, 14);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        passwordField.setBounds(177, 169, 167, 20);
        contentPane.add(passwordField);
        passwordField.setColumns(10);

        JButton btnLoginAsStaff = new JButton("Login as Staff");
        btnLoginAsStaff.setBounds(164, 267, 145, 23);
        contentPane.add(btnLoginAsStaff);
        btnLoginAsStaff.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String username = textField.getText().toString();
        		String password = passwordField.getText().toString();
        		Staff staff = loginControllerS.login(username, password);
        		StaffWindow staffWindow = new StaffWindow(textField.getText());
        	}
        });

        JButton btnNewButton = new JButton("Login as User");
        btnNewButton.setBounds(164, 233, 145, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username=textField.getText().toString();
                String password=passwordField.getText().toString();
                User user=loginController.login(username,password);
                if(user!=null)
                    System.out.println("M-am logat");
                else
                    System.out.println("Nu m-am logat!");
                UserWindow userWindow = new UserWindow(textField.getText());
                }

        });

        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(385, 327, 89, 23);
        contentPane.add(btnExit);

        JButton btnNewButton_1 = new JButton("Create an account");
        btnNewButton_1.setBounds(164, 301, 145, 23);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CreateWindow create = new CreateWindow(0);
        	}
        });
    }
}
