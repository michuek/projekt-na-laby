package Window_package;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;

import MathPackage.ArrowField;
import Simulation.SimulationSettings;
import Simulation.Spaceship;

public class VectorPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	public static int width = 600;
	public static int height = 600;
	
	Polygon xAxis;
	Polygon yAxis;
	static BasicStroke axisStroke = new BasicStroke(1);
	static BasicStroke vectorStroke = new BasicStroke(1);

	static final int arrowsInRow = 10;
	static final int arrowsInColumn = 15;
	public static ArrowField arrowField;
	
	private static Spaceship spaceship1;
	
	public VectorPanel() 
	{
		setBackground(Color.BLACK);
		
		xAxis = new Polygon();
		xAxis.addPoint(0, height/2);
		xAxis.addPoint(width, height/2);
		yAxis = new Polygon();
		yAxis.addPoint(width/2, 0);
		yAxis.addPoint(width/2, height);
		
		arrowField = new ArrowField(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString());
		
		spaceship1 = new Spaceship();
	}
	
	
	public static void startThread () //Powoduje wywolanie metody run statku spaceship1
	{
		ExecutorService exec = Executors.newFixedThreadPool(1);
		exec.execute(spaceship1);
		exec.shutdown();
	}
	
	public void paintComponent(Graphics g) 	//Rysowanie pola i statku
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.WHITE);
		g2d.setStroke(axisStroke);
		g.drawPolygon(xAxis);
		g.drawPolygon(yAxis);
		g.drawRect(0, 0, width, height);
		
		g2d.setStroke(vectorStroke);
		for(int i = 0; i < arrowsInRow; i++)
		{
			for(int j = 0; j < arrowsInColumn; j++)
			{
				g2d.setColor(arrowField.getArrow(i, j).getColor());
				g.drawPolygon(arrowField.getArrow(i, j));
				g.fillPolygon(arrowField.getArrow(i, j));
			}
		}
		spaceship1.paint(g2d);
		repaint();
	}
	

}
