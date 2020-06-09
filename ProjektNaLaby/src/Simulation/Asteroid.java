package Simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.script.ScriptException;

import MathPackage.TextToEquation;
import Window_package.MainClass;
import Window_package.VectorPanel;

public class Asteroid implements Runnable {


	private double xAcceleration;
	private double yAcceleration;
	
	private double xCurrentSpeed;
	private double yCurrentSpeed;
	static private double minV0 = 10;
	static private double maxV0 = 100;
	private double xCurrentPos;
	private double yCurrentPos;
	private double mass;
	static private double minMass = 1.0;
	static private double maxMass = 3.0;
	private int diameter;
	static private int minDiameter = 40;
	static private int maxDiameter = 100;
	private double dt;
	
	static Random r = new Random();
	VectorPanel vPanel = null;
	
	double d2;
	double d3;

	@SuppressWarnings("static-access")
	public Asteroid() {//==========================konstruktor bez argumentu
		vPanel = MainClass.frame.getVectorPanel();
		dt = SimulationSettings.getDt();
		mass = (r.nextDouble() * (maxMass-minMass)) + minMass;
		diameter = r.nextInt(maxDiameter-minDiameter) + minDiameter;
		randomPos();
		d2 = (SimulationSettings.getDiameter() + diameter) * (SimulationSettings.getDiameter() + diameter) / 4;
		d3 = (vPanel.getLaser().getDiameter() + diameter) * (vPanel.getLaser().getDiameter() + diameter) / 4;
	}

	public Asteroid(VectorPanel vPanel) {//================konstruktor z argumentem
		dt = SimulationSettings.getDt();
		mass = (r.nextDouble()+1) * (maxMass-minMass) / 2;
		diameter = 0;
		xCurrentPos = 1500;
		yCurrentPos = 1500;
		d2=0;
	}
	
	void randomPos() {//=========================losuje pozycjê i prêdkoœæ startow¹ asteroidy
		switch(r.nextInt(4))
		{
			case 0:
			{
				xCurrentPos = r.nextInt(vPanel.getWidth()) - (vPanel.getWidth()/2);
				yCurrentPos = vPanel.getHeight()/2 + diameter/2;
				xCurrentSpeed = (r.nextDouble()-0.5)*2*(maxV0 - minV0);
				yCurrentSpeed = -r.nextDouble()*(maxV0 - minV0);
				break;
			}
			case 1:
			{
				xCurrentPos = vPanel.getWidth()/2 + diameter/2;
				yCurrentPos = r.nextInt(vPanel.getHeight()) - (vPanel.getHeight()/2);
				xCurrentSpeed = -r.nextDouble()*(maxV0 - minV0);
				yCurrentSpeed = (r.nextDouble()-0.5)*2*(maxV0-minV0);
				break;
			}
			case 2:
			{
				xCurrentPos = r.nextInt(vPanel.getWidth()) - (vPanel.getWidth()/2);
				yCurrentPos = 10 - vPanel.getHeight()/2 - diameter/2;
				xCurrentSpeed = (r.nextDouble()-0.5)*2*(maxV0 - minV0);
				yCurrentSpeed = r.nextDouble()*(maxV0 - minV0);
				break;
			}
			case 3:
			{
				xCurrentPos = 10 - vPanel.getWidth()/2 - diameter/2;
				yCurrentPos = r.nextInt(vPanel.getHeight()) - (vPanel.getHeight()/2);
				xCurrentSpeed = r.nextDouble()*(maxV0 - minV0);
				yCurrentSpeed = (r.nextDouble()-0.5)*2*(maxV0-minV0);
				break;
			}
		}
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
	
	@SuppressWarnings("static-access")
	public void performSimulatingStep ()
	{
		updateAcceleration(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString());
		updateVelocity();
		updatePosition();//(int) (vPanel.getWidth()/2 + xCurrentPos - diameter/2)
		int x1 = (int) (vPanel.getSpaceship().getxCurrentPos());
		int y1 = (int) (vPanel.getSpaceship().getyCurrentPos());
		int x2 = (int) (xCurrentPos);
		int y2 = (int) (yCurrentPos);
		double d1 = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
		if(d1 < d2)
			{VectorPanel.stopSpaceshipThread();}
		if( (xCurrentPos - diameter) > (vPanel.getWidth()/2) )
			{randomPos();}
		if( (xCurrentPos + diameter) < (-(vPanel.getWidth()/2)) )
			{randomPos();}
		if( (yCurrentPos - diameter) > (vPanel.getHeight()/2) )
			{randomPos();}
		if( (yCurrentPos + diameter) < (-(vPanel.getHeight()/2)) )
			{randomPos();}
		
		x1 = (int) (vPanel.getLaser().getxCurrentPos());
		y1 = (int) (vPanel.getLaser().getyCurrentPos());
		d1 = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
		if(d1 < d3)
		{
			randomPos();
			vPanel.setLaser(new Laser());
		}
	}
	
	@Override
	public void run() {
		while (Spaceship.keepRunning)
		{
			this.performSimulatingStep();		
			try { Thread.sleep(SimulationSettings.getSpeedOfSimulation()); } 		// graphical speed of movement 	[0-fast 	10-slow]
			catch (InterruptedException e) {  }
		}		
	}
	
	//HOW TO DRAW THE SPACESHIP*********************************
	public void paint(Graphics g, VectorPanel vPanel)
	{
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.green);
		g2D.fillOval((int) (vPanel.getWidth()/2 + xCurrentPos - diameter/2), (int) (vPanel.getHeight()/2 - yCurrentPos - diameter/2), diameter, diameter);

	}


}
