/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.extension;

import exp.nullpointerworks.jscript.ExtensionType;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * E LOG defines the name of a external protocol file (LOG file). It is highly recommended that the E LOG command is not used with the internal flash file system (iffs), as the internal chip is not designed for many write cycles. (From the manual)
 * 
 * @author Michiel
 * @see The CAB Programming Manual x4 - page 309
 */
public class ExtensionLOG implements ExtensionType
{
	private String file;
	
	public ExtensionLOG()
	{
		file = null;
	}
	
	public ExtensionLOG(String fname)
	{
		setExternalFile(fname);
	}
	
	/**
	 * 
	 * @param fname
	 * @return the instance of this object
	 */
	public ExtensionLOG setExternalFile(String fname)
	{
		if (fname.toLowerCase().endsWith(".log")) // remove the extension, if present
		{
			fname = fname.substring(0, fname.length()-4);
		}
		
		file = fname;
		return this;
	}
	
	@Override
	public String getText() throws JScriptException 
	{
		if (file==null) throw new JScriptException("Nullpointer: No file name has been specified.");
		return "LOG;"+file;
	}
}
