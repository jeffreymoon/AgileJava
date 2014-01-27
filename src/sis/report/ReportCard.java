package sis.report;

import java.util.Map;
import java.util.EnumMap;
import sis.studentinfo.Student.Grade;

public class ReportCard {

    public static final String A_MESSAGE = "Excellent";
    public static final String B_MESSAGE = "Very Good";
    public static final String C_MESSAGE = "Hmmm...";
    public static final String D_MESSAGE = "You are not trying";
    public static final String F_MESSAGE = "Loser";
    private Map<Grade, String> messages = null;
    
    public String getMessage(Grade grade) {
        return getMessages().get(grade);
    }

    public Map<Grade, String> getMessages() {
        if (messages == null) {
            loadMessages();
        }
        return messages;
    }

    private void loadMessages() {
        messages = new EnumMap<Grade, String>(Grade.class);
        messages.put(Grade.A, A_MESSAGE);
        messages.put(Grade.B, B_MESSAGE);
        messages.put(Grade.C, C_MESSAGE);
        messages.put(Grade.D, D_MESSAGE);
        messages.put(Grade.F, F_MESSAGE);
    }

    
}
