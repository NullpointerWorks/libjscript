/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.extension;

import exp.nullpointerworks.jscript.ExtensionType;
import exp.nullpointerworks.jscript.JScriptException;
import exp.nullpointerworks.jscript.RFIDTagType;

/**
 * Define parameters for RFID tag. ( Requires that the cab RFID unit is installed ) (From the manual)
 * 
 * @author Michiel
 * @see The CAB Programming Manual x4 - page 314
 */
public class ExtensionRFID implements ExtensionType
{
	private RFIDTagType tag;
	
	
	public ExtensionRFID()
	{
		tag = RFIDTagType.AUTO;
	}
	
	public ExtensionRFID(String ip, String port)
	{
		tag = RFIDTagType.AUTO;
	}
	
	
	
	
	/**
	 * @param tag
	 * @return the instance of this object
	 */
	public ExtensionRFID setTagType(RFIDTagType tag)
	{
		this.tag = tag;
		return this;
	}
	
	@Override
	public String getText() throws JScriptException 
	{
		if (tag==null) throw new JScriptException("Nullpointer: No tag type has been specified.");
		
		
		
		
		String ret = "RFID";
		ret += "T:"+tag.toString();
		return ret;
	}
}
