package MathPackage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//KLASA MAJACA METODY LICZACE WARTOSCI: WYRAZEN, FUNKCJI f(x), FUNKCJI f(x,y)
public class TextToEquation
{
	public TextToEquation() { }
	
	//FUNKCJA LICZACA WYRAZENIE ZAPISANE W STRINGU
	public static double evaluateEquationInString (String mathExpression) throws ScriptException
	{
		ScriptEngineManager mgr = new ScriptEngineManager(); 
		ScriptEngine engine = mgr.getEngineByName("JavaScript"); //ciezko powiedziec po co, bylo w internecie
		
		try 
		{
			return( ((Number) engine.eval(mathExpression)).doubleValue() ); // o to jest fajne bo faktycznie liczy
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(new JFrame(), "Computation error \n I'm gonna return 0", "Info message", JOptionPane.INFORMATION_MESSAGE);
			return 0;
		}
	}
	
	//FUNKCA LICZACA WARTOSC DOWOLNEj FUNKCJI R-->R ZAPISANEJ W STRINGU 
	//[ARG1 (String) nazwa zmiennej zwierajacej wzor funkcji f] [ARG2 (String) nazwa argumentu funkcji f np. "x"] [ARG3 (double)wartosc argumentu]
	public static double evaluateFunctionInString (String function, String variable, double x) throws ScriptException
	{
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript"); //ciezko powiedziec po co, bylo w internecie
		
		String xValue = new String();
		xValue = xValue+x;
		function = function.replaceAll(variable, xValue);
		
		try 
		{
			return( ((Number) engine.eval(function)).doubleValue() ); // o to jest fajne bo faktycznie liczy
		} 
		catch (Exception e) 
		{
			//JOptionPane.showMessageDialog(new JFrame(), "Computation error, I'm gonna return 0", "Info message", JOptionPane.INFORMATION_MESSAGE);
			return 0;
		}
	}
	
	//FUNKCA LICZACA WARTOSC DOWOLNEj FUNKCJI R^2-->R ZAPISANEJ W STRINGU 
	//[ARG1 (String) nazwa zmiennej zwierajacej wzor funkcji f] [ARG2 (String) nazwa pierwszego argumentu] [ARG3 (String) nazwa drugiego argumentu] [ARG4 (double) wartosc pierwszego argumentu] [ARG5 (double) wartosc drugiego argumentu]
	//Zamiast x i y sa te dodatkowe pola zeby np zamiast f(x) bylo f(kasztan) aby z exp nie zrobiæ e4p.
	public static double evaluateTwoVariableFunctionInString (String function, String nameOfFirtVariable, String nameOfSecondVariable, double valueOfFirstVariable, double valueOfSecondVariable) throws ScriptException
	{
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript"); //ciezko powiedziec po co, bylo w internecie
		
		String xValue = new String();
		String yValue  = new String();
		xValue = xValue+valueOfFirstVariable; //zmiana doubla na stringa
		yValue = yValue + valueOfSecondVariable;
		function = function.replaceAll(nameOfFirtVariable, xValue); //zmiana x na wartosc x
		function = function.replaceAll(nameOfSecondVariable, yValue);
		
		try 
		{
			return( ((Number) engine.eval(function)).doubleValue() ); // o to jest fajne bo faktycznie liczy
		} 
		catch (Exception e) 
		{
			//JOptionPane.showMessageDialog(new JFrame(), "Computation error, \n I'm gonna return 0", "Info message", JOptionPane.INFORMATION_MESSAGE);
			return 0;
		}
	}
	//main do testowania metod klasy (wspolpracuje z klawiatura ekranowa)
	public static void main(String[] args) throws ScriptException 
	{
		//PRZYKLADY UZYCIA
		String equation  = new String("96+Math.sqrt(6)");
		System.out.println(equation + "=" + evaluateEquationInString(equation));
		
		String formula = "2*x";
		System.out.println(formula + "=" + evaluateFunctionInString(formula, "x", 3));
		
		String twoVariableFormula = "Math.sqrt(Math.log(x)+2*y)";
		System.out.println(twoVariableFormula + "=" + evaluateTwoVariableFunctionInString(twoVariableFormula, "x",	 "y", 1, 5));
	}
}
