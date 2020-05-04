package Window_package;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Keyboard_package.Window;

public class RightPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	StartStopButton startStopButton;
	
	public static String lastJTextField = new String();
	public static String xTrueForceInString = "-1", yTrueForceInString = "0";
	
	JTextField fX;
	JTextField fY;
	JTextField rX;
	JTextField rY;
	JTextField vX;
	JTextField vY;
	JTextField m;
	JButton options;

	public RightPanel() 
	{
		xTrueForceInString = new String();
		setLayout(new GridLayout(18, 1, 5, 5));
		add(new JLabel(" "));
		
		fX = new JTextField("F(x)=");
		fX.setName("Fx");
		fX.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {// TODO Auto-generated method stub
			}			
			@Override
			public void mousePressed(MouseEvent e) {// TODO Auto-generated method stub
			}			
			@Override
			public void mouseExited(MouseEvent e) {// TODO Auto-generated method stub
			}			
			@Override
			public void mouseEntered(MouseEvent e) {// TODO Auto-generated method stub
			}			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Window keysFrame = new Window("Podaj Fx", fX);
				keysFrame.setVisible(true);	
				lastJTextField = "F(x)";
			}
		});
		add(fX);
		fY = new JTextField("F(y)=");
		fY.setName("Fy");
		fY.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent e) {// TODO Auto-generated method stub
			}
			@Override
			public void mouseEntered(MouseEvent e) {// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Window keysFrame = new Window("Podaj Fy", fY);
				keysFrame.setVisible(true);	
				lastJTextField = "F(y)";
			}
		});
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
