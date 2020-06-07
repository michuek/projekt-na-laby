package OpcjeButtonWindow;

import java.awt.Color;

import javax.swing.JColorChooser;

import Simulation.SimulationSettings;

public class SpaceskipColorChooser 
{

	public SpaceskipColorChooser() 
	{
		SimulationSettings.setSpaceshipColor(JColorChooser.showDialog(null, "Kolor linii wielkokata", Color.GREEN));
	}

}
