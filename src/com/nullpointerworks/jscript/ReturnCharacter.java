/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
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
