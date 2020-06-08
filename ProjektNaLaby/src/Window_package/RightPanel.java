package Window_package;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Keyboard_package.Window;
import OpcjeButtonWindow.OpcjeWindow;

//uzywana przez MainWindow
public class RightPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	StartStopButton startStopButton;
	JButton pauseButton;
	JButton stopButton;
	
	public static String lastJTextField = new String();
	
	JTextField fX;
	JTextField fY;
	JTextField rX;
	JTextField rY;
	JTextField vX;
	JTextField vY;
	JTextField m;
	JButton options;
	
	JPanel panelForGroupOfJRadiobuttons;
	static JRadioButton Polish;
	static JRadioButton English;
	ButtonGroup chooseLanguage;
	
	public static int keyboardUsageCounter = 0;
	public static int badKeyboardUsageCounter = 0;
	public static boolean isLastKeyboardUsageWasCorrect = false;

	public RightPanel(VectorPanel vPanel) 
	{
		setLayout(new GridLayout(20, 1, 5, 5));
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
				Window keysFrame = new Window("Podaj Fx", fX, vPanel);
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
				Window keysFrame = new Window("Podaj Fy", fY, vPanel);
				keysFrame.setVisible(true);	
				lastJTextField = "F(y)";
			}
		});
		add(fY);
		
		add(new JLabel(" "));
		
		rX = new JTextField("Podaj rx");
		rX.setName("rx");
		rX.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Window keysFrame = new Window("Podaj r_x", rX, vPanel);
				keysFrame.getKeysPanel().removeFrist();
				keysFrame.getKeysPanel().removeSecond();
				keysFrame.setVisible(true);	
				lastJTextField = "r_x";
			}
		});
		
		add(rX);
		rY = new JTextField("Podaj ry");
		rY.setName("ry");
		rY.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Window keysFrame = new Window("Podaj r_y", rY, vPanel);
				keysFrame.getKeysPanel().removeFrist();
				keysFrame.getKeysPanel().removeSecond();
				keysFrame.setVisible(true);	
				lastJTextField = "r_y";
			}
		});
		add(rY);
		
		add(new JLabel(" "));
		
		vX = new JTextField("Podaj vx");
		vX.setName("vx");
		vX.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Window keysFrame = new Window("Podaj v_x", vX, vPanel);
				keysFrame.getKeysPanel().removeFrist();
				keysFrame.getKeysPanel().removeSecond();
				keysFrame.setVisible(true);	
				lastJTextField = "v_x";
			}
		});
		add(vX);
		vY = new JTextField("Podaj vy");
		vY.setName("vy");
		vY.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Window keysFrame = new Window("Podaj v_y", vY, vPanel);
				keysFrame.getKeysPanel().removeFrist();
				keysFrame.getKeysPanel().removeSecond();
				keysFrame.setVisible(true);	
				lastJTextField = "v_y";
			}
		});
		add(vY);
		
		add(new JLabel(" "));
		
		m = new JTextField("Podaj m");
		m.setName("m");
		m.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Window keysFrame = new Window("Podaj m", m, vPanel);
				keysFrame.getKeysPanel().removeFrist();
				keysFrame.getKeysPanel().removeSecond();
				keysFrame.setVisible(true);	
				lastJTextField = "m";
			}
		});
		add(m);
		
		add(new JLabel(" "));
		//LANGUAGE SELECTION
		panelForGroupOfJRadiobuttons = new JPanel();
		panelForGroupOfJRadiobuttons.setLayout(new GridLayout(2,1));
		English = new JRadioButton("English");
		Polish = new JRadioButton("Polish");
		chooseLanguage = new ButtonGroup();
		
		chooseLanguage.add(English);
		chooseLanguage.add(Polish);
		Polish.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainClass.language = new Language.Polish();
				
				MainClass.frame.setTitle(MainClass.language.getFrameTitleText());
				
				MainClass.frame.menuBar.menu.setText(MainClass.language.getMenuBarText());
				MainClass.frame.menuBar.otworz.setText(MainClass.language.getMenuOptionOpenText());
				MainClass.frame.menuBar.zapisz.setText(MainClass.language.getMenuOptionSaveText());
				
				MainClass.frame.rightPanel.m.setText(MainClass.language.getTypeInMassText());
				MainClass.frame.rightPanel.options.setText(MainClass.language.getOptionsButtonText());
				MainClass.frame.rightPanel.pauseButton.setText(MainClass.language.getPauseButtonText());
				MainClass.frame.rightPanel.rX.setText(MainClass.language.getTypeInPosisionXText());
				MainClass.frame.rightPanel.rY.setText(MainClass.language.getTypeInPosisionYText());
				MainClass.frame.rightPanel.vX.setText(MainClass.language.getTypeInSpeedXText());
				MainClass.frame.rightPanel.vY.setText(MainClass.language.getTypeInSpeedYText());
				
				MainClass.frame.repaint();
			}
		});
		
		English.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainClass.language = new Language.English();
				
				MainClass.frame.setTitle(MainClass.language.getFrameTitleText());
				
				MainClass.frame.menuBar.menu.setText(MainClass.language.getMenuBarText());
				MainClass.frame.menuBar.otworz.setText(MainClass.language.getMenuOptionOpenText());
				MainClass.frame.menuBar.zapisz.setText(MainClass.language.getMenuOptionSaveText());
				
				MainClass.frame.rightPanel.m.setText(MainClass.language.getTypeInMassText());
				MainClass.frame.rightPanel.options.setText(MainClass.language.getOptionsButtonText());
				MainClass.frame.rightPanel.pauseButton.setText(MainClass.language.getPauseButtonText());
				MainClass.frame.rightPanel.rX.setText(MainClass.language.getTypeInPosisionXText());
				MainClass.frame.rightPanel.rY.setText(MainClass.language.getTypeInPosisionYText());
				MainClass.frame.rightPanel.vX.setText(MainClass.language.getTypeInSpeedXText());
				MainClass.frame.rightPanel.vY.setText(MainClass.language.getTypeInSpeedYText());
				
				MainClass.frame.repaint();
			}
		});
		
		Polish.setSelected(true);
		
		panelForGroupOfJRadiobuttons.add(English);
		panelForGroupOfJRadiobuttons.add(Polish);

		this.add(panelForGroupOfJRadiobuttons);
		//**************************************************************************
		add(new JLabel(" "));
		
		options = new JButton("Opcje");
		options.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				OpcjeWindow opcje = new OpcjeWindow(vPanel);
				opcje.setVisible(true);
			}
		});
		add(options);
		add(new JLabel(" "));
		
		startStopButton = new StartStopButton();
		add(startStopButton);

		pauseButton = new JButton("PAUSE");
		pauseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VectorPanel.pauseSpaceshipThread();
				
			}
		});
		add(pauseButton);
		
		stopButton = new JButton("STOP");
		stopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VectorPanel.stopSpaceshipThread();
				
			}
		});
		add(stopButton);
		
		
		add(new JLabel(" "));
		
	}

}
