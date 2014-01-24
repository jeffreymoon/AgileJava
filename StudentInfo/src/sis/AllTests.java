package sis;

import junit.framework.TestSuite;
import sis.report.CourseReportTest;
import sis.report.ReportCardTest;
import sis.report.RosterReporterTest;
import sis.studentinfo.BasicGradingStrategyTest;
import sis.studentinfo.CourseSessionTest;
import sis.studentinfo.CourseTest;
import sis.studentinfo.DateUtilTest;
import sis.studentinfo.HonorsGradingStrategyTest;
import sis.studentinfo.SessionTest;
import sis.studentinfo.StudentDirectoryTest;
import sis.studentinfo.StudentTest;
import sis.summer.SummerCourseSessionTest;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(RosterReporterTest.class);
        suite.addTestSuite(DateUtilTest.class);
        suite.addTestSuite(CourseReportTest.class);
        suite.addTestSuite(ReportCardTest.class);
        suite.addTestSuite(BasicGradingStrategyTest.class);
        suite.addTestSuite(HonorsGradingStrategyTest.class);
        suite.addTestSuite(SummerCourseSessionTest.class);
        suite.addTestSuite(SessionTest.class);
        suite.addTestSuite(StudentDirectoryTest.class);
        suite.addTestSuite(CourseTest.class);
        return suite;
    }
}
