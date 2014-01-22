package sis.report;

import junit.framework.TestCase;

public class PalindromeTest extends TestCase {

    public static boolean isPalindrome(String string) {
        if (string.length() == 0) {
            return true;
        }
        int limit = string.length() / 2;
        for (int forward = 0, backward = string.length() - 1;
                forward < limit;
                forward++, backward--) {
            if (string.charAt(forward) != string.charAt(backward)) {
                return false;
            }
        }
        return true;
    }
    
    public void testPalindrome() {
        assertFalse(isPalindrome("abcdvf"));
        assertFalse(isPalindrome("abccda"));
        assertTrue(isPalindrome("abccba"));
        assertFalse(isPalindrome("abcxba"));
        assertTrue(isPalindrome("a"));
        assertTrue(isPalindrome("aa"));
        assertFalse(isPalindrome("ab"));
        assertTrue(isPalindrome(""));
        assertTrue(isPalindrome("aaa"));
        assertTrue(isPalindrome("aba"));
        assertTrue(isPalindrome("abbba"));
        assertTrue(isPalindrome("abba"));
        assertFalse(isPalindrome("abbaa"));
        assertFalse(isPalindrome("abcda"));
    }
}
