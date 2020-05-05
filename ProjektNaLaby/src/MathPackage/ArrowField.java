package MathPackage;

import java.awt.Color;

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Window_package.Arrow;
import Window_package.RightPanel;
import Window_package.VectorPanel;

public class ArrowField
{
	final int arrowsInRow = 10;
	final int arrowsInColumn = 15;
	Arrow [][] arrowArray;
	int xSpaceBetweenArrows;
	int ySpaceBetweenArrows;
	String fxString;
	String fyString;
	int badXArrowsAmount;
	int badYArrowsAmount;
	double largestForceValue;
	
	public ArrowField(String fxString, String fyString, VectorPanel vPanel) 
	{
		this.badXArrowsAmount = 0;
		this.badYArrowsAmount = 0;
		this.fxString = fxString;
		this.fyString = fyString;
		xSpaceBetweenArrows = vPanel.getWidth()/(arrowsInRow);
		ySpaceBetweenArrows = vPanel.getHeight()/(arrowsInColumn);
		this.arrowArray = new Arrow [arrowsInRow][arrowsInColumn];
		this.createForceField(fxString, fyString, vPanel);
		this.findLargestForceValue();
		this.setProperColorsToArrows();
		VerifyEquation();
	}
	
	public void createForceField (String fxString, String fyString, VectorPanel vPanel)
	{
		for (int i=0; i<arrowsInRow; i++)
		{
			for (int j=0; j<arrowsInColumn; j++)
			{
				int xPos = (int) (-vPanel.getWidth()/2 + i*xSpaceBetweenArrows); // x nalezy (-width/2 ; width/2)
				int yPos = (int) (-vPanel.getHeight()/2 + j*ySpaceBetweenArrows); // y nalezy (-height/2 ; height/2)
				double xVal = 1;
				double yVal = 1;
				// F(x,y) w normalnym uk³adzie wspó³rzêdnych tj. (0,0) w œrodku
				try 
				{
					xVal = TextToEquation.evaluateTwoVariableFunctionInString(fxString, "firstVariable", "secondVariable", xPos, yPos); 
					if (xVal == Math.pow(10, -10))
					{
						badXArrowsAmount++;
					}
				}	 
				catch (ScriptException e) { } //do nothing
					
				try 
				{
					yVal = TextToEquation.evaluateTwoVariableFunctionInString(fyString, "firstVariable", "secondVariable", xPos, yPos); 
					if (yVal == Math.pow(10, -10))
					{
						badYArrowsAmount++;
					}
				}	 
				catch (ScriptException e) {  } //do nothing
				
				arrowArray[i][j] = new Arrow(xPos, yPos, xVal, yVal, vPanel);
			}
		}
	}
	
	public void VerifyEquation ()
	{
		if (badXArrowsAmount!=0 || badYArrowsAmount!=0)
		{
			if (badXArrowsAmount!=0)
			{	
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect F(x) equation.\n Example:\n 2sin(xy) -----> incorrect.\n 2*sin(x*y) -----> correct.", "INFO", JOptionPane.INFORMATION_MESSAGE);
				RightPanel.badKeyboardUsageCounter++;
				RightPanel.isLastKeyboardUsageWasCorrect = false;
			}
				
			
			if (badYArrowsAmount!=0)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect F(y) equation.\n Example:\n 2sin(xy) -----> incorrect.\n 2*sin(x*y) -----> correct.", "INFO", JOptionPane.INFORMATION_MESSAGE);
				RightPanel.badKeyboardUsageCounter++;
				RightPanel.isLastKeyboardUsageWasCorrect = false;
			}
		}
		else
		{
			RightPanel.isLastKeyboardUsageWasCorrect = true;
		}
	}

	void findLargestForceValue ()
	{
		double largest=0;
		for (int i=0; i<arrowsInRow; i++)
		{
			for (int j=0; j<arrowsInColumn; j++)
			{
				if(arrowArray[i][j].getMagnitude() > largest)
				{
					largest = arrowArray[i][j].getMagnitude();
				}
			}
		}
		largestForceValue = largest;
	}
	
	public double getLargestForceValue()
	{
		return largestForceValue;
	}
	
	void setProperColorsToArrows()
	{
		Color LOW = Color.RED;
		Color HIGH = Color.BLUE;
		for (int i=0; i<arrowsInRow; i++)
		{
			for (int j=0; j<arrowsInColumn; j++)
			{			//ratio is from range [0 , 1]
				double ratio = arrowArray[i][j].getMagnitude() / largestForceValue;
				int red = (int)Math.abs((ratio * LOW.getRed()) + ((1 - ratio) * HIGH.getRed()));
				int green = (int)Math.abs((ratio * LOW.getGreen()) + ((1 - ratio) * HIGH.getGreen()));
				int blue = (int)Math.abs((ratio * LOW.getBlue()) + ((1 - ratio) * HIGH.getBlue()));
				arrowArray[i][j].setColor(new Color(red, green, blue));
			}
		}
	}
	
	public Arrow getArrow (int i, int j)
	{
		return (arrowArray[i][j]);
	}

	public int getArrowsInRow() { return arrowsInRow; }

	public  int getArrowsInColumn() { return arrowsInColumn; }
		
	

}
