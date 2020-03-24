package Window_package;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class VectorPanel extends JPanel {
	
	static int width = 778;
	static int height = 744;
	
	Polygon xAxis;
	Polygon yAxis;
	static BasicStroke axisStroke = new BasicStroke(1);
	static BasicStroke vectorStroke = new BasicStroke(1);
	
	Arrow arrow;
	Arrow[][] arrowTab;
	static final int n = 10;

	public VectorPanel() {
		setBackground(Color.white);
		
		xAxis = new Polygon();
		xAxis.addPoint(0, height/2);
		xAxis.addPoint(width, height/2);
		yAxis = new Polygon();
		yAxis.addPoint(width/2, 0);
		yAxis.addPoint(width/2, height);
		
		arrowTab = new Arrow[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				arrowTab[i][j] = new Arrow( (width/n)/2 + i*width/n, (height/n)/2 + j*height/n, 1, 1);
			}
		}

		//arrow = new Arrow(00+(width/2),00+(height/2), -1, 0);

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLACK);
		g2d.setStroke(axisStroke);
		g.drawPolygon(xAxis);
		g.drawPolygon(yAxis);
		g.drawRect(0, 0, width, height);
		
		g2d.setStroke(vectorStroke);
		g2d.setColor(Color.red);
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				g.drawPolygon(arrowTab[i][j]);
				g.fillPolygon(arrowTab[i][j]);
			}
		}
		//g.fillPolygon(arrow);
		//g.drawPolygon(arrow);
	}
	
}
