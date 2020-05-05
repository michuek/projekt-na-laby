package Window_package;

import java.awt.Color;
import java.awt.Polygon;

public class Arrow extends Polygon {
	
	private static final long serialVersionUID = 1L;
	int positionX;
	int positionY;
	double x;
	double y;
	double magnitude;
	double argument;
	Color color ;
	
	static int lineHalfWidth = 5;
	static int lineLength =20;
	static int topHalfWidth = 10;
	static int topLength = 16;

	public Arrow(int posX, int posY, double argX, double argY, VectorPanel vPanel) 
	{
		positionX = 0;
		positionY = 0;
		x = argX;
		y = argY;
		setArgument();
		color = Color.YELLOW;
		
		addPoint(0, -lineHalfWidth);
		addPoint(lineLength, -lineHalfWidth);
		addPoint(lineLength, -topHalfWidth);
		addPoint(lineLength+topLength, 0);
		addPoint(lineLength, topHalfWidth);
		addPoint(lineLength, lineHalfWidth);
		addPoint(0, lineHalfWidth);
		
		
		translateArrow(posX, posY, vPanel);
		rotateArrow(argument);
		setMagnitude(x, y);
	}
	
	void translateArrow(int posX, int posY, VectorPanel vPanel) 
	{
		positionX = vPanel.getWidth()/2 + posX;
		positionY = vPanel.getHeight()/2 -posY;
		for(int i = 0; i < 7; i++)
		{
			xpoints[i] += positionX;
			ypoints[i] += positionY;
		}
		
	}
		
	void setMagnitude(double argX, double argY) {
		magnitude = Math.sqrt( argX*argX + argY*argY);
	}
	
	void setArgument() 
	{
		argument=Math.atan2(y, x);
	}
	
	public void setColor (Color c)
	{
		color = c;
	}
	
	public Color getColor ()
	{
		return (color);
	}
	
	void rotateArrow(double theta) {
		int xTemp = 0;
		int yTemp = 0;
		for(int i = 0; i < 7; i++)
		{
			xpoints[i] -= positionX;
			ypoints[i] -= positionY;
			
			xTemp = xpoints[i];
			yTemp = ypoints[i];
			
			xpoints[i] = (int) (xTemp*Math.cos(theta) + yTemp*Math.sin(theta));
			ypoints[i] = (int) (-xTemp*Math.sin(theta) + yTemp*Math.cos(theta));
			
			
			xpoints[i] += positionX;
			ypoints[i] += positionY;
		}		
		
	}
	
	public double getMagnitude()
	{
		return (magnitude);
	}

}

