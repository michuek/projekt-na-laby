package Window_package;

public class MainClass 
{
	public static  MainWindow frame;
	public MainClass() {  }
	
	public static void main(String[] args) 
	{
		frame = new MainWindow("Window");
		frame.setVisible(true);
	}
}
