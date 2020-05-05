package Simulation;

public class SimulationSettings 
{
	static double x0Pos;
	static double y0Pos;
	
	static double v0X;
	static double v0Y;

	static double mass;
	
	static double time;
	static double dt;
	
	static double speedOfSimulation;
	

	public SimulationSettings() 
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
		
	public static double getTime() { return time; }
	public static void setTime(double time) { SimulationSettings.time = time; }
		
	public static double getDt() { return dt; }	
	public static void setDt(double dt) { SimulationSettings.dt = dt; }
	
	public static double getSpeedOfSimulation() { return speedOfSimulation; }
	public static void setSpeedOfSimulation(double speedOfSimulation) { SimulationSettings.speedOfSimulation = speedOfSimulation; }
	//END OF GETTERS AND SETERS*****************************

}
