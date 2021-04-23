/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package com.nullpointerworks.jscript.commands;

import com.nullpointerworks.jscript.JScript;

/**
 * The A command is used to define the end of the label definition and to set the amount of labels to be printed. (From the manual)<br>
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 107
 */
public class PrintLabels implements JScript 
{
	private int amount = 0;
	private boolean noprint = false;
	
	public PrintLabels setAmount(int amount)
	{
		setNoPrint(false);
		
		this.amount=amount;
		return this;
	}
	
	public PrintLabels setNoPrint(boolean b)
	{
		noprint = b;
		return this;
	}
	
	@Override
	public String getText()
	{
		if (noprint)
		{
			return "A [NOPRINT]"; // store in buffer
		}
		
		
		
		
		
		
		
		
		if (amount > 0)
		{
			return "A "+amount; // print a fixed amount
		}
		
		if (amount < 0)
		{
			return "A"; // warning! print infinite
		}
		
		return "A 1"; // default; print 1
	}
}
