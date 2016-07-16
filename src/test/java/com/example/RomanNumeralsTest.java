package com.example;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Mateusz on 2016-07-15.
 */

public class RomanNumeralsTest {

    private RomanNumerals romanNumerals;

    @Before
    public void tierUp(){
        romanNumerals = new RomanNumerals();
    }

    @Test
    public void shouldBeValid(){
        assertTrue(romanNumerals.isValid("XVIII"));
        assertTrue(romanNumerals.isValid("CDXCII"));
        assertTrue(romanNumerals.isValid("MDCLXVI"));
        assertTrue(romanNumerals.isValid("mdclxvi"));
    }

    @Test
    public void shouldBeInvalid(){
        assertFalse(romanNumerals.isValid("XVIIE"));
        assertFalse(romanNumerals.isValid("124"));
        assertFalse(romanNumerals.isValid("xif"));
    }

    @Test
    public void readCasualRomanNumerals(){
        assertEquals(8, romanNumerals.convert("VIII"));
        assertEquals(8, romanNumerals.convert("viii"));
        assertEquals(626, romanNumerals.convert("DCXXVI"));
        assertEquals(1001, romanNumerals.convert("MI"));
    }

    @Test
    public void readRomanNumeralsWithShift(){
        assertEquals(9, romanNumerals.convert("IX"));
        assertEquals(9, romanNumerals.convert("ix"));
        assertEquals(629, romanNumerals.convert("DCXXIX"));
        assertEquals(999, romanNumerals.convert("CMXCIX"));
    }

    @Test
    public void convertCasualNumbersToRomanNotation(){
        assertEquals("VIII", romanNumerals.convert(8));
        assertEquals("DCXXVI", romanNumerals.convert(626));
        assertEquals("MI", romanNumerals.convert(1001));
    }

    @Test
    public void convertNumbersWithShiftToRomanNotation(){
        assertEquals("IX", romanNumerals.convert(9));
        assertEquals("DCXXIX", romanNumerals.convert(629));
        assertEquals("CMXCIX", romanNumerals.convert(999));
    }

}