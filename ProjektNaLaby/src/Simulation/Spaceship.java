package Simulation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import javax.script.ScriptException;

import MathPackage.TextToEquation;
import Window_package.VectorPanel;

public class Spaceship implements Runnable
{
	private double xAcceleration;
	private double yAcceleration;
	
	public static double arrowKeyAccX = 0.0;
	public static double arrowKeyAccY = 0.0;
	public static double thrust = 500.0;
	public static boolean keepRunning = false;
	
	private double xCurrentSpeed;
	private double yCurrentSpeed;
	private double xCurrentPos;
	private double yCurrentPos;
	private double mass;
	private double time;
	private double dt;
	
	
	
	private int diameter;
	private List<Path> ListOfPaths;
	private Path path;
	Path totalPathJustForSaving;
	double totalMaksSpeed=1;
	double totalLowestSpeed=0;
	double totalMaksDeltaSpeed =1;
	double ratio =0;
	public Spaceship() 
	{
		diameter = SimulationSettings.getDiameter();
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
		ListOfPaths = new LinkedList<Path>();
		path = new Path(2, this);
		totalPathJustForSaving = new Path(2, this);
		//Thread t1 = new Thread (path);
		//t1.start();
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
	
	synchronized void updateVelocity (boolean colored)
	{ 
		path.addSpeedToPath(Math.sqrt(xCurrentSpeed*xCurrentSpeed + yCurrentSpeed*yCurrentSpeed));
		totalPathJustForSaving.addSpeedToPath(Math.sqrt(xCurrentSpeed*xCurrentSpeed + yCurrentSpeed*yCurrentSpeed));
		xCurrentSpeed += (xAcceleration + arrowKeyAccX) * dt;
		yCurrentSpeed += (yAcceleration + arrowKeyAccY) * dt;	
	}
	
	synchronized void updatePosition()
	{
		path.addPositionToPath(new Point((int) xCurrentPos, (int)yCurrentPos));
		totalPathJustForSaving.addPositionToPath(new Point((int) xCurrentPos, (int)yCurrentPos));
		xCurrentPos += xCurrentSpeed * dt;
		yCurrentPos += yCurrentSpeed * dt;
	}
	
	synchronized void  checkTimeIfNewPathIsNeeded()
	{
		if(ListOfPaths.size() ==1 )
		{
			totalLowestSpeed = ListOfPaths.get(0).lowestSpeed;
			totalMaksSpeed = ListOfPaths.get(0).maksSpeed;		}
		if (Math.ceil(time*5)>ListOfPaths.size())
		{
			ListOfPaths.add(path);
			if(path.lowestSpeed<totalLowestSpeed)
			{
				totalLowestSpeed = path.lowestSpeed;
				totalMaksDeltaSpeed = totalMaksSpeed - totalLowestSpeed;
			}
			if (path.maksSpeed > totalMaksSpeed)
			{
				totalMaksSpeed = path.maksSpeed;
				totalMaksDeltaSpeed = totalMaksSpeed - totalLowestSpeed;
			}
			updateTotalPathColor();
			path = new Path(2, this);
			path.ListOfColors.add( ListOfPaths.get(ListOfPaths.size()-1).getLastColor());
			path.ListOfPositions.add( ListOfPaths.get(ListOfPaths.size()-1).getLastPosition());
			path.ListOfSpeeds.add( ListOfPaths.get(ListOfPaths.size()-1).getLastSpeed());
			
		}
		
	}
		
	public void performSimulatingStep (boolean colored)
	{
		
		updateAcceleration(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString());
		updateVelocity(colored);
		updatePosition();
		checkTimeIfNewPathIsNeeded();
		time = time + dt;
	}
	//END OF HOW TO PERFORM SIMULATION ************************
	
	//HOW TO DRAW THE SPACESHIP*********************************
	public synchronized void paint(Graphics g, VectorPanel vPanel)
	{
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(SimulationSettings.getSpaceshipColor());
		g2D.fillOval((int) (vPanel.getWidth()/2 + xCurrentPos - diameter/2), (int) (vPanel.getHeight()/2 - yCurrentPos - diameter/2), 50, 50);
		path.paint(g2D, vPanel);
		for (Path p : ListOfPaths)
		{
			p.paint(g2D, vPanel);
		}
    }//END HOW TO DRAW THE SPACESHIP*****************************
	
	
	@Override			
	public  void run() 			// PERFORMING SIMULATION
	{
		while (keepRunning)
		{
			this.performSimulatingStep(SimulationSettings.isColoredPath());		
			try 
			{ 
				Thread.sleep(SimulationSettings.getSpeedOfSimulation());
			} 		
			catch (InterruptedException e) {  }
		}
			
	}
	
	
	synchronized void updateTotalPathColor()
	{
		for (Path p :ListOfPaths)
		{
			p.setProperColorsToPath();
		}
	}
	
	synchronized Path getLastPath()
	{
		return (ListOfPaths.get(ListOfPaths.size()-1));
	}
	
	
	
	public static void setArrowKeyAccX(double ax){arrowKeyAccX = ax;}
	public static void setArrowKeyAccY(double ay){arrowKeyAccY = ay;}
	
	public double getxCurrentSpeed() { return xCurrentSpeed; }
	public double getyCurrentSpeed() { return yCurrentSpeed; }
	
	public double getxCurrentPos() { return xCurrentPos; }
	public double getyCurrentPos() { return yCurrentPos; }
	
	public Path getPath() { return path; }


	public List<Path> getListOfPaths() {
		return ListOfPaths;
	}

	public void setListOfPaths(List<Path> listOfPaths) {
		ListOfPaths = listOfPaths;
	}


	public Path getTotalPathJustForSaving() {
		return totalPathJustForSaving;
	}


	public void setTotalPathJustForSaving(Path totalPathJustForSaving) {
		this.totalPathJustForSaving = totalPathJustForSaving;
	}

}
