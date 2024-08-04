package org.zorkclone;

public class SecondRoom extends Room{

    private String torch;
    private boolean isTorchOn;

    public SecondRoom() {
        this.torch = "torch";
        this.isTorchOn = false;
    }

    public void setTorchOn() {
        this.isTorchOn = true;
    }

    @Override
    public void openChest() {
        if(!isTorchOn) {
            System.out.println("It is dark. You cannot see anything.");
        } else {
            setKeyOptained(true);
            System.out.println("Key is acquired.");
        }
    }

    @Override
    public void openDoor() {
        if(!this.isTorchOn) {
            System.out.println("It is dark. You cannot see anything.");
        } else {
            if(isKeyOptained()) {
                setDoorOpened(true);
                System.out.println("Door opened");
                System.out.println("You have escaped successfully.");

            } else {
                System.out.println("Cannot open door.");
            }
        }

    }

    @Override
    public void returnContents() {
        if(!this.isTorchOn){
            System.out.println("A really dark room.");
        } else {
            System.out.println("The room contains a door and a chest.");
        }
    }

}
