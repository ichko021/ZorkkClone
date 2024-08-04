package org.zorkclone;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class GameClass {

    private Room room1;
    private SecondRoom room2;
    private Room playerLocation;
    private ArrayList<String> inventoryList;
    private String command;
    private String item;

    private boolean isGameStartedFlag;

    public GameClass() {}

    public void startGame() {
        this.inventoryList = new ArrayList<>();
        this.room1 = new Room();
        this.room2 = new SecondRoom();
        this.isGameStartedFlag = true;
        this.playerLocation = room1;

        HelperClass helperClass = new HelperClass();
        String input;

        System.out.println("You have started the game successfully.");
        System.out.println("You are place in room 1. Your task is to escape from there.");
        System.out.println("You can use the following commands in order to explore the world around you: ");
        System.out.println("open, inspect, look around, show inventory");
        System.out.println("That's it. Escape.");

        while(isGameStartedFlag) {
            input = helperClass.readInput();
            this.command = helperClass.filterCommand(input);
            this.item = helperClass.filterItem(input);

            if(!(command.equals("invalid")) || !(item.equals("invalid"))) {
                performCommand(this.command, this.item);
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    public void performCommand(String command, String item) {

        switch (command) {
            case "open":
                handleOpenCommand(item);
                break;
            case "inspect":
                handleInspectCommand(item);
                break;
            case "look around":
                playerLocation.returnContents();
                break;
            case "show inventory":
                showInventory();
                break;
            case "light torch":
                room2.setTorchOn();
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    }

    private void handleOpenCommand(String item) {
        switch (item) {
            case "door":
                playerLocation.openDoor();
                if (playerLocation.isDoorOpened()) {
                    this.playerLocation = room2;
                    if(room2.isDoorOpened()) {
                        System.out.println("You have escaped.");
                        this.isGameStartedFlag = false;
                    }
//                    try {
//                        Desktop.getDesktop().browse(new URL("https://youtu.be/dQw4w9WgXcQ?t=4").toURI());
//                    } catch (Exception e) {}
                }
                break;
            case "chest":
                playerLocation.openChest();
                break;
            case "window":
                playerLocation.inspectChest();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private void handleInspectCommand(String item) {
        switch (item) {
            case "door":
                playerLocation.insepctDoor();
                break;
            case "chest":
                playerLocation.inspectChest();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private void showInventory() {
        for (String item : this.inventoryList) {
            System.out.println(item);
        }
    }
}

