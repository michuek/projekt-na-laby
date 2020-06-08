package Window_package;

import javax.swing.SwingUtilities;

import Language.Polish;
import Language.TextLanguageTemplate;

public class MainClass 
{
	public static  MainWindow frame;
	public static TextLanguageTemplate language = new Polish();
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
