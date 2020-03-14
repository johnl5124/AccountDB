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

public class panelTwo extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelTwo() 
	{
		setLayout(null);
		
		JLabel lblAccountCreationPage = new JLabel("Account Creation Page");
		lblAccountCreationPage.setBounds(320, 16, 167, 20);
		add(lblAccountCreationPage);
		{				
			JButton btnConnectionToDatabase = new JButton("Connection to database");
			btnConnectionToDatabase.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					connect();
				}
			});
			
			//USER INFORMATION
			firstname = new JTextField();
			firstname.setBounds(322, 165, 146, 26);
			contentPane.add(firstname);
			firstname.setColumns(10);
			lastname = new JTextField();
			lastname.setBounds(322, 207, 146, 26);
			contentPane.add(lastname);
			lastname.setColumns(10);
			emailadd = new JTextField();
			emailadd.setBounds(322, 249, 146, 26);
			contentPane.add(emailadd);
			emailadd.setColumns(10);
			password1 = new JTextField();
			password1.setBounds(322, 333, 146, 26);
			contentPane.add(password1);
			password1.setColumns(10);
			username = new JTextField();
			username.setBounds(322, 291, 146, 26);
			contentPane.add(username);
			username.setColumns(10);
			
			JLabel firstName = new JLabel("First Name:");
			firstName.setBounds(202, 168, 92, 20);
			contentPane.add(firstName);
			
			JLabel lastName = new JLabel("Last Name:");
			lastName.setBounds(202, 210, 92, 20);
			contentPane.add(lastName);
			
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
			contentPane.add(finishBtn);
			
			JLabel emailTitle = new JLabel("Email:");
			emailTitle.setBounds(212, 252, 69, 20);
			contentPane.add(emailTitle);
			
			JLabel passwordTitle = new JLabel("Password");
			passwordTitle.setBounds(202, 336, 69, 20);
			contentPane.add(passwordTitle);
			
			JLabel lblUsername = new JLabel("Username:");
			lblUsername.setBounds(189, 287, 92, 35);
			contentPane.add(lblUsername);
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
	}

}
