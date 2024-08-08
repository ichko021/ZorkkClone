package org.zorkclone;

public class ThirdRoom extends Room {

    private boolean isCodeCorrect;

    public ThirdRoom() {
        this.isCodeCorrect = false;
    }

    public boolean isCodeCorrect() {
        return this.isCodeCorrect;
    }

    public void returnContents() {
        System.out.println("Room contains a door with keypad. There is also a table, which has a piece of paper on it.");
    }

    public void readListOfPaper() {
        System.out.println("The code for the door is 55123");
    }

    public boolean insertCode(String code) {
        System.out.println("Enter the code: ");

        if (code.equals("55123")) {
            System.out.println("Door has opened.");
            this.isCodeCorrect = true;
            System.out.println("You have escaped successfully.");
        } else {
            System.out.println("Invalid code. Please try again.");
        }

        return isCodeCorrect();
    }
}
