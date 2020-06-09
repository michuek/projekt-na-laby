package Window_package;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BaseFrame extends JFrame {

	private JPanel topPanel;
	JButton localButton;
	JButton externalButton;
	
	private JPanel centerPanel;
	JPanel basePanel;
	JLabel baseLabel;
	JTextField baseField;
	JPanel nickPanel;
	JLabel nickLabel;
	JTextField nickField;
	JPanel passPanel;
	JLabel passLabel;
	JTextField passField;
	JPanel okPanel;
	JButton okButton;
	
	//==================================================konstruktor
		public BaseFrame() throws HeadlessException {
			super("Wybierz bazê danych");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setSize(450, 94);
			
			topPanel = new JPanel(new FlowLayout());
			add(topPanel, BorderLayout.PAGE_START);
			
			localButton = new JButton("Lokalna");
			topPanel.add(localButton);
			
			topPanel.add(new JLabel("     "));
			
			externalButton = new JButton("Zewnêtrzna");
			externalButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setSize(450, 250);
					
				}
			});
			topPanel.add(externalButton);
			
			centerPanel = new JPanel(new GridLayout(4, 1));
			add(centerPanel, BorderLayout.CENTER);
			
			//==========================nazwa bazy
			basePanel = new JPanel(new FlowLayout());
			baseLabel = new JLabel("Nazwa bazy:                ");
			baseField = new JTextField();
			baseField.setPreferredSize(new Dimension(200, 24));
			baseField.setText("jdbc:mysql://db4free.net/macialowicz_baza");
			basePanel.add(baseLabel);
			basePanel.add(baseField);
			centerPanel.add(basePanel);
			
			//==========================nazwa u¿ytkownika
			nickPanel = new JPanel(new FlowLayout());
			nickLabel = new JLabel("Nazwa u¿ytkownika: ");
			nickField = new JTextField();
			nickField.setPreferredSize(new Dimension(200, 24));
			nickField.setText("macialowicz");
			nickPanel.add(nickLabel);
			nickPanel.add(nickField);
			centerPanel.add(nickPanel);
			
			//==========================has³o
			passPanel = new JPanel(new FlowLayout());
			passLabel = new JLabel("Has³o:                           ");
			passField = new JTextField();
			passField.setPreferredSize(new Dimension(200, 24));
			passField.setText("macialowicz_haslo");
			passPanel.add(passLabel);
			passPanel.add(passField);
			centerPanel.add(passPanel);
			
			//==========================ok
			okPanel = new JPanel(new FlowLayout());
			okButton = new JButton("Ok");
			okPanel.add(okButton);
			centerPanel.add(okPanel);
		}
		
		public String getTekst(int i) {//===================funkcja zwracaj¹ca dane wpisane w JTextFieldy
			switch(i) {
			case 1:
				return baseField.getText();
			case 2:
				return nickField.getText();
			case 3:
				return passField.getText();
			default:
				return null;
			}
		}
		
		//==================================================dodawanie listenerów
		public void addLocalListener(ActionListener a) {localButton.addActionListener(a); }
		public void addOkListener(ActionListener a) { okButton.addActionListener(a); }


}
