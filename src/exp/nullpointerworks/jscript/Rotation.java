/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript;

public enum Rotation 
{
	DEG_0("0"),
	DEG_90("90"),
	DEG_180("180"),
	DEG_270("270");
	
	@Override
	public String toString() {return retChar;}
	private final String retChar;
	private Rotation(String ret) {retChar = ret;}
}
