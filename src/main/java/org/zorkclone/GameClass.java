package org.zorkclone;

public class GameClass {

    private Room room1;
    private String command;
    private String item;

    private boolean isGameStartedFlag;

    public GameClass() {}

    public void startGame() {
        room1 = new Room();
        HelperClass helperClass = new HelperClass();
        String input;
        this.isGameStartedFlag = true;

        System.out.println("You have started the game successfully.");
        System.out.println("You are place in room 1. Your task is to escape from there.");
        System.out.println("You can use the following commands in order to explore the world around you: ");
        System.out.println("open, inspect, look around");
        System.out.println("That's it. Escape.");

        while(isGameStartedFlag) {
            input = helperClass.readInput();
            this.command = helperClass.filterCommand(input);
            this.item = helperClass.filterItem(input);

            if(!(command.equals("invalid")) || !(item.equals("invalid"))) {
                performCommand(this.command, this.item);
            } else {
                System.out.println("Invalid command.");
            }
        }
    }

    public void performCommand(String command, String item) {

        if(command.equals("open") && item.equals("door")) {
            room1.openDoor();
            if(room1.isDoorOpened()) {
                System.out.println("You escaped successfully.");
                this.isGameStartedFlag = false;
            }
        } else if(command.equals("open") && item.equals("chest")) {
            room1.openChest();
        } else if(command.equals("inspect") && item.equals("door")) {
            room1.insepctDoor();
        } else if(command.equals("inspect") && item.equals("chest")) {
            room1.inspectChest();
        } else if(command.equals("look") && item.equals("around")) {
            room1.returnContents();
        } else {
            System.out.println("Invalid command.");
        }
    }
}

