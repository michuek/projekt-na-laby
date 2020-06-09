package Window_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import MathPackage.ArrowField;
import Simulation.Path;
import Simulation.SimulationSettings;

public class MainMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	JMenu menu;
	
	JMenu zapisz;
	SaveToFile doPliku;
	SaveToBase doBazy;
	
	JMenu otworz;
	OpenFromFile zPliku;
	OpenFromBase zBazy;
	
	public static String parameters;

	public MainMenu(MainWindow window) {
		menu = new JMenu("Plik");
		
		otworz = new JMenu("Otwórz");
		zPliku = new OpenFromFile("Z pliku", window);
		otworz.add(zPliku);
		zBazy = new OpenFromBase("Z bazy danych", window);
		otworz.add(zBazy);
		menu.add(otworz);
		
		zapisz = new JMenu("Zapisz");
		doPliku = new SaveToFile("Do pliku", window);
		zapisz.add(doPliku);
		doBazy =  new SaveToBase("Do bazy danych", window);
		zapisz.add(doBazy);
		menu.add(zapisz);

		add(menu);
	}
	
}
