package hotelcalifornia.testcode;

import hotelcalifornia.Room;
import java.util.ArrayList;
import java.util.Arrays;

public class Room_UnitTests {

    // When this is set to true, test will give more information about the test executed
    private boolean verbose = true;

    private ArrayList textOutput;

    // 
    private Room room;

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

    public static void printRoomInfo(Room r) {

        System.out.println("Room  :  " + "\u001B[36m" + r.getRoomNumber() + "\u001B[00m");
        System.out.println("Beds:    " + "\u001B[36m" + r.getNumberOfBeds() + "\u001B[00m");
        System.out.println("Balcony: " + "\u001B[36m" + r.isHasBalcony() + "\u001B[00m");
        System.out.println("Price:   " + "\u001B[36m" + r.getPricePerNight() + "\u001B[00m");
        System.out.println("Booked:  " + "\u001B[36m" + r.isIsBooked() + "\u001B[00m");

    }

// @BeforeMethod
    public void setUp() {
        if (verbose == true) {
            System.out.println("Testing: Room.java");
        }
        textOutput = new ArrayList();

    }

    //@AfterMethod
    public void tearDown() {

        textOutput.clear();

    }

    public boolean test_RoomConstructor_and_getMethods() {
        System.out.println("Running: test_RoomConstructor_and_getMethods\n");

        boolean result = false;

        int roomnum = 1;
        int beds = 2;
        boolean hasBalcony = true;
        double price = 119.49;
        boolean booked = false;

        room = new Room(roomnum, beds, hasBalcony, price, false);

        if (verbose == true) {
            System.out.println("Expect match with Testdata:\n");
            System.out.println("Room  :  " + "\u001B[36m" + roomnum + "\u001B[00m");
            System.out.println("Beds:    " + "\u001B[36m" + beds + "\u001B[00m");
            System.out.println("Balcony: " + "\u001B[36m" + hasBalcony + "\u001B[00m");
            System.out.println("Price:   " + "\u001B[36m" + price + "\u001B[00m");
            System.out.println("Booked:  " + "\u001B[36m" + booked + "\u001B[00m");
            System.out.println("");
        }

        if (verbose == true) {
            System.out.println("Actual data:\n");
            System.out.println("Room  :  " + "\u001B[36m" + room.getRoomNumber() + "\u001B[00m");
            System.out.println("Beds:    " + "\u001B[36m" + room.getNumberOfBeds() + "\u001B[00m");
            System.out.println("Balcony: " + "\u001B[36m" + room.isHasBalcony() + "\u001B[00m");
            System.out.println("Price:   " + "\u001B[36m" + room.getPricePerNight() + "\u001B[00m");
            System.out.println("Booked:  " + "\u001B[36m" + room.isIsBooked() + "\u001B[00m");
            System.out.println("");
        }

        if (room.getRoomNumber() == roomnum
                && room.getNumberOfBeds() == beds
                && room.isHasBalcony() == hasBalcony
                && room.getPricePerNight() == price
                && room.isIsBooked() == booked) {
            result = true;
        } else {
            result = false;
        }

        return result;

    }

    public boolean test_Room_setMethods() {
        System.out.println("Running: test_Room_setMethods\n");

        boolean result = false;

        
        int beds = 3;
        double price = 179.99;
        boolean booked = true;

        room = new Room(0, 0, false, 0, false);

        if (verbose == true) {
            System.out.println("Expect change from initial data:\n");


            System.out.println("Beds:    " + "\u001B[36m" + room.getNumberOfBeds() + "\u001B[00m");
            System.out.println("Price:   " + "\u001B[36m" + room.getPricePerNight() + "\u001B[00m");
            System.out.println("Booked:  " + "\u001B[36m" + room.isIsBooked() + "\u001B[00m");
            System.out.println("");
        }

        room.setNumberOfBeds(beds);
        room.setPricePerNight(price);
        room.setIsBooked(booked);

        if (verbose == true) {
            System.out.println("New test data:\n");

            System.out.println("Beds:    " + "\u001B[36m" + room.getNumberOfBeds() + "\u001B[00m");
            System.out.println("Price:   " + "\u001B[36m" + room.getPricePerNight() + "\u001B[00m");
            System.out.println("Booked:  " + "\u001B[36m" + room.isIsBooked() + "\u001B[00m");
            System.out.println("");
        }

        if (room.getNumberOfBeds() == beds && room.getPricePerNight() == price && room.isIsBooked() == booked) {
            result = true;
        } else {
            result = false;
        }

        return result;

    }

} //end of class
