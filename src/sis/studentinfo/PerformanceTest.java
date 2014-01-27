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
}
