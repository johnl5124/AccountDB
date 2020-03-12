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

public class LoginPage {

	private JFrame frame;
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
					window.frame.setVisible(true);
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
		frame = new JFrame("Account Application");
		frame.setBounds(100, 100, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 728, 694);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnPaneltest = new JButton("PanelTest");
		btnPaneltest.setBounds(15, 16, 101, 29);
		panel.add(btnPaneltest);
		
		JButton account_creation_btn = new JButton("Account Creation");
		account_creation_btn.setBounds(254, 495, 196, 29);
		panel.add(account_creation_btn);
		
		JButton enter_btn = new JButton("Enter");
		enter_btn.setBounds(274, 327, 115, 29);
		panel.add(enter_btn);
		enter_btn.setEnabled(false);
		
		JLabel password_title = new JLabel("Password:");
		password_title.setBounds(153, 273, 90, 20);
		panel.add(password_title);
		
		JLabel username_title = new JLabel("Username:");
		username_title.setBounds(158, 221, 90, 20);
		panel.add(username_title);
		
		password = new JTextField();
		password.setBounds(257, 269, 146, 26);
		panel.add(password);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setColumns(10);
		
		JButton adminbtn = new JButton("Admin Mode");
		adminbtn.setBounds(568, 16, 145, 29);
		panel.add(adminbtn);
		adminbtn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				AdminPage AP = new AdminPage();
				AP.setVisible(true);
			}
		});
		
		JLabel title = new JLabel("Login");
		title.setBounds(291, 71, 69, 20);
		panel.add(title);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		user_name = new JTextField();
		user_name.setBounds(256, 218, 145, 25);
		panel.add(user_name);
		user_name.setHorizontalAlignment(SwingConstants.CENTER);
		user_name.setColumns(10);
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
		btnPaneltest.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				panel.setVisible(false);
				
				System.out.println("Hello world");
				
				paneltest pt = new paneltest();
				pt.setVisible(true);
				frame.add(pt);
			}
		});
	}
}
