package Window_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.SwingWorker;

import Simulation.Laser;
import Simulation.SimulationSettings;
import Simulation.Spaceship;

public class StartStopButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	static ExecutorService exec;

	public StartStopButton() 
	{
		super("START");
		
		addKeyListener(new ControlListener());//sterowanie strza³kami
		
		addActionListener(new ActionListener() {// Rozpoczyna symulacjê ruchu statku
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MainMenu.parameters = new String();
				MainMenu.parameters += (SimulationSettings.getxTrueForceInString());
				MainMenu.parameters += ('\n');
				MainMenu.parameters += (SimulationSettings.getyTrueForceInString());
				MainMenu.parameters += ('\n');
				MainMenu.parameters += (new Double(SimulationSettings.getX0Pos()).toString());
				MainMenu.parameters += ('\n');
				MainMenu.parameters += (new Double(SimulationSettings.getY0Pos()).toString());
				MainMenu.parameters += ('\n');
				MainMenu.parameters += (new Double(SimulationSettings.getV0X()).toString());
				MainMenu.parameters += ('\n');
				MainMenu.parameters += (new Double(SimulationSettings.getV0Y()).toString());
				MainMenu.parameters += ('\n');
				MainMenu.parameters += (new Double(SimulationSettings.getMass()).toString());
				MainMenu.parameters += ('\n');
				VectorPanel.startSpaceshipThread(); //statek zaczyna dzialac
				AMainClass.frame.getVectorPanel().addMouseListener(new LaserListener());
			}
		});

	}
	
	class ControlListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			switch(arg0.getKeyCode())
			{
			case KeyEvent.VK_LEFT: 
				Spaceship.setArrowKeyAccX(-Spaceship.thrust/SimulationSettings.getMass());
				break;
			case KeyEvent.VK_A:
				Spaceship.setArrowKeyAccX(-Spaceship.thrust/SimulationSettings.getMass());
				break;
			case KeyEvent.VK_RIGHT: 
				Spaceship.setArrowKeyAccX(Spaceship.thrust/SimulationSettings.getMass());
				break;
			case KeyEvent.VK_D: 
				Spaceship.setArrowKeyAccX(Spaceship.thrust/SimulationSettings.getMass());
				break;
			case KeyEvent.VK_UP: 
				Spaceship.setArrowKeyAccY(Spaceship.thrust/SimulationSettings.getMass());
				break;
			case KeyEvent.VK_W: 
				Spaceship.setArrowKeyAccY(Spaceship.thrust/SimulationSettings.getMass());
				break;
			case KeyEvent.VK_DOWN:
				Spaceship.setArrowKeyAccY(-Spaceship.thrust/SimulationSettings.getMass());
				break;
			case KeyEvent.VK_S:
				Spaceship.setArrowKeyAccY(-Spaceship.thrust/SimulationSettings.getMass());
				break;
			default: 
				break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			Spaceship.setArrowKeyAccX(0.0);
			Spaceship.setArrowKeyAccY(0.0);	
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class LaserListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(!VectorPanel.getLaser().getKeepRunning())
			{
				int x = e.getX() - (AMainClass.frame.getVectorPanel().getWidth()/2);
				int y =  (AMainClass.frame.getVectorPanel().getHeight()/2) - e.getY();
				exec = Executors.newFixedThreadPool(1);
				VectorPanel.setLaser(new Laser());
				VectorPanel.setLaser(new Laser(VectorPanel.getSpaceship(), x, y, AMainClass.frame.getVectorPanel()));
				exec.execute(VectorPanel.getLaser());
				exec.shutdown();
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
