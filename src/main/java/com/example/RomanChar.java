package com.example;

/**
 * Created by Mateusz on 2016-07-15.
 */

public enum RomanChar {
    I('I', 1), V('V', 5), X('X', 10), L('L', 50), C('C', 100), D('D', 500), M('M', 1000);

    private char name;
    private int value;

    RomanChar(char name, int value){
        this.name = name;
        this.value = value;
    }

    public char getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public  boolean isLessThan(int number){
        return this.value < number;
    }

    public boolean isGraterThan(int number){
        return this.value > number;
    }

    @Override
    public String toString(){
        return String.valueOf(name);
    }
}
