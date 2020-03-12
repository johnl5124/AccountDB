import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountCreation {

	private JFrame frame;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField emailadd;
	private JTextField password1;
	private JTextField username;

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
					AccountCreation window = new AccountCreation();
					window.frame.setVisible(true);
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
	public AccountCreation() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{	
		frame = new JFrame("Account Creation");
		frame.setBounds(100, 100, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnConnectionToDatabase = new JButton("Connection to database");
		btnConnectionToDatabase.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				connect();
			}
		});
		btnConnectionToDatabase.setBounds(15, 16, 232, 29);
		frame.getContentPane().add(btnConnectionToDatabase);
		
		//USER INFORMATION
		firstname = new JTextField();
		firstname.setBounds(322, 165, 146, 26);
		frame.getContentPane().add(firstname);
		firstname.setColumns(10);
		lastname = new JTextField();
		lastname.setBounds(322, 207, 146, 26);
		frame.getContentPane().add(lastname);
		lastname.setColumns(10);
		emailadd = new JTextField();
		emailadd.setBounds(322, 249, 146, 26);
		frame.getContentPane().add(emailadd);
		emailadd.setColumns(10);
		password1 = new JTextField();
		password1.setBounds(322, 333, 146, 26);
		frame.getContentPane().add(password1);
		password1.setColumns(10);
		username = new JTextField();
		username.setBounds(322, 291, 146, 26);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel firstName = new JLabel("First Name:");
		firstName.setBounds(202, 168, 92, 20);
		frame.getContentPane().add(firstName);
		
		JLabel lastName = new JLabel("Last Name:");
		lastName.setBounds(202, 210, 92, 20);
		frame.getContentPane().add(lastName);
		
		JButton finishBtn = new JButton("Finish");
		finishBtn.setEnabled(false);
		finishBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		finishBtn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String first_name = firstname.getText();
				String last_name = lastname.getText(); 
				String email = emailadd.getText(); 
				String password = password1.getText(); 
				String userName = username.getText();
				
				if(first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || password.isEmpty() || userName.isEmpty())
				{
					finishBtn.setEnabled(false);
				}
				else
				{
					finishBtn.setEnabled(true);
					AccountCreation app = new AccountCreation();
					app.insert(first_name, last_name, email, userName, password);
				}
			}
		});
		finishBtn.setBounds(332, 375, 115, 29);
		frame.getContentPane().add(finishBtn);
		
		JLabel emailTitle = new JLabel("Email:");
		emailTitle.setBounds(212, 252, 69, 20);
		frame.getContentPane().add(emailTitle);
		
		JLabel passwordTitle = new JLabel("Password");
		passwordTitle.setBounds(202, 336, 69, 20);
		frame.getContentPane().add(passwordTitle);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(202, 294, 92, 20);
		frame.getContentPane().add(lblUsername);
	}

	//Connection Object to SQL DB
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
	
	//Inserts user's information
	public void insert(String firstname, String lastname, String email,String username, String password) 
	{
        String sql = "INSERT INTO UserName(firstName, lastName, email, userName, password) VALUES (?, ?, ?, ?, ?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, email);
            pstmt.setString(4, username);
            pstmt.setString(5, password);
            pstmt.executeUpdate();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
