package Window_package;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

//UZYWANA PRZEZ MainClass
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	MainMenu menuBar;
	VectorPanel vectorPanel;
	RightPanel rightPanel;

	public MainWindow(String arg0) throws HeadlessException 
	{
		super(arg0);
		setSize(800, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menuBar = new MainMenu(this);
		setJMenuBar(menuBar);
		
		setLayout(new BorderLayout());
		
		vectorPanel = new VectorPanel();
		add(vectorPanel, BorderLayout.CENTER);

		rightPanel = new RightPanel(vectorPanel);
		add(rightPanel, BorderLayout.LINE_END);
	}
	
	
	public VectorPanel getVectorPanel() {
		return vectorPanel;
	}

	public void setVectorPanel(VectorPanel vectorPanel) {
		this.vectorPanel = vectorPanel;
	}

	public RightPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(RightPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

}
