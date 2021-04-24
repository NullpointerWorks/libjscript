/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.cutting;

import exp.nullpointerworks.jscript.CuttingMethod;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * Cut at print start (before the first label). This command is only executed once in the job and can be combined with " C amount ". Disp1 is an optional offset in the chosen unit. (From the manual)
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 303
 */
public class CuttingStartOfJob implements CuttingMethod
{
	public CuttingStartOfJob() 
	{
		
	}

	@Override
	public String getText() throws JScriptException 
	{
		return "s";
	}
}
