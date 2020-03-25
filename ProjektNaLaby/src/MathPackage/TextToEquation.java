package MathPackage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//KLASA MAJACA METODY LICZACE WARTOSCI: WYRAZEN, FUNKCJI f(x), FUNKCJI f(x,y)
public class TextToEquation
{
	public TextToEquation() { }
	
	//FUNKCJA LICZACA WYRAZENIE ZAPISANE W STRINGU
	public static double evaluateEquationInString (String mathExpression) throws ScriptException
	{
		ScriptEngineManager mgr = new ScriptEngineManager(); 
		ScriptEngine engine = mgr.getEngineByName("JavaScript"); //ciezko powiedziec po co, bylo w internecie
	    if (engine.eval(mathExpression) instanceof Number) // zamiana typu object na typ douuble
	    {
	        return( ((Number) engine.eval(mathExpression)).doubleValue() ); // o to jest fajne bo faktycznie liczy
	    }
	    else
	    {
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
		
	    if (engine.eval(function) instanceof Number)  // zamiana typu object na typ douuble
	    {
	        return( ((Number) engine.eval(function)).doubleValue() ); // o to jest fajne bo faktycznie liczy
	    }
	    else
	    {
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
		
	    if (engine.eval(function) instanceof Number)  // zamiana typu object na typ douuble
	    {
	        return( ((Number) engine.eval(function)).doubleValue() ); // o to jest fajne bo faktycznie liczy
	    }
	    else
	    {
	    	return 0;
	    }
	}
	//main do testowania metod klasy (wspolpracuje z klawiatura ekranowa, OK wypisuje na konsole)
	public static void main(String[] args) throws ScriptException 
	{
		String equation  = new String("Math.exp(1)");
		System.out.println(equation);
		System.out.println(evaluateEquationInString(equation));
		System.out.println(Math.sinh(4));
		
		String formula = "2*x";
		System.out.println(evaluateFunctionInString(formula, "x", 3));
		
		String twoVariableFormula = "Math.sqrt(Math.log(x)+2*y)";
		System.out.println(evaluateTwoVariableFunctionInString(twoVariableFormula, "x",	 "y", 1, 5));
	}
}
