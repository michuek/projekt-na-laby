package Window_package;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import MathPackage.ArrowField;
import Simulation.ExampleSimulations;
import Simulation.Path;
import Simulation.SimulationSettings;


//uzywana przez MainWindow
public class MainMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	JMenu menu;
	JMenuItem otworz;
	JMenuItem zapisz;
	JMenuItem zapiszObraz;
	
	JMenu menuSymulacje;
	JMenuItem symulacja1, symulacja2, symulacja3;
	
	BufferedWriter br;
	final String path = "simulation_history.txt";
	
	public static String parameters;

	public MainMenu(MainWindow window) {
		menu = new JMenu(MainClass.language.getMenuBarText());
		
		otworz = new JMenuItem("Otworz");
		otworz.addActionListener(new ActionListener() {
			
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
		menu.add(otworz);
		
		zapisz = new JMenuItem("Zapisz");
		zapisz.addActionListener(new ActionListener() 
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
						br.write(parameters);
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
		menu.add(zapisz);
		
		zapiszObraz = new JMenuItem("zapisz Obraz");
		zapiszObraz.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				BufferedImage image = new BufferedImage(MainClass.frame.vectorPanel.getWidth(), MainClass.frame.vectorPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d = image.createGraphics();
				MainClass.frame.vectorPanel.paintAll(g2d);
				
				//Okienko z miejscem na podanie nazwy pliku
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) 
				{
					File selectedFile = jfc.getSelectedFile();
					try
					{	//Zapis do pliku
						ImageIO.write(image, "png", selectedFile);
					} 
					catch (IOException event) 
					{	//Okienko z informacja o bledzie
						JOptionPane.showMessageDialog(new JFrame(), "ERROR", "Image can't be saved", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}); menu.add(zapiszObraz);
		
		add(menu);
		
		menuSymulacje = new JMenu(MainClass.language.getMenuReadySimulationsText());
		symulacja1 = new JMenuItem("S1");
		symulacja2 = new JMenuItem("S2");
		symulacja3 = new JMenuItem("S3");
		
		symulacja1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ExampleSimulations.createFirstSimulation();
				
			}
		});menuSymulacje.add(symulacja1);
		
		symulacja2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ExampleSimulations.createSecondSimulation();
				
			}
		});menuSymulacje.add(symulacja2);
		
		
		symulacja3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ExampleSimulations.createThirdSimulation();
				
			}
		});menuSymulacje.add(symulacja3);
		
		
		add(menuSymulacje);
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
