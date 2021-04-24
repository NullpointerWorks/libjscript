/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import exp.nullpointerworks.jscript.*;
import exp.nullpointerworks.jscript.barcodes.*;
import exp.nullpointerworks.jscript.commands.*;
import exp.nullpointerworks.jscript.cutting.*;
import exp.nullpointerworks.jscript.extension.ExtensionDBF;

public class MainTestJScriptBuilder 
{
	public static void main(String[] args) 
	{
		new MainTestJScriptBuilder();
	}
	
	public MainTestJScriptBuilder()
	{
		DataMatrix dataMatrix 		= new DataMatrix(0.3f, "Hello World!");
		CuttingMethod cutTwo 		= new CuttingAmount(2);
		JScriptBuilder script 		= new JScriptBuilder();
		script.setReturnCharacter( ReturnCharacter.CRLF );
		
		// the command below affects all labels printed afterwards, even outside this job.
		// I advise to always set the unit to make sure you're working in the intended unit
		script.add( new SetMeasurementUnit(Measurement.METRIC) );
		
		
		script.add( new JobStart() );
		script.add( new BarcodeDefinition( 13, 1.2f, Rotation.DEG_0, dataMatrix ) );
		script.add( new CutterParameter( cutTwo ) );
		script.add( new DefineExtension( new ExtensionDBF("testdb.dbf") ) );
		
		
		script.add( new PrintLabels().setAmount(20) );
		
		String jscript = "";
		try 
		{
			jscript = script.getText();
		} 
		catch (JScriptException e) 
		{
			e.printStackTrace();
			return;
		}
		
		System.out.println(jscript);
		
		/*
		try 
		{
			sendJScript("192.168.10.95", 9100, jscript);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		//*/
	}
	
	public void sendJScript(String ip, int port, String jscript) throws IOException
	{
		var s = new Socket(ip,port);
		var o = new DataOutputStream( s.getOutputStream() );
		o.write(jscript.getBytes("UTF-8"));
		o.close();
		s.close();
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