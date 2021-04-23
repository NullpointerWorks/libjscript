/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.barcodes;

import exp.nullpointerworks.jscript.BarcodeType;

/**
 * TODO - Data Matrix
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 153
 */
public class DataMatrix implements BarcodeType 
{
	private float d;
	
	public DataMatrix()
	{
		d = 0.3f;
	}
	
	public DataMatrix(float dotsize)
	{
		d = dotsize;
	}
	
	/**
	 * The dotsize of the pixels of the datamatrix. 
	 * @param dotsize
	 * @return the instance of this object
	 */
	public DataMatrix setDotSize(float dotsize)
	{
		d=dotsize;
		return this;
	}
	
	@Override
	public String getText() 
	{
		// B[:name;]x, y,  r, DATAMATRIX[+options],dotsize,{fx};text
		// B        13,1.2,0, DATAMATRIX          ,0.3         ;Hello
		
		String str = "DATAMATRIX";
		
		
		str += "," + System.out.printf("%.1f", d);
		return str;
	}

}
