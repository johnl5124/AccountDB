import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBClass 
{
	//TEST FOR CONNECTION TO DB
	Connection connectTest()
	{
		 // SQLite connection string
        String url = "jdbc:sqlite:C://Users//johnl//Documents//SQL DB//Users.db";
        
        Connection conn = null;
        try 
        {
        	JOptionPane.showMessageDialog(null, "Connection to database established");
        	
            conn = DriverManager.getConnection(url);
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return conn;
	}
	//CONNECT TO DB
	Connection connect() throws SQLException 
	{
        // SQLite connection string
        String url = "jdbc:sqlite:C://Users//johnl//Documents//SQL DB//Users.db";
        
        Connection conn = null;
        conn = DriverManager.getConnection(url);

        return conn;
    }
	//Inserts user's information
	public void insert(String firstname, String lastname, String email,String username, String password) 
	{
        String sql = "INSERT INTO UserInfo(FirstName, LastName, Email, UserName, Password) VALUES (?, ?, ?, ?, ?)";
 
        try (//Connection conn = this.connect();
                PreparedStatement pstmt = connect().prepareStatement(sql)) 
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
	
	//Select information from db
	public void selectAll()
	{
        String sql = "SELECT FirstName, LastName, Email FROM UserInfo";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) 
            {
                System.out.println(rs.getString("FirstName") +  "\t" + 
                                   rs.getString("LastName") + "\t" +
                                   rs.getString("Email"));
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
