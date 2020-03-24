package Window_package;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightPanel extends JPanel {
	
	StartStopButton startStopButton;
	
	JTextField fX;
	JTextField fY;
	JTextField rX;
	JTextField rY;
	JTextField vX;
	JTextField vY;
	JTextField m;
	JButton options;

	public RightPanel() {
		setLayout(new GridLayout(18, 1, 5, 5));
		add(new JLabel(" "));
		fX = new JTextField("Podaj Fx");
		add(fX);
		fY = new JTextField("Podaj Fy");
		add(fY);
		add(new JLabel(" "));
		rX = new JTextField("Podaj rx");
		add(rX);
		rY = new JTextField("Podaj ry");
		add(rY);
		add(new JLabel(" "));
		vX = new JTextField("Podaj vx");
		add(vX);
		vY = new JTextField("Podaj vy");
		add(vY);
		add(new JLabel(" "));
		m = new JTextField("Podaj m");
		add(m);
		add(new JLabel(" "));
		add(new JLabel(" "));
		options = new JButton("Opcje");
		add(options);
		add(new JLabel(" "));
		add(new JLabel(" "));
		startStopButton = new StartStopButton();
		add(startStopButton);
		add(new JLabel(" "));
	}

}
