package Keyboard_package;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Window extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	JTextField field;
	int fontSize;
	String written;
	List<String> printedHistory = new LinkedList<String>();
	
	KeysPanel keysPanel;
	
	public Window(String arg0, JTextField f) throws HeadlessException {
		super(arg0);
		setSize(600, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		written = "";
		field = new JTextField("Text");
		fontSize = 40;
		field.setFont(new Font(null, Font.PLAIN, fontSize));
		add(field, BorderLayout.PAGE_START);
		
		keysPanel = new KeysPanel(this, f);
		add(keysPanel, BorderLayout.CENTER);
		
		for(int i = 0; i < 10; i++) { keysPanel.digits[i].addActionListener(new KeysListener()); }
		
		keysPanel.plus.addActionListener(new KeysListener());
		keysPanel.minus.addActionListener(new KeysListener());
		keysPanel.times.addActionListener(new KeysListener());
		keysPanel.divided.addActionListener(new KeysListener());
		keysPanel.coma.addActionListener(new KeysListener());
		keysPanel.backspace.addActionListener(new BackspaceListener());
		keysPanel.decimalPoint.addActionListener(new KeysListener());
		
		keysPanel.leftBracket.addActionListener(new KeysListener());
		keysPanel.rightBracket.addActionListener(new KeysListener());
		keysPanel.piValueButton.addActionListener(new KeysListener());
		keysPanel.eValueButton.addActionListener(new KeysListener());
		keysPanel.power.addActionListener(new KeysListener());
		keysPanel.squareRoot.addActionListener(new KeysListener());
		keysPanel.absoluteValue.addActionListener(new KeysListener());
		keysPanel.sinus.addActionListener(new KeysListener());
		keysPanel.cosinus.addActionListener(new KeysListener());
		keysPanel.tangens.addActionListener(new KeysListener());
		keysPanel.arcusSinus.addActionListener(new KeysListener());
		keysPanel.arcusCosinus.addActionListener(new KeysListener());
		keysPanel.arcusTangens.addActionListener(new KeysListener());
		keysPanel.exp.addActionListener(new KeysListener());
		keysPanel.naturalLogarythm.addActionListener(new KeysListener());
		keysPanel.firtstVariableButoon.addActionListener(new KeysListener());
		keysPanel.secondVariableButton.addActionListener(new KeysListener());
	}
	
	
	class KeysListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			printedHistory.add(e.getActionCommand());
			written += e.getActionCommand();
			field.setText(written);
			field.grabFocus();
		}
	}
	
	
	class BackspaceListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				String lastClick = printedHistory.get(printedHistory.size()-1);
				int newLength = written.length() - lastClick.length() ;
				written = written.substring(0, newLength);
				field.setText(written);
				field.setCaretPosition(written.length());
				printedHistory.remove(printedHistory.size()-1);
			} catch (Exception e2) {} //do nothing
		}
	}
	
	public KeysPanel getKeysPanel() { return (keysPanel); }

}