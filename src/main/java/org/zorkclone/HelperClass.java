package org.zorkclone;

import java.util.Scanner;

public class HelperClass {

    private Scanner scanner;
    private String[] listOfCommands;
    private String[] listOfObjects;

    public HelperClass() {
        this.scanner = new Scanner(System.in);
        this.listOfCommands = new String[]{"open", "look around", "go", "inspect", "show inventory", "light torch"};
        this.listOfObjects = new String[]{"door", "chest", "window", "key"};
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public String filterCommand(String input) {
        for(String word: listOfCommands) {
            if (input.toLowerCase().contains(word)) {
                return word;
            }
        }
        return "invalid";
    }

    public String filterItem(String input) {
        for(String word: listOfObjects) {
            if (input.toLowerCase().contains(word)) {
                return word;
            }
        }
        return "invalid";
    }
}
