package com.example;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mateusz on 2016-07-15.
 */

public class RomanChars {

    private final static List<RomanChar> romanChars;
    private static int currentIndex;

    static {
        romanChars = new ArrayList<>();
        Collections.addAll(romanChars, RomanChar.values());
        currentIndex = romanChars.size() - 1;
    }

    public static boolean contains(char c){
        for (RomanChar romanChar : romanChars) {
            if (romanChar.getName() == c){
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static RomanChar get(char c) {
        for (RomanChar romanChar : romanChars){
            if (romanChar.getName() == c){
                return romanChar;
            }
        }
        return null;
    }

    @Nullable
    public static RomanChar get(String s){
        return get(s.charAt(0));
    }

    //smaller or equals = number + 1;
    public static String getBiggestNumeralSmallerThan(int number) {
        String nearlyNumeral = Character.toString(RomanChar.I.getName());
        int nearlyNumber = RomanChar.I.getValue();

        for (RomanChar candidate : romanChars) {
            String candidateName = Character.toString(candidate.getName());
            int candidateValue = candidate.getValue();
            if (candidateValue > nearlyNumber) {
                if (candidateValue < number) {
                    nearlyNumber = candidateValue;
                    nearlyNumeral = candidateName;
                }
            }
        }
        return nearlyNumeral;
    }
}
