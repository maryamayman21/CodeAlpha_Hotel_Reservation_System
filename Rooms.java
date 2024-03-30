/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mariam
 */
enum RoomType {
    SINGLE,
    DOUBLE,
    SUITE
}

public abstract class Rooms {

    private int number;
    boolean availability;
    double pricePerNight;
    private RoomType type;

    public Rooms() {
        this.number = 0;
        this.availability = false;
        this.pricePerNight = 0;
        this.type = null;
    }

    public Rooms(int number, boolean availability, double pricePerNight, RoomType type) {
        this.number = number;
        this.availability = availability;
        this.pricePerNight = pricePerNight;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        if (availability) {
            return true;
        } else {
            return false;
        }
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public abstract void roomFeatures();

    public void printRoomDetails() {

        System.out.println("Room type : " + this.getType());
        System.out.println("Room Number : " + this.getNumber());
        System.out.println("Room price : " + this.getPricePerNight());

    }

}

class SingleRoom extends Rooms {

    public SingleRoom() {

    }

    public SingleRoom(int number, boolean availability) {
        super(number, availability, 2500, RoomType.SINGLE);
    }

    @Override
    public void roomFeatures() {

        System.out.println("Features of Single Room:");
        System.out.println("- Single bed");
        System.out.println("- Ensuite bathroom with shower");
        System.out.println("- Wi-Fi/internet access");
        System.out.println("- City view");

    }

}

class DoubleRoom extends Rooms {

    public DoubleRoom() {
    }

    public DoubleRoom(int number, boolean availability) {
        super(number, availability, 3600, RoomType.DOUBLE);
    }

    @Override
    public void roomFeatures() {

        System.out.println("Features of Double Room:");
        System.out.println("- Double bed");
        System.out.println("- Ensuite bathroom with bathtub or shower");
        System.out.println("- Wi-Fi/internet access");
        System.out.println("- Seating area with sofa or armchairs");
        System.out.println("-  pool view");

    }

}

class Suite extends Rooms {

    public Suite() {
    }

    public Suite(int number, boolean availability) {
        super(number, availability, 6000, RoomType.SUITE);
    }

    @Override
    public void roomFeatures() {

        System.out.println("Features of Suite:");
        System.out.println("- King-sized bed");
        System.out.println("- Ensuite bathroom with bathtub and separate shower");
        System.out.println("- Wi-Fi/internet access");
        System.out.println("- Lounge area with comfortable seating");
        System.out.println("- Kitchenette with microwave, stove, and dishwasher");
        System.out.println("- Private terrace.");
        System.out.println("- Panoramic city view");

    }

}
