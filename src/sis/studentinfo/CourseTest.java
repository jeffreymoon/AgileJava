package sis.studentinfo;

import junit.framework.TestCase;


public class CourseTest extends TestCase {

	public void testCreate() {
		Course course = new Course("CMSC", "120");
		assertEquals("CMSC", course.getDepartment());
		assertEquals("120", course.getNumber());
	}
	
	public void testEquality() {
		Course courseA = new Course("NURS", "201");
		Course courseAPrime = new Course("NURS", "201");
		assertEquals(courseA, courseAPrime);
		
		Course courseB = new Course("ARTH", "330");
		assertFalse(courseA.equals(courseB));

		// reflexivity
		assertTrue(courseA.equals(courseA));
		
		// symmetry
		assertTrue(courseAPrime.equals(courseA));

		// transitivity
		Course courseAPrime2 = new Course("NURS", "201");
		assertTrue(courseAPrime.equals(courseAPrime2));
		assertTrue(courseA.equals(courseAPrime2));
		
		// consistency
		assertTrue(courseA.equals(courseAPrime));
		
		// comparison to null
		assertFalse(courseA.equals(null));
		
		// apples & oranges
		assertFalse(courseA.equals("CMSC-120"));
	}
	
}
