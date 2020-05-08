package Simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import Window_package.VectorPanel;

public class Path implements Runnable
{
	int pathRadius;
	List<Point> ListOfPositions;
	List<Double> ListOfSpeeds;
	List<Color> ListOfColors;
	//Color LOW = SimulationSettings.g;
	//Color HIGH = Color.WHITE;
	
	Double maksSpeed;
	Double lowestSpeed;
	Double maksDeltaSpeed = 1.0;

	public Path(int pathRadius, Spaceship ship) 
	{
		super();
		this.pathRadius = pathRadius;
		ListOfPositions  = new LinkedList<Point>();
		ListOfSpeeds = new LinkedList<Double>();
		ListOfColors = new LinkedList<Color>();
		
		maksSpeed = Math.sqrt(ship.getxCurrentSpeed()*ship.getxCurrentSpeed() + ship.getyCurrentSpeed()*ship.getyCurrentSpeed());
		lowestSpeed = maksSpeed;
	}
	
	public void addPositionToPath (Point p)
	{
		ListOfPositions.add(p);
	}
	
	
	public void addSpeedToPath (Double v)
	{
		ListOfSpeeds.add(v);
		if (v > maksSpeed )	
		{
			maksSpeed = v;
			maksDeltaSpeed = maksSpeed - lowestSpeed;
			ListOfColors.add(SimulationSettings.getHIGHpath());	
			//setProperColorsToPath();
		}
		else if (v <lowestSpeed) 
		{
			lowestSpeed = v;
			maksDeltaSpeed = maksSpeed - lowestSpeed;
			ListOfColors.add(SimulationSettings.getLOWpath());
			//setProperColorsToPath();
		}
		else 
		{
			double ratio = (v-lowestSpeed)/(maksDeltaSpeed);
			addColorRatioToList(ratio);
		}
	}
	
	void addColorRatioToList (double ratio)
	{
		int red = (int)Math.abs((ratio * SimulationSettings.getHIGHpath().getRed()) + ((1 - ratio) * SimulationSettings.getLOWpath().getRed()));
		int green = (int)Math.abs((ratio * SimulationSettings.getHIGHpath().getGreen()) + ((1 - ratio) * SimulationSettings.getLOWpath().getGreen()));
		int blue = (int)Math.abs((ratio * SimulationSettings.getHIGHpath().getBlue()) + ((1 - ratio) * SimulationSettings.getLOWpath().getBlue()));
		ListOfColors.add(new Color(red, green, blue));
	}
	
	void setProperColorsToPath()
	{
		for (int i=0; i<ListOfSpeeds.size(); i++)
		{
			//ratio is from range [0 , 1]
			double ratio = (ListOfSpeeds.get(i) - lowestSpeed) / maksDeltaSpeed;
			int red = (int)Math.abs((ratio * SimulationSettings.getHIGHpath().getRed()) + ((1 - ratio) * SimulationSettings.getLOWpath().getRed()));
			int green = (int)Math.abs((ratio * SimulationSettings.getHIGHpath().getGreen()) + ((1 - ratio) * SimulationSettings.getLOWpath().getGreen()));
			int blue = (int)Math.abs((ratio * SimulationSettings.getHIGHpath().getBlue()) + ((1 - ratio) * SimulationSettings.getLOWpath().getBlue()));
			ListOfColors.set(i, new Color(red, green, blue));
		}
	}
	
	
	//HOW TO DRAW THE PATH********************************* VERSION WITH ADJUSTABLE COLOR 
		public void paint(Graphics g, VectorPanel vPanel)
		{
			Graphics2D g2D = (Graphics2D) g;
			for(int i=0; i<ListOfPositions.size() - 1; i++)
			{
				g2D.setColor(ListOfColors.get(i));
				g2D.fillOval(vPanel.getWidth()/2 + ListOfPositions.get(i).x-pathRadius, vPanel.getHeight()/2 - ListOfPositions.get(i).y-pathRadius, pathRadius*2, pathRadius*2);
			}
		}//END HOW TO DRAW THE PATH*****************************

		
		
	@Override
	public void run() 
	{
		while (true)
		{
			this.setProperColorsToPath();
			try { Thread.sleep(1000); } 		//co 1s aktualizuje kolor sciezki
			catch (InterruptedException e) {  }
		}
		
	}
	
		

}
