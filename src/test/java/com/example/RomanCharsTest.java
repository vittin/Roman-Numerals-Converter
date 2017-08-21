package com.example;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Mateusz on 2016-07-15.
 */

public class RomanCharsTest {

    @Test
    public void shouldContainsChar(){
        assertTrue(RomanChars.contains('D'));
        assertTrue(RomanChars.contains('I'));
        assertTrue(RomanChars.contains('X'));
        assertTrue(RomanChars.contains('C'));

    }

    @Test
    public void shouldNotContainsChar(){
        assertFalse(RomanChars.contains('W'));
        assertFalse(RomanChars.contains('Z'));
        assertFalse(RomanChars.contains('B'));
        assertFalse(RomanChars.contains('J'));

    }

    @Test
    public void shouldReturnBiggerNumeralSmallerThanGivenNumber(){
        assertEquals("I", RomanChars.getBestNumeral(3));
        assertEquals("L", RomanChars.getBestNumeral(84));
        assertEquals("C", RomanChars.getBestNumeral(364));
        assertEquals("M", RomanChars.getBestNumeral(1023));
        assertEquals("D", RomanChars.getBestNumeral(677));
    }

    @Test
    public void shouldReturnClosestNumber(){
        assertEquals("I", RomanChars.getBestNumeral(2));
        assertEquals("IV", RomanChars.getBestNumeral(4));
        assertEquals("V", RomanChars.getBestNumeral(5));
        assertEquals("V", RomanChars.getBestNumeral(6));
        assertEquals("IX", RomanChars.getBestNumeral(9));
        assertEquals("X", RomanChars.getBestNumeral(10));
        assertEquals("X", RomanChars.getBestNumeral(11));

    }
}