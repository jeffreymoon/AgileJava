package sis.summer;

import java.util.Date;

import sis.studentinfo.Course;
import sis.studentinfo.Session;

public class SummerCourseSession extends Session {

    public SummerCourseSession(Course course, Date startDate) {
        super(course, startDate);
    }

    public static SummerCourseSession create(Course course, Date startDate) {
        return new SummerCourseSession(course, startDate);
    }
    
    @Override
    protected int getSessionLength() {
        return 8;
    }
}
