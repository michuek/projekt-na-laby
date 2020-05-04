package MathPackage;

import javax.script.ScriptException;

import Window_package.Arrow;
import Window_package.VectorPanel;

public class ArrowField
{
	static final int arrowsInRow = 10;
	static final int arrowsInColumn = 15;
	Arrow [][] arrowArray;
	static final int xSpaceBetweenArrows = VectorPanel.width/(arrowsInRow);
	static final int ySpaceBetweenArrows = VectorPanel.height/(arrowsInColumn);
	String fxString;
	String fyString;
	
	public ArrowField(String fxString, String fyString) 
	{
		this.fxString = fxString;
		this.fyString = fyString;
		this.arrowArray = new Arrow [arrowsInRow][arrowsInColumn];
		this.createForceField(fxString, fyString);
	}
	
	public void createForceField (String fxString, String fyString)
	{
		for (int i=0; i<arrowsInRow; i++)
		{
			for (int j=0; j<arrowsInColumn; j++)
			{
				int xPos = (int) (-VectorPanel.width/2 + i*xSpaceBetweenArrows); // x nalezy (-width/2 ; width/2)
				int yPos = (int) (-VectorPanel.height/2 + j*ySpaceBetweenArrows); // y nalezy (-height/2 ; height/2)
				double xVal =1;
				double yVal = 0;
				// F(x,y) w normalnym uk³adzie wspó³rzêdnych tj. (0,0) w œrodku
				try { xVal = TextToEquation.evaluateTwoVariableFunctionInString(fxString, "firstVariable", "secondVariable", xPos, yPos); }	 
				catch (ScriptException e) { } //do nothing
					
				try { yVal = TextToEquation.evaluateTwoVariableFunctionInString(fyString, "firstVariable", "secondVariable", xPos, yPos); }	 
				catch (ScriptException e) { } //do nothing
				
				arrowArray[i][j] = new Arrow(xPos, yPos, xVal, yVal);
			}
		}
	}

	public Arrow getArrow (int i, int j)
	{
		return (arrowArray[i][j]);
	}

	

}
