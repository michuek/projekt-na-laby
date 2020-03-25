package Keyboard_package;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class KeysPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;

	String prawdziwyEfektKlikania;
	
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
	JButton leftBracket;		//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton rightBracket; 		//************************  TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton squareRoot;			//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton sinus;				//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton cosinus;			//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton tangens;			//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton naturalLogarythm;	//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	//JButton log10; Magiczna funkcja eval tego nie lubi
	JButton power;				//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton exp;				//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton arcusSinus;			//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton arcusCosinus;		//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton arcusTangens;		//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	//JButton sinusHiperboliczny;
	//JButton cosinusHiperboliczny;
	//JButton tangensHiperboliczny;
	//JButton areaSinusHiperboliczny;
	//JButton areaCosinusHiperboliczny;
	//JButton areaTangensHiperboliczny;
	JButton firtstVariableButoon;	//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton secondVariableButton;	//************************* TRZEBA DODAC TEN PRZYCIK DO KLAWIATURY EKRANOWEJ
	JButton ok;
	
	int fontSize;

	public KeysPanel(Window frame) 
	{
		setLayout(new GridLayout(gridRows, gridColumns, gridHgap, gridVgap));
		fontSize = 30;
		
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
		leftBracket = new JButton("(");
		leftBracket.setFont(new Font(null, Font.PLAIN, fontSize));
		rightBracket = new JButton(")");
		rightBracket.setFont(new Font(null, Font.PLAIN, fontSize));
		squareRoot = new JButton("sqrt(");
		squareRoot.setFont(new Font(null, Font.PLAIN, fontSize));
		sinus = new JButton("sin(");
		sinus.setFont(new Font(null, Font.PLAIN, fontSize));
		cosinus = new JButton("cos(");
		cosinus.setFont(new Font(null, Font.PLAIN, fontSize));
		tangens = new JButton("tan(");
		naturalLogarythm = new JButton("ln(");
		naturalLogarythm.setFont(new Font(null, Font.PLAIN, fontSize));
		//log10  = new JButton();
		//log10.setFont(new Font(null, Font.PLAIN, fontSize));
		power =  new JButton("pow(");
		power.setFont(new Font(null, Font.PLAIN, fontSize));
		exp = new JButton("exp(");
		exp.setFont(new Font(null, Font.PLAIN, fontSize));
		arcusSinus = new JButton("asin(");
		arcusSinus.setFont(new Font(null, Font.PLAIN, fontSize));
		arcusCosinus = new JButton("acos(");
		arcusCosinus.setFont(new Font(null, Font.PLAIN, fontSize));
		arcusTangens = new JButton("atan(");
		//sinusHiperboliczny = new JButton("sinh(");
		//sinusHiperboliczny.setFont(new Font(null, Font.PLAIN, fontSize));
		//cosinusHiperboliczny = new JButton("cosh(");
		//cosinusHiperboliczny.setFont(new Font(null, Font.PLAIN, fontSize));
		//tangensHiperboliczny = new JButton("tanh(");
		//tangensHiperboliczny.setFont(new Font(null, Font.PLAIN, fontSize));
		//areaSinusHiperboliczny = new JButton("asinh(");
		//areaSinusHiperboliczny.setFont(new Font(null, Font.PLAIN, fontSize));
		//areaCosinusHiperboliczny = new JButton("acosh(");
		//areaCosinusHiperboliczny.setFont(new Font(null, Font.PLAIN, fontSize));
		//areaTangensHiperboliczny = new JButton("atanh(");
		//areaTangensHiperboliczny.setFont(new Font(null, Font.PLAIN, fontSize));
		firtstVariableButoon = new JButton("x");
		firtstVariableButoon.setFont(new Font(null, Font.PLAIN, fontSize));
		secondVariableButton = new JButton("y");
		secondVariableButton.setFont(new Font(null, Font.PLAIN, fontSize));
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
		
		ok.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{

			}
		});
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
		ActionListener okButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(prawdziwyEfektKlikania);   //////////////////////Wypisuje na ekran zawartosc stringa (testowo)
			}
		}; ok.addActionListener(okButtonListener);
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
		ActionListener log10ButtonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prawdziwyEfektKlikania =prawdziwyEfektKlikania + "Math.log10(";							//NIESTETY
			}
		}; //log10.addActionListener(log10ButtonListener);
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
		
	}

}

