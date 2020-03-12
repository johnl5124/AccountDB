import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPage {

	private JFrame frame;
	private JTextField user_name;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame("Login Page");
		frame.setBounds(100, 100, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Login");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(304, 117, 69, 20);
		frame.getContentPane().add(title);
		
		user_name = new JTextField();
		user_name.setBounds(270, 152, 146, 26);
		frame.getContentPane().add(user_name);
		user_name.setColumns(10);
		
		password = new JTextField();
		password.setBounds(270, 207, 146, 26);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel username_title = new JLabel("Username:");
		username_title.setBounds(177, 155, 90, 20);
		frame.getContentPane().add(username_title);
		
		JLabel password_title = new JLabel("Password:");
		password_title.setBounds(177, 210, 90, 20);
		frame.getContentPane().add(password_title);
		
		JButton enter_btn = new JButton("Enter");
		enter_btn.addMouseListener(new MouseAdapter() 
		{
			String name = user_name.toString();
			String pass = password.toString();
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				System.out.println("Error to console");
				if (name.isEmpty())
				{
					System.out.println("Error to console");
					JOptionPane.showMessageDialog(frame, "Error");
				}
				else if (pass.isEmpty())
				{
					System.out.println("Error to console");
					JOptionPane.showMessageDialog(frame, "Error");
				}				
			}
		});
		enter_btn.setBounds(280, 256, 115, 29);
		frame.getContentPane().add(enter_btn);
		
		JButton account_creation_btn = new JButton("Account Creation");
		account_creation_btn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				AccountCreation ac = new AccountCreation();
				
			}
		});
		account_creation_btn.setBounds(241, 356, 196, 29);
		frame.getContentPane().add(account_creation_btn);
		
		user_name = new JTextField();
		user_name.setBounds(271, 152, 146, 26);
		frame.getContentPane().add(user_name);
		user_name.setColumns(10);
		
		password = new JTextField();
		password.setBounds(271, 207, 146, 26);
		frame.getContentPane().add(password);
		password.setColumns(10);
	}
}
