package sis.report;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import junit.framework.TestCase;
import sis.studentinfo.Course;
import sis.studentinfo.CourseSession;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Session;
import sis.studentinfo.Student;

public class RosterReporterTest extends TestCase {
	private Session session;
	
	protected void setUp() {
		session = CourseSession.create(new Course("ENGL", "101"),
				DateUtil.createDate(2003, 1, 6));
		
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
	}

	public void testRosterReport() throws IOException {
		Writer writer = new StringWriter();
		new RosterReporter(session).writeReport(writer);
		assertReportContents(writer.toString());
	}
	
	public void assertReportContents(String rosterReport) {
		
		assertEquals(
				String.format(RosterReporter.ROSTER_REPORT_HEADER
							+ "A%n"
							+ "B%n"
							+ RosterReporter.ROSTER_REPORT_FOOTER, 2)
				, rosterReport);
	}

	public void testFileReport() throws IOException {
		final String filename = "testFiledReport.txt";
		new RosterReporter(session).writeReport(filename);
		
		StringBuffer buffer = new StringBuffer();
		String line;
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		while ((line = reader.readLine()) != null) {
			buffer.append(String.format(line + "%n"));
		}
		reader.close();
		
		assertReportContents(buffer.toString());
	}
}
