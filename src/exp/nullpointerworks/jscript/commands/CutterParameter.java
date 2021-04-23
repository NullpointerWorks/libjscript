/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.commands;

import exp.nullpointerworks.jscript.CuttingMethod;
import exp.nullpointerworks.jscript.JScript;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * The C command is used to set the parameters for the optional cutter or perforation cutter. The cutting
command uses the label counter to cut after a specified amount of printed labels or can be set to cut at
the job end. Additionally it is possible to perform a second cut (double-cut) in one label.
Furthermore an optional perforation cutter is available, which can perforate and which is also able to
do a "regular" cut. (From the manual)
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 303
 */
public class CutterParameter implements JScript 
{
	private CuttingMethod method = null;
	
	public CutterParameter() {}
	
	public CutterParameter(CuttingMethod m)
	{
		setCuttingMethod(m);
	}
	
	public CutterParameter setCuttingMethod(CuttingMethod m)
	{
		method = m;
		return this;
	}
	
	@Override
	public String getText() throws JScriptException
	{
		if (method==null) throw new JScriptException("Nullpointer: Cutting method option is null.");
		
		String str = "C ";
		str += method.getText();
		return str;
	}
}
