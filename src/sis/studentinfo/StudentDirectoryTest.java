package sis.studentinfo;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class StudentDirectoryTest extends TestCase {

    private StudentDirectory dir;
    
    @Before
    protected void setUp() {
        dir = new StudentDirectory();
    }
    
    @Test
    public void testStoreAndRetrieve() throws IOException {
        final int numberOfStudents = 10;
        for (int i = 0; i < numberOfStudents; i++) {
            addStudent(dir, i);
        }
        for (int i = 0; i < numberOfStudents; i++) {
            verifyStudentLookup(dir, i);
        }
    }

    private void addStudent(StudentDirectory directory, int i) throws IOException {
        String id = "" + i;
        Student student = new Student(id);
        student.setId(id);
        student.addCredits(i);
        directory.add(student);
    }
    
    private void verifyStudentLookup(StudentDirectory directory, int i) {
        String id = "" + i;
        Student student = dir.findById(id);
        assertEquals(id, student.getLastName());
        assertEquals(id, student.getId());
        assertEquals(i, student.getCredits());
    }

}
