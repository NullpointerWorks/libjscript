/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.cutting;

import exp.nullpointerworks.jscript.AbstractJScriptCommand;
import exp.nullpointerworks.jscript.CuttingMethod;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * Amount of labels after which a cut is processed. Possible values 1-9999. (From the manual)
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 303
 */
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
		return format(amount);
	}
}
