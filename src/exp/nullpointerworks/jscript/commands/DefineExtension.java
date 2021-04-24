/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.commands;

import exp.nullpointerworks.jscript.ExtensionType;
import exp.nullpointerworks.jscript.JScript;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * Defines the use of an external data source. 
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 308
 */
public class DefineExtension implements JScript 
{
	private ExtensionType ext;
	
	public DefineExtension() 
	{
		ext = null;
	}
	
	public DefineExtension(ExtensionType type)
	{
		ext = type;
	}
	
	/**
	 * 
	 * @param type
	 * @return the instance of this object
	 */
	public DefineExtension setExtensionType(ExtensionType type)
	{
		ext = type;
		return this;
	}
	
	@Override
	public String getText() throws JScriptException
	{
		if (ext==null) throw new JScriptException("Nullpointer: No extension type has been provided.");
		String str = "E "+ext.getText();
		return str;
	}
}
