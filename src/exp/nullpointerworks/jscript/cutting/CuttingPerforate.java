/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.cutting;

import exp.nullpointerworks.jscript.CuttingMethod;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * Perforate - requires the optional perforation cutter! (From the manual)
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 303
 */
public class CuttingPerforate implements CuttingMethod
{
	public CuttingPerforate() 
	{
		
	}

	@Override
	public String getText() throws JScriptException 
	{
		return "p";
	}
}
