/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.extension;

import exp.nullpointerworks.jscript.ExtensionType;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * E SQL tells the printer the IP - address of an external database server. (From the manual)
 * 
 * @author Michiel
 * @see The CAB Programming Manual x4 - page 315
 */
public class ExtensionSQL implements ExtensionType
{
	private String netIP;
	private String netPort;
	
	public ExtensionSQL()
	{
		netIP = null;
		netPort = null;
	}
	
	public ExtensionSQL(String ip, String port)
	{
		setIPAddress(ip);
		setPort(port);
	}
	
	/**
	 * 
	 * @param ip
	 * @return the instance of this object
	 */
	public ExtensionSQL setIPAddress(String ip)
	{
		netIP = ip;
		return this;
	}
	
	/**
	 * 
	 * @param ip
	 * @return the instance of this object
	 */
	public ExtensionSQL setPort(String port)
	{
		netPort = port;
		return this;
	}
	
	@Override
	public String getText() throws JScriptException 
	{
		if (netIP==null) throw new JScriptException("Nullpointer: No IP address has been specified.");
		if (netPort==null) throw new JScriptException("Nullpointer: No network port has been specified.");
		return "SQL;"+netIP+":"+netPort;
	}
}
