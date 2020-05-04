package MovingObject;

import javax.script.ScriptException;

import MathPackage.TextToEquation;
import Window_package.RightPanel;

public class Spaceship 
{
	double xAcceleration;
	double yAcceleration;
	
	double xCurrentSpeed;
	double yCurrentSpeed;
	double xLastSpeed;
	double yLastSpeed;
	
	double xCurrentPos;
	double yCurrentPos;
	double xLastPos;
	double yLastPos;
	
	double mass;
	
	double time;
	double dt;
	
	public Spaceship() 
	{
		xLastPos = 0;
		yLastPos = 0;
		xCurrentPos =0;
		yCurrentPos =0;
		
		xLastSpeed = 0;
		yLastSpeed = 0;
		xCurrentSpeed =0;
		yCurrentSpeed =0;
		
		xAcceleration =0;
		yAcceleration =0;
		
		mass=1;
		
		time =0;
		dt = 0.01;
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
		
		xCurrentSpeed = xLastSpeed +  (xAcceleration * dt);
		yCurrentSpeed = yLastSpeed +  (yAcceleration * dt);
		
		xLastSpeed = x;
		yLastSpeed = y;
	}
	
	void updatePosition()
	{
		double x = xCurrentPos;
		double y = yCurrentPos;
		
		xCurrentPos = xLastPos + (xCurrentSpeed * dt);
		yCurrentPos = yLastPos + (yCurrentSpeed * dt);
		
		xLastPos = x;
		yLastPos = y;
	}
	
	public void performSimulatingStep ()
	{
		updateAcceleration(RightPanel.xTrueForceInString, RightPanel.yTrueForceInString);
		updateVelocity();
		updatePosition();
		time = time + dt;
	}

}
