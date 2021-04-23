/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript;

import java.util.ArrayList;
import java.util.List;

/**
 * This class serves to hold a collection of JScript commands that can later 
 * be compiled into a single string. This string can be send over via a 
 * network connection or USB stream.
 * @author Michiel Drost - Nullpointer Works
 */
public class JScriptBuilder implements JScript
{
	private List<JScript> script;
	private ReturnCharacter RET;
	
	public JScriptBuilder()
	{
		script = new ArrayList<JScript>();
		RET = ReturnCharacter.CR;
	}
	
	public void setReturnCharacter(ReturnCharacter ret)
	{
		RET = ret;
	}
	
	public void add(JScript js)
	{
		script.add(js);
	}
	
	public void add(JScript ... jsl)
	{
		for (JScript js : jsl)
		{
			add(js);
		}
	}
	
	public void add(List<JScript> jsl)
	{
		for (JScript js : jsl)
		{
			add(js);
		}
	}
	
	public JScript set(int index, JScript js)
	{
		return script.set(index, js);
	}
	
	public void remove(JScript js)
	{
		script.remove(js);
	}
	
	public JScript remove(int index)
	{
		return script.remove(index);
	}
	
	@Override
	public String getText() 
	{
		String job = "";
		
		for (JScript js : script) 
		{
			job += (js.getText() + RET.toString());
		}
		
		return job;
	}
}
