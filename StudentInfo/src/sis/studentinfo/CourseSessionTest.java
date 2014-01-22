package sis.studentinfo;

import java.util.Date;
//import static sis.studentinfo.DateUtil.*;

public class CourseSessionTest extends SessionTest {

    public void testCourseDate() {
        Date startDate = DateUtil.createDate(2003, 1, 6);
        Session session = createSession("ENGL", "200", startDate);
        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }
    
    public void testCount() {
        CourseSession.resetCount();
        createSession("", "", new Date());
        assertEquals(1, CourseSession.getCount());
        createSession("", "", new Date());
        assertEquals(2, CourseSession.getCount());
    }
    
    protected Session createSession(String department, String number, Date startDate) {
        return CourseSession.create(department, number, startDate);
    }

}
