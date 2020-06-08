package OpcjeButtonWindow;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Simulation.SimulationSettings;
import Window_package.MainClass;
import Window_package.VectorPanel;

public class OpcjeWindow extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public OpcjeWindow(VectorPanel vPanel) 
	{
		super(MainClass.language.getOptionsButtonText());
		setSize(500, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		this.add(new SpeedOfSimulationSlider(), BorderLayout.PAGE_START);
		
		JPanel choosingColorPanel = new JPanel();
		choosingColorPanel.setLayout(new GridLayout(2,5));
		
		//SPACESHIP COLOR CHOOSER********************************************
		JButton chooseSpaceshipColor = new JButton(MainClass.language.getSpaceshipColorText());
		chooseSpaceshipColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setSpaceshipColor(JColorChooser.showDialog(null, MainClass.language.getSpaceshipColorText(), SimulationSettings.getSpaceshipColor()));
			}
		}); choosingColorPanel.add(chooseSpaceshipColor);
		//END OF SPACESHIP COLOR CHOOSER********************************************
		
		//PATH LOW SPEEED COLOR CHOOSER ********************************************
		JButton chooseSlowPathColor = new JButton( MainClass.language.getLowSpeedPathColorButtonText());
		chooseSlowPathColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setLOWpath(JColorChooser.showDialog(null, MainClass.language.getLowSpeedPathColorChooserTitleText(), SimulationSettings.getLOWpath()));
			}
		}); choosingColorPanel.add(chooseSlowPathColor);
		//END OF PATH LOW SPEEED COLOR CHOOSER *************************************
		
		
		//PATH HIGH SPEEED COLOR CHOOSER ********************************************
		JButton chooseHighPathColor = new JButton(MainClass.language.getHighSpeedPathColorButtonText());
		chooseHighPathColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setHIGHpath(JColorChooser.showDialog(null, MainClass.language.getHighSpeedPathColorChooserTitleText(), SimulationSettings.getHIGHpath()));				
			}
		}); choosingColorPanel.add(chooseHighPathColor);
		//END OF PATH HIGH SPEEED COLOR CHOOSER *************************************
		
		choosingColorPanel.add(new JPanel()); //pusty panel aby zachowaæ uk³ad przycisków
		
		//PATH STANDARD COLOR CHOOSER ********************************************
		JButton chooseStandardPathColor = new JButton(MainClass.language.getPathColorButtonText());
		chooseStandardPathColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setStandardPathColor(JColorChooser.showDialog(null, MainClass.language.getPathColorChooserTitleText(), SimulationSettings.getHIGHpath()));
				
			}
		}); choosingColorPanel.add(chooseStandardPathColor);
		//END OF PATHSTANDARD COLOR CHOOSER *************************************
		
		
		
		//WEAK FORCE COLOR CHOOSER ********************************************
		JButton chooseWeakForceColor = new JButton(MainClass.language.getWeakForceColorButtonText());
		chooseWeakForceColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setLOWarrow(JColorChooser.showDialog(null, MainClass.language.getWeakForceColorChooserTitleText(), SimulationSettings.getLOWarrow()));
				VectorPanel.arrowField.setProperColorsToArrows();
			}
		}); choosingColorPanel.add(chooseWeakForceColor);
		//END OF PATH HIGH SPEEED COLOR CHOOSER *************************************
		
		
		//STRONG FORCE COLOR CHOOSER ********************************************
		JButton chooseStrongForceColor = new JButton(MainClass.language.getStrongForceColorButtonText());
		chooseStrongForceColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SimulationSettings.setHIGHarrow(JColorChooser.showDialog(null, MainClass.language.getStrongForceColorChooserTitleText(), SimulationSettings.getHIGHarrow()));
				VectorPanel.arrowField.setProperColorsToArrows();
			}
		}); choosingColorPanel.add(chooseStrongForceColor);
		//END OF PATH HIGH SPEEED COLOR CHOOSER *************************************
		
		//CHOOSING IF PATH SHOULD BE COLORED ==================================================================
				String[] fontStrings = { MainClass.language.getPathColoredOptionText() , MainClass.language.getPathUncoloredOptionText() };
				JComboBox<String> jComboBox = new JComboBox<>(fontStrings);
				JComboBox<String> chooserPathColor = jComboBox;
				if (SimulationSettings.isColoredPath())
				{
					chooserPathColor.setSelectedIndex(0);
				}
				else
				{
					chooserPathColor.setSelectedIndex(1);
				}
				
				chooserPathColor.addActionListener(new ActionListener()
				{	
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						@SuppressWarnings("unchecked")
						JComboBox<String> cb = (JComboBox<String>)e.getSource();
						String colored = (String)cb.getSelectedItem();
						
						if(colored == MainClass.language.getPathColoredOptionText())
						{
							SimulationSettings.setColoredPath(true);
							vPanel.getSpaceship().getPath().setProperColorsToPath();
						}	
				        if(colored == MainClass.language.getPathUncoloredOptionText())
				        {
				        	SimulationSettings.setColoredPath(false);
				        	vPanel.getSpaceship().getPath().changePathColorIntoStandardColor();
				        }
				        	
					}
				});
				choosingColorPanel.add(chooserPathColor);
				//END OF CHOOSING IF PATH SHOULD BE COLORED ============================================================
		
		
		
		this.add(choosingColorPanel, BorderLayout.CENTER);
	}

}
