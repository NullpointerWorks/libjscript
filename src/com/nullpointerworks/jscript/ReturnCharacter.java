package com.nullpointerworks.jscript;

public enum ReturnCharacter 
{
	CR("\r"),
	LF("\n"),
	CRLF("\r\n");
	
	@Override
	public String toString() {return retChar;}
	private final String retChar;
	private ReturnCharacter(String ret) {retChar = ret;}
}
