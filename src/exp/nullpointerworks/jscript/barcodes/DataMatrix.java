/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.barcodes;

import exp.nullpointerworks.jscript.AbstractJScriptCommand;
import exp.nullpointerworks.jscript.BarcodeType;
import exp.nullpointerworks.jscript.DataMatrixDimension;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * 
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 153
 */
public class DataMatrix extends AbstractJScriptCommand implements BarcodeType 
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
	
	public DataMatrix(float dotsize, String text)
	{
		this();
		setDotSize(dotsize);
		setText(text);
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
	
	/**
	 * 
	 * @param verify
	 * @param checkContent
	 * @param offset
	 * @return the instance of this object
	 */
	public DataMatrix setVerification(boolean verify, boolean checkContent, float offset)
	{
		if (verify)
		{
			optGoodBad = false;
			optVerify = false;
			o = offset;
			if (verify ^ checkContent) optGoodBad = verify;
			else optVerify = verify;
		}
		return this;
	}
	
	/**
	 * 
	 * @param dim
	 * @return the instance of this object
	 */
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
	public String getText() throws JScriptException 
	{
		if (text.length() < 1) throw new JScriptException("No Data Exception: No data was provided to decode into a datamatrix.");
		
		if (dim != null)
		{
			boolean fits = true;
			boolean isNumeric = text.matches("^[0-9]+$");
			if (isNumeric) // has only numbers
			{
				if (text.length() > dim.getNumerics())
				{
					fits = false;
				}
			}
			else
			{
				if (text.length() > dim.getAlphaNumerics())
				{
					fits = false;
				}
			}
			if (!fits) throw new JScriptException("Size Exception: The text \""+text+"\" does not fit in the dimension of the datamatrix.");
		}
		
		String str = "DATAMATRIX";
		if (optForcRect) str += "+RECT";
		if (optVerify) str += "+VERIFY"+format(o);
		if (optGoodBad) str += "+GOODBAD"+format(o);
		if (dim != null) str += dim.toString();
		str += "," + format(d);
		str += ";" + text;
		return str;
	}
}
