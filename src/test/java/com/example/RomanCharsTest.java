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
        assertEquals("I", RomanChars.getBiggestNumeralSmallerThan(3));
        assertEquals("L", RomanChars.getBiggestNumeralSmallerThan(84));
        assertEquals("C", RomanChars.getBiggestNumeralSmallerThan(364));
        assertEquals("M", RomanChars.getBiggestNumeralSmallerThan(1023));
        assertEquals("D", RomanChars.getBiggestNumeralSmallerThan(677));
    }

    @Test
    public void shouldReturnClosestNumber(){
        assertEquals("I", RomanChars.getBiggestNumeralSmallerThan(2));
        assertEquals("I", RomanChars.getBiggestNumeralSmallerThan(4));
        assertEquals("I", RomanChars.getBiggestNumeralSmallerThan(5));
        assertEquals("V", RomanChars.getBiggestNumeralSmallerThan(6));
        assertEquals("V", RomanChars.getBiggestNumeralSmallerThan(9));
        assertEquals("V", RomanChars.getBiggestNumeralSmallerThan(10));
        assertEquals("X", RomanChars.getBiggestNumeralSmallerThan(11));

    }
}