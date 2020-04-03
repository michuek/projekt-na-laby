package Keyboard_package;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import MathPackage.TextToEquation;

public class KeysPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;

	String prawdziwyEfektKlikania;
	
	final int gridRows = 5;
	final int gridColumns = 7;
	final int gridHgap = 5;
	final int gridVgap = 5;
	int fontSize;
	
	JButton[] digits;
	JButton plus;
	JButton minus;
	JButton times;
	JButton divided;
	JButton coma;
	JButton backspace;
	JButton decimalPoint;
	JButton left;
	JButton right;
	JButton leftBracket;		
	JButton rightBracket; 		
	JButton squareRoot;			
	JButton absoluteValue;		
	JButton sinus;				
	JButton cosinus;			
	JButton tangens;			
	JButton naturalLogarythm;	
	JButton power;				
	JButton exp;				
	JButton arcusSinus;			
	JButton arcusCosinus;		
	JButton arcusTangens;		
	JButton firtstVariableButoon;	
	JButton secondVariableButton;	
	JButton piValueButton;			
	JButton eValueButton;		
	JButton ok;
	
	//KONSTRUKTOR KLAWIATURY===================================================================
	public KeysPanel(Window frame) 
	{
		setLayout(new GridLayout(gridRows, gridColumns, gridHgap, gridVgap));
		fontSize = 15;
		prawdziwyEfektKlikania = new  String();
		digits = new JButton[10];
		
		plus = new JButton("+");
		plus.setFont(new Font(null, Font.PLAIN, fontSize));
		minus = new JButton("-");
		minus.setFont(new Font(null, Font.PLAIN, fontSize));
		times = new JButton("*");
		times.setFont(new Font(null, Font.PLAIN, fontSize));
		divided = new JButton("/");
		divided.setFont(new Font(null, Font.PLAIN, fontSize));
		coma = new JButton(";");
		coma.setFont(new Font(null, Font.PLAIN, fontSize));
		backspace = new JButton("<--");
		backspace.setFont(new Font(null, Font.PLAIN, fontSize));
		decimalPoint = new JButton(".");
		decimalPoint.setFont(new Font(null, Font.PLAIN, fontSize));
		left = new JButton("<");
		left.setFont(new Font(null, Font.PLAIN, fontSize));
		right = new JButton(">");
		right.setFont(new Font(null, Font.PLAIN, fontSize));
		leftBracket = new JButton("(");
		leftBracket.setFont(new Font(null, Font.PLAIN, fontSize));
		rightBracket = new JButton(")");
		rightBracket.setFont(new Font(null, Font.PLAIN, fontSize));
		squareRoot = new JButton("sqrt(");
		squareRoot.setFont(new Font(null, Font.PLAIN, fontSize));
		absoluteValue = new JButton("abs(");
		absoluteValue.setFont(new Font(null, Font.PLAIN, fontSize));
		sinus = new JButton("sin(");
		sinus.setFont(new Font(null, Font.PLAIN, fontSize));
		cosinus = new JButton("cos(");
		cosinus.setFont(new Font(null, Font.PLAIN, fontSize));
		tangens = new JButton("tan(");
		tangens.setFont(new Font(null, Font.PLAIN, fontSize));
		naturalLogarythm = new JButton("ln(");
		naturalLogarythm.setFont(new Font(null, Font.PLAIN, fontSize));
		power =  new JButton("pow(");
		power.setFont(new Font(null, Font.PLAIN, fontSize));
		exp = new JButton("exp(");
		exp.setFont(new Font(null, Font.PLAIN, fontSize));
		arcusSinus = new JButton("asin(");
		arcusSinus.setFont(new Font(null, Font.PLAIN, fontSize));
		arcusCosinus = new JButton("acos(");
		arcusCosinus.setFont(new Font(null, Font.PLAIN, fontSize));
		arcusTangens = new JButton("atan(");
		arcusTangens.setFont(new Font(null, Font.PLAIN, fontSize));
		firtstVariableButoon = new JButton("x");
		firtstVariableButoon.setFont(new Font(null, Font.PLAIN, fontSize));
		secondVariableButton = new JButton("y");
		secondVariableButton.setFont(new Font(null, Font.PLAIN, fontSize));
		piValueButton = new JButton("pi");
		piValueButton.setFont(new Font(null, Font.PLAIN, fontSize));
		eValueButton = new JButton("e");
		eValueButton.setFont(new Font(null, Font.PLAIN, fontSize));
		ok = new JButton("ok");
		ok.setFont(new Font(null, Font.PLAIN, fontSize));
		
		
		//*********************************************************
		left.setActionCommand(left.getText());
		right.setActionCommand(right.getText());
		
		leftBracket.setActionCommand(leftBracket.getText());
		rightBracket.setActionCommand(rightBracket.getText());
		piValueButton.setActionCommand(piValueButton.getText());
		eValueButton.setActionCommand(eValueButton.getText());
		power.setActionCommand(power.getText());
		squareRoot.setActionCommand(squareRoot.getText());
		absoluteValue.setActionCommand(absoluteValue.getText());
		
		plus.setActionCommand(plus.getText());
		sinus.setActionCommand(sinus.getText());
		cosinus.setActionCommand(cosinus.getText());
		tangens.setActionCommand(tangens.getText());
		
		minus.setActionCommand(minus.getText());
		arcusSinus.setActionCommand(arcusSinus.getText());
		arcusCosinus.setActionCommand(arcusCosinus.getText());
		arcusTangens.setActionCommand(arcusTangens.getText());
		
		times.setActionCommand(times.getText());
		exp.setActionCommand(exp.getText());
		naturalLogarythm.setActionCommand(naturalLogarythm.getText());
		backspace.setActionCommand(backspace.getText());
		
		decimalPoint.setActionCommand(decimalPoint.getText());
		divided.setActionCommand(divided.getText());
		coma.setActionCommand(coma.getText());
		firtstVariableButoon.setActionCommand(firtstVariableButoon.getText());
		secondVariableButton.setActionCommand(secondVariableButton.getText());
		ok.setActionCommand(ok.getText());
		
		for(int i = 0; i < 10; i++)
		{
			digits[i] = new JButton((new Integer(i)).toString());
			digits[i].setActionCommand((new Integer(i)).toString());
			digits[i].setFont(new Font(null, Font.PLAIN, fontSize));
		}
		
		add(leftBracket);
		add(rightBracket);
		add(piValueButton);
		add(eValueButton);
		add(power);
		add(squareRoot);
		add(absoluteValue);
		
		add(digits[7]);
		add(digits[8]);
		add(digits[9]);
		add(plus);
		add(sinus);
		add(cosinus);
		add(tangens);
		
		add(digits[4]);
		add(digits[5]);
		add(digits[6]);
		add(minus);
		add(arcusSinus);
		add(arcusCosinus);
		add(arcusTangens);
		
		add(digits[1]);
		add(digits[2]);
		add(digits[3]);
		add(times);
		add(exp);
		add(naturalLogarythm);
		add(backspace);
		
		add(digits[0]);
		add(decimalPoint);
		add(coma);
		add(divided);
		add(firtstVariableButoon);
		add(secondVariableButton);
		add(ok);
		
		//add(left);
		//add(right);

		//*********************************************************************
		ActionListener plusButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania = prawdziwyEfektKlikania + "+";
			}
		}; plus.addActionListener(plusButtonListener);
		//*********************************************************************
		ActionListener minusButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania = prawdziwyEfektKlikania + "-";
			}
		}; minus.addActionListener(minusButtonListener);
		//*********************************************************************
		ActionListener timesButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania = prawdziwyEfektKlikania + "*";
			}
		}; times.addActionListener(timesButtonListener);
		//*********************************************************************
		ActionListener dividedButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania = prawdziwyEfektKlikania + "/";
			}
		}; divided.addActionListener(dividedButtonListener);
		//*********************************************************************
		ActionListener decimalPointButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania = prawdziwyEfektKlikania + ".";
			}
		}; decimalPoint.addActionListener(decimalPointButtonListener);
		//*********************************************************************
		ActionListener leftBracketButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania = prawdziwyEfektKlikania + "(";
			}
		}; leftBracket.addActionListener(leftBracketButtonListener);
		//*********************************************************************
		ActionListener rightBracketButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania = prawdziwyEfektKlikania + ")";
			}
		}; rightBracket.addActionListener(rightBracketButtonListener);
		//*********************************************************************
		ActionListener digit0_ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "0";
			}
		}; digits[0].addActionListener(digit0_ButtonListener);
		//*********************************************************************
		ActionListener digit1_ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "1";
			}
		}; digits[1].addActionListener(digit1_ButtonListener);
		//*********************************************************************
		ActionListener digit2_ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "2";
			}
		}; digits[2].addActionListener(digit2_ButtonListener);
		//*********************************************************************
		ActionListener digit3_ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "3";
			}
		}; digits[3].addActionListener(digit3_ButtonListener);
		//*********************************************************************
		ActionListener digit4_ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "4";
			}
		}; digits[4].addActionListener(digit4_ButtonListener);
		//*********************************************************************
		ActionListener digit5_ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "5";
			}
		}; digits[5].addActionListener(digit5_ButtonListener);
		//*********************************************************************
		ActionListener digit6_ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "6";
			}
		}; digits[6].addActionListener(digit6_ButtonListener);
		//*********************************************************************
		ActionListener digit7_ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "7";
			}
		}; digits[7].addActionListener(digit7_ButtonListener);
		//*********************************************************************
		ActionListener digit8_ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "8";
			}
		}; digits[8].addActionListener(digit8_ButtonListener);
		//*********************************************************************
		ActionListener digit9_ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "9";
			}
		}; digits[9].addActionListener(digit9_ButtonListener);
		//*********************************************************************
		ActionListener squareRootButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.sqrt(";
			}
		}; squareRoot.addActionListener(squareRootButtonListener);
		//*********************************************************************
		ActionListener absoluteValueButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.abs(";
			}
		}; absoluteValue.addActionListener(absoluteValueButtonListener);
		//*********************************************************************
		ActionListener sinusButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.sin(";
			}
		}; sinus.addActionListener(sinusButtonListener);
		//*********************************************************************
		ActionListener cosinusButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.cos(";
			}
		}; cosinus.addActionListener(cosinusButtonListener);
		//*********************************************************************
		ActionListener tangensButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.tan(";
			}
		}; tangens.addActionListener(tangensButtonListener);
		//*********************************************************************
		ActionListener naturalLogarythmButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.log(";
			}
		}; naturalLogarythm.addActionListener(naturalLogarythmButtonListener);
		//*********************************************************************
		ActionListener powerButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.pow(";
			}
		}; power.addActionListener(powerButtonListener);
		//***********************************************************************************
		ActionListener expButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.exp(";
			}
		}; exp.addActionListener(expButtonListener);
		//***********************************************************************************
		ActionListener arcusSinusButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.asin(";
			}
		}; arcusSinus.addActionListener(arcusSinusButtonListener);
		//***********************************************************************************
		ActionListener arcusCosinusButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.acos(";
			}
		}; arcusCosinus.addActionListener(arcusCosinusButtonListener);
		//***********************************************************************************
		ActionListener arcusTangensButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.atan(";
			}
		}; arcusTangens.addActionListener(arcusTangensButtonListener);
		//***********************************************************************************
		ActionListener firstVariableButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "firstVariable";
			}
		}; firtstVariableButoon.addActionListener(firstVariableButtonListener);
		//***********************************************************************************
		ActionListener secondVariableButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "secondVariable";
			}
		}; secondVariableButton.addActionListener(secondVariableButtonListener);
		//***********************************************************************************
		ActionListener piValueButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "3.14159265359";
			}
		}; piValueButton.addActionListener(piValueButtonListener);
		//***********************************************************************************
		ActionListener eValueButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "2.71828182846";
			}
		}; eValueButton.addActionListener(eValueButtonListener);
		//***********************************************************************************
		ActionListener comaButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + ",";
			}
		}; coma.addActionListener(comaButtonListener);
		//***********************************************************************************
		ActionListener okButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					double result = TextToEquation.evaluateTwoVariableFunctionInString(prawdziwyEfektKlikania, "firstVariable", "secondVariable", 2, 3);
					
					String mess = new String();
					mess = mess +result;
					JOptionPane.showMessageDialog(new JFrame(), mess, "Result for x=2, y=3", JOptionPane.INFORMATION_MESSAGE);
				} 
				catch (ScriptException e1) 
				{
					e1.printStackTrace();
				}
				System.out.println(prawdziwyEfektKlikania);   //////////////////////Wypisuje na konsole zawartosc stringa (testowo)
			}
		}; ok.addActionListener(okButtonListener);
		
		//*********************************************************************
	}

}

