package Window_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import Simulation.Path;
import Simulation.SimulationSettings;

public class SaveToFile extends JMenuItem {

	private static final long serialVersionUID = 1L;
	
	BufferedWriter br;
	final String path = "simulation_history.txt";

	public SaveToFile(String arg0, MainWindow window) {
		super(arg0);

		addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setAcceptAllFileFilterUsed(false);		//TYLKO PLIKI TXT DO NADPISANIA
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files", "txt");
				jfc.addChoosableFileFilter(filter);
				int returnValue = jfc.showSaveDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) 
				{
					File selectedFile = jfc.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					if(!path.endsWith(".txt"))
					{
						path= path +".txt";
					}
					try 
					{
						br = new BufferedWriter(new FileWriter(path));
						br.write(MainMenu.parameters);
						br.write('\n');
						copy(window.vectorPanel.getSpaceship().getTotalPathJustForSaving());
						br.close();
					} catch (IOException e1) 
					{
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	
	void copy(Path path) {
		double timeStamp = 0.0;
		try {
			br.write("time");
			br.write('\t');
			br.write("x");
			br.write('\t');
			br.write("y");
			br.write('\t');
			br.write("v");
			br.write('\n');				
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < path.getListOfPositions().size(); i++) 
		{
			try {
				br.write(new Double(timeStamp).toString());
				br.write('\t');
				br.write(new Double(path.getListOfPositions().get(i).getX()).toString());
				br.write('\t');
				br.write(new Double(path.getListOfPositions().get(i).getY()).toString());
				br.write('\t');
				br.write(new Double(path.getListOfSpeeds().get(i)).toString());
				br.write('\n');				
			} catch (IOException e) {
				e.printStackTrace();
			}
			timeStamp += SimulationSettings.getDt();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
