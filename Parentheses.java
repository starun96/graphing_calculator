import static java.lang.System.*;

public class Parentheses implements Substitution
{
	private String var;
	private double input;
	private MathExConverter converter;
	
	public Parentheses(String varLetter, double inputValue)
	{
		var = varLetter;
		input = inputValue;
		converter = new MathExConverter();
	}
	
	public String doSubstitution(String ex)
	{
		String s = ex;
		int startIndex = s.indexOf('('), endIndex = searchEndIndexPar(s, startIndex);
		
		double middle = converter.evaluate(s.substring(startIndex + 1, endIndex), var, input);
		String m = middle + "";
		
		if (middle < 0 && endIndex != s.length() - 1 && s.substring(endIndex + 1, endIndex + 2).equals("^"))
			m += "~";
		
		s = s.substring(0, startIndex) + 
			m +  
			s.substring(endIndex + 1);
		
		return s;
	}
	
	private int searchEndIndexPar(String str, int startInd)
	{
		int count = 1;
		
		for (int i = startInd + 1; i < str.length(); i++)
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
