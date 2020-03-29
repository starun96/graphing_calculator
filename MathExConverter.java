import static java.lang.Math.*;
import static java.lang.System.*;
import java.util.ArrayList;

import java.lang.reflect.Method;

public class MathExConverter 
{	
	public static final char[] operators = 
	{
		'+', '-', '*', '/', 
	};
	
	public static final Class c1 = Math.class, c2 = EMath.class, c3 = double.class;
	
	public static final String[] stringFunctions1 = 
	{
		"sinh", "cosh", "tanh", "asin", "acos", "atan", "sin", "cos", "tan",
		"sqrt", "abs",  "log10", "log",  "floor", "ceil"
	};
	
	public static final String[] stringFunctions2 = 
	{	
		"acsch", "asech", "acoth",
		"asinh", "acosh", "atanh",
		"acsc", "asec", "acot", 
		"csch", "sech", "coth", 
		"csc", "sec", "cot"
	};
	
	public static ArrayList<Method> functions = new ArrayList<Method>();
	
	public MathExConverter()
	{
		try
		{
			for (String str : stringFunctions2)
				functions.add(c2.getMethod(str, c3));
			for (String str : stringFunctions1)
				functions.add(c1.getMethod(str, c3));
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		
			
	}
	
	public double evaluate(String ex, String var, double input) 
	{
		String s = ex;
		
		if (var.equals("e"))
			exit(0);
		
		while (s.contains(" "))
		{
			int midIndex = s.indexOf(" ");
			s = s.substring(0, midIndex) + s.substring(midIndex+1);
		}
		
		while (s.contains("(") && s.contains(")"))
		{
			int startIndex = s.indexOf('('), endIndex = searchEndIndexPar(s, startIndex);
			s = s.substring(0, startIndex) + (double) round(evaluate(s.substring(startIndex + 1, endIndex), var, input) * 1000000000
				)/1000000000 + s.substring(endIndex + 1);
		}
		
		if (s.contains("--"))
		{
			int midIndex = s.indexOf("--");
			s = s.substring(0, midIndex) + "+" + s.substring(midIndex + 2);
		}
		
		if (s.contains("+"))
		{
			int midIndex = s.indexOf('+');
			return evaluate(s.substring(0, midIndex), var, input) + evaluate(s.substring(midIndex + 1), var, input);
		}
		
		if (s.contains("-"))
		{
			int midIndex = s.lastIndexOf('-');
			boolean hasOperator = false;
			if (midIndex > 0)
			{
				for (char c : operators)
					if (s.charAt(midIndex - 1) == c)
						hasOperator = true;
			}
			
			if (!hasOperator)
				return evaluate(s.substring(0, midIndex), var, input) - evaluate(s.substring(midIndex + 1), var, input);
		}
		
		if (s.contains("*"))
		{
			int midIndex = s.indexOf('*');
			return evaluate(s.substring(0, midIndex), var, input) * evaluate(s.substring(midIndex + 1), var, input);
		}
		
		if (s.contains("/"))
		{
			int midIndex = s.lastIndexOf('/');
			return evaluate(s.substring(0, midIndex), var, input) / evaluate(s.substring(midIndex + 1), var, input);
		}
		
		if (s.contains("^"))
		{
			int midIndex = s.indexOf('^');
			return pow(evaluate(s.substring(0, midIndex), var, input), evaluate(s.substring(midIndex + 1), var, input));
		}
		
		if (s.contains("log"))
		{
			s = "log10" + s.substring(3);
		}
		
		if (s.contains("ln"))
		{
			s = "log" + s.substring(2);
		}
		
		for (Method m : functions)
		{
			if (s.contains(m.getName()))
			{
				out.println(m.getName());
				
				int midIndex = m.getName().length()-1;
				if (!m.getName().equals(s.substring(0, midIndex+1)))
					continue;
				
				try
				{
					return (Double) m.invoke(null, evaluate(s.substring(midIndex+1), var, input));
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		
		}
		
		if (s.equals(var))
			return input;
		
		if (s.equals("pi") || s.equals("PI"))
			return PI;
		
		if (s.equals("e"))
			return E;
		
		if (s.equals(""))
			return 0;
		
		if (Double.parseDouble(s) >= Double.MIN_VALUE && Double.parseDouble(s) <= Double.MAX_VALUE)
			return Double.parseDouble(s);
		
		return 0;
	}
	
	private int searchEndIndexPar(String str, int startIndex)
	{
		int count = 1;
		
		for (int i = startIndex + 1; i < str.length(); i++)
		{
					if (str.charAt(i) == '(')
						count++;
					
					if (str.charAt(i) == ')')
						count--;
					
					if (count == 0)
						return i;
				
		}
		
		
		return -1;
	}

	
}
