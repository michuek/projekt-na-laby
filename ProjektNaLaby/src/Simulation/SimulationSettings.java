package Simulation;

import java.awt.Color;

public class SimulationSettings 
{
	static double x0Pos=100;
	static double y0Pos=200;
	
	static double v0X = 70;
	static double v0Y = -200;

	static double mass = 1;
	static int diameter = 50;
	
	static double time = 0;
	static double dt = 0.01;
	
	static int speedOfSimulation = 10;
	
	static String xTrueForceInString = "-1*firstVariable";			//domyslne Fx
	static String yTrueForceInString = "-1*secondVariable";			//domyslne Fy
	
	static Color LOWarrow = Color.BLUE;
	static Color HIGHarrow = Color.RED;
	
	static Color LOWpath = Color.DARK_GRAY;
	static Color HIGHpath=Color.WHITE;
	
	static Color spaceshipColor = Color.YELLOW;
	static Color standardPathColor = Color.GREEN;
	
	static boolean coloredPath = true;

	public SimulationSettings() 	//NIEUZYWANY JESZCE
	{
		x0Pos=0;
		y0Pos=0;
		
		v0X=0;
		v0Y=0;
		
		mass=1;
		time=0;
		dt=0.01;
		
		speedOfSimulation = 1;
	}

	//GETTERS AND SETERS*****************************
	public static double getX0Pos() { return x0Pos; }
	public static void setX0Pos(double x0Pos) { SimulationSettings.x0Pos = x0Pos; }
		
	public static double getY0Pos() { return y0Pos; }	
	public static void setY0Pos(double y0Pos) { SimulationSettings.y0Pos = y0Pos; }
		
	public static double getV0X() { return v0X; }
	public static void setV0X(double v0x) { v0X = v0x; }
		
	public static double getV0Y() { return v0Y; }
	public static void setV0Y(double v0y) { v0Y = v0y; }


	public static double getMass() { return mass; }
	public static void setMass(double mass) { SimulationSettings.mass = mass; }
	
	public static int getDiameter() { return diameter; }
		
	public static double getTime() { return time; }
	public static void setTime(double time) { SimulationSettings.time = time; }
		
	public static double getDt() { return dt; }	
	public static void setDt(double dt) { SimulationSettings.dt = dt; }
	
	public static int getSpeedOfSimulation() { return speedOfSimulation; }
	public static void setSpeedOfSimulation(int speedOfSimulation) { SimulationSettings.speedOfSimulation = speedOfSimulation; }

	public static String getxTrueForceInString() { return xTrueForceInString; }
	public static void setxTrueForceInString(String xTrueForceInString) { SimulationSettings.xTrueForceInString = xTrueForceInString; }
		
	public static String getyTrueForceInString() { return yTrueForceInString; }
	public static void setyTrueForceInString(String yTrueForceInString) { SimulationSettings.yTrueForceInString = yTrueForceInString; }
	//END OF GETTERS AND SETERS*****************************

	public static Color getLOWarrow() { return LOWarrow; }
	public static void setLOWarrow(Color lOWarrow) { LOWarrow = lOWarrow; }
		

	public static Color getHIGHarrow() { return HIGHarrow; }
	public static void setHIGHarrow(Color hIGHarrow) { HIGHarrow = hIGHarrow; }
	
	public static Color getLOWpath() { return LOWpath; }
	public static void setLOWpath(Color lOWpath) { LOWpath = lOWpath; }
	public static Color getHIGHpath() { return HIGHpath; }
	public static void setHIGHpath(Color hIGHpath) { HIGHpath = hIGHpath; }
	
	public static Color getSpaceshipColor() { return spaceshipColor; }
	public static void setSpaceshipColor(Color SpaceshipColor) { spaceshipColor = SpaceshipColor; }
	
	public static Color getStandardPathColor() { return standardPathColor; }
	public static void setStandardPathColor(Color StandardPathColor) { standardPathColor = StandardPathColor; }

	public static boolean isColoredPath() { return coloredPath; }
	public static void setColoredPath(boolean coloredPath) { SimulationSettings.coloredPath = coloredPath; }
		
}
