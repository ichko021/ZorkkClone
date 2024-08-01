package org.zorkclone;

import java.util.Scanner;

public class HelperClass {

    private Scanner scanner;
    
    public HelperClass() {
        this.scanner = new Scanner(System.in);
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public String filterCommand(String input) {

        if (input.contains("open")) {
            return "open";
        } else if (input.contains("inspect")) {
            return "inspect";
        } else if (input.contains("look")) {
            return "look";
        } else {
            return "invalid";
        }
    }

    public String filterItem(String input) {

        if (input.contains("door")) {
            return "door";
        } else if (input.contains("chest")) {
            return "chest";
        } else if (input.contains("around")) {
            return "around";
        } else {
            return "invalid";
        }
    }

}
