package com.nullpointerworks.jscript.commands;

import com.nullpointerworks.jscript.JScript;
import com.nullpointerworks.jscript.Measurement;

/**
 * This command sets the measuring unit for the following label data.
 * Once it is sent, all following settings in a label are measured in the selected unit. 
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 86
 */
public class SetMeasurementUnit implements JScript 
{
	private Measurement measure;
	
	/**
	 * Sets the measurement to "metric"by default.
	 */
	public SetMeasurementUnit()
	{
		measure = Measurement.METRIC;
	}
	
	public SetMeasurementUnit(Measurement m)
	{
		measure = m;
	}
	
	public SetMeasurementUnit setMeasurement(Measurement m)
	{
		measure = m;
		return this;
	}
	
	@Override
	public String getText()
	{
		switch(measure)
		{
		default:
		case METRIC:
			return "m m";
		case IMPERIAL:
			return "m i";
		}
	}
}
