/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mariam
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Reservations {

    private LocalDate checkInDate; //
    private LocalDate checkOutDate;//
    private String customerName;
    private long customerID;
    private long reservationID;
    private Rooms reservedRoom;
    // --> cash , visa  -->handle visa inputs

    public Reservations() {
    }

    public Reservations(LocalDate checkInDate, LocalDate checkOutDate, String customerName, long customerID, Rooms reservedRoom) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customerName = customerName;
        this.customerID = customerID;
        this.reservedRoom = reservedRoom;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public Rooms getReservedRoom() {
        return reservedRoom;
    }

    public void setReservedRoom(Rooms reservedRoom) {
        this.reservedRoom = reservedRoom;
    }

    private long getReservationID() {
        Random random = new Random();
        this.reservationID = random.nextInt(90000) + 10000;
        return reservationID;
    }

    // print reservation details
    public void printReservationInfo() {

        System.out.println("****************************************");
        System.out.println("Reservation details : ");
        System.out.println("Customer name : " + getCustomerName());
        System.out.println("Customer ID : " + getCustomerID());
        System.out.println("Check-in date : " + getCheckInDate());
        System.out.println("Check-out date : " + getCheckOutDate());
        System.out.println("Room details : ");
        reservedRoom.printRoomDetails();
        System.out.println("Reservation ID : " + getReservationID());
        System.out.println("****************************************");
    }

}
