import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

public class LoginPage {

	public JFrame myFrame;
	private JTextField user_name;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LoginPage window = new LoginPage();
					window.myFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		myFrame = new JFrame("Account Application");
		myFrame.setBounds(100, 100, 750, 750);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(null);
		myFrame.setLocationRelativeTo(null);
		
		JPanel toolbar = new JPanel();
		toolbar.setBounds(0, 0, 728, 49);
		myFrame.getContentPane().add(toolbar);
		toolbar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPaneltest = new JButton("PanelTest");
		toolbar.add(btnPaneltest);
		
		JButton account_creation_btn = new JButton("Account Creation");
		toolbar.add(account_creation_btn);
		
		JButton adminbtn = new JButton("Admin Mode");
		toolbar.add(adminbtn);
		adminbtn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				AdminPage AP = new AdminPage();
				AP.setVisible(true);
			}
		});
		
		JPanel maincontent = new JPanel();
		maincontent.setBounds(118, 137, 491, 411);
		myFrame.getContentPane().add(maincontent);
		
		JLabel title = new JLabel("Login");
		maincontent.add(title);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel username_title = new JLabel("Username:");
		maincontent.add(username_title);
		
		user_name = new JTextField();
		maincontent.add(user_name);
		user_name.setHorizontalAlignment(SwingConstants.CENTER);
		user_name.setColumns(10);
		
		JLabel password_title = new JLabel("Password:");
		maincontent.add(password_title);
		
		password = new JTextField();
		maincontent.add(password);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setColumns(10);
		
		JButton enter_btn = new JButton("Enter");
		maincontent.add(enter_btn);
		enter_btn.setEnabled(false);
		enter_btn.addMouseListener(new MouseAdapter() 
		{
			String name = user_name.getText();
			String pass = password.getText();
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{	
				if (name.isEmpty() || pass.isEmpty())
				{
					enter_btn.setEnabled(false);
				}
				else
				{
					enter_btn.setEnabled(true);
				}
			}
		});
		account_creation_btn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				AccountCreation ac = new AccountCreation();
				ac.setVisible(true);
			}
		});
	}
}
