package Window_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import Keyboard_package.Window;
import Simulation.Path;
import Simulation.SimulationSettings;

public class SaveToBase extends JMenuItem {
	
	BaseFrame frame;
	MainWindow window;

	public SaveToBase(String arg0, MainWindow w) {//===============Konstruktor
		super(arg0);	
		window = w;
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame = new BaseFrame();
				frame.setVisible(true);
				
				frame.addLocalListener(new LocalListener());
				frame.addOkListener(new OkListener());
			}
		});
		
	}
	
	class LocalListener implements ActionListener {//==============LocalListener

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Connection conn = DriverManager.getConnection(	"jdbc:h2:./data/nazwabazyXYZ", "sa", "");							

				//=====================================tworzenie tabeli parametrów pocz¹tkowych
				Statement stmt =conn.createStatement();
				stmt.execute("DROP TABLE IF EXISTS PARAMETERS");
				stmt.execute("CREATE TABLE PARAMETERS(" +
				"F_x varchar(255), F_y varchar(255), r_x double, r_y double, v_x double, v_y double, m double" +")");
				
				//=====================================zapisywanie parametrów pocz¹tkowych do tabeli
				PreparedStatement prep = conn.prepareStatement("INSERT into PARAMETERS VALUES (?, ?, ?, ?, ?, ?, ?)");
				String a, b;
				a = new String(MainMenu.parameters);
				b = a.substring(0, a.indexOf('\n'));
				prep.setString(1, b);//============F_x
				a = a.substring(a.indexOf('\n')+1);
				b = a.substring(0, a.indexOf('\n'));
				prep.setString(2, b);//============F_y
				a = a.substring(a.indexOf('\n')+1);
				b = a.substring(0, a.indexOf('\n'));
				prep.setString(3, b);//============r_x
				a = a.substring(a.indexOf('\n')+1);
				b = a.substring(0, a.indexOf('\n'));
				prep.setString(4, b);//============r_y
				a = a.substring(a.indexOf('\n')+1);
				b = a.substring(0, a.indexOf('\n'));
				prep.setString(5, b);//============v_x
				a = a.substring(a.indexOf('\n')+1);
				b = a.substring(0, a.indexOf('\n'));
				prep.setString(6, b);//============v_y
				a = a.substring(a.indexOf('\n')+1);
				b = a.substring(0, a.indexOf('\n'));
				prep.setString(7, b);//============m
				prep.executeUpdate();
				
				//===============================================tworzenie tabeli symulacji
				stmt.execute("DROP TABLE IF EXISTS SIMULATION");
				stmt.execute("CREATE TABLE SIMULATION(" +
				"time double, x double, y double, v double" +")");
				
				//===============================================zapisywanie symulacji do tabeli
				double timeStamp = 0.0;
				Path path = window.vectorPanel.getSpaceship().getPath();
				for(int i = 0; i < path.getListOfPositions().size(); i++)
				{
					prep = conn.prepareStatement("INSERT into SIMULATION VALUES (?, ?, ?, ?)");
					prep.setString(1, new Double(timeStamp).toString());
					prep.setString(2, new Double(path.getListOfPositions().get(i).getX()).toString());
					prep.setString(3, new Double(path.getListOfPositions().get(i).getY()).toString());
					prep.setString(4, new Double(path.getListOfSpeeds().get(i)).toString());
					timeStamp += SimulationSettings.getDt();
				}
				
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			JComponent comp = (JComponent) e.getSource();
			BaseFrame win = (BaseFrame) SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			
		}
		
	}
	
	class OkListener implements ActionListener {//=================OkListener

		@Override
		public void actionPerformed(ActionEvent e) {
			SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {

				@Override
				protected String doInBackground() throws Exception {
						try {
						Connection conn = DriverManager.getConnection(	frame.baseField.getText(), frame.nickField.getText(), frame.passField.getText());
						
						//=====================================tworzenie tabeli parametrów pocz¹tkowych
						Statement stmt =conn.createStatement();
						stmt.execute("DROP TABLE IF EXISTS PARAMETERS");
						stmt.execute("CREATE TABLE PARAMETERS(" +
						"F_x varchar(255), F_y varchar(255), r_x double, r_y double, v_x double, v_y double, m double" +")");
						
						//=====================================zapisywanie parametrów pocz¹tkowych do tabeli
						PreparedStatement prep = conn.prepareStatement("INSERT into PARAMETERS VALUES (?, ?, ?, ?, ?, ?, ?)");
						String a, b;
						a = new String(MainMenu.parameters);
						b = a.substring(0, a.indexOf('\n'));
						prep.setString(1, b);//============F_x
						a = a.substring(a.indexOf('\n')+1);
						b = a.substring(0, a.indexOf('\n'));
						prep.setString(2, b);//============F_y
						a = a.substring(a.indexOf('\n')+1);
						b = a.substring(0, a.indexOf('\n'));
						prep.setString(3, b);//============r_x
						a = a.substring(a.indexOf('\n')+1);
						b = a.substring(0, a.indexOf('\n'));
						prep.setString(4, b);//============r_y
						a = a.substring(a.indexOf('\n')+1);
						b = a.substring(0, a.indexOf('\n'));
						prep.setString(5, b);//============v_x
						a = a.substring(a.indexOf('\n')+1);
						b = a.substring(0, a.indexOf('\n'));
						prep.setString(6, b);//============v_y
						a = a.substring(a.indexOf('\n')+1);
						b = a.substring(0, a.indexOf('\n'));
						prep.setString(7, b);//============m
						prep.executeUpdate();
						
						//===============================================tworzenie tabeli symulacji
						stmt.execute("DROP TABLE IF EXISTS SIMULATION");
						stmt.execute("CREATE TABLE SIMULATION(" +
						"time double, x double, y double, v double" +")");
						
						//===============================================zapisywanie symulacji do tabeli
						double timeStamp = 0.0;
						Path path = window.vectorPanel.getSpaceship().getPath();
						for(int i = 0; i < path.getListOfPositions().size(); i++)
						{
							prep = conn.prepareStatement("INSERT into SIMULATION VALUES (?, ?, ?, ?)");
							prep.setString(1, new Double(timeStamp).toString());
							prep.setString(2, new Double(path.getListOfPositions().get(i).getX()).toString());
							prep.setString(3, new Double(path.getListOfPositions().get(i).getY()).toString());
							prep.setString(4, new Double(path.getListOfSpeeds().get(i)).toString());
							timeStamp += SimulationSettings.getDt();
						}
						
						conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					return null;
				}
				
				@Override
				protected void done() {
					JComponent comp = (JComponent) e.getSource();
					BaseFrame win = (BaseFrame) SwingUtilities.getWindowAncestor(comp);
					win.dispose();	
				}
			};worker.execute();
			
		}
		
	}
	
}
