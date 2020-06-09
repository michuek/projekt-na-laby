package Window_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import MathPackage.ArrowField;
import Simulation.SimulationSettings;

public class OpenFromFile extends JMenuItem {

	public OpenFromFile(String text, MainWindow window) {
		super(text);
		
		addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setAcceptAllFileFilterUsed(false);		//TYLKO PLIKI TXT DO NADPISANIA
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files", "txt");
				jfc.addChoosableFileFilter(filter);
				int returnValue = jfc.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION)
				{
					try {
						LineNumberReader lr = new LineNumberReader(new FileReader(jfc.getSelectedFile()));
						SimulationSettings.setxTrueForceInString(lr.readLine());
						SimulationSettings.setyTrueForceInString(lr.readLine());
						SimulationSettings.setX0Pos(Double.parseDouble(lr.readLine()));
						SimulationSettings.setY0Pos(Double.parseDouble(lr.readLine()));
						SimulationSettings.setV0X(Double.parseDouble(lr.readLine()));
						SimulationSettings.setV0Y(Double.parseDouble(lr.readLine()));
						SimulationSettings.setMass(Double.parseDouble(lr.readLine()));
						window.getVectorPanel().arrowField = new ArrowField(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString(), window.getVectorPanel());
						lr.close();
					} catch (IOException e) {
					e.printStackTrace();
					}
				}
				
			}
		});
	}
}
