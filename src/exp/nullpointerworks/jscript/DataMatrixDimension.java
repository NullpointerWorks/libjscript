package exp.nullpointerworks.jscript;

public enum DataMatrixDimension
{
	/**
	 * 
	 */
	DM_10x10(10, 10, 6, 3),
	
	/**
	 * 
	 */
	DM_12x12(12, 12, 10, 6);
	
	
	
	/*
	
	14 x 14 16 10
	16 x 16 24 16
	18 x 18 36 25
	20 x 20 44 31
	22 x 22 60 43
	24 x 24 72 52
	26 x 26 88 64
	32 x 32 124 91
	36 x 36 172 127
	40 x 40 228 169
	44 x 44 288 214
	48 x 48 348 259
	52 x 52 408 304
	64 x 64 560 418
	72 x 72 736 550
	80 x 80 912 682
	88 x 88 1152 862
	96 x 96 1392 1042
	104 x 104 1632 1222
	120 x 120 2100 1573
	132 x 132 2608 1954
	144 x 144 3116 2335
	
	*/
	
	private final int rows;
	private final int cols;
	private final int chars;
	private final int nums;
	private DataMatrixDimension(int r, int c, int cr, int nm) 
	{
		rows = r;
		cols = c;
		chars = cr;
		nums = nm;
	}
	
	@Override
	public String toString() 
	{
		return "+ROWS"+rows+"+COLS"+cols;
	}
}
