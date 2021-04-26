package com.company;

import java.util.InputMismatchException;

public class RomanNumberConverter {

    private static boolean isRoman(String number) {
        boolean isRoman = true;

        String notRomanNumerals = number.replaceAll("[IVXLCDM]+", "_");

        for(int i=0; i<notRomanNumerals.length(); i++) {
            if(notRomanNumerals.charAt(i) != '_') {
                isRoman = false;
            }
        }

        return isRoman;
    }

    public static int toArabic(String number) {

        if (!isRoman(number))
            throw new InputMismatchException("Invalid input!");

        if (number == null || number.length() == 0)
            throw new InputMismatchException("Invalid conversion of Roman numerals to Arabic numerals!");

        int arabic = 0;
        char currentChar = number.charAt(0);
        int currentValue = valueOfRoman(currentChar);

        for (int i = 1; i < number.length(); i++) {

            char next = number.charAt(i);
            int value = valueOfRoman(next);

            if (value <= valueOfRoman(currentChar)) {
                arabic += currentValue;
            } else {
                arabic -= currentValue;
            }

            currentValue = valueOfRoman(next);

            currentChar = next;
        }

        return arabic + currentValue;
    }

    static int valueOfRoman(char c) {

        if (c == 'X') {
            return 10;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'I') {
            return 1;
        }

        return -1;
    }

    public static String toRoman(int number) {

        if (number < 1 || number > 3999)
            throw new InputMismatchException("Invalid Roman Number Value");

        String roman = "";

        while (number >= 1000) {
            roman += "M";
            number -= 1000;        }
        while (number >= 900) {
            roman += "CM";
            number -= 900;
        }
        while (number >= 500) {
            roman += "D";
            number -= 500;
        }
        while (number >= 400) {
            roman += "CD";
            number -= 400;
        }
        while (number >= 100) {
            roman += "C";
            number -= 100;
        }
        while (number >= 90) {
            roman += "XC";
            number -= 90;
        }
        while (number >= 50) {
            roman += "L";
            number -= 50;
        }
        while (number >= 40) {
            roman += "XL";
            number -= 40;
        }
        while (number >= 10) {
            roman += "X";
            number -= 10;
        }
        while (number >= 9) {
            roman += "IX";
            number -= 9;
        }
        while (number >= 5) {
            roman += "V";
            number -= 5;
        }
        while (number >= 4) {
            roman += "IV";
            number -= 4;
        }
        while (number >= 1) {
            roman += "I";
            number -= 1;
        }

        return roman;
    }
}
