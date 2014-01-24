package sis.studentinfo;

import java.util.Date;
//import static sis.studentinfo.DateUtil.*;

public class CourseSessionTest extends SessionTest {

    public void testCourseDate() {
        Date startDate = DateUtil.createDate(2003, 1, 6);
        Session session = createSession(createCourse(), startDate);
        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }
    
    private Course createCourse() {
		return new Course("ENGL", "200");
	}

	public void testCount() {
        CourseSession.resetCount();
        createSession(createCourse(), new Date());
        assertEquals(1, CourseSession.getCount());
        createSession(createCourse(), new Date());
        assertEquals(2, CourseSession.getCount());
    }
    
    protected Session createSession(Course course, Date startDate) {
        return CourseSession.create(course, startDate);
    }

}
