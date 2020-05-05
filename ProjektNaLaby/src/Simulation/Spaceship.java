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
	private double xCurrentPos;
	private double yCurrentPos;
	private double mass;
	private double time;
	private double dt;
	
	private Color color = Color.YELLOW;
	private int diameter = 50;
	
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
		xCurrentSpeed += xAcceleration * dt;
		yCurrentSpeed += yAcceleration * dt;
	}
	
	void updatePosition()
	{
		xCurrentPos += xCurrentSpeed * dt;
		yCurrentPos += yCurrentSpeed * dt;
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
	public void paint(Graphics g, VectorPanel vPanel)
	{
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(getColor());
		g2D.fillOval((int) (vPanel.getWidth()/2 + xCurrentPos - diameter/2), (int) (vPanel.getHeight()/2 - yCurrentPos - diameter/2), 50, 50);
    }//END HOW TO DRAW THE SPACESHIP*****************************
	
	
	@Override			
	public void run() 			// PERFORMING SIMULATION
	{
		while (true)
		{
			this.performSimulatingStep();		
			try { Thread.sleep(1); } 		// graphical speed of movement 	[0-fast 	10-slow]
			catch (InterruptedException e) {  }
		}
	}
	
	public Color getColor() { return color; }
	public void setColor(Color color) { this.color = color; }

}
