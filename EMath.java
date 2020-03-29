import java.math.BigDecimal;
import java.math.MathContext;


public class EMath 
{
	public static final BigDecimal E = new BigDecimal("2.7182818284590452353602874713526624977572470936999595749669676277240766303535475945713821785251664274274663919320030599218174135966290435729003342952605956307381323286279434907632338298807531952510190115738341879307021540891499348841675092447"), 
								   PI = new BigDecimal("3.14159265358979323846264338327");
	public static final MathContext PRECISION = new MathContext(50);
	public static final BigDecimal TWO = new BigDecimal("2"),
								   NEGATIVE_ONE = new BigDecimal("-1"),
								   P = TWO.multiply(PI);
	
	public static BigDecimal sin(BigDecimal a)
	{
		if (a.compareTo(BigDecimal.ZERO) == 0)
			return BigDecimal.ZERO;
		
		BigDecimal x = a;
		
		while(x.compareTo(P) > 0)
			x = x.subtract(P);
		
		while(x.compareTo(P.negate()) < 0)
			x = x.add(P);
		
		BigDecimal commonRatio = x.pow(2).negate();
		BigDecimal term = x;
		BigDecimal result = term;
		
		for (int n = 3; n < 60; n+=2)
		{
			term = term.multiply(commonRatio).divide(new BigDecimal(String.valueOf(n*n-n)), PRECISION);
			result = result.add(term);
		}
		
		return result;
		
	}

}
