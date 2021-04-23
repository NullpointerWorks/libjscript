package exp.nullpointerworks.jscript.cutting;

import exp.nullpointerworks.jscript.AbstractJScriptCommand;
import exp.nullpointerworks.jscript.CuttingMethod;
import exp.nullpointerworks.jscript.JScriptException;

public class CuttingAmount extends AbstractJScriptCommand implements CuttingMethod
{
	private float amount = 0f;
	
	public CuttingAmount(float a) 
	{
		amount = a;
	}

	@Override
	public String getText() throws JScriptException 
	{
		
		
		
		return null;
	}
}
