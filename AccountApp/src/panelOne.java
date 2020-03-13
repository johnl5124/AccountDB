import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;

public class panelOne extends JPanel {
	private JTextField usernameinput;
	private JTextField passwordinput;

	/**
	 * Create the panel.
	 */
	public panelOne() 
	{
		setBounds(new Rectangle(800, 800, 800, 800));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setBounds(336, 112, 78, 20);
		add(lblLoginPage);
		
		JLabel usernameTitle = new JLabel("Username: ");
		usernameTitle.setBounds(239, 216, 82, 20);
		add(usernameTitle);
		
		usernameinput = new JTextField();
		usernameinput.setBounds(336, 213, 146, 26);
		add(usernameinput);
		usernameinput.setColumns(10);
		
		JLabel passwordTitle = new JLabel("Password:");
		passwordTitle.setBounds(240, 302, 73, 20);
		add(passwordTitle);
		
		passwordinput = new JTextField();
		passwordinput.setBounds(336, 299, 146, 26);
		add(passwordinput);
		passwordinput.setColumns(10);
		
		JButton enterBtn = new JButton("Enter");
		enterBtn.setBounds(323, 361, 69, 29);
		add(enterBtn);

	}

}
