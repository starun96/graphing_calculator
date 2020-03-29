
public class KeepChangeChange implements Substitution
{
	public String doSubstitution(String ex)
	{
		String s = ex;
		int midIndex = s.indexOf("--");
		s = s.substring(0, midIndex) + "+" + s.substring(midIndex + 2);
		return s;
	}

}
