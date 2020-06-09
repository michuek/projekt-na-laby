package Window_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
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

import MathPackage.ArrowField;
import Simulation.SimulationSettings;

public class OpenFromBase extends JMenuItem {
	
	BaseFrame frame;
	MainWindow window;
	
	public OpenFromBase(String text, MainWindow w) {//================konstruktor
		super(text);
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
	
	class LocalListener implements ActionListener {//=================LocalListener

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Connection conn;
			try {
				conn = DriverManager.getConnection(	"jdbc:h2:./data/nazwabazyXYZ", "sa", "");
				Statement stmt =conn.createStatement();
				stmt.execute("SELECT * FROM PARAMETERS");
				ResultSet rs = stmt.getResultSet();
				ResultSetMetaData md  = rs.getMetaData();
				rs.next();
				SimulationSettings.setxTrueForceInString(rs.getObject(1).toString());
				SimulationSettings.setyTrueForceInString(rs.getObject(2).toString());
				SimulationSettings.setX0Pos(Double.parseDouble(rs.getObject(3).toString()));
				SimulationSettings.setY0Pos(Double.parseDouble(rs.getObject(4).toString()));
				SimulationSettings.setV0X(Double.parseDouble(rs.getObject(5).toString()));
				SimulationSettings.setV0Y(Double.parseDouble(rs.getObject(6).toString()));
				SimulationSettings.setMass(Double.parseDouble(rs.getObject(7).toString()));
				window.getVectorPanel().arrowField = new ArrowField(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString(), window.getVectorPanel());
				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			AMainClass.frame.repaint();
			JComponent comp = (JComponent) arg0.getSource();
			BaseFrame win = (BaseFrame) SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			
		}
		
	}
	
	class OkListener implements ActionListener {//====================OkListener

		@Override
		public void actionPerformed(ActionEvent e) {
			SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {

				@Override
				protected String doInBackground() throws Exception {
					try {
						Connection conn = DriverManager.getConnection(	frame.baseField.getText(), frame.nickField.getText(), frame.passField.getText());

						Statement stmt =conn.createStatement();
						stmt.execute("SELECT * FROM PARAMETERS");
						ResultSet rs = stmt.getResultSet();
						ResultSetMetaData md  = rs.getMetaData();
						rs.next();
						SimulationSettings.setxTrueForceInString(rs.getObject(1).toString());
						SimulationSettings.setyTrueForceInString(rs.getObject(2).toString());
						SimulationSettings.setX0Pos(Double.parseDouble(rs.getObject(3).toString()));
						SimulationSettings.setY0Pos(Double.parseDouble(rs.getObject(4).toString()));
						SimulationSettings.setV0X(Double.parseDouble(rs.getObject(5).toString()));
						SimulationSettings.setV0Y(Double.parseDouble(rs.getObject(6).toString()));
						SimulationSettings.setMass(Double.parseDouble(rs.getObject(7).toString()));
						window.getVectorPanel().arrowField = new ArrowField(SimulationSettings.getxTrueForceInString(), SimulationSettings.getyTrueForceInString(), window.getVectorPanel());
						
						conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					return null;
				}
				
				@Override
				protected void done() {
					AMainClass.frame.repaint();
					JComponent comp = (JComponent) e.getSource();
					BaseFrame win = (BaseFrame) SwingUtilities.getWindowAncestor(comp);
					win.dispose();
				}
				
			};worker.execute();
			
		}
		
	}
}
