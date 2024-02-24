package com.uniqueapps.assistos;

public class OSKernel {
    
    String name = "";
    Calculator calc;

    public OSKernel(HomeScreen homeScreen) {
        for (int i=0; i < 11; i++) {
            name += Integer.toString((int) (Math.random() * 10));
        }
        calc = new Calculator(homeScreen);
    }
    
    public String enterCommand(String command) {
        switch(command) {
            case "info" -> {
                return "Session no. - " + name;
            }
            case "help" -> {
                return "Commands: info, help, calc, exit";
            }
            case "calc" -> {
                calc.run();
                return "";
            }
            case "exit" -> {
                System.exit(0);
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
