package Window_package;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;
import MathPackage.ArrowField;
import OpcjeButtonWindow.OpcjeWindow;
import Simulation.Asteroid;
import Simulation.Laser;
import Simulation.SimulationSettings;
import Simulation.Spaceship;

//uzywana przez MainWindow
public class VectorPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	
	
	static BasicStroke axisStroke = new BasicStroke(1);
	static BasicStroke vectorStroke = new BasicStroke(1);

	public static ArrowField arrowField;
	
	private static Spaceship spaceship1;
	private static ArrayList<Asteroid> asteroidy;
	private static int lAsteroid = 3;
	private static Laser laser;
	
	KeyListener keyListener;
	MouseListener mouseListener;
	
	static ExecutorService exec;
	
	private static boolean stopOrPause = true;// stop == true, pause == false
	
	//====================================================KONSTRUKTOR
	public VectorPanel() 
	{
		setBackground(Color.BLACK);
		
		arrowField = new ArrowField(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString(), this);
		spaceship1 = new Spaceship();
		asteroidy = new ArrayList<Asteroid>();
		for(int i = 0; i < lAsteroid; i++) {
			asteroidy.add(new Asteroid(this));
		}
		laser = new Laser();
		
		//TWORZY NOWE POLE WEKTOROWE I RYSUJE JE GDY ZMIENIA SIE ROZMIAR OKNA
		this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) { }
				
			@Override
			public void componentMoved(ComponentEvent e) {  }
				
			@Override
			public void componentHidden(ComponentEvent e) { }
			
			@Override
			public void componentResized(ComponentEvent e) 
			{
				arrowField = new ArrowField(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString(), (VectorPanel) e.getComponent());
			}
		});
	
		keyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		addKeyListener(keyListener);
		mouseListener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		addMouseListener(mouseListener);
		
	}
	
	//=============Powoduje wywolanie metody run statku spaceship1 i odswiezania sladu za nim
	public static void startSpaceshipThread ()
	{
		if(OpcjeWindow.getAsteroids())
		{
			exec = Executors.newFixedThreadPool(3 + lAsteroid);
			if(stopOrPause)
			{
				spaceship1 = new Spaceship();
				asteroidy = new ArrayList<Asteroid>();
				for(int i = 0; i < lAsteroid; i++) {
					asteroidy.add(new Asteroid());
				}
			}
			Spaceship.keepRunning = true;
			exec.execute(spaceship1);
			for(int i = 0; i < lAsteroid; i++) {
				exec.execute(asteroidy.get(i));
			}
			exec.shutdown();
		}
		else
		{
			exec = Executors.newFixedThreadPool(3);
			if(stopOrPause)
			{
				spaceship1 = new Spaceship();
			}
			Spaceship.keepRunning = true;
			exec.execute(spaceship1);
			exec.shutdown();
		}

	}
	
	public static void pauseSpaceshipThread()
	{
		Spaceship.keepRunning = false;
		stopOrPause = false;
	}
	public static void stopSpaceshipThread()
	{
		Spaceship.keepRunning = false;
		stopOrPause = true;
	}
	
	public void paintComponent(Graphics g) 	//Rysowanie siatki, pola i statku
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.WHITE);
		g2d.setStroke(axisStroke);
		g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);		//adjustable x Axis
		g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());		//adjustable y Axis
		g2d.setStroke(vectorStroke);
		for(int i = 0; i < arrowField.getArrowsInRow() ; i++)
		{
			for(int j = 0; j < arrowField.getArrowsInColumn(); j++)
			{
				if (arrowField.getArrow(i, j).getMagnitude() > 0.5)		//nie rysuje malych strzalek
				{
					g2d.setColor(arrowField.getArrow(i, j).getColor());
					g.drawPolygon(arrowField.getArrow(i, j));
					g.fillPolygon(arrowField.getArrow(i, j));
				}
			}
		}
		spaceship1.paint(g2d, this);
		for(int i = 0; i < lAsteroid; i++) {
			asteroidy.get(i).paint(g2d, this);
		laser.paint(g2d, this);
		}
		repaint();
	}
	
	//====================================GETTERY I SETTERY
	public Spaceship getSpaceship() {
		return spaceship1;
	}
	
	public void setSpaceship(Spaceship s) {
		spaceship1 = s;
	}

	public static Spaceship getSpaceship1() {
		return spaceship1;
	}

	public static void setSpaceship1(Spaceship spaceship1) {
		VectorPanel.spaceship1 = spaceship1;
	}
	
	public ArrayList<Asteroid> getAsteroidy() {
		return asteroidy;
	}
	
	static public Laser getLaser() {
		return laser;
	}
	
	static public void setLaser(Laser l) {
		laser = l;
	}
	
	//====================================funkcje listenerów
	public void changeKey(KeyListener kl) {
		removeKeyListener(keyListener);
		keyListener = kl;
		addKeyListener(keyListener);
	}
	public void changeMouse(MouseListener ml) {
		removeMouseListener(mouseListener);
		mouseListener = ml;
		addMouseListener(mouseListener);
	}

}
