package org.zorkclone;

class Room {

    //items? layout? is this class going to be inherited?
    //also doors?

    private boolean isDoorOpened;
    private boolean isKeyOptained;

    public Room() {
        this.isDoorOpened = false;
        this.isKeyOptained = false;
    }

    public boolean isDoorOpened() {
        return isDoorOpened;
    }

    public void setDoorOpened(boolean doorOpened) {
        isDoorOpened = doorOpened;
    }

    public boolean isKeyOptained() {
        return isKeyOptained;
    }

    public void setKeyOptained(boolean keyOptained) {
        isKeyOptained = keyOptained;
    }

    public void openDoor() {
        if(isKeyOptained()) {
            setDoorOpened(true);
            System.out.println("Door opened");
            System.out.println("You have entered another room");
        } else {
            System.out.println("Cannot open door.");
        }
    }

    public void openChest() {
        setKeyOptained(true);
        System.out.println("Key is acquired.");
    }

    public void returnContents() {
        System.out.println("Room contains a chest and a door.");
    }

    public void inspectChest() {
        System.out.println("A chest. Can be opened without a key.");
    }

    public void insepctDoor() {
        System.out.println("A door. Cannot be opened without a key.");
    }
}