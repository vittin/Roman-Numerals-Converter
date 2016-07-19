package com.example;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    //string must be validate before call this
    //use isValid() method
    public int convert(String romanNumeral) {

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

    public String convert(int number) {

        final StringBuilder stringBuilder = new StringBuilder();
        List<Integer> preparedNumbers = prepareNumbers(number);
        for (Integer preparedNumber : preparedNumbers) {
            String numeral = createNumeral(preparedNumber);
            stringBuilder.append(numeral);
        }

        final String result = stringBuilder.toString();

        return result;
    }

    private List<Integer> prepareNumbers(int number) {
        List<Integer> preparedNumber = new ArrayList<>();
        preparedNumber.add(0, number);
        int index = 1;
        while (number > 0){
            int poweredModulo = (int) Math.pow(10, String.valueOf(number).length() - 1);

            number = number % (poweredModulo);
            preparedNumber.add(index, number);

            int rightValue = preparedNumber.get(index - 1) - number;
            preparedNumber.set(index - 1, rightValue);
            index += 1;
            if (number < 10){
                number = 0;
            }
        }

        return preparedNumber;
    }

    @NotNull
    private String createNumeral(Integer preparedNumber) {
        StringBuilder subStringBuilder = new StringBuilder();

        while (preparedNumber > 0){
            String numeral = RomanChars.getBestNumeral(preparedNumber);
            subStringBuilder.append(numeral);
            preparedNumber -= convert(numeral);

        }

        return subStringBuilder.toString();
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
