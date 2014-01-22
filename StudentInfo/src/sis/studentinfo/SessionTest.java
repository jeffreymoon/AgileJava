package sis.studentinfo;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

abstract public class SessionTest extends TestCase {

    private Session session;
    private Date startDate;
    private static final int CREDITS = 3;

    @Before
    public void setUp() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createSession("ENGL", "101", startDate);
        session.setNumberOfCredits(CREDITS);
    }

    abstract protected Session createSession(String department, String number, Date startDate);
    
    @Test
    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }
    
    @Test
    public void testEnrollStudents() {
        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        assertEquals(CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        
        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        assertEquals(CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }
    
//    @Test
//    public void testCourseDate() {
//        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
//        assertEquals(sixteenWeeksOut, session.getEndDate());
//    }
//    
//    public void testCount() {
//        CourseSession.resetCount();
//        createCourseSession();
//        assertEquals(1, CourseSession.getCount());
//        createCourseSession();
//        assertEquals(2, CourseSession.getCount());
//    }

    public void testComparable() {
        final Date date = new Date();
        Session sessionA = createSession("CMSC", "101", date);
        Session sessionB = createSession("ENGL", "101", date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);
        
        Session sessionC = createSession("CMSC", "101", date);
        assertEquals(0, sessionA.compareTo(sessionC));
        
        Session sessionD = createSession("CMSC", "210", date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
        assertTrue(sessionD.compareTo(sessionC) > 0);
    }
    
    public void testIterate() {
        enrollStudents(session);
        List<Student> results = new ArrayList<Student>();
        for (Student student : session) {
            results.add(student);
        }
        assertEquals(session.getAllStudents(), results);
    }
    
    private void enrollStudents(Session session) {
        session.enroll(new Student("1"));
        session.enroll(new Student("2"));
        session.enroll(new Student("3"));
    }
    
    public void testCasting() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("a"));
        students.add(new Student("b"));
        
        List<String> names = new ArrayList<String>();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student student = (Student)it.next();
            names.add(student.getLastName());
        }
        
        assertEquals("a", names.get(0));
        assertEquals("b", names.get(1));
        
    }
    
    @Test
    public void testSessionUrl() throws SessionException {
        final String url = "http://course.langrsoft.com/cmsc300";
        session.setUrl(url);
        assertEquals(url, session.getUrl().toString());
    }
    
    @Test
    public void testInvalidSessionUrl() {
        final String url = "httsp://course.langrsoft.com/cmsc300";
        try {
            session.setUrl(url);
            fail("expected exception due to invalid protocol in URL");
        } catch (SessionException expectedException) {
            Throwable cause = expectedException.getCause();
            assertEquals(MalformedURLException.class, cause.getClass());
        }
    }
}
