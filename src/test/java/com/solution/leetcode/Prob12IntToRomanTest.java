package com.solution.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Prob12IntToRomanTest {
    private Prob12IntToRoman prob12Instance;

    @Before
    public void setup() {
        prob12Instance = new Prob12IntToRoman();
    }

    @Test
    public void run() {
        assertEquals("XV", prob12Instance.intToRoman(15));
        assertEquals("MCMXCIV", prob12Instance.intToRoman(1994));
        assertEquals("III", prob12Instance.intToRoman(3));
    }
}
