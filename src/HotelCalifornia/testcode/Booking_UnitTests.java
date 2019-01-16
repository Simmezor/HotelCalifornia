package hotelcalifornia.testcode;

import hotelcalifornia.Booking;
import hotelcalifornia.Room;
import java.util.ArrayList;
import java.util.Arrays;

public class Booking_UnitTests {

    // When this is set to true, test will give more information about the test executed
    private boolean verbose = true;

    private ArrayList textOutput;

    // 
    private Booking booking;

    public void setVerboseOutput(boolean set) {
        verbose = set;
    }

    public void printVerbose() {

        System.out.println("Expected: " + textOutput.get(0));
        System.out.println("Actual:   " + textOutput.get(1));
        System.out.print("Result:   ");

    }

    public void printVerboseMultiTest() {

        System.out.println("Expected: " + textOutput.get(1));
        System.out.println("Actual:   " + textOutput.get(2));
        System.out.println("Result:   " + textOutput.get(0));

    }

    public static void printBookingInfo(Booking b) {

        System.out.println("BookingID:     " + "\u001B[36m" + b.getBookingId() + "\u001B[00m");
        System.out.println("CheckIn Date:  " + "\u001B[36m" + b.getCheckInDate() + "\u001B[00m");
        System.out.println("CheckOut Date: " + "\u001B[36m" + b.getCheckOutDate() + "\u001B[00m");
        System.out.println("TotalPrice:    " + "\u001B[36m" + b.getTotalPrice() + "\u001B[00m");

    }

// @BeforeMethod
    public void setUp() {
        if (verbose == true) {
            System.out.println("Testing: Booking.java");
        }
        textOutput = new ArrayList();

    }

    //@AfterMethod
    public void tearDown() {

        textOutput.clear();

    }


    public boolean test_BookingConstructor_and_getMethods() {
        System.out.println("Running: test_BookingConstructor_and_getMethods\n");

        boolean result = false;

        int bookingID = 1;
        String inDate = "2019-01-10";
        String outDate = "2019-01-15";
        double price = 749.99;

        booking = new Booking(bookingID, inDate, outDate, price);

        if (verbose == true) {
            System.out.println("Expect match with Testdata:\n");
            System.out.println("BookingID:     " + "\u001B[36m" + bookingID + "\u001B[00m");
            System.out.println("CheckIn Date:  " + "\u001B[36m" + inDate + "\u001B[00m");
            System.out.println("CheckOut Date: " + "\u001B[36m" + outDate + "\u001B[00m");
            System.out.println("TotalPrice:    " + "\u001B[36m" + price + "\u001B[00m");
            System.out.println("");
        }

        if (verbose == true) {
            System.out.println("Actual data:\n");
            System.out.println("BookingID:     " + "\u001B[36m" + booking.getBookingId() + "\u001B[00m");
            System.out.println("CheckIn Date:  " + "\u001B[36m" + booking.getCheckInDate() + "\u001B[00m");
            System.out.println("CheckOut Date: " + "\u001B[36m" + booking.getCheckOutDate() + "\u001B[00m");
            System.out.println("TotalPrice:    " + "\u001B[36m" + booking.getTotalPrice() + "\u001B[00m");
            System.out.println("");
        }

        if (booking.getBookingId() == bookingID
                && booking.getCheckInDate() == inDate
                && booking.getCheckOutDate() == outDate
                && booking.getTotalPrice() == price) {
            result = true;
        } else {
            result = false;
        }

        return result;

    }
    
    public boolean test_Booking_setMethods() {
        System.out.println("Running: test_Booking_setMethods\n");

        boolean result = false;

        String outDate = "2019-01-15";
        double price = 749.99;

        booking = new Booking(0, "-", "-", 0);

        if (verbose == true) {
            System.out.println("Expect change from initial data:\n");
            
            System.out.println("CheckOut Date: " + "\u001B[36m" + booking.getCheckOutDate() + "\u001B[00m");
            System.out.println("TotalPrice:    " + "\u001B[36m" + booking.getTotalPrice() + "\u001B[00m");
            System.out.println("");
        }

        booking.setCheckOutDate(outDate);
        booking.setTotalPrice(price);
        
        if (verbose == true) {
            System.out.println("New test data:\n");

            System.out.println("CheckOut Date: " + "\u001B[36m" + booking.getCheckOutDate() + "\u001B[00m");
            System.out.println("TotalPrice:    " + "\u001B[36m" + booking.getTotalPrice() + "\u001B[00m");
            System.out.println("");
        }

        if ( booking.getCheckOutDate() == outDate && booking.getTotalPrice() == price) {
            result = true;
        } else {
            result = false;
        }

        return result;

    }
    
    public boolean test_Booking_addRoom_and_getRooms() {
        System.out.println("Running: test_Booking_addRoom_and_getRooms\n");

        boolean result = false;
        
        int roomnum = 1;
        int beds = 2;
        boolean hasBalcony = true;
        double price = 119.49;
        boolean booked = false;

        Room room = new Room(roomnum, beds, hasBalcony, price, false);

        
        if (verbose == true) {
            System.out.println("Adding room with test data:\n");         
            System.out.println("Room  :  " + "\u001B[36m" + room.getRoomNumber() + "\u001B[00m");
            System.out.println("Beds:    " + "\u001B[36m" + room.getNumberOfBeds() + "\u001B[00m");
            System.out.println("Balcony: " + "\u001B[36m" + room.isHasBalcony() + "\u001B[00m");
            System.out.println("Price:   " + "\u001B[36m" + room.getPricePerNight() + "\u001B[00m");
            System.out.println("Booked:  " + "\u001B[36m" + room.isIsBooked() + "\u001B[00m");
            System.out.println("");
        }
        
        booking.addRoom(room);

        if (verbose == true) {
            
            for (int i = 0; i < booking.getRooms().size(); i++) {
                
            System.out.println("Actual data:\n");
            System.out.println("Room  :  " + "\u001B[36m" + booking.getRooms().get(i).getRoomNumber() + "\u001B[00m");
            System.out.println("Beds:    " + "\u001B[36m" + booking.getRooms().get(i).getNumberOfBeds() + "\u001B[00m");
            System.out.println("Balcony: " + "\u001B[36m" + booking.getRooms().get(i).isHasBalcony() + "\u001B[00m");
            System.out.println("Price:   " + "\u001B[36m" + booking.getRooms().get(i).getPricePerNight() + "\u001B[00m");
            System.out.println("Booked:  " + "\u001B[36m" + booking.getRooms().get(i).isIsBooked() + "\u001B[00m");
            System.out.println("");
            }
        }
         for (int i = 0; i < booking.getRooms().size(); i++) {
            
        
        if (       room.getRoomNumber() ==  booking.getRooms().get(i).getRoomNumber() 
                && room.getNumberOfBeds() ==  booking.getRooms().get(i).getNumberOfBeds()
                && room.isHasBalcony() == booking.getRooms().get(i).isHasBalcony()
                && room.getPricePerNight() == booking.getRooms().get(i).getPricePerNight()
                && room.isIsBooked() == booking.getRooms().get(i).isIsBooked()) {
            result = true;
        } else {
            result = false;
        }
         }
        return result;

    }

    

} //end of class
