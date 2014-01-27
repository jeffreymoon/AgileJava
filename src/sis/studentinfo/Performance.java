package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Performance {

    private int[] tests = {};

    public void setNumberOfTests(int numberOfTests) {
        tests = new int[numberOfTests];
    }

    public void set(int testNumber, int score) {
        tests[testNumber] = score;
    }

    public int get(int testNumber) {
        return tests[testNumber];
    }

    public double average() {
    	if (tests.length == 0) {
    		return 0.0;
    	}
        double total = 0.0;
        for (int score : tests) {
            total += score;
        }
        return total / tests.length;
    }

    public void setScore(int score1, int score2, int score3, int score4) {
        tests = new int[] {score1, score2, score3, score4};
        int[] values = {1, 2, 3};
        int[] values2 = {
                1,
                2,
                3,
        };
    }

    public void setScore(int... tests) {
        this.tests = tests;
    }

    private List<String> split(String name) {
        List<String> results = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(name, " ");
        while (tokenizer.hasMoreTokens()) {
            results.add(tokenizer.nextToken());
        }
        return results;
    }
}
