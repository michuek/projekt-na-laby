package Window_package;

import javax.swing.SwingUtilities;

public class MainClass 
{
	public static  MainWindow frame;
	public MainClass() {  }
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				frame = new MainWindow("Window");
				frame.setVisible(true);
			}
		});
		
		
	}
}
