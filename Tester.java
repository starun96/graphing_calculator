import static java.lang.System.*;
import static java.lang.Math.*;

public class Tester 
{
	public static void main(String[] args)
	{
		MathExConverter converter = new MathExConverter();
		
		double second = converter.evaluate("abs(x-2)^2", "x", 0);
		out.println(second + " calc");
		
		
	}

}
