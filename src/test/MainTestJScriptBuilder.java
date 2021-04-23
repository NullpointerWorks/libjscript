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
		
		// the command below affects all labels printed afterwards, even outside this job.
		// I advise to always set the unit to make sure you're working in the intended unit
		builder.add( new SetMeasurementUnit(Measurement.METRIC) );
		
		builder.add( new JobStart() );
		builder.add( new PrintLabels().setAmount(4) );
		
	}
	
	
	
}
/*

; start a job with mm setting
m m
J

; speed,heat,print method,no saver
H 30,0,T,R0

; Brady THT-1-729 label and 180 deg rotation
S l1;0,1,6,9,19,20.5,4
O R

; text = x,y,r,font,size;text
T 1,4,0,3,2;Hello World

; datamatrix size depends on the encoded data
B 13,1.2,0,DATAMATRIX,0.3;Hello

; print 4 labels
A 4


*/