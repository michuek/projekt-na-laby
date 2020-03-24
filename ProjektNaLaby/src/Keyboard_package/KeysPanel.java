package Keyboard_package;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class KeysPanel extends JPanel {
	
	final int gridRows = 4;
	final int gridColumns = 5;
	final int gridHgap = 5;
	final int gridVgap = 5;
	
	JButton[] digits;
	
	JButton plus;
	JButton minus;
	JButton times;
	JButton divided;
	JButton equals;
	JButton backspace;
	JButton decimalPoint;
	JButton left;
	JButton right;
	JButton ok;
	
	int fontSize;

	public KeysPanel(Window frame) {
		setLayout(new GridLayout(gridRows, gridColumns, gridHgap, gridVgap));
		fontSize = 30;
		
		digits = new JButton[10];
		
		plus = new JButton("+");
		plus.setFont(new Font(null, Font.PLAIN, fontSize));
		minus = new JButton("-");
		minus.setFont(new Font(null, Font.PLAIN, fontSize));
		times = new JButton("*");
		times.setFont(new Font(null, Font.PLAIN, fontSize));
		divided = new JButton("/");
		divided.setFont(new Font(null, Font.PLAIN, fontSize));
		equals = new JButton("=");
		equals.setFont(new Font(null, Font.PLAIN, fontSize));
		backspace = new JButton("<--");
		backspace.setFont(new Font(null, Font.PLAIN, fontSize));
		decimalPoint = new JButton(".");
		decimalPoint.setFont(new Font(null, Font.PLAIN, fontSize));
		left = new JButton("<");
		left.setFont(new Font(null, Font.PLAIN, fontSize));
		right = new JButton(">");
		right.setFont(new Font(null, Font.PLAIN, fontSize));
		ok = new JButton("ok");
		ok.setFont(new Font(null, Font.PLAIN, fontSize));
		
		plus.setActionCommand(plus.getText());
		minus.setActionCommand(minus.getText());
		times.setActionCommand(times.getText());
		divided.setActionCommand(divided.getText());
		equals.setActionCommand(equals.getText());
		backspace.setActionCommand(backspace.getText());
		decimalPoint.setActionCommand(decimalPoint.getText());
		left.setActionCommand(left.getText());
		right.setActionCommand(right.getText());
		ok.setActionCommand(ok.getText());
		
		for(int i = 0; i < 10; i++)
		{
			digits[i] = new JButton((new Integer(i)).toString());
			digits[i].setActionCommand((new Integer(i)).toString());
			digits[i].setFont(new Font(null, Font.PLAIN, fontSize));
		}
		add(digits[7]);
		add(digits[8]);
		add(digits[9]);
		add(times);
		add(divided);
		add(digits[4]);
		add(digits[5]);
		add(digits[6]);
		add(plus);
		add(minus);
		add(digits[1]);
		add(digits[2]);
		add(digits[3]);
		add(equals);
		add(backspace);
		add(digits[0]);
		add(decimalPoint);
		add(left);
		add(right);
		add(ok);
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}

