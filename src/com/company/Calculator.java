package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Calculator {

    private static final String[] operations  = {"+", "-", "*", "/"};

    public static int performOperation(int a, int b, String operation) {

        if (!(a >= 1 && a <= 10) || !(b >= 1 && b <= 10))
            throw new InputMismatchException("The numbers must be in the range from 1 to 10 inclusive!");

        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new InputMismatchException("Invalid operation!");
        }
    }
}

