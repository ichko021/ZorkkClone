package org.zorkclone;

import java.util.ArrayList;

public class GameClass {

    private Room room1;
    private SecondRoom room2;
    private ThirdRoom room3;
    private ArrayList<Room> listOfRooms;
    private int indexOfRoom;
    private HelperClass helperClass;
    private Room playerLocation;
    private ArrayList<String> inventoryList;
    private String command;
    private String item;

    private boolean isGameStartedFlag;

    public GameClass() {
    }

    public void startGame() {
        this.inventoryList = new ArrayList<>();

        this.room1 = new Room();
        this.room2 = new SecondRoom();
        this.room3 = new ThirdRoom();

        this.isGameStartedFlag = true;
        this.indexOfRoom = 0;
        this.playerLocation = returnListOfRooms().get(0);

        this.helperClass = new HelperClass();
        String input;

        System.out.println("You have started the game successfully.");
        System.out.println("You are place in room 1. Your task is to escape from there.");
        System.out.println("You can use the following commands in order to explore the world around you: ");
        System.out.println("open, inspect, look around, show inventory, type code, light torch");
        System.out.println("That's it. Escape.");

        while (isGameStartedFlag) {

            input = helperClass.readInput();

            this.command = helperClass.filterCommand(input);
            this.item = helperClass.filterItem(input);

            if (!(command.equals("invalid")) || !(item.equals("invalid"))) {
                performCommand(this.command, this.item);
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    public ArrayList<Room> returnListOfRooms() {
        this.listOfRooms = new ArrayList<>();

        listOfRooms.add(room1);
        listOfRooms.add(room2);
        listOfRooms.add(room3);

        return listOfRooms;
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
            case "type code":
                boolean check = room3.insertCode(this.helperClass.readInput());
                if (check) {
                    this.isGameStartedFlag = false;
                }
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
                    this.indexOfRoom = this.indexOfRoom + 1;
                    this.playerLocation = returnListOfRooms().get(indexOfRoom);
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
            case "paper":
                room3.readListOfPaper();
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

