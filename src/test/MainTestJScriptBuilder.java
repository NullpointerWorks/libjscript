/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package test;

import com.nullpointerworks.jscript.*;
import com.nullpointerworks.jscript.commands.*;

public class MainTestJScriptBuilder 
{
	public static void main(String[] args) 
	{
		new MainTestJScriptBuilder();
	}
	
	
	
	public MainTestJScriptBuilder()
	{
		JScriptBuilder builder = new JScriptBuilder();
		builder.setReturnCharacter( ReturnCharacter.LF );
		
		builder.add( new SetMeasurementUnit(Measurement.METRIC) );
		
		
		
		
	}
	
	
	
}
