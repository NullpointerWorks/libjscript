/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.cutting;

import exp.nullpointerworks.jscript.CuttingMethod;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * Perforate at the start of the printjob ( requires the optional perforation cutter !, and can be combined with " C amount "). disp1 is an optional offset in the chosen unit. (From the manual)
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 303
 */
public class CuttingPerforateAtStart implements CuttingMethod
{
	public CuttingPerforateAtStart() 
	{
		
	}

	@Override
	public String getText() throws JScriptException 
	{
		return "sp";
	}
}
