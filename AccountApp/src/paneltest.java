import javax.swing.JPanel;
import javax.swing.JLabel;

public class paneltest extends JPanel 
{	
	/**
	 * Create the panel.
	 */
	public paneltest() 
	{	
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 750, 750);
		add(panel);
		panel.setVisible(true);
		
		JLabel lblHelloWorld = new JLabel("Hello World");
		panel.add(lblHelloWorld);
		
	}

}
