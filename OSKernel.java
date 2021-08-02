/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniqueapps.assistos;

/**
 *
 * @author Owner
 */
public class OSKernel {
    
    String name;
    Calculator calc;

    public OSKernel() {
        name = "SESSIONNO. ";
        for (int i=0; i < 11; i++) {
            name += Integer.toString((int) (Math.random() * 10));
        }
        calc = new Calculator();
    }
    
    public String enterCommand(String command) {
        switch(command) {
            case "info" -> {
                return "Session name - " + name;
            }
            case "help" -> {
                return "Commands: info, help, calc";
            }
            case "calc" -> {
                calc.run();
                return "";
            }
            default -> {
                return "Error: No such command found!";
            }
        }
    }

    public String getName() {
        return name;
    }    
}
