/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniqueapps.assistos;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class Calculator implements Runnable {

    @Override
    public void run() {

        try (java.util.Scanner scn = new Scanner(System.in)) {
            double num1, num2, answer = 0;
            char opsign;
            boolean success = true;
            System.out.println("Calculator\n----------\n");
            System.out.println("Enter first number: ");
            try {
                if (scn.hasNext()) {
                    System.out.println("Calculator\n----------\n");
                    System.out.println("Enter first number: ");
                    num1 = scn.nextDouble();
                    System.out.println("Enter second number: ");
                    num2 = scn.nextDouble();
                    System.out.println("\nChoose an operation:-\n"
                            + "+ - Addition\n"
                            + "- - Subtraction\n"
                            + "* - Multiplication\n"
                            + "/ - Division\n"
                            + "& - Square Root (of first number)\n"
                            + "^ - Power/Exponent (first number raised to second number)\n"
                            + "% - Mod (Division Remainder)"
                            + "! - Exit");
                    System.out.println("Enter operation character: ");
                    opsign = scn.next().charAt(0);
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
                        case '!' ->
                            answer = num1 % num2;
                        default -> {
                            System.out.println("Wrong option entered: " + opsign);
                            success = false;
                        }
                    }
                    if (success) {
                        System.out.println("Answer: " + num1 + " " + opsign + " " + num2 + " = " + answer);
                        scn.close();
                    }
                } else {
                    System.out.println("No next");
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }
}
