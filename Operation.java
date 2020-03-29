public abstract class Operation 
{
	private String var;
	private double input;
	private MathExConverter converter;
	
	public Operation(String varLetter, double inputValue)
	{
		var = varLetter;
		input = inputValue;
		converter = new MathExConverter();
	}
	
	public abstract double doOperation(String ex);
	
	public MathExConverter getConverter()
	{
		return converter;
	}
	
	public String getVarLetter()
	{
		return var;
	}
	
	public double getInputValue()
	{
		return input;
	}
}

