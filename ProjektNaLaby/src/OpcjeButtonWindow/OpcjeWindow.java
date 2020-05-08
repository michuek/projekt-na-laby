package OpcjeButtonWindow;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Simulation.SimulationSettings;
import Window_package.VectorPanel;

public class OpcjeWindow extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public OpcjeWindow(VectorPanel vPanel) 
	{
		super("Opcje");
		setSize(500, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		this.add(new SpeedOfSimulationSlider(), BorderLayout.PAGE_START);
		
		JPanel choosingColorPanel = new JPanel();
		choosingColorPanel.setLayout(new GridLayout(2,4));
		
		//SPACESHIP COLOR CHOOSER********************************************
		JButton chooseSpaceshipColor = new JButton("Spaceship color");
		chooseSpaceshipColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setSpaceshipColor(JColorChooser.showDialog(null, "Kolor statku", SimulationSettings.getSpaceshipColor()));
			}
		}); choosingColorPanel.add(chooseSpaceshipColor);
		//END OF SPACESHIP COLOR CHOOSER********************************************
		
		//PATH LOW SPEEED COLOR CHOOSER ********************************************
		JButton chooseSlowPathColor = new JButton("Low speed color");
		chooseSlowPathColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setLOWpath(JColorChooser.showDialog(null, "Kolor œladu przy niskiej prêdkoœci statku", SimulationSettings.getLOWpath()));
			}
		}); choosingColorPanel.add(chooseSlowPathColor);
		//END OF PATH LOW SPEEED COLOR CHOOSER *************************************
		
		
		//PATH HIGH SPEEED COLOR CHOOSER ********************************************
		JButton chooseHighPathColor = new JButton("High speed color");
		chooseHighPathColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setHIGHpath(JColorChooser.showDialog(null, "Kolor œladu przy du¿ej prêdkoœci statku", SimulationSettings.getHIGHpath()));				
			}
		}); choosingColorPanel.add(chooseHighPathColor);
		//END OF PATH HIGH SPEEED COLOR CHOOSER *************************************
		
		choosingColorPanel.add(new JPanel());	//pusty panel dla lepszego ulozenia guzikow w menu
		
		//WEAK FORCE COLOR CHOOSER ********************************************
		JButton chooseWeakForceColor = new JButton("Weak force color");
		chooseWeakForceColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setLOWarrow(JColorChooser.showDialog(null, "Kolor pola o ma³ej sile", SimulationSettings.getLOWarrow()));
				vPanel.arrowField.setProperColorsToArrows();
			}
		}); choosingColorPanel.add(chooseWeakForceColor);
		//END OF PATH HIGH SPEEED COLOR CHOOSER *************************************
		
		
		//STRONG FORCE COLOR CHOOSER ********************************************
		JButton chooseStrongForceColor = new JButton("Strong force color");
		chooseStrongForceColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setHIGHarrow(JColorChooser.showDialog(null, "Kolor pola o du¿ej sile", SimulationSettings.getHIGHarrow()));
				vPanel.arrowField.setProperColorsToArrows();
			}
		}); choosingColorPanel.add(chooseStrongForceColor);
		//END OF PATH HIGH SPEEED COLOR CHOOSER *************************************
		
		
		
		this.add(choosingColorPanel, BorderLayout.CENTER);
	}

}
