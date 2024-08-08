package org.zorkclone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("                    ZORK CLONE");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");

        String optionChoice;
        HelperClass helper = new HelperClass();
        GameClass game = new GameClass();

        while (true) {
            System.out.println("Select:  ");
            System.out.println("1. New Game");
            System.out.println("2(Or every other key). Quit");

            optionChoice = (helper.readInput());

            if (optionChoice.equals("1")) {
                game.startGame();
            } else {
                break;
            }
        }
    }
}