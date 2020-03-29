public class Multiplication extends Operation
{
	public Multiplication(String varLetter, double input)
	{
		super(varLetter, input);
	}
	
	public double doOperation(String ex)
	{
		String s = ex;
		int midIndex = s.indexOf('*');
		return getConverter().evaluate(s.substring(0, midIndex), getVarLetter(), getInputValue()) * (getConverter().evaluate(s.substring(midIndex + 1), getVarLetter(), getInputValue()));
	}

}
