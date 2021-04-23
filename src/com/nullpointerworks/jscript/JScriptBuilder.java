package com.nullpointerworks.jscript;

import java.util.ArrayList;
import java.util.List;

public class JScriptBuilder implements JScript
{
	private final String CRLF = "\r\n";
	private List<JScript> script;
	
	public JScriptBuilder()
	{
		script = new ArrayList<JScript>();
		
	}
	
	@Override
	public String getText() 
	{
		String job = "";
		
		for (JScript js : script) 
		{
			job += (js.getText() + CRLF);
		}
		
		return job;
	}
}
