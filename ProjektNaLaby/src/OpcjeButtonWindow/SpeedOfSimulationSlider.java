package OpcjeButtonWindow;

import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Simulation.SimulationSettings;
import Window_package.MainClass;

public class SpeedOfSimulationSlider extends JSlider implements ChangeListener
{
	private static final long serialVersionUID = 1L;

	int sliderMinValue = 1;
	int sliderMaxValue = 40;
	
	public SpeedOfSimulationSlider() 
	{
		super();
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put( sliderMinValue, new JLabel(MainClass.language.getFastSpeedOfSimulationText()));
		labelTable.put((sliderMaxValue - sliderMinValue)/2 , new JLabel(MainClass.language.getSpeedOfsimulationSliderText()));
		labelTable.put( sliderMaxValue, new JLabel(MainClass.language.getSlowSpedOfSimulationText()) );
		this.setInverted(true);
		
		this.setLabelTable( labelTable );
		this.setMaximum(sliderMaxValue);
		this.setMinimum(sliderMinValue);
		this.setValue(SimulationSettings.getSpeedOfSimulation());
		this.setMajorTickSpacing((sliderMaxValue - sliderMinValue)/5);
		this.setMinorTickSpacing((sliderMaxValue - sliderMinValue)/20);
		this.setPaintTicks(true);
		this.setPaintLabels(true);
		this.addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) 
	{
		SimulationSettings.setSpeedOfSimulation(this.getValue());
	}

}
