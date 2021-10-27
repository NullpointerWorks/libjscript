/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript.font;

import exp.nullpointerworks.jscript.JScript;
import exp.nullpointerworks.jscript.JScriptException;

/**
 * The F command assigns an alternate number to a font name. The reason for this command is to
simplify the font handling, keeping a better overview on the used fonts in a label and enables the
programmer to exchange a font in a label very easy.
The resident fonts in the cab printers have fixed names, but they can be redefined with this command.
Once the font number is defined it is valid for the complete label. The theoretical limit of fonts per label
is 100 font files. ( which might exceed the printers memory...) (From the manual)
 * 
 * @author Michiel
 * @see The CAB Programming Manual x4 - page 316
 */
public class FontNumber implements JScript
{
	private String number;
	private String font;
	
	public FontNumber() {}
	
	public FontNumber(String n, String f)
	{
		setNumberToFont(n,f);
	}
	
	public void setNumberToFont(String n, String f)
	{
		number = n;
		font = f;
	}
	
	@Override
	public String getText() throws JScriptException 
	{
		return "F "+number+";"+font;
	}
}
