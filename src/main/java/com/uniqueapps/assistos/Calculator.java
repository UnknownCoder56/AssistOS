package com.uniqueapps.assistos;

public class Calculator {

    HomeScreen homeScreen;
    int input = 0;
    double num1, num2, answer = 0;
    char opsign;
    boolean success = true;

    public Calculator(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

    public void run() {
        homeScreen.currentProgram = HomeScreen.Program.CALC;
        homeScreen.calc = this;
        HomeScreen.addTextToConsole(homeScreen, "Enter first number: ");
    }

    public void onInput(String text) {
        switch (input) {
            case 0 -> {
                num1 = Integer.parseInt(text);
                HomeScreen.addTextToConsole(homeScreen, "Enter second number: ");
                input++;
            }
            case 1 -> {
                num2 = Integer.parseInt(text);
                HomeScreen.addTextToConsole(homeScreen, """
                              Choose an operation:-
                              + - Addition
                              - - Subtraction
                              * - Multiplication
                              / - Division
                              & - Square Root (of first number)
                              ^ - Power/Exponent (first number raised to second number)
                              % - Mod (Division Remainder)
                              ! - Exit
                              
                              Enter operation character: """);
                input++;
            }
            case 2 -> {
                opsign = text.charAt(0);
                switch (opsign) {
                    case '+' ->
                        answer = num1 + num2;
                    case '-' ->
                        answer = num1 - num2;
                    case '*' ->
                        answer = num1 * num2;
                    case '/' ->
                        answer = num1 / num2;
                    case '&' ->
                        answer = Math.sqrt(num1);
                    case '^' ->
                        answer = Math.pow(num1, num2);
                    case '%' ->
                        answer = num1 % num2;
                    case '!' -> {
                        HomeScreen.addTextToConsole(homeScreen, "");
                        success = false;
                    }
                    default -> {
                        HomeScreen.addTextToConsole(homeScreen, "Wrong option entered: " + opsign);
                        success = false;
                    }
                }
                if (success) {
                    HomeScreen.addTextToConsole(homeScreen, "Answer: " + num1 + " " + opsign + " " + num2 + " = " + answer);
                }
                success = true;
                input = 0;
                homeScreen.currentProgram = HomeScreen.Program.KERNEL;
            }
        }
    }
}
