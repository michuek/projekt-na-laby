package Simulation;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Window_package.VectorPanel;

public class Laser implements Runnable {

	double xCurrentPos;
	double yCurrentPos;
	static double c = 600.0;
	double xSpeed;
	double ySpeed;
	int diameter;
	boolean keepRunning;
	VectorPanel vPanel;
	
	public Laser(Spaceship s, int xAim, int yAim, VectorPanel vp) {//===========konstruktor
		keepRunning = true;
		diameter = 10;
		xCurrentPos = s.getxCurrentPos();
		yCurrentPos = s.getyCurrentPos();
		
		double x = xAim - xCurrentPos;
		double y = yAim - yCurrentPos;
		double theta = Math.atan2(y, x);
		xSpeed = c * Math.cos(theta);
		ySpeed = c * Math.sin(theta);
		
		vPanel = vp;
	}
	public Laser() {
		keepRunning = false;
		diameter = 0;
		xCurrentPos = 1500;
		yCurrentPos = 1500;
		xSpeed = 0;
		ySpeed = 0;
	}

	//==============================================SYMULACJA
	@Override
	public void run() {
		while(Spaceship.keepRunning && keepRunning)
		{
			xCurrentPos += xSpeed * SimulationSettings.dt;
			yCurrentPos += ySpeed * SimulationSettings.dt;
			
			if( (xCurrentPos - diameter) > (vPanel.getWidth()/2) )
				{keepRunning = false;}
			if( (xCurrentPos + diameter) < (-(vPanel.getWidth()/2)) )
				{keepRunning = false;}
			if( (yCurrentPos - diameter) > (vPanel.getHeight()/2) )
				{keepRunning = false;}
			if( (yCurrentPos + diameter) < (-(vPanel.getHeight()/2)) )
				{keepRunning = false;}
			
			try { Thread.sleep(SimulationSettings.getSpeedOfSimulation()); } 		// graphical speed of movement 	[0-fast 	10-slow]
			catch (InterruptedException e) {  }
		}
	}
	
	//===============================================PAINT COMPONENT
	public void paint(Graphics g, VectorPanel vPanel)
	{
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(SimulationSettings.getSpaceshipColor());
		g2D.fillOval((int) (vPanel.getWidth()/2 + xCurrentPos - diameter/2), (int) (vPanel.getHeight()/2 - yCurrentPos - diameter/2), diameter, diameter);
    }
	
	//=========================GETERY I SETERY
	public int getDiameter() { return diameter; }
	public double getxCurrentPos() { return xCurrentPos; }
	public double getyCurrentPos() { return yCurrentPos; }
	public void setKeepRunning(boolean bul) {keepRunning = bul;}
	public boolean getKeepRunning() { return keepRunning; }

}
