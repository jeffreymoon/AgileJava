package sis.studentinfo;

import java.util.logging.Handler;

import junit.framework.TestCase;

import org.junit.Test;

public class StudentTest extends TestCase {

    private static final double GRADE_TOLERANCE = 0.05;

    @Test
    public void testCreate() {
        final String firstStudentName = "Jane Doe";
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudentName, firstStudent.getName());
        assertEquals("Jane", firstStudent.getFirstName());
        assertEquals("Doe", firstStudent.getLastName());
        assertEquals("", firstStudent.getMiddleName());

        final String secondStudentName = "Blow";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());
        assertEquals("", secondStudent.getFirstName());
        assertEquals("Blow", secondStudent.getLastName());
        assertEquals("", secondStudent.getMiddleName());

        final String thirdStudentName = "Raymond Douglas Davies";
        Student thirdStudent = new Student(thirdStudentName);
        assertEquals(thirdStudentName, thirdStudent.getName());
        assertEquals("Raymond", thirdStudent.getFirstName());
        assertEquals("Davies", thirdStudent.getLastName());
        assertEquals("Douglas", thirdStudent.getMiddleName());

    }

    public void testFullTime() {
        Student student = new Student("a");
        assertFalse(student.isFullTime());
    }

    public void testCredits() {
        Student student = new Student("a");
        assertEquals(0, student.getCredits());
        assertFalse(student.isFullTime());
        student.addCredits(3);
        assertEquals(3, student.getCredits());
        assertFalse(student.isFullTime());
        student.addCredits(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());
        student.addCredits(5);
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
        assertTrue(student.isFullTime());
    }

    public void testInState() {
        Student student = new Student("a");
        assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());
    }

    public void testCalculateGpa() {
        Student student = new Student("a");
        assertGpa(0.0, student);
        student.addGrade(Student.Grade.A);
        assertGpa(4.0, student);
        student.addGrade(Student.Grade.B);
        assertGpa(3.5, student);
        student.addGrade(Student.Grade.C);
        assertGpa(3.0, student);
        student.addGrade(Student.Grade.D);
        assertGpa(2.5, student);
        student.addGrade(Student.Grade.F);
        assertGpa(2.0, student);
    }

    private void assertGpa(Double expectedGpa, Student student) {
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }

    public void testCalculateHonorsSTudentGpa() {
        assertGpa(0.0, createHonorsStudent());
        assertGpa(5.0, createHonorsStudent(Student.Grade.A));
        assertGpa(4.0, createHonorsStudent(Student.Grade.B));
        assertGpa(3.0, createHonorsStudent(Student.Grade.C));
    }

    private Student createHonorsStudent() {
        Student student = new Student("a");
        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }

    private Student createHonorsStudent(Student.Grade grade) {
        Student student = createHonorsStudent();
        student.addGrade(grade);
        return student;
    }

    public void testCharges() {
        Student student = new Student("a");
        student.addCharge(500);
        student.addCharge(200);
        student.addCharge(399);
        assertEquals(1099, student.totalCharges());
    }

    @Test
    public void testBadlyFormattedName() {
        Handler handler = new TestHandler();
        Student.logger.addHandler(handler);
        final String studentName = "a b c d";
        try {
            new Student(studentName);
            fail("excepted exception from 4-part name");
        } catch (StudentNameFormatException expectedException) {
            String message = String.format(Student.TOO_MANY_NAME_PARTS_MSG, studentName,
                    Student.MAX_NAME_PARTS);
            assertEquals(message, expectedException.getMessage());
            assertEquals(message, ((TestHandler)handler).getMessage());
        }
    }

    private boolean wasLogged(String message, TestHandler handler) {
        return message.equals(handler.getMessage());
    }
}
