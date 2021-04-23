/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.commands;

import exp.nullpointerworks.jscript.JScript;

/**
 * A user defined command set with just a string. This is a quick way to write JScript without going through various options and conditions.
 * 
 * @author Michiel Drost - Nullpointer Works
 */
public class Custom implements JScript 
{
	private String str = "";
	
	public Custom(String s)
	{
		str = s;
	}
	
	@Override
	public String getText()
	{
		return str;
	}
}
