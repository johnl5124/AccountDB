import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class panelTwo extends JPanel {
	private JTextField firstname;
	private JTextField lastname;
	private JTextField emailadd;
	private JTextField username;
	private JTextField password;

	/**
	 * Create the panel.
	 */
	public panelTwo() 
	{
		setLayout(null);
		
		JLabel lblAccountCreationPage = new JLabel("Account Creation Page");
		lblAccountCreationPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountCreationPage.setBounds(282, 11, 167, 20);
		add(lblAccountCreationPage);
		{				
			JButton btnConnectionToDatabase = new JButton("Connection to database");
			btnConnectionToDatabase.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					//connect();
				}
			});
			
			/*String first_name = firstname.getText();
			String last_name = lastname.getText(); 
			String email = emailadd.getText(); 
			String password = password.getText(); 
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
	    */
	}
	}

}
