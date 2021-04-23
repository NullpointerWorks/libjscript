package exp.nullpointerworks.jscript;

public enum DataMatrixDimension
{
	/**
	 * 
	 */
	DM_10x10(10, 6, 3),
	DM_12x12(12, 10, 6),
	DM_14x14(14, 16, 10),
	DM_16x16(16, 24, 16),
	DM_18x18(18, 36, 25),
	DM_20x20(20, 44, 31),
	DM_22x22(22, 60, 43),
	DM_24x24(24, 72, 52),
	DM_26x26(26, 88, 64),
	DM_32x32(32, 124, 91),
	DM_36x36(36, 172, 127),
	DM_40x40(40, 228, 169),
	DM_44x44(44, 288, 214),
	DM_48x48(48, 348, 259),
	DM_52x52(52, 408, 304),
	DM_64x64(64, 560, 418),
	DM_72x72(72, 736, 550),
	DM_80x80(80, 912, 682),
	DM_88x88(88, 1152, 862),
	DM_96x96(96, 1392, 1042),
	DM_104x104(104, 1632, 1222),
	DM_120x120(120, 2100, 1573),
	DM_132x132(132, 2608, 1954),
	DM_144x144(144, 144, 3116, 2335);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private final int rows;
	private final int cols;
	private final int chars;
	private final int nums;
	private DataMatrixDimension(int s, int cr, int nm) 
	{
		rows = s;
		cols = s;
		chars = cr;
		nums = nm;
	}
	
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
