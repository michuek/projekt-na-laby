package Simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.script.ScriptException;

import MathPackage.TextToEquation;
import Window_package.VectorPanel;

public class Spaceship implements Runnable
{
	private double xAcceleration;
	private double yAcceleration;
	
	private double xCurrentSpeed;
	private double yCurrentSpeed;
	private double xPreviousSpeed;
	private double yPreviousSpeed;
	
	private double xCurrentPos;
	private double yCurrentPos;
	private double xPreviousPos;
	private double yPreviousPos;
	
	private double mass;
	private double time;
	private double dt;
	
	private Color color = Color.YELLOW;
	private int sizeOfSpaceship = 20; 
	
	public Spaceship() 
	{
		xPreviousPos = SimulationSettings.getX0Pos();
		yPreviousPos = SimulationSettings.getY0Pos();
		xCurrentPos = SimulationSettings.getX0Pos();
		yCurrentPos = SimulationSettings.getY0Pos();
		
		xPreviousSpeed = SimulationSettings.getV0X();
		yPreviousSpeed = SimulationSettings.getV0Y();
		xCurrentSpeed = SimulationSettings.getV0X();
		yCurrentSpeed = SimulationSettings.getV0Y();
		
		mass = SimulationSettings.getMass();
		
		time = SimulationSettings.getTime();
		dt = SimulationSettings.getDt();
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
	
	void updateVelocity ()
	{
		double x = xCurrentSpeed;
		double y = yCurrentSpeed;
		
		xCurrentSpeed = xPreviousSpeed +  (xAcceleration * dt);
		yCurrentSpeed = yPreviousSpeed +  (yAcceleration * dt);
		
		xPreviousSpeed = x;
		yPreviousSpeed = y;
	}
	
	void updatePosition()
	{
		double x = xCurrentPos;
		double y = yCurrentPos;
		
		xCurrentPos = xPreviousPos + (xCurrentSpeed * dt);
		yCurrentPos = yPreviousPos + (yCurrentSpeed * dt);
		
		
		xPreviousPos = x;
		yPreviousPos = y;
	}
	
	public void performSimulatingStep ()
	{
		
		updateAcceleration(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString());
		updateVelocity();
		updatePosition();
		
		time = time + dt;
	}
	//END OF HOW TO PERFORM SIMULATION ************************
	
	//HOW TO DRAW THE SPACESHIP*********************************
	public void paint(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(getColor());
		g2D.fillOval((int) (VectorPanel.width/2 + xCurrentPos - sizeOfSpaceship/2), (int) (VectorPanel.height/2 - yCurrentPos - sizeOfSpaceship/2), sizeOfSpaceship, sizeOfSpaceship);
    }//END HOW TO DRAW THE SPACESHIP*****************************
	
	
	@Override			
	public void run() 			// PERFORMING SIMULATION
	{
		while (true)
		{
			this.performSimulatingStep();		
			try { Thread.sleep(0); } 		// graphical speed of movement 	[0-fast 	10-slow]
			catch (InterruptedException e) {  }
		}
	}
	
	public Color getColor() { return color; }
	public void setColor(Color color) { this.color = color; }

}
