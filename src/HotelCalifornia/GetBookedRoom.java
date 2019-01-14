package HotelCalifornia;

import java.util.ArrayList;

public class GetBookedRoom
{

    public static void showBookedRoom(ArrayList<Room> rooms, ArrayList<Customer> customers, ArrayList<Booking> bookings)
    {
        //TODO: Add logic to show the booked room for a customer
        //1: Enter ssn of the customer
        //2: If no match, print an error message
        //3: If there is a match, print the room number

    }

    //Helper method. REMOVE when calling from another method.
    public static void main(String[] args)
    {
        ArrayList<Room> rooms = new ArrayList<Room>(); //Add rooms and put them in an arraylist
        Room room1 = new Room(1, 2, false, 1000, false);
        Room room2 = new Room(2, 1, true, 1000, false);
        Room room3 = new Room(3, 1, false, 1000, true);
        Room room4 = new Room(4, 2, true, 1000, false);
        Room room5 = new Room(5, 1, false, 1000, true);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);

        ArrayList<Customer> customers = new ArrayList<Customer>(); //Create two customers and add them to an arraylist
        Customer customer1 = new Customer("19890523", "Peter Niklas", "Långtbortigatan 23", "042333210");
        Customer customer2 = new Customer("19760720", "Lisa Flisa", "Storgatan 213", "555-847-2345");
        customers.add(customer1);
        customers.add(customer2);

        ArrayList<Booking> bookings = new ArrayList<Booking>(); //Create an arraylist of bookings and add a booking to it
        Booking booking1 = new Booking(1, "2019-02-02", "2019-02-05", 6750);
        bookings.add(booking1);

        customer1.addBooking(booking1); //Add the booking to the first customer

        //TODO: Call showBookedRoom(ArrayList<Room> rooms, ArrayList<Customer> customers, ArrayList<Booking> bookings)
    }
}