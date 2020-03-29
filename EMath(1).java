import static java.lang.Math.*;

public class EMath 
{
	
	public static final double EPSILON = 1E-14;
	
	public static double sin(double a)
	{
		return Math.sin(a);
	}
	
	public static double cos(double a)
	{
		return Math.cos(a);
	}
	
	public static double tan(double a)
	{
		return Math.tan(a);
	}
	
	public static double cot(double a)
	{
		return 1/Math.tan(a);
	}
	
	public static double sec(double a)
	{
		return 1/Math.cos(a);
	}

	public static double csc(double a)
	{
		return 1/Math.sin(a);
	}
	
	public static double asin(double a)
	{
		return Math.asin(a);
	}
	
	public static double acos(double a)
	{
		return Math.acos(a);
	}
	
	public static double atan(double a)
	{
		return Math.atan(a);
	}
	
	public static double acot(double a)
	{
		return 1/Math.atan(a);
	}
	
	public static double asec(double a)
	{
		return 1/Math.atan(a);
	}
	
	public static double acsc(double a)
	{
		return 1/Math.atan(a);
	}
	
	public static double ln(double a)
	{
		return Math.log(a);
	}
	
	public static double log(double a)
	{
		return Math.log10(a);
	}
	
	public static double sqrt(double a)
	{
		return Math.sqrt(a);
	}
	
	public static double abs(double a)
	{
		return Math.abs(a);
	}
	
	
	

}
