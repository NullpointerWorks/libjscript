/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.barcodes;

import exp.nullpointerworks.jscript.BarcodeType;
import exp.nullpointerworks.jscript.DataMatrixDimension;

/**
 * TODO - Data Matrix
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 153
 */
public class DataMatrix implements BarcodeType 
{
	private float d;
	private float o;
	private boolean optForcRect;
	private boolean optVerify;
	private boolean optGoodBad;
	private DataMatrixDimension dim;
	private String text;
	
	public DataMatrix()
	{
		setDotSize(0.3f);
		setText("");
		setForceRectangle(false);
		setVerification(false,false,0f);
		setDataMatrixDimension(null);
	}
	
	public DataMatrix(float dotsize, String text, DataMatrixDimension dim)
	{
		this();
		setDotSize(dotsize);
		setText(text);
		setDataMatrixDimension(dim);
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
	
	/**
	 * 
	 * @param b
	 * @return the instance of this object
	 */
	public DataMatrix setForceRectangle(boolean b)
	{
		optForcRect = b;
		return this;
	}
	
	public DataMatrix setVerification(boolean verify, boolean checkContent, float offset)
	{
		if (verify)
		{
			o = offset;
			if (verify ^ checkContent) optGoodBad = verify;
			else optVerify = verify;
		}
		return this;
	}
	
	public DataMatrix setDataMatrixDimension(DataMatrixDimension dim)
	{
		this.dim=dim;
		return this;
	}
	
	/**
	 * Contains the barcode data to be encoded in a barcode.
Depending on the selected barcode type. Different rules are
used for different barcodes. Some barcodes allow only
numbers, some others have a fixed length etc. More
 information can be found at the samples of each barcode. (From the manual)
	 * @param t
	 * @return the instance of this object
	 */
	public DataMatrix setText(String t)
	{
		if (t==null) t = "";
		text = t;
		return this;
	}
	
	@Override
	public String getText() 
	{
		// B[:name;]x, y,  r, DATAMATRIX[+options],dotsize,{fx};text
		// B        13,1.2,0, DATAMATRIX          ,0.3         ;Hello
		
		String str = "DATAMATRIX";

		if (optForcRect) str += "+RECT";
		if (optVerify) str += "+VERIFY"+format(o);
		if (optGoodBad) str += "+GOODBAD"+format(o);
		
		str += dim.toString();
		str += "," + format(d);
		str += ";" + text;
		
		return str;
	}
	
	private String format(float x) 
	{
		String str = String.format("%.1f", x);
		if (str.endsWith(".0"))
		{
			str = str.substring(0,str.length()-2);
		}
		return str;
	}
}
