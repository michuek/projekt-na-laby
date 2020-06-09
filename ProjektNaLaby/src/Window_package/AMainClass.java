package Window_package;

public class AMainClass 
{
	public static  MainWindow frame;
	public AMainClass() {  }
	
	public static void main(String[] args) 
	{
		frame = new MainWindow("Window");
		frame.setVisible(true);
	}
}
