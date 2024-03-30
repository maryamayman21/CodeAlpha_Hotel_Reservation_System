
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Mariam
 */
enum PaymentMethod {
    CASH, VISA

}

public class BookingSystem {

    private ArrayList<Rooms> rooms;
    private ArrayList<Reservations> reservations;
    private Hotel hotel;
    private PaymentMethod paymentMethod;

    public BookingSystem() {

    }

    public BookingSystem(ArrayList<Rooms> rooms, ArrayList<Reservations> reservations, Hotel hotel) {
        this.rooms = rooms;
        this.reservations = reservations;
        this.hotel = hotel;
    }

    public ArrayList<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Rooms> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservations> reservations) {
        this.reservations = reservations;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<Rooms> getAvalibaleRooms() {
        ArrayList<Rooms> avaliableRooms = new ArrayList<>();
        ArrayList<Rooms> allRooms = hotel.getHotelRooms();

        for (Rooms room : allRooms) {

            if (room.isAvailable()) {

                avaliableRooms.add(room);
            }

        }
        return avaliableRooms;
    }

    public int calculateNumberOfNights() {
        // calculate number of nights between check-in and check-out dates

        int nights = 0;

        LocalDate date = reservations.get(0).getCheckInDate();
        while (!date.isEqual(reservations.get(0).getCheckOutDate())) {
            nights++;
            date = date.plusDays(1);
        }

        return nights;
    }

    public double calculateTotalPrice() {

        int numberOfNights = calculateNumberOfNights();  //2 3 4
        double totalPricePerReservation = 0;

        for (int i = 0; i < rooms.size(); i++) {

            double priceForOneRoom = rooms.get(i).getPricePerNight();

            totalPricePerReservation += priceForOneRoom * numberOfNights;

        }

        return totalPricePerReservation;
    }

    public void updateRoomAvailability(boolean available) {

        for (Rooms room : rooms) {
            ArrayList<Rooms> hotelRooms = hotel.getHotelRooms();

            for (Rooms hotelRoom : hotelRooms) {
                if (hotelRoom == room && hotelRoom.availability == true) {
                    hotelRoom.setAvailability(available);
                }
            }

        }

    }

    public boolean validateCardInputs() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your Visa card number:");
        String cardNumber = input.nextLine();

        System.out.println("Please enter the expiration date (MM/YYYY):");
        String expirationDate = input.nextLine();

        System.out.println("Please enter the CVV:");
        String cvv = input.nextLine();

        System.out.println("Please enter the cardholder name:");
        String cardholderName = input.nextLine();

        boolean isCardNumberValid = cardNumber.matches("^4\\d{15}$");

        boolean isExpirationDateValid = expirationDate.matches("^(0[1-9]|1[0-2])/\\d{4}$");

        boolean isCVVValid = cvv.matches("^\\d{3}$");

        boolean isCardholderNameValid = cardholderName.matches("^[a-zA-Z\\s]+$");
        return isCardNumberValid && isExpirationDateValid && isCVVValid && isCardholderNameValid;
    }

    public boolean paymentMethodValidation(PaymentMethod paymentMethod) {

        //handle cash
        double totalPrice = calculateTotalPrice();
        boolean isConfirmed = false;
        if (paymentMethod == PaymentMethod.CASH) {
            System.out.println("Successful Payment");
            isConfirmed = true;
        } else if (paymentMethod == PaymentMethod.VISA) {
            //validate card inputs
            boolean cardIsValid = validateCardInputs();
            if (cardIsValid) {
                System.out.println("Successful transaction");
                isConfirmed = true;
            } else {
                System.out.println("Unsuccessful transaction, Recheck the Credit information");
            }
        }
        return isConfirmed;
    }

   
    public void makeReservation() {

        updateRoomAvailability(false);//

        boolean isConfirmed = paymentMethodValidation(paymentMethod);

        if (isConfirmed) {
            System.out.println("Reservation confirmed, Enjoy your stay at " + hotel.getName());
        } else {
            System.out.println("Failed to make reservation. Please try again later.");
            System.exit(0);
        }

    }

    public void showCustomerReservation() {

        System.out.println("All reservations : ");

        for (Reservations reservation : reservations) {

            reservation.printReservationInfo();

        }
        //print total price 
        System.out.println("Total price : " + calculateTotalPrice());
        //print payment method 
        System.out.println("Payment method : " + getPaymentMethod());

    }

}
