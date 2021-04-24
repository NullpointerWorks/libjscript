/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.extension;

import exp.nullpointerworks.jscript.ExtensionType;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * E TMP defines the name of an external temporary file (TMP file). TMP files 
 * can be used e.g. for serial numbering where the incremented or decremented 
 * value is saved in the printer. This value can be the starting value for 
 * the next label. (From the manual)
 * 
 * @author Michiel
 * @see The CAB Programming Manual x4 - page 313
 */
public class ExtensionTMP implements ExtensionType
{
	private String file;
	
	public ExtensionTMP()
	{
		file = null;
	}
	
	public ExtensionTMP(String fname)
	{
		setExternalFile(fname);
	}
	
	/**
	 * 
	 * @param fname
	 * @return the instance of this object
	 */
	public ExtensionTMP setExternalFile(String fname)
	{
		if (fname.toLowerCase().endsWith(".tmp")) // remove the extension, if present
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
		return "TMP;"+file;
	}
}
