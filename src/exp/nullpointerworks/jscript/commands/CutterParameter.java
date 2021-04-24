/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.commands;

import exp.nullpointerworks.jscript.AbstractJScriptCommand;
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
public class CutterParameter extends AbstractJScriptCommand implements JScript 
{
	private CuttingMethod method = null;
	private Float disp1 = null;
	private Float disp2 = null;
	
	public CutterParameter() {}
	
	public CutterParameter(CuttingMethod m)
	{
		setCuttingMethod(m);
	}
	
	/**
	 * 
	 * @param m
	 * @return the instance of this object
	 */
	public CutterParameter setCuttingMethod(CuttingMethod m)
	{
		method = m;
		return this;
	}
	
	/**
	 * Offset to the end of the defined label. (From the manual)
	 * @param d1
	 * @return the instance of this object
	 */
	public CutterParameter setDisplacement1(Float d1)
	{
		disp1 = d1;
		return this;
	}
	
	/**
	 * Offset to the first cutting position. (always positive values!) This double 
	 * cut option offers the possibility to cut off portions of a label. [disp2] is 
	 * not available when the cut before first label (s) parameter is used. disp2 
	 * is only available for regular cuts and not for perforations! (From the manual)
	 * @param d2
	 * @return the instance of this object
	 */
	public CutterParameter setDisplacement2(Float d2)
	{
		disp2 = d2;
		return this;
	}
	
	@Override
	public String getText() throws JScriptException
	{
		if (method==null) throw new JScriptException("Nullpointer: Cutting method option is null.");
		
		String str = "C ";
		str += method.getText();
		
		if (disp1!=null)
		{
			str += ","+format(disp1);
			if (disp2!=null) str += ","+format(disp2);
		}
		
		return str;
	}
}
