package Window_package;

import java.awt.BasicStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JMenuBar {
	
	JMenu menu;
	JMenuItem menuItem1;
	JMenuItem menuItem2;
	JMenuItem menuItem3;

	public MainMenu() {
		menu = new JMenu("Menu");
		menuItem1 = new JMenuItem("Opcja 1");
		menu.add(menuItem1);
		
		menuItem2 = new JMenuItem("Opcja 2");
		menu.add(menuItem2);
		
		menuItem3 = new JMenuItem("Opcja 3");
		menu.add(menuItem3);
		add(menu);
	}

}
