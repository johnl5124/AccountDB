import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	private static JFrame frmAccountApp;
	private JPanel LoginPanel;
	private JPanel AccountCreation;
	private JTextField username;
	private JTextField password;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField email;
	private JTextField usernameTF;
	private JTextField passwordTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		frmAccountApp = new JFrame();
		frmAccountApp.setResizable(false);
		frmAccountApp.setTitle("Account App");
		frmAccountApp.setBackground(Color.PINK);
		frmAccountApp.setBounds(100, 100, 800, 800);
		frmAccountApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccountApp.getContentPane().setLayout(null);
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					App window = new App();
					window.frmAccountApp.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() 
	{
		loginPanel();
		
		accountPanel();
	}

	public void loginPanel()
	{
		LoginPanel = new JPanel();
		LoginPanel.setBounds(0, 0, 794, 771);
		frmAccountApp.getContentPane().add(LoginPanel);
		LoginPanel.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setBounds(328, 11, 150, 39);
		LoginPanel.add(lblLoginPage);
		
		JLabel usernamelbl = new JLabel("Username: ");
		usernamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		usernamelbl.setBounds(226, 284, 76, 14);
		LoginPanel.add(usernamelbl);
		
		JLabel passwordlbl = new JLabel("Password:");
		passwordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlbl.setBounds(226, 321, 76, 14);
		LoginPanel.add(passwordlbl);
		
		username = new JTextField();
		username.setBounds(328, 283, 86, 20);
		LoginPanel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(328, 314, 86, 20);
		LoginPanel.add(password);
		password.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(283, 369, 89, 23);
		LoginPanel.add(btnEnter);
		
		JButton btnAccountCreation = new JButton("Account Creation");
		btnAccountCreation.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				LoginPanel.setVisible(false);
				AccountCreation.setVisible(true);
			}
		});
		btnAccountCreation.setBounds(271, 528, 177, 23);
		LoginPanel.add(btnAccountCreation);
	}
	
	public void accountPanel()
	{
		AccountCreation = new JPanel();
		AccountCreation.setBounds(0, 0, 794, 771);
		frmAccountApp.getContentPane().add(AccountCreation);
		AccountCreation.setLayout(null);
		
		JLabel title = new JLabel("Account Creation");
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(310, 11, 192, 35);
		AccountCreation.add(title);
		
		JLabel firstnamelbl = new JLabel("First name:");
		firstnamelbl.setBounds(275, 181, 64, 14);
		AccountCreation.add(firstnamelbl);
		
		JLabel lastnamelbl = new JLabel("Last name:");
		lastnamelbl.setBounds(268, 215, 76, 14);
		AccountCreation.add(lastnamelbl);
		
		JLabel emaillbl = new JLabel("Email: ");
		emaillbl.setBounds(279, 242, 46, 14);
		AccountCreation.add(emaillbl);
		
		JLabel usernamelbl = new JLabel("User name:");
		usernamelbl.setBounds(272, 272, 67, 14);
		AccountCreation.add(usernamelbl);
		
		JLabel passwordlbl = new JLabel("Password: ");
		passwordlbl.setBounds(278, 308, 59, 14);
		AccountCreation.add(passwordlbl);
		
		firstname = new JTextField();
		firstname.setBounds(363, 175, 86, 20);
		AccountCreation.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(364, 207, 86, 20);
		AccountCreation.add(lastname);
		lastname.setColumns(10);
		
		email = new JTextField();
		email.setBounds(364, 238, 86, 20);
		AccountCreation.add(email);
		email.setColumns(10);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(365, 268, 86, 20);
		AccountCreation.add(usernameTF);
		usernameTF.setColumns(10);
		
		passwordTF = new JTextField();
		passwordTF.setBounds(365, 302, 86, 20);
		AccountCreation.add(passwordTF);
		passwordTF.setColumns(10);
		
		JButton donebtn = new JButton("Enter");
		donebtn.setBounds(317, 366, 89, 23);
		AccountCreation.add(donebtn);
		
		JButton backbtn = new JButton("Back");
		backbtn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				AccountCreation.setVisible(false);
				LoginPanel.setVisible(true);
			}
		});
		backbtn.setBounds(10, 11, 89, 23);
		AccountCreation.add(backbtn);
		
		JButton btnConnectionTest = new JButton("Connection Test");
		btnConnectionTest.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				connect();
			}
		});
		btnConnectionTest.setBounds(661, 11, 123, 23);
		AccountCreation.add(btnConnectionTest);
	}
	private Connection connect() 
	{
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\John\\Desktop\\SQL DB\\Users.db";
        Connection conn = null;
        try 
        {
        	 System.out.println("Connection to SQLite has been established.");  
        	
            conn = DriverManager.getConnection(url);
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
