/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.extension;

import exp.nullpointerworks.jscript.ExtensionType;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * E DBF defines a dBASE III compatible database file which will be used in the label. Uses a .DBF as external file on memory card or internal flash file system(iffs). (From the manual)
 * 
 * @author Michiel
 * @see The CAB Programming Manual x4 - page 308
 */
public class ExtensionDBF implements ExtensionType
{
	private String file;
	
	public ExtensionDBF()
	{
		file = null;
	}
	
	public ExtensionDBF(String fname)
	{
		setExternalFile(fname);
	}
	
	/**
	 * 
	 * @param fname
	 * @return the instance of this object
	 */
	public ExtensionDBF setExternalFile(String fname)
	{
		if (fname.toLowerCase().endsWith(".dbf")) // remove the extension, if present
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
		return "DBF;"+file;
	}
}
