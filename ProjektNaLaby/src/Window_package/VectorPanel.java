package Window_package;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;
import MathPackage.ArrowField;
import Simulation.SimulationSettings;
import Simulation.Spaceship;

public class VectorPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	
	
	static BasicStroke axisStroke = new BasicStroke(1);
	static BasicStroke vectorStroke = new BasicStroke(1);

	public ArrowField arrowField;
	
	private static Spaceship spaceship1;
	
	public VectorPanel() 
	{
		setBackground(Color.BLACK);
		
		arrowField = new ArrowField(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString(), this);
		spaceship1 = new Spaceship();
		
		this.addComponentListener(new ComponentListener() {		//TWORZY NOWE POLE WEKTOROWE I RYSUJE JE GDY ZMIENIA SIE ROZMIAR OKNA
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) 
			{
				arrowField = new ArrowField(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString(), (VectorPanel) e.getComponent());
				
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
	public static void startThread () //Powoduje wywolanie metody run statku spaceship1
	{
		ExecutorService exec = Executors.newFixedThreadPool(1);
		spaceship1 = new Spaceship();
		exec.execute(spaceship1);
		exec.shutdown();
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
		repaint();
	}
	

}
