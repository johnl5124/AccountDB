import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class entryPoint {

	private JFrame frame;
	private panelOne p1;
	private panelTwo p2;

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
					entryPoint window = new entryPoint();
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
	public entryPoint() 
	{	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame("Account Application");
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p2 = new panelTwo();
		p2.setBounds(100, 100, 800, 800);
		p2.setVisible(false);
		
		p1 = new panelOne();
		p1.setVisible(true);
		frame.getContentPane().add(p1, BorderLayout.CENTER);
		frame.getContentPane().add(p2);
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

}
