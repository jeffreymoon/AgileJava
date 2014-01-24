package sis.studentinfo;

import java.util.Date;

public class CourseSession extends Session {

    private static int count;
    
    public static CourseSession create(Course course, Date startDate) {
    	CourseSession.incrementCount();
        return new CourseSession(course, startDate);
    }
    
    protected CourseSession(Course course, Date startDate) {
        super(course, startDate);
    }

    private static void incrementCount() {
        count++;
    }

    public static void resetCount() {
        count = 0;
    }

    public static int getCount() {
        return count;
    }

    protected int getSessionLength() {
        return 16;
    }

}
