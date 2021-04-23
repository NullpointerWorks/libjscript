/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.jscript;

public interface JScript 
{
	/**
	 * Generates the JScript describing this object and returns it as a String. It 
	 * might throw an exception of the object, or embedded JScript object, encounters a problem.
	 * @return the JScript describing this object
	 * @throws JScriptException
	 */
	String getText() throws JScriptException;
}
