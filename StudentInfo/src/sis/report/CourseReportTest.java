package sis.report;

import java.util.ArrayList;
import java.util.Date;

import static sis.report.ReportConstant.NEWLINE;
import sis.studentinfo.CourseSession;
import junit.framework.TestCase;

public class CourseReportTest extends TestCase{

    public void testReport() {
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(CourseSession.create("ENGL", "101", date));
        report.add(CourseSession.create("CZEC", "200", date));
        report.add(CourseSession.create("ITAL", "410", date));
        report.add(CourseSession.create("CZEC", "220", date));
        report.add(CourseSession.create("ITAL", "330", date));
        
        assertEquals(
                "CZEC 200" + NEWLINE +
                "CZEC 220" + NEWLINE +
                "ENGL 101" + NEWLINE +
                "ITAL 330" + NEWLINE +
                "ITAL 410" + NEWLINE,
                report.text());
    }
    
    
    public void testSortStringInPlace() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        java.util.Collections.sort(list);
        assertEquals("Boyle", list.get(0));
        assertEquals("Camus", list.get(1));
        assertEquals("Heller", list.get(2));
        assertEquals("Kafka", list.get(3));
    }
    
    public void testSortStringInNewList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        ArrayList<String> sortedList = new ArrayList<String>(list);
        java.util.Collections.sort(sortedList);
        assertEquals("Boyle", sortedList.get(0));
        assertEquals("Camus", sortedList.get(1));
        assertEquals("Heller", sortedList.get(2));
        assertEquals("Kafka", sortedList.get(3));
        
        assertEquals("Heller", list.get(0));
        assertEquals("Kafka", list.get(1));
        assertEquals("Camus", list.get(2));
        assertEquals("Boyle", list.get(3));
    }
    
    public void testStringCompareTo() {
        assertTrue("A".compareTo("B") < 0);
        assertEquals(0, "A".compareTo("A"));
        assertTrue("B".compareTo("A") > 0);
    }
}
