package org.zorkclone;

public class SecondRoom extends Room{

    private boolean isTorchOn;

    public SecondRoom() {
        this.isTorchOn = false;
    }

    public void setTorchOn() {
        this.isTorchOn = true;
        System.out.println("Torch is lit. You can see the room contents.");
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
