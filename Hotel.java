
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Mariam
 */
public class Hotel {

    private String name;
    private String location;
    private String contact;
    private ArrayList<Rooms> hotelRooms;

    public Hotel() {
        this.name = "Marsa Hotel";
        this.location = "123 Main Street Springfield, Anytown";
        this.contact = "+123 456 789";
    }

    public Hotel(String name, String location, String contact, ArrayList<Rooms> hotelRooms) {
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.hotelRooms = hotelRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ArrayList<Rooms> getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(ArrayList<Rooms> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    public void diningServices() {
        System.out.println("Dining Services at " + name + ":");
        System.out.println("- On-site restaurant serving breakfast, lunch, and dinner");
        System.out.println("- Room service during specified hours");
        System.out.println("- Complimentary breakfast buffet or continental breakfast");
    }

    public void accommodationServices() {
        System.out.println("Accommodation Services at " + name + ":");
        System.out.println("- Comfortable and clean rooms");
        System.out.println("- Daily housekeeping services");
        System.out.println("- Linens and towels provided");
    }

    public void guestServices() {
        System.out.println("Guest Services at " + name + ":");
        System.out.println("- 24-hour front desk assistance");
        System.out.println("- Luggage storage facilities");
        System.out.println("- Assistance with transportation arrangements");
        System.out.println("- Wake-up call service");
    }

    public void recreationalServices() {
        System.out.println("Recreational Services at " + name + ":");
        System.out.println("- Swimming pool (outdoor)");
        System.out.println("- Fitness center and gym equipment");
        System.out.println("- Spa services");
        System.out.println("- Games room");
    }

    public void printHotelInfo() {

        System.out.println("Welcome to " + name);
        System.out.println("Location : " + location);
        System.out.println("Customer service : " + contact);
    }

}
