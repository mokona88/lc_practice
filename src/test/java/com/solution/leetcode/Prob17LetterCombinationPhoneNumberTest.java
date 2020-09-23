package com.solution.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Prob17LetterCombinationPhoneNumberTest {
    private Prob17LetterCombinationPhoneNumber prob17Instance;

    @Before
    public void setup() {
        prob17Instance = new Prob17LetterCombinationPhoneNumber();
    }

    @Test
    public void run() {
        List<String> expectedValues = new ArrayList<>();
        Collections.addAll(expectedValues, "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(expectedValues, prob17Instance.letterCombinations("23"));
    }
}
