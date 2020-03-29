import static java.lang.Math.*;
import static java.lang.Double.*;
import static java.lang.System.*;
public class Exponentiation extends Operation 
{
	public Exponentiation(String var, double input)
	{
		super(var, input);
	}
	
	public double doOperation(String ex)
	{
		String s = ex;
		int midIndex = s.indexOf('^');
		String beginning = s.substring(0, midIndex);
		String end = s.substring(midIndex + 1);

		
		if (s.charAt(midIndex - 1) == '~')
		{
			String str = s.substring(0, 1);
			if (str.equals("a") || str.equals("c") || str.equals("s") || str.equals("t") || str.equals("l"))
				return pow(getConverter().evaluate(s.substring(0, midIndex - 1), getVarLetter(), getInputValue()), getConverter().evaluate(end, getVarLetter(), getInputValue()));
			
			if (parseDouble(end) % 2 == 0)
				return -pow(getConverter().evaluate(s.substring(0, midIndex - 1), getVarLetter(), getInputValue()), getConverter().evaluate(end, getVarLetter(), getInputValue()));
			
			if (parseDouble(end) % 2 == 1)
				return pow(getConverter().evaluate(s.substring(0, midIndex - 1), getVarLetter(), getInputValue()), getConverter().evaluate(end, getVarLetter(), getInputValue()));
			
			return NaN;
		}
		
		return pow(getConverter().evaluate(beginning, getVarLetter(), getInputValue()), getConverter().evaluate(end, getVarLetter(), getInputValue()));
	}
}

