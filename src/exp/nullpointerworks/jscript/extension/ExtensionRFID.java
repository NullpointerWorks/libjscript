/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.extension;

import exp.nullpointerworks.jscript.ExtensionType;
import exp.nullpointerworks.jscript.FieldStrength;
import exp.nullpointerworks.jscript.JScriptException;
import exp.nullpointerworks.jscript.RFIDTagType;

/**
 * Define parameters for RFID tag. ( Requires that the cab RFID unit is installed ) 
 * This command is not available on printers with separate RFID interface. (A+ series) (From the manual)
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 314
 */
public class ExtensionRFID implements ExtensionType
{
	private RFIDTagType tag;
	private String r;
	private String cp;
	private String position;
	private FieldStrength p;
	
	public ExtensionRFID()
	{
		tag = RFIDTagType.AUTO;
		r = null;
		cp = null;
		position = null;
		p = null;
	}
	
	public ExtensionRFID(int retries, String codepage, int pos, FieldStrength power)
	{
		setTagType(RFIDTagType.AUTO);
		setRetries(retries);
		setCodePage(codepage);
		setPosition(pos);
		setFieldStrength(power);
	}
	
	public ExtensionRFID setTagType(RFIDTagType tag)
	{
		this.tag = tag;
		return this;
	}
	
	public ExtensionRFID setRetries(int retries)
	{
		if (retries < 0) retries = 0;
		if (retries > 10) retries = 10;
		r = ""+retries;
		return this;
	}
	
	public ExtensionRFID setCodePage(String codepage)
	{
		if (codepage==null) codepage = "Auto";
		cp = codepage;
		return this;
	}
	
	/**
	 * Reading position relatively to the printhead.
	 * @param pos
	 * @return
	 */
	public ExtensionRFID setPosition(int pos)
	{
		if (pos < -10) pos = -10;
		if (pos > 20) pos = 20;
		position = ""+pos;
		return this;
	}
	
	public ExtensionRFID setFieldStrength(FieldStrength power)
	{
		p = power;
		return this;
	}
	
	@Override
	public String getText() throws JScriptException 
	{
		if (tag==null) throw new JScriptException("Nullpointer: No tag type has been specified.");
		
		String ret = "RFID";
		ret += ( "T:"+tag.toString() );
		
		if (r != null)
		{
			ret += (",R:"+r);
		}
		
		if (cp != null)
		{
			ret += (",C:"+cp);
		}
		
		if (position != null)
		{
			ret += (",P:"+position);
		}
		
		if (p != null)
		{
			ret += (",E:"+p.toString());
		}
		
		return ret;
	}
}
