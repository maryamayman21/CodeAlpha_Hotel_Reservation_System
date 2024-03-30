/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mariam
 */
public class HotelReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Rooms> hotelRooms = new ArrayList<>();
        SingleRoom s1 = new SingleRoom(101, true);
        SingleRoom s2 = new SingleRoom(102, true);
        SingleRoom s3 = new SingleRoom(103, false);
        DoubleRoom d1 = new DoubleRoom(201, false);
        DoubleRoom d2 = new DoubleRoom(202, true);
        DoubleRoom d3 = new DoubleRoom(203, true);
        Suite su1 = new Suite(301, true);
        Suite su2 = new Suite(302, false);
        Suite su3 = new Suite(303, true);
        hotelRooms.add(s1);
        hotelRooms.add(s2);
        hotelRooms.add(s3);
        hotelRooms.add(d1);
        hotelRooms.add(d2);
        hotelRooms.add(d3);
        hotelRooms.add(su1);
        hotelRooms.add(su2);
        hotelRooms.add(su3);

        Hotel hotel = new Hotel();
        hotel.setHotelRooms(hotelRooms);

        hotel.printHotelInfo();
        System.out.println("Hotel services : ");
        hotel.accommodationServices();
        hotel.diningServices();
        hotel.guestServices();
        hotel.recreationalServices();
        
        System.out.println("---------------------------------------------------------");
        System.out.println("Press 1 to view room types and features ");
        System.out.println("Press 0 to exist ");

        int input;
        while (true) {
            input = scanner.nextInt();
            if (input == 1) {
                break;
            } else if (input == 0) {
                System.exit(0);
            } else {
                System.out.println("Invalid input, try again");

            }
        }
        System.out.println("---------------------------------------------------------");
        //printing room details 
        s1.roomFeatures();
        d1.roomFeatures();
        su1.roomFeatures();

        System.out.println("---------------------------------------------------------");
        System.out.println("Press 1 to book accommodation ");
        System.out.println("Press 0 to exist ");

        
        while (true) {
            input = scanner.nextInt();
            if (input == 1) {
                break;
            } else if (input == 0) {
                System.exit(0);
            } else {
                System.out.println("Invalid input, try again");

            }
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("Please enter number of rooms you would like to book");
        int numberOfRooms = scanner.nextInt();

        //Scan user info 
        System.out.println("Please enter your ID : ");
        long userID = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Please enter your name : ");
        String userName = scanner.nextLine();

        LocalDate checkInDate = null;
        while (checkInDate == null) {
            System.out.println("Please enter the check-in date (YYYY-MM-DD):");
            String date = scanner.nextLine();
            try {
                checkInDate = LocalDate.parse(date);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            }
        }

        LocalDate checkOutDate = null;
        while (checkOutDate == null) {
            System.out.println("Please enter the check-out date (YYYY-MM-DD):");
            String date = scanner.nextLine();
            try {
                checkOutDate = LocalDate.parse(date);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            }
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("Searching for available rooms...");

        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.setHotel(hotel);
        bookingSystem.setRooms(hotel.getHotelRooms());

        ArrayList<Rooms> availableRooms = bookingSystem.getAvalibaleRooms();

        //printing available rooms
        int i = 0;
        for (Rooms room : availableRooms) {
            System.out.print((i+1) + " : ");
            room.printRoomDetails();
            i++;
        }

        System.out.println("---------------------------------------------------------");
        //storing selected rooms by user
        //for every corresponding room -> reservation
        ArrayList<Rooms> selectedRoomsByUser = new ArrayList<>();
        ArrayList<Reservations> roomsReservations = new ArrayList<>();
        System.out.println("Enter number of rooms you would like to book");
        int index = 0;
        int x = numberOfRooms;

        while (x != 0) {
            System.out.println("Enter room : ");
            index = scanner.nextInt();
            selectedRoomsByUser.add(availableRooms.get(index-1));
            Reservations reservation = new Reservations(checkInDate, checkOutDate, userName, userID, availableRooms.get(index-1));
            roomsReservations.add(reservation);
            x--;
        }

     
        bookingSystem.setRooms(selectedRoomsByUser);
        bookingSystem.setReservations(roomsReservations);

        System.out.println("---------------------------------------------------------");
        
        System.out.println("Choose payment method : ");
        System.out.println("Press 1 for cash  ");
        System.out.println("Press 2 for Visa  ");
        boolean flag = false;
        int paymentMethod;
        while (true) {
            paymentMethod = scanner.nextInt();
            if (paymentMethod == 1) {
                flag = true;
                break;
            } else if (paymentMethod == 2) {
                break;
            } else {
                System.out.println("Invalid input, try again");

            }
        }

        if (flag) {

            bookingSystem.setPaymentMethod(PaymentMethod.CASH);

        } else {
            bookingSystem.setPaymentMethod(PaymentMethod.VISA);
        }
        System.out.println("Total Amount : " + bookingSystem.calculateTotalPrice());

        bookingSystem.makeReservation();
        
        System.out.println("---------------------------------------------------------");
        bookingSystem.showCustomerReservation();

    }

}
