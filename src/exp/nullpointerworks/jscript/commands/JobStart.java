/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.commands;

import exp.nullpointerworks.jscript.JScript;

/**
 * The J command tells the printer, that the following data contains label specific data. It starts a new print job. (From the manual)
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 336
 */
public class JobStart implements JScript 
{
	public JobStart()
	{
		
	}
	
	@Override
	public String getText()
	{
		return "J";
	}
}
