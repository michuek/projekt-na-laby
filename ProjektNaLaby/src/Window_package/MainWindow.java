package Window_package;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	
	MainMenu menuBar;
	
	VectorPanel vectorPanel;
	RightPanel rightPanel;

	public MainWindow(String arg0) throws HeadlessException {
		super(arg0);
		setSize(908, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		menuBar = new MainMenu();
		setJMenuBar(menuBar);
		
		setLayout(new BorderLayout());

		vectorPanel = new VectorPanel();
		add(vectorPanel, BorderLayout.CENTER);
		
		rightPanel = new RightPanel();
		add(rightPanel, BorderLayout.LINE_END);
		
	}

	public static void main(String[] args) {
		MainWindow frame = new MainWindow("Window");
		frame.setVisible(true);
		//frame.vectorPanel.arrow.rotateArrow(Math.PI/2);

	}

}
