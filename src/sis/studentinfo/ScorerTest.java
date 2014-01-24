package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScorerTest {

    @Test
    public void testCaptureScore() {
        Scorer scorer = new Scorer();
        assertEquals(75, scorer.score("75"));
    }

    @Test
    public void testBadScoreEntered() {
        Scorer scorer = new Scorer();
        try {
            scorer.score("abd");
            fail("excepted NumberFormatException on bad input");
        } catch (NumberFormatException sucess) {
            
        }
    }
    
    @Test
    public void testIsValid() {
        Scorer scorer = new Scorer();
        assertTrue(scorer.isValid("75"));
        assertFalse(scorer.isValid("bd"));
    }
}
