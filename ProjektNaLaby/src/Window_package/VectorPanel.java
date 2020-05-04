package Window_package;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;

import MathPackage.ArrowField;

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
	
	public VectorPanel() 
	{
		setBackground(Color.BLACK);
		
		xAxis = new Polygon();
		xAxis.addPoint(0, height/2);
		xAxis.addPoint(width, height/2);
		yAxis = new Polygon();
		yAxis.addPoint(width/2, 0);
		yAxis.addPoint(width/2, height);
		
		//arrowField = new ArrowField("0", "0");
		arrowField = new ArrowField(RightPanel.xTrueForceInString, RightPanel.yTrueForceInString);
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.WHITE);
		g2d.setStroke(axisStroke);
		g.drawPolygon(xAxis);
		g.drawPolygon(yAxis);
		g.drawRect(0, 0, width, height);
		
		g2d.setStroke(vectorStroke);
		g2d.setColor(Color.YELLOW);
		for(int i = 0; i < arrowsInRow; i++)
		{
			for(int j = 0; j < arrowsInColumn; j++)
			{
				g.drawPolygon(arrowField.getArrow(i, j));
				g.fillPolygon(arrowField.getArrow(i, j));
			}
		}
		
		//g.drawPolygon(demoArrow);
		//g.fillPolygon(demoArrow);
		
	}
	
}
