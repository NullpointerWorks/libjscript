package exp.nullpointerworks.jscript;

public abstract class AbstractJScriptCommand 
{
	
	
	protected String format(float x) 
	{
		String str = String.format("%.1f", x);
		if (str.endsWith(".0"))
		{
			str = str.substring(0,str.length()-2);
		}
		return str;
	}
}
