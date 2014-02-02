package sis.report;

import static sis.report.ReportConstant.NEWLINE;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import sis.studentinfo.Session;
import sis.studentinfo.Student;

public class RosterReporter {

    public static final String ROSTER_REPORT_HEADER = "Student%n-%n";
    public static final String ROSTER_REPORT_FOOTER = "%n# students = %d%n";
    private Session session;
	private Writer writer;

    public RosterReporter(Session session) {
        this.session = session;
    }

    public String getReport() {
        StringBuilder buffer = new StringBuilder();
        writeHeader(buffer);
        writeBody(buffer);
        wirteFooter(buffer);
        return buffer.toString();
    }

    private void wirteFooter(StringBuilder buffer) {
        buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + NEWLINE);
    }

    private void writeBody(StringBuilder buffer) {
        for (Student student : session.getAllStudents()) {
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }
    }

    private void writeHeader(StringBuilder buffer) {
        buffer.append(ROSTER_REPORT_HEADER);
    }
    
    public void writeReport(String filename) throws IOException {
    	Writer bufferedWriter = new BufferedWriter(new FileWriter(filename));
    	try {
    		writeReport(bufferedWriter);
    	}
    	finally {
    		bufferedWriter.close();
    	}
    }

	public void writeReport(Writer writer) throws IOException {
		this.writer = writer;
		writeHeader();
		writeBody();
		writeFooter();
	}

	private void writeFooter() throws IOException {
		writer.write(String.format(ROSTER_REPORT_FOOTER
				, session.getAllStudents().size()));
	}

	private void writeBody() throws IOException {
		for (Student student : session.getAllStudents()) {
			writer.write(String.format(student.getName() + "%n"));
		}
	}

	private void writeHeader() throws IOException {
		writer.write(String.format(ROSTER_REPORT_HEADER));
	}

}
