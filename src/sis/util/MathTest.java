package sis.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

public class MathTest extends TestCase {

	static final double TOLERANCE = 0.05;
	
	public void testHypotenuse() {
		assertEquals(5.0, MyMath.hypotenuse(3.0, 4.0), TOLERANCE);
	}
	
	public void testIntegerToString() {
		assertEquals("101", Integer.toBinaryString(5));
		assertEquals("32", Integer.toHexString(50));
		assertEquals("21", Integer.toOctalString(17));
		
		assertEquals("1022", Integer.toString(35, 3));
	}
	
	public void testStringToInteger() {
		assertEquals(new Integer(253), Integer.decode("0xFD"));
		assertEquals(new Integer(253), Integer.decode("0xFD"));
		assertEquals(new Integer(253), Integer.decode("#FD"));
		assertEquals(new Integer(15), Integer.decode("017"));
	}
	
	public void testCoinFlips() {
		final long seed = 100L;
		final int total = 10;
		Random random1 = new Random(seed);
		List<Boolean> flips1 = new ArrayList<Boolean>();
		for (int i = 0; i < total; i++) {
			Boolean bool1 = random1.nextBoolean();
//			System.out.println(bool1);
			flips1.add(bool1);
		}
		
		Random random2 = new Random(seed);
		List<Boolean> flips2 = new ArrayList<Boolean>();
		for (int i = 0; i < total; i++) {
			Boolean bool2 = random2.nextBoolean();
//			System.out.println(bool2);
			flips2.add(bool2);
		}
		assertEquals(flips1, flips2);
	}
}
