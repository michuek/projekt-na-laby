package Simulation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.script.ScriptException;

import MathPackage.TextToEquation;
import Window_package.VectorPanel;

public class Spaceship implements Runnable
{
	private double xAcceleration;
	private double yAcceleration;
	
	public static double arrowKeyAccX = 0.0;
	public static double arrowKeyAccY = 0.0;
	public static double thrust = 100.0;
	public static boolean keepRunning = false;
	
	private double xCurrentSpeed;
	private double yCurrentSpeed;
	private double xCurrentPos;
	private double yCurrentPos;
	private double mass;
	private double time;
	private double dt;
	
	private int diameter = 50;
	
	private Path path;
	public Spaceship() 
	{
		SimulationSettings.getX0Pos();
		SimulationSettings.getY0Pos();
		xCurrentPos = SimulationSettings.getX0Pos();
		yCurrentPos = SimulationSettings.getY0Pos();
		
		SimulationSettings.getV0X();
		SimulationSettings.getV0Y();
		xCurrentSpeed = SimulationSettings.getV0X();
		yCurrentSpeed = SimulationSettings.getV0Y();
		
		mass = SimulationSettings.getMass();
		
		time = SimulationSettings.getTime();
		dt = SimulationSettings.getDt();
		
		path = new Path(2, this);
		
	}
	

	//HOW TO PERFORM SIMULATION *******************************
	void updateAcceleration (String fxString, String fyString)
	{
		try 
		{
			double Fx = TextToEquation.evaluateTwoVariableFunctionInString(fxString, "firstVariable", "secondVariable", xCurrentPos, yCurrentPos);
			xAcceleration = Fx/mass;
			
			double Fy = TextToEquation.evaluateTwoVariableFunctionInString(fyString, "firstVariable", "secondVariable", xCurrentPos, yCurrentPos);
			yAcceleration = Fy/mass;
		} catch (ScriptException e) { } // do nothing
		
	}
	
	void updateVelocity (boolean colored)
	{
		path.addSpeedToPath(Math.sqrt(xCurrentSpeed*xCurrentSpeed + yCurrentSpeed*yCurrentSpeed));
		xCurrentSpeed += (xAcceleration + arrowKeyAccX) * dt;
		yCurrentSpeed += (yAcceleration + arrowKeyAccY) * dt;
	}
	
	void updatePosition()
	{
		path.addPositionToPath(new Point((int) xCurrentPos, (int)yCurrentPos));
		xCurrentPos += xCurrentSpeed * dt;
		yCurrentPos += yCurrentSpeed * dt;
	}
	
	public void performSimulatingStep (boolean colored)
	{
		updateAcceleration(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString());
		updateVelocity(colored);
		updatePosition();
		
		time = time + dt;
	}
	//END OF HOW TO PERFORM SIMULATION ************************
	
	//HOW TO DRAW THE SPACESHIP*********************************
	public void paint(Graphics g, VectorPanel vPanel)
	{
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(SimulationSettings.getSpaceshipColor());
		g2D.fillOval((int) (vPanel.getWidth()/2 + xCurrentPos - diameter/2), (int) (vPanel.getHeight()/2 - yCurrentPos - diameter/2), 50, 50);
		path.paint(g2D, vPanel);
		
    }//END HOW TO DRAW THE SPACESHIP*****************************
	
	
	@Override			
	public void run() 			// PERFORMING SIMULATION
	{
		while (keepRunning)
		{
			this.performSimulatingStep(SimulationSettings.isColoredPath());		
			try { Thread.sleep(SimulationSettings.getSpeedOfSimulation()); } 		// graphical speed of movement 	[0-fast 	10-slow]
			catch (InterruptedException e) {  }
		}
	}
	
	public static void setArrowKeyAccX(double ax){arrowKeyAccX = ax;}
	public static void setArrowKeyAccY(double ay){arrowKeyAccY = ay;}
	
	public double getxCurrentSpeed() { return xCurrentSpeed; }
	public double getyCurrentSpeed() { return yCurrentSpeed; }
	
	public Path getPath() { return path; }

}
