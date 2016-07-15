package com.example;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Mateusz on 2016-07-15.
 */

@Component
public class RomanNumerals {



    public boolean isValid(String string) {
        string = string.toUpperCase();
        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if (!RomanChars.contains(c)){
                return false;
            }
        }
        return true;
    }

    public String convert(int number) {

        final StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.toString();
    }

    //string must be validate before call this
    //use isValid() method
    public int convert(String romanNumeral){

        romanNumeral = romanNumeral.toUpperCase();
        int numeralLength = romanNumeral.length();
        int value = 0;

        Character currentChar;
        @Nullable Character nextChar;

        for(int i = 0; i < romanNumeral.length(); i++){
            currentChar = romanNumeral.charAt(i);
            nextChar = (i+1 < numeralLength) ? romanNumeral.charAt(i+1) : null;
            value += checkValue(currentChar, nextChar);
        }
        return value;
    }

    static private boolean skip = false;
    private int checkValue(Character currentChar, @Nullable Character nextChar) {
        if (skip){
            skip = false;
            return 0;
        } else if (nextChar == null){
            return RomanChars.get(currentChar).getValue();
        }

        RomanChar current = RomanChars.get(currentChar);
        RomanChar next = RomanChars.get(nextChar);

        if (current.getValue() >= next.getValue()){
            return current.getValue();
        } else {
            skip = true;
            return next.getValue() - current.getValue();
        }
    }
}
