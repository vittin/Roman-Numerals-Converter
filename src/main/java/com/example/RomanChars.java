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
    private static String getBiggestNumeralSmallerThan(int number) {
        String nearlyNumeral = RomanChar.I.toString();
        int nearlyNumber = RomanChar.I.getValue();

        for (RomanChar romanChar : romanChars){
            if (romanChar.isLessThan(number) && romanChar.isGraterThan(nearlyNumber)){
                nearlyNumber = romanChar.getValue();
                nearlyNumeral = romanChar.toString();
            }
        }
        return nearlyNumeral;
    }

    private static String getBiggerNumeralThan(RomanChar givenRomanChar){
        String nearlyNumeral = RomanChar.M.toString();
        int nearlyNumber = RomanChar.M.getValue();


        int givenRomanCharValue = givenRomanChar.getValue();

        for (RomanChar romanChar : romanChars){
            if (romanChar.isGraterThan(givenRomanCharValue) && romanChar.isLessThan(nearlyNumber)){
                nearlyNumber = romanChar.getValue();
                nearlyNumeral = romanChar.toString();
            }
        }

        return nearlyNumeral;
    }

    public static String getBestNumeral(int number) {

        RomanChar candidate = get(getBiggestNumeralSmallerThan(number+1));
        int candidateValue = candidate.getValue();

        RomanChar biggerCandidate = get(getBiggerNumeralThan(candidate));
        int biggerCharValue = biggerCandidate.getValue();

        RomanChar prefixCandidate = get(getBiggestNumeralSmallerThan(biggerCharValue));
        int prefixCandidateValue = prefixCandidate.getValue();

        int togetherValue = biggerCharValue - prefixCandidateValue;
        String bestChoice = candidate.toString();

        RomanChar oldPrefix = null;
        while (togetherValue <= number && prefixCandidate != oldPrefix){

            if (candidate.isLessThan(togetherValue)){
                bestChoice = prefixCandidate.toString() + biggerCandidate.toString();
                number = 0;
            }

            oldPrefix = prefixCandidate;
            prefixCandidate = get(getBiggestNumeralSmallerThan(prefixCandidateValue));
            prefixCandidateValue = prefixCandidate.getValue();
            togetherValue = biggerCharValue - prefixCandidateValue;
        }

        return bestChoice;
    }
}
