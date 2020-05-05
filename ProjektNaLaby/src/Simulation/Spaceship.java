package Simulation;

import javax.script.ScriptException;

import MathPackage.TextToEquation;
import Window_package.RightPanel;

public class Spaceship 
{
	double xAcceleration;
	double yAcceleration;
	
	double xCurrentSpeed;
	double yCurrentSpeed;
	double xPreviousSpeed;
	double yPreviousSpeed;
	
	double xCurrentPos;
	double yCurrentPos;
	double xPreviousPos;
	double yPreviousPos;
	
	double mass;
	double time;
	double dt;
	
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
		
		xAcceleration =0;
		yAcceleration =0;
		
		mass = SimulationSettings.getMass();
		
		time = SimulationSettings.getTime();
		dt = SimulationSettings.getDt();
	}
	
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
		updateAcceleration(RightPanel.xTrueForceInString, RightPanel.yTrueForceInString);
		updateVelocity();
		updatePosition();
		time = time + dt;
	}

}
