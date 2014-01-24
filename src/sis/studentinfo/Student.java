package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Student {

    public enum Grade {
        A(4), B(3), C(2), D(1), F(0);

        private int points;

        Grade(int points) {
            this.points = points;
        }

        int getPoints() {
            return points;
        }
    }

    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s' contains more than %d parts";
    static final String IN_STATE = "CO";
    static final Logger logger = Logger.getLogger(Student.class.getName());
    private String name;
    private int credits;
    private String state;
    private ArrayList<Grade> grades = new ArrayList<Grade>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    private String firstName = "";
    private String lastName;
    private String middleName = "";
    private List<Integer> charges = new ArrayList<Integer>();
    private String id;
    static final int MAX_NAME_PARTS = 3;

    public Student(String fullName) {
        this.name = fullName;
        credits = 0;
        List<String> nameParts = split(fullName);
        if (nameParts.size() > MAX_NAME_PARTS) {
            String message = String.format(Student.TOO_MANY_NAME_PARTS_MSG, fullName,
                    MAX_NAME_PARTS);
            Student.logger.info(message);
            throw new StudentNameFormatException(message);
        }
        setName(nameParts);
        state = "";
    }

    private void log(String message) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.info(message);
    }

    private List<String> split(String name) {
        List<String> results = new ArrayList<String>();
        for (String splitName : name.split(" ")) {
            results.add(splitName);
        }
        return results;
        // List<String> results = new ArrayList<String>();
        //
        // StringBuffer word = new StringBuffer();
        // for (int index = 0; index < name.length(); index++) {
        // char ch = name.charAt(index);
        // if (ch != ' ') {
        // word.append(ch);
        // } else {
        // if (word.length() > 0) {
        // results.add(word.toString());
        // word = new StringBuffer();
        // }
        // }
        // }
        // if (word.length() > 0) {
        // results.add(word.toString());
        // }
        // return results;
    }

    private List<String> tokenize(String string) {
        List<String> results = new ArrayList<String>();

        StringBuffer word = new StringBuffer();
        int index = 0;
        while (index < string.length()) {
            char ch = string.charAt(index);
            if (ch != ' ') {
                word.append(ch);
            } else {
                if (word.length() > 0) {
                    results.add(word.toString());
                    word = new StringBuffer();
                }
                index++;
            }
        }
        if (word.length() > 0) {
            results.add(word.toString());
        }
        return results;
    }

    private void setName(List<String> nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty()) {
            this.firstName = name;
        } else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }

    private String removeLast(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        return list.remove(list.size() - 1);
    }

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return credits >= Student.CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public int getCredits() {
        return credits;
    }

    public void addCredits(int credits) {
        this.credits += credits;
    }

    public boolean isInState() {
        // return Student.IN_STATE.equals(state);
        return state.equals(Student.IN_STATE);
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getGpa() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (Grade grade : grades) {
            total += gradingStrategy.getGradePointsFor(grade);
        }
        return total / grades.size();
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void addCharge(int charge) {
        charges.add(charge);
    }

    public int totalCharges() {
        int total = 0;
        for (int charge : charges) {
            total += charge;
        }
        return total;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
