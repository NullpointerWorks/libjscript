/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.commands;

import exp.nullpointerworks.jscript.BarcodeType;
import exp.nullpointerworks.jscript.JScript;
import exp.nullpointerworks.jscript.JScriptException;
import exp.nullpointerworks.jscript.Rotation;

/**
 * The B command defines a barcode field in the label format. The most common barcode 
types are supported by the printers. (From the manual)
 * 
 * @author Michiel Drost - Nullpointer Works
 * @see The CAB Programming Manual x4 - page 111
 */
public class BarcodeDefinition implements JScript 
{
	private String name;
	private float x;
	private float y;
	private Rotation r;
	private BarcodeType bt;
	private String text;
	
	public BarcodeDefinition()
	{
		name = "";
		x = 0;
		y = 0;
		r = Rotation.DEG_0;
		bt = null;
		text = "";
	}
	
	public BarcodeDefinition(float x, float y, Rotation r, BarcodeType bt, String text)
	{
		name="";
		this.x=x;
		this.y=y;
		this.r=r;
		this.bt=bt;
		this.text=text;
	}
	
	/**
	 * Describes the field name and is optional. No special characters allowed.
Fieldnames must start with an Alpha character and they are
cases sensitive. A field name can be used for further operations,
such as calculations ,as linked field, for field replacements or for
the enhanced usage when downloaded to a memory card etc.
The field name must be unique in each label. (From the manual)
	 * @param n
	 * @return the instance of this object
	 */
	public BarcodeDefinition setName(String n)
	{
		if (n==null) n = "";
		name = n;
		return this;
	}
	
	/**
	 * The x - coordinate is the horizontal start position of a barcode
(in millimeters or inches), the distance between the left margin
of a label and the upper left corner of the barcode. (From the manual)
	 * @param xpos
	 * @return the instance of this object
	 */
	public BarcodeDefinition setX(float xpos)
	{
		x=xpos;
		return this;
	}
	
	/**
	 * The y - coordinate is the vertical start position of a barcode,
the distance between the top margin of a label and the upper
left corner of the barcode.
The maximum coordinate depends on the printer type. Please
refer to the operator´s manual. (From the manual)
	 * @param ypos
	 * @return the instance of this object
	 */
	public BarcodeDefinition setY(float ypos)
	{
		y=ypos;
		return this;
	}
	
	/**
	 * Rotation - Rotates a barcode in 4 directions. Valid values are 0, 
90, 180 and 270. Measurement in degrees. (From the manual)
	 * @param r
	 * @return the instance of this object
	 */
	public BarcodeDefinition setRotation(Rotation r)
	{
		this.r = r;
		return this;
	}
	
	/**
	 * 
	 * @param bct
	 * @return the instance of this object
	 */
	public BarcodeDefinition setBarcodeType(BarcodeType bct)
	{
		this.bt=bct;
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
	public BarcodeDefinition setText(String t)
	{
		if (t==null) t = "";
		text = t;
		return this;
	}
	
	@Override
	public String getText() throws JScriptException 
	{
		if (r==null) throw new JScriptException("Nullpointer: The rotation parameter is null");
		if (bt==null) throw new JScriptException("Nullpointer: The barcode type is null");
		
		String str = "B ";
		if (name.length()>0)
		{
			str = ("B:"+name+";");
		}
		
		str += System.out.printf("%.1f", x)+",";
		str += System.out.printf("%.1f", y)+",";
		str += r.toString()+",";
		str += bt.getText()+";";
		str += text;
		
		return str;
	}
}
