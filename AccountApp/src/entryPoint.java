import java.awt.EventQueue;

import javax.swing.JFrame;

public class entryPoint {

	private JFrame frame;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelOne p1 = new panelOne();
		p1.setBounds(100, 100, 800, 800);
		p1.setVisible(true);
		p1.setAlignmentX(JFrame.CENTER_ALIGNMENT);
		p1.setAlignmentY(JFrame.CENTER_ALIGNMENT);
		frame.add(p1);
		
		frame.setLocationRelativeTo(null);
	}

}
