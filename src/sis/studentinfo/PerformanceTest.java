package sis.studentinfo;

import java.util.Arrays;

import junit.framework.TestCase;

public class PerformanceTest extends TestCase {

    private static final double tolerance = 0.005;
	
    public void testAverage() {
        Performance performance = new Performance();
        performance.setNumberOfTests(4);
        performance.set(0, 98);
        performance.set(1, 92);
        performance.set(2, 81);
        performance.set(3, 72);
        assertEquals(92, performance.get(1));
        assertEquals(85.75, performance.average(), tolerance);
    }
    
    public void testAverageForNoScores() {
    	Performance performance = new Performance();
    	assertEquals(0.0, performance.average());
//    	assertTrue(Double.isNaN(performance.average()));
    }
    
    public void testInitialization() {
        Performance performance = new Performance();
        performance.setScore(75, 72, 90, 60);
        assertEquals(74.25, performance.average(), tolerance);
        
        performance.setScore(100, 90);
        assertEquals(95.0, performance.average(), tolerance);
    }
    
    public void testArrayParm() {
        Performance performance = new Performance();
        performance.setScore(new int[] {75, 72, 90, 60});
        assertEquals(74.25, performance.average(), tolerance);
    }
    
    public void testArrayEquality() {
        int[] a = { 1, 2, 3 };
        int[] b = new int[] { 1, 2, 3 };
        assertFalse(a == b);
        assertTrue(Arrays.equals(a, b));
    }
    
    public void testArrayEquals() {
        int[] a = { 1, 2, 3 };
        int[] b = new int[3];
        b[0] = 1;
        b[1] = 2;
        b[2] = 3;
        assertFalse(a.equals(b));
        assertTrue(Arrays.equals(a, b));
    }
    
    public void testArraysEquals() {
        int[] a = { 1, 2, 3 };
        int[] b = { 1, 2, 3 };
        assertTrue(Arrays.equals(a, b));
    }
    
    public void testInfinity() {
    	final float tolerance = 0.5f;
    	final float x = 1f;

    	assertEquals(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY * 100, tolerance);
    	assertEquals(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY * -1, tolerance);
    	
    	assertEquals(Float.POSITIVE_INFINITY, x / 0f, tolerance);
    	assertEquals(Float.NEGATIVE_INFINITY, x / -0f, tolerance);
    	assertTrue(Float.isNaN(x % 0f));
    	
    	assertEquals(0f, x / Float.POSITIVE_INFINITY, tolerance);
    	assertEquals(-0f, x / Float.NEGATIVE_INFINITY, tolerance);
    	assertEquals(x, x % Float.POSITIVE_INFINITY, tolerance);
    }
    
    public void testOverflow() {
    	byte b = Byte.MAX_VALUE;
    	assertEquals(Byte.MAX_VALUE + 1, b + 1);
    	b += 1;
    	assertEquals(Byte.MIN_VALUE, b);
    	assertTrue(Double.isInfinite(Double.MAX_VALUE * Double.MAX_VALUE));
    }
    
    public void testBitOperator() {
    	assertEquals(0, 0 & 0);
    	assertEquals(0, 0 & 1);
    	assertEquals(0, 1 & 0);
    	assertEquals(1, 1 & 1);
    	
    	int x = 0x7FFFFFF1;
    	assertEquals(0x8000000E, ~x);
    }
    
    public void testFlags() {
    	Student student = new Student("a");
    	student.set(Student.Flag.ON_CAMPUS, Student.Flag.TAX_EXEMPT, Student.Flag.MINOR);
    	assertTrue(student.isOn(Student.Flag.ON_CAMPUS));
    	assertTrue(student.isOn(Student.Flag.TAX_EXEMPT));
    	assertTrue(student.isOn(Student.Flag.MINOR));
    	
    	assertFalse(student.isOff(Student.Flag.ON_CAMPUS));
    	assertTrue(student.isOff(Student.Flag.TROUBLEMAKER));
    	
    	student.unset(Student.Flag.ON_CAMPUS);
    	assertTrue(student.isOff(Student.Flag.ON_CAMPUS));
    	assertTrue(student.isOn(Student.Flag.TAX_EXEMPT));
    	assertTrue(student.isOn(Student.Flag.MINOR));
    }
}
