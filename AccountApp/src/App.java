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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

public class App {

	private static JFrame frmAccountApp;
	private JPanel LoginPanel;
	private JPanel AccountCreation;
	private JPanel AdminPanel;
	public JTextField username;
	public JTextField password;
	public JTextField firstname;
	public JTextField lastname;
	public JTextField email;
	public JTextField usernameTF;
	public JTextField passwordTF;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		frmAccountApp = new JFrame();
		frmAccountApp.setResizable(false);
		frmAccountApp.setTitle("Account App");
		frmAccountApp.setBackground(Color.PINK);
		frmAccountApp.setBounds(100, 100, 500, 500);
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
		
		adminPanel();
	}

	public void loginPanel()
	{
		LoginPanel = new JPanel();
		LoginPanel.setBounds(0, 0, 494, 471);
		frmAccountApp.getContentPane().add(LoginPanel);
		LoginPanel.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setBounds(145, 5, 175, 25);
		LoginPanel.add(lblLoginPage);
		
		JLabel usernamelbl = new JLabel("Username: ");
		usernamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		usernamelbl.setBounds(150, 195, 70, 15);
		LoginPanel.add(usernamelbl);
		
		JLabel passwordlbl = new JLabel("Password:");
		passwordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlbl.setBounds(150, 225, 70, 15);
		LoginPanel.add(passwordlbl);
		
		username = new JTextField();
		username.setBounds(225, 195, 86, 20);
		LoginPanel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(225, 225, 86, 20);
		LoginPanel.add(password);
		password.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(200, 300, 89, 23);
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
		btnAccountCreation.setBounds(355, 5, 135, 25);
		LoginPanel.add(btnAccountCreation);
		
		JButton btnAdminPage = new JButton("Admin Page");
		btnAdminPage.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				LoginPanel.setVisible(false);
				AccountCreation.setVisible(false);
				AdminPanel.setVisible(true);
			}
		});

		btnAdminPage.setBounds(5, 5, 110, 25);
		LoginPanel.add(btnAdminPage);
	}
	
	public void accountPanel()
	{
		AccountCreation = new JPanel();
		AccountCreation.setBounds(0, 0, 494, 471);
		frmAccountApp.getContentPane().add(AccountCreation);
		AccountCreation.setLayout(null);
		
		JLabel title = new JLabel("Account Creation");
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(145, 5, 175, 20);
		AccountCreation.add(title);
		
		JLabel firstnamelbl = new JLabel("First name:");
		firstnamelbl.setBounds(145, 144, 80, 15);
		AccountCreation.add(firstnamelbl);
		
		JLabel lastnamelbl = new JLabel("Last name:");
		lastnamelbl.setBounds(145, 169, 80, 15);
		AccountCreation.add(lastnamelbl);
		
		JLabel emaillbl = new JLabel("Email: ");
		emaillbl.setBounds(145, 194, 80, 15);
		AccountCreation.add(emaillbl);
		
		JLabel usernamelbl = new JLabel("User name:");
		usernamelbl.setBounds(145, 219, 80, 15);
		AccountCreation.add(usernamelbl);
		
		JLabel passwordlbl = new JLabel("Password: ");
		passwordlbl.setBounds(145, 244, 80, 15);
		AccountCreation.add(passwordlbl);
		
		firstname = new JTextField();
		firstname.setBounds(235, 141, 86, 20);
		AccountCreation.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(235, 166, 86, 20);
		AccountCreation.add(lastname);
		lastname.setColumns(10);
		
		email = new JTextField();
		email.setBounds(235, 191, 86, 20);
		AccountCreation.add(email);
		email.setColumns(10);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(235, 216, 86, 20);
		AccountCreation.add(usernameTF);
		usernameTF.setColumns(10);
		
		passwordTF = new JTextField();
		passwordTF.setBounds(235, 241, 86, 20);
		AccountCreation.add(passwordTF);
		passwordTF.setColumns(10);
		
		JButton donebtn = new JButton("Enter");
		donebtn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String name1 = firstname.getText();
				String name2 = lastname.getText();
				String emailinput = email.getText();
				String userinput = usernameTF.getText();
				String passwordinput = passwordTF.getText();
				
					
				if(firstname.equals(0) || name2.isEmpty() || emailinput.isEmpty() || userinput.isEmpty() || passwordinput.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter your details");
				}
				else
				{
					firstname.setText("");
					lastname.setText("");
					email.setText("");
					usernameTF.setText("");
					passwordTF.setText("");
					
					DBClass application = new DBClass();
					application.insert(name1, name2, emailinput, userinput, passwordinput);
					JOptionPane.showMessageDialog(null, "Details added successfully");
				}
			}
		});
		donebtn.setBounds(191, 287, 89, 23);
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
		backbtn.setBounds(10, 5, 89, 20);
		AccountCreation.add(backbtn);
		
		JButton btnConnectionTest = new JButton("Connection Test");
		btnConnectionTest.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				DBClass dbmethod = new DBClass();
				dbmethod.connectTest();
			}
		});
		btnConnectionTest.setBounds(350, 5, 135, 20);
		AccountCreation.add(btnConnectionTest);
	}
	
	public void adminPanel()
	{
		AdminPanel = new JPanel();
		AdminPanel.setBounds(0, 0, 494, 471);
		frmAccountApp.getContentPane().add(AdminPanel);
		AdminPanel.setLayout(null);
		
		JLabel lblAdminPage = new JLabel("Admin Page");
		lblAdminPage.setBounds(218, 11, 70, 15);
		AdminPanel.add(lblAdminPage);
		
		JButton backbtn = new JButton("Back");
		backbtn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				LoginPanel.setVisible(true);
				AdminPanel.setVisible(false);
			}
		});
		backbtn.setBounds(10, 5, 89, 20);
		AdminPanel.add(backbtn);
		
		String[] dbInfo = {"First Name", "Last Name", "Email", "Username", "Password"};
		
		JComboBox comboBox = new JComboBox(dbInfo);
		comboBox.setBounds(183, 116, 117, 20);
		AdminPanel.add(comboBox);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(121, 166, 249, 112);
		AdminPanel.add(editorPane);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				DBClass dbselect = new DBClass();
				dbselect.selectAll();
			}
		});
		btnFinish.setBounds(199, 321, 89, 23);
		AdminPanel.add(btnFinish);
		
		JButton btnResetDb = new JButton("Reset DB");
		btnResetDb.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				DBClass DBdelete = new DBClass();
				//DBdelete.ifEmpty();
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the database?");
				
				if(confirm == 0)
				{
					JOptionPane.showMessageDialog(null, "You have reset the DB");

					DBdelete.deleteAll();
				}
			}
		});
		btnResetDb.setBounds(10, 437, 89, 23);
		AdminPanel.add(btnResetDb);
		

	}
}
