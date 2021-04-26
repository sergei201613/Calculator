package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NumeralSystem numeralSystem = NumeralSystem.ARABIC;

        int number1 = 0;
        String operation = " ";
        int number2 = 0;

        try {

            if (scanner.hasNextInt()) {
                number1 = scanner.nextInt();
                operation = scanner.next();
                number2 = scanner.nextInt();
            } else {
                numeralSystem = NumeralSystem.ROMAN;

                number1 = RomanNumberConverter.toArabic(scanner.next());
                operation = scanner.next();
                number2 = RomanNumberConverter.toArabic(scanner.next());
            }

            int result = Calculator.performOperation(number1, number2, operation);

            // Output
            if (numeralSystem == NumeralSystem.ARABIC)
                System.out.println(result);
            else
                System.out.println(RomanNumberConverter.toRoman(result));

        } catch (InputMismatchException e) {
            if (e.getMessage() == null)
                System.out.println("Invalid input!");
            else
                System.out.println(e.getMessage());
        }
    }
}
