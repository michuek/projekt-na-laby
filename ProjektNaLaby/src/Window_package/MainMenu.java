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
	
	static BaseFrame frame = new BaseFrame();

	private static final long serialVersionUID = 1L;
	JMenu menu;
	JMenu otworz;
	JMenu zapisz;
	OpenFromFile openFromFile;
	OpenFromBase openFromBase;
	SaveToFile saveToFile;
	SaveToBase saveToBase;
	JMenuItem zapiszObraz;
	
	JMenu menuSymulacje;
	JMenuItem symulacja1, symulacja2, symulacja3;
	
	BufferedWriter br;
	final String path = "simulation_history.txt";
	
	public static String parameters;

	public MainMenu(MainWindow window) {
		menu = new JMenu(MainClass.language.getMenuBarText());
		
		otworz = new JMenu("Otworz");
		openFromFile = new OpenFromFile("Z pliku", window);
		otworz.add(openFromFile);
		openFromBase = new OpenFromBase("Z bazy", window);
		otworz.add(openFromBase);
		menu.add(otworz);
		
		zapisz = new JMenu("Zapisz");
		saveToFile = new SaveToFile("Do pliku", window);
		zapisz.add(saveToFile);
		saveToBase = new SaveToBase("Do bazy", window);
		zapisz.add(saveToBase);
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

}
