/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript;

public enum FieldStrength 
{
	NORMAL("S"),
	HIGH("H");
	
	@Override
	public String toString() {return retChar;}
	private final String retChar;
	private FieldStrength(String ret) {retChar = ret;}
}
