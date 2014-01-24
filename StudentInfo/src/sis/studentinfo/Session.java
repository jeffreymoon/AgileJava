package sis.studentinfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public abstract class Session implements Comparable<Session>, Iterable<Student>{

//    private static int count;
//    private String department;
//    private String number;
    private Course course;
//    private List<Student> students = new ArrayList<Student>();
    private Vector<Student> students = new Vector<Student>();
    private Date startDate;
    private int numberOfCredits;
    private URL url;

    protected Session(Course course, Date startDate) {
//        this.department = course.getDepartment();
//        this.number = course.getNumber();
    	this.course = course;
        this.startDate = startDate;
    }

    @Override
    public int compareTo(Session that) {
        int compare = this.getDepartment().compareTo(that.getDepartment());
        if (0 == compare) {
            compare = this.getNumber().compareTo(that.getNumber());
        }
        return compare;
    }
    
    void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
    
    public String getDepartment() {
        return course.getDepartment();
    }

    public String getNumber() {
        return course.getNumber();
    }

    int getNumberOfStudents() {
        return students.size();
    }

    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    Student get(int index) {
        return students.get(index);
    }
    
    protected Date getStartDate() {
        return startDate;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    abstract protected int getSessionLength();
    
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;
        int numberOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
    
    double averageGpaForPartTimeStudents() {
        double total = 0.0;
        int count = 0;
        for (Enumeration<Student> it = students.elements(); it.hasMoreElements(); ) {
            Student student = it.nextElement();
            if (student.isFullTime()) {
                continue;
            }
            count++;
            total += student.getGpa();
        }
        if (count == 0) {
            return 0.0;
        }
        return total / count;
    }
    
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public void setUrl(String urlString) throws SessionException {
        try {
            this.url = new URL(urlString);
        } catch (MalformedURLException e) {
            log(e);
            throw new SessionException(e);
        }
    }
    
    private void log(MalformedURLException e) {
        e.printStackTrace();
    }

    public URL getUrl() {
        return url;
    }
}
