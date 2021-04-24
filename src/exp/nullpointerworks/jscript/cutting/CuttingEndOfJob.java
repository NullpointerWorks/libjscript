/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.cutting;

import exp.nullpointerworks.jscript.CuttingMethod;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * Cutting at the job end. Cuts once at the job end which is defined by the "A" (amount) command. (From the manual)
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 303
 */
public class CuttingEndOfJob implements CuttingMethod
{
	public CuttingEndOfJob() 
	{
		
	}

	@Override
	public String getText() throws JScriptException 
	{
		return "e";
	}
}
