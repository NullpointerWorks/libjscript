/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript;

public enum RFIDTagType 
{
	/*
	 * Auto detect tag type is the default value.
	 */
	AUTO("Auto"),
	
	/**
	 * ISO 15693 tags, fixed block size 32 bits
	 */
	ISO15693("ISO 15693");
	
	@Override
	public String toString() {return retChar;}
	private final String retChar;
	private RFIDTagType(String ret) {retChar = ret;}
}
