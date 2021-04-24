/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.extension;

import exp.nullpointerworks.jscript.ExtensionType;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * E SQLITE defines a SQLITE database which will be used in the label. (From the manual)
 * 
 * @author Michiel
 * @see The CAB Programming Manual x4 - page 310
 */
public class ExtensionSQLITE implements ExtensionType
{
	private String file;
	
	public ExtensionSQLITE()
	{
		file = null;
	}
	
	public ExtensionSQLITE(String fname)
	{
		setExternalFile(fname);
	}
	
	/**
	 * 
	 * @param fname
	 * @return the instance of this object
	 */
	public ExtensionSQLITE setExternalFile(String fname)
	{
		if (fname.toLowerCase().endsWith(".db")) // remove the extension, if present
		{
			fname = fname.substring(0, fname.length()-3);
		}
		
		file = fname;
		return this;
	}
	
	@Override
	public String getText() throws JScriptException 
	{
		if (file==null) throw new JScriptException("Nullpointer: No file name has been specified.");
		return "SQLITE;"+file;
	}
}
