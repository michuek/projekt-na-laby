package Window_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import Simulation.SimulationSettings;
import Simulation.Spaceship;

public class StartStopButton extends JButton {

	private static final long serialVersionUID = 1L;

	public StartStopButton() 
	{
		super("START");
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {	}	
			
			@Override
			public void keyReleased(KeyEvent e) 
			{
				Spaceship.setArrowKeyAccX(0.0);
				Spaceship.setArrowKeyAccY(0.0);								
			}
			
			@Override
			public void keyPressed(KeyEvent e) 
			{
				switch(e.getKeyCode())
				{
				case KeyEvent.VK_LEFT: 
					Spaceship.setArrowKeyAccX(-Spaceship.thrust/SimulationSettings.getMass());
					break;
				case KeyEvent.VK_RIGHT: 
					Spaceship.setArrowKeyAccX(Spaceship.thrust/SimulationSettings.getMass());
					break;
				case KeyEvent.VK_UP: 
					Spaceship.setArrowKeyAccY(Spaceship.thrust/SimulationSettings.getMass());
					break;
				case KeyEvent.VK_DOWN:
					Spaceship.setArrowKeyAccY(-Spaceship.thrust/SimulationSettings.getMass());
					break;
				default: 
					break;
				}
			}
		});
		
		addActionListener(new ActionListener() {// Rozpoczyna symulacjê ruchu statku
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				VectorPanel.startSpaceshipThread(); //statek zaczyna dzialac
			}
		});

	}
	
}
