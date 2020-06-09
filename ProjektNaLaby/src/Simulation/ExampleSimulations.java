package Simulation;

import MathPackage.ArrowField;
import Window_package.MainClass;

public abstract class ExampleSimulations 
{

	public ExampleSimulations() 
	{
		
	}
	
	@SuppressWarnings("static-access")
	public static void createFirstSimulation()
	{
		SimulationSettings.x0Pos=10;
		SimulationSettings.y0Pos = -77;
		SimulationSettings.v0X =14;
		SimulationSettings.v0Y=90;
		SimulationSettings.mass=0.7;
		MainClass.frame.getVectorPanel().arrowField = new ArrowField(SimulationSettings.xTrueForceInString, SimulationSettings.yTrueForceInString, MainClass.frame.getVectorPanel());
	}
	
	@SuppressWarnings("static-access")
	public static void createSecondSimulation()
	{
		SimulationSettings.x0Pos=107;
		SimulationSettings.y0Pos = -277;
		SimulationSettings.v0X =14;
		SimulationSettings.v0Y=-22;
		SimulationSettings.mass=4;
		SimulationSettings.xTrueForceInString = "firstVariable / secondVariable";
		SimulationSettings.yTrueForceInString = "-1*secondVariable+firstVariable";
		MainClass.frame.getVectorPanel().arrowField = new ArrowField(SimulationSettings.xTrueForceInString, SimulationSettings.yTrueForceInString, MainClass.frame.getVectorPanel());
	}
	
	@SuppressWarnings("static-access")
	public static void createThirdSimulation()
	{
		SimulationSettings.x0Pos=-200;
		SimulationSettings.y0Pos = 10;
		SimulationSettings.v0X =4;
		SimulationSettings.v0Y=-0;
		SimulationSettings.mass=0.2;
		SimulationSettings.xTrueForceInString = "Math.sqrt(Math.abs(firstVariable / secondVariable))";
		SimulationSettings.yTrueForceInString = "2";
		MainClass.frame.getVectorPanel().arrowField = new ArrowField(SimulationSettings.xTrueForceInString, SimulationSettings.yTrueForceInString, MainClass.frame.getVectorPanel());
	}

}
