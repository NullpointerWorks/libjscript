/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.commands;

import exp.nullpointerworks.jscript.AbstractJScriptCommand;
import exp.nullpointerworks.jscript.JScript;

/**
 * The D command is used to move the complete label content to the specified 
 * location. All following object positions are influenced by this command. 
 * The starting point for the label content is shifted by this values. (From the manual)
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 307
 */
public class GlobalObjectOffset extends AbstractJScriptCommand implements JScript 
{
	private float x = 0f;
	private float y = 0f;
	
	public GlobalObjectOffset()
	{
		
	}
	
	public GlobalObjectOffset(float xpos, float ypos)
	{
		setX(xpos);
		setY(ypos);
	}
	
	/**
	 * Offset value in horizontal direction. (From the manual)
	 * @param xpos
	 * @return the instance of this object
	 */
	public GlobalObjectOffset setX(float xpos)
	{
		x=xpos;
		return this;
	}
	
	/**
	 * Offset value in vertical direction. (From the manual)
	 * @param ypos
	 * @return the instance of this object
	 */
	public GlobalObjectOffset setY(float ypos)
	{
		y=ypos;
		return this;
	}
	
	@Override
	public String getText()
	{
		String str = "D ";
		
		str += format(x);
		str += ","+format(y);
		
		return str;
	}
}
