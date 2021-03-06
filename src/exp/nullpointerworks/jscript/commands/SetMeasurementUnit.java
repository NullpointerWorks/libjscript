package exp.nullpointerworks.jscript.commands;

import exp.nullpointerworks.jscript.JScript;
import exp.nullpointerworks.jscript.JScriptException;
import exp.nullpointerworks.jscript.Measurement;

/**
 * This command sets the measuring unit for the following label data.
 * Once it is sent, all following settings in a label are measured in the selected unit. (From the manual)
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
	public String getText() throws JScriptException
	{
		if (measure==null) throw new JScriptException("Nullpointer: Measurement option is null.");
		
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
