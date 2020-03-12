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

public class AccountCreation {

	private JFrame frame;
	private JTextField username;
	private JTextField lastname;

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
		
		username = new JTextField();
		username.setBounds(262, 103, 146, 26);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(262, 145, 146, 26);
		frame.getContentPane().add(lastname);
		lastname.setColumns(10);
		
		JLabel firstName = new JLabel("First Name:");
		firstName.setBounds(142, 106, 92, 20);
		frame.getContentPane().add(firstName);
		
		JLabel lastName = new JLabel("Last Name:");
		lastName.setBounds(142, 148, 92, 20);
		frame.getContentPane().add(lastName);
		
		JButton finishBtn = new JButton("Finish");
		finishBtn.addMouseListener(new MouseAdapter() 
		{
			String user_name = username.toString();
			String last_name = lastname.toString();
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				/*try
				{
		                PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
		            pstmt.setString(1, user_name);
		            pstmt.setString(2, last_name);
		            pstmt.executeUpdate();
		        } 
				catch (SQLException e1) 
				{
		            System.out.println(e1.getMessage());
		        }
		        */
			}
		});
		finishBtn.setBounds(277, 208, 115, 29);
		frame.getContentPane().add(finishBtn);
	}

	//Test connection on SQL database
	public static void connect() 
	{  
	        Connection conn = null;  
	        try 
	        {  
	            // db parameters  
	            String url = "jdbc:sqlite:C:\\Users\\John\\Desktop\\SQL DB\\Users.db";  
	            // create a connection to the database  
	            conn = DriverManager.getConnection(url);  
	              
	            System.out.println("Connection to SQLite has been established.");  
	              
	        } 
	        catch (SQLException e) 
	        {  
	            System.out.println(e.getMessage());  
	        } 
	        finally 
	        {  
	            try 
	            {  
	                if (conn != null) 
	                {  
	                    conn.close();  
	                }  
	            } 
	            catch (SQLException ex) 
	            {  
	                System.out.println(ex.getMessage());  
	            }  
	        }  
	    }  
	
}
