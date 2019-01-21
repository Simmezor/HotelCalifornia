
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelcalifornia;

import hotelcalifornia.testcode.UnitTests;
import java.util.ArrayList;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author simon
 */
public class HotelLogic {

    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    private boolean help = false;

    public HotelLogic() {
        customers = new ArrayList();
        rooms = new ArrayList();
        bookings = new ArrayList();
    }

    public ArrayList getArrayListCustomers() {
        return customers;
    }

    public ArrayList getArrayListRooms() {
        return rooms;
    }

    public ArrayList getArrayListBookings() {
        return bookings;
    }

    public static void printRoomInfo(Room r) {

        System.out.println("RoomNumber: " + r.getRoomNumber());
        System.out.println("Beds: " + r.getNumberOfBeds());
        System.out.println("Has Balcony: " + r.isHasBalcony());
        System.out.println("Price: " + r.getPricePerNight());
        System.out.println("Booked: " + r.isIsBooked());

        System.out.println("");

    }

    public static void printCustomerInfo(Customer c) {

        System.out.println("SSN:    " + c.getSsn());
        System.out.println("Name:   " + c.getName());
        System.out.println("Adress: " + c.getAddress());
        System.out.println("Phone:  " + c.getTelephoneNumber());

        System.out.println("");

    }

    public static void printBookingInfo(Booking b) {

        System.out.println("BookingID     " + b.getBookingId());
        System.out.println("Check-in Date:  " + b.getCheckInDate());
        System.out.println("Check-out Date: " + b.getCheckOutDate());
        System.out.println("Total Price:    " + b.getTotalPrice());

        System.out.println("Rooms Booked: \n");

        if (b.getRooms().size() == 0) {
            System.out.println("No rooms Booked.");
        } else {

            for (int i = 0; i < b.getRooms().size(); i++) {

                printRoomInfo(b.getRooms().get(i));
            }

        }

    }

    public static void showLogo() {

        System.out.println("   _           _       _             _ _  __                 _        \n"
                + "  | |         | |     | |           | (_)/ _|               (_)   	  \n"
                + "  | |__   ___ | |_ ___| |   ___ __ _| |_| |_ ___  _ __ _ __  _  __ _  \n"
                + "  | '_ \\ / _ \\| __/ _ \\ |  / __/ _` | | |  _/ _ \\| '__| '_ \\| |/ _` | \n"
                + "  | | | | (_) | ||  __/ | | (_| (_| | | | || (_) | |  | | | | | (_| | \n"
                + "  |_| |_|\\___/\\__\\___|_|   \\___\\__,_|_|_|_| \\___/|_|  |_| |_|_|\\__,_| \n\n"
                + "                                         |				   \n"
                + "                                       \\ _ /			   \n"
                + "                                     -= (_) =-			   \n"
                + "    .\\/.                               /   \\                           \n"
                + " .\\\\//o\\\\                      ,\\/.      |              ,~             \n"
                + " //o\\\\|,\\/.   ,.,.,   ,\\/.  ,\\//o\\\\                     |\\             \n"
                + "   |  |//o\\  /###/#\\  //o\\  /o\\\\|                      /| \\		   \n"
                + " ^^|^^|^~|^^^|' '|:|^^^|^^^^^|^^|^^^\"\"\"\"\"\"\"\"(\"~~~~~~~~/_|__\\~~~~~~~~~~ \n"
                + "  .|'' . |  '''\"\"'\"''. |`===`|''  '\"\" \"\" \" (\" ~~~~ ~ ~======~~  ~~ ~   \n"
                + "     ^^   ^^^ ^ ^^^ ^^^^ ^^^ ^^ ^^ \"\" \"\"\"( \" ~~~~~~ ~~~~~  ~~~ ~       ");

    }

// Menu code written by Andreas
    public void showMenu() {

        showLogo();

        loadRooms("Rooms.txt");
        loadBookings("Bookings.txt");
        loadCustomers("Customers.txt");

        String choice;
        boolean gettingInput = true;

        Scanner sc = new Scanner(System.in);

        while (gettingInput) {

            if (help) {
                System.out.println(""
                        + "1 = Rooms (here is all the functions)\n"
                        + "2 = Customer\n"
                        + "3 = Booking\n"
                        + "4 = TestMenu\n"
                        + "5 = exit\n"
                        + "type help for instructions");

            } else {
                System.out.println(""
                        + "1 = Rooms\n"
                        + "2 = Customer\n"
                        + "3 = Booking\n"
                        + "4 = TestMenu\n"
                        + "5 = exit\n");

            }

            choice = sc.nextLine();

            switch (choice) {

                case "1":
                    roomMenu();
                    break;

                case "2":
                    customerMenu();
                    break;

                case "3":
                    bookingMenu();
                    break;
                case "4":
                    testMenu();
                    break;
                case "5":

                    gettingInput = false;

                    writeCustomers("Customers");
                    writeBookings("Bookings");
                    writeRooms("Rooms");
                    break;
                case "admin test":
                    UnitTests.runUnitTests(true);
                    break;
                case "help":
                    help = true;
                    break;
                case "admin test -ver":
                    UnitTests.runUnitTests(false);
                    break;
                default:
                    System.out.println("Error: Pick 1 - 3  or 5 and try again!");
                    break;
            }
        }

    }

    public void roomMenu() {

        String choice;
        boolean gettingInput = true;

        Scanner sc = new Scanner(System.in);
        while (gettingInput == true) {
            System.out.println(""
                    + "1 = Show all rooms\n"
                    + "2 = Show available rooms\n"
                    + "3 = Add new room\n"
                    + "4 = Remove room\n"
                    + "5 = Edit Room\n"
                    + "6 = Search for room\n"
                    + "7 = Return to main menu");

            choice = sc.nextLine();

            switch (choice) {

                case "1":
                    CheckAllRooms();

                    break;

                case "2":
                    CheckAvailableRooms();
                    break;

                case "3":
                    addRoom();
                    break;

                case "4":
                    removeRoom();
                    break;

                case "5":
                    editRoom();

                    break;
                case "6":
                    searchRoom();

                    break;

                case "7":
                    System.out.println("Returning to main menu");
                    gettingInput = false;
                    break;

                default:
                    System.out.println("Error: Pick 1 - 6 and try again!");
                    break;
            }
        }
    }

    public void customerMenu() {

        String choice;
        boolean gettingInput = true;

        Scanner sc = new Scanner(System.in);

        while (gettingInput == true) {

            System.out.println(""
                    + "1 = Show Customers\n"
                    + "2 = Add new Customer\n"
                    + "3 = Search Customer\n"
                    + "4 = Edit customer\n"
                    + "5 = Return to main menu");

            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    showAllCustomers();
                    break;

                case "2":
                    addCustomer();

                    break;

                case "3":
                    searchForCustomer();
                    break;

                case "4":
                    editCustomer();
                    break;

                case "5":
                    System.out.println("Returning to main menu");
                    gettingInput = false;
                    break;

                default:
                    System.out.println("Error: Pick 1 - 5 and try again!");
                    break;
            }
        }
    }

    public void bookingMenu() {

        String choice;
        boolean asking = true;
        Scanner sc = new Scanner(System.in);

        while (asking == true) {

            System.out.println(""
                    + "1 = Show Bookings\n"
                    + "2 = Check in\n"
                    + "3 = Check out\n"
                    + "4 = Edit Booking\n"
                    + "5 = Return to main menu");
            choice = sc.nextLine();

            switch (choice) {

                case "1":
                    showBookings();

                    break;

                case "2":
                    checkInCustomer();

                    break;

                case "3":
                    checkOutCustomer();

                    break;

                case "4":
                    editBooking();
                    break;

                case "5":
                    System.out.println("Returning to main menu");
                    asking = false;
                    break;

                default:
                    System.out.println("Error: Pick 1 - 5 and try again!");
                    break;
            }
        }
    }

    public void testMenu() {
        System.out.println("\n" + "\u001B[32m" + "Working master" + "\u001B[0m" + "\n");
    }

    public void CheckAllRooms(ArrayList<Room> rooms) {
        System.out.println("Total number of rooms: " + rooms.size());
        System.out.println("-------------------------");

        for (Room room : rooms) {

            System.out.println("Room " + room.getRoomNumber());
            System.out.println("Number of beds: " + room.getNumberOfBeds());

            if (room.isHasBalcony()) {

                System.out.println("Has balcony.");

            } else {

                System.out.println("Does not have balcony.");
            }

            if (room.isIsBooked()) {
                System.out.println("Room is " + (char) 27 + "[31m" + "BOOKED!");
            } else {
                System.out.println("Room is " + (char) 27 + "[32m" + "AVAILABLE!");
            }

            System.out.println((char) 27 + "[39m" + "Price per night: " + room.getPricePerNight() + ".\r\n");

        }
    }

    public void CheckAllRooms() {
        System.out.println("Total number of rooms: " + rooms.size());
        System.out.println("-------------------------");

        for (Room room : rooms) {

            System.out.println("Room " + room.getRoomNumber());
            System.out.println("Number of beds: " + room.getNumberOfBeds());

            if (room.isHasBalcony()) {

                System.out.println("Has balcony.");

            } else {

                System.out.println("Does not have balcony.");
            }

            if (room.isIsBooked()) {
                System.out.println("Room is " + (char) 27 + "[31m" + "BOOKED!");
            } else {
                System.out.println("Room is " + (char) 27 + "[32m" + "AVAILABLE!");
            }

            System.out.println((char) 27 + "[39m" + "Price per night: " + room.getPricePerNight() + ".\r\n");

        }
    }

    public void CheckAvailableRooms(ArrayList<Room> rooms) {
        for (Room room : rooms) {

            if (!room.isBooked) {
                System.out.println("Room " + room.roomNumber + " is available.");
            }
        }
    }

    public void CheckAvailableRooms() {
        for (Room room : rooms) {

            if (!room.isBooked) {
                System.out.println("Room " + room.roomNumber + " is available.");
            }
        }
    }

    public void addRoom() {

        Scanner in = new Scanner(System.in);

        boolean gettinginput = true;

        int temproomnum = -1;
        int beds = -1;

        String balcony = "-1";
        boolean balconybool = false;
        double price = -1;

        while (gettinginput) {

            try {
                System.out.println("What is the room's number (100 - 1112): ");
                temproomnum = in.nextInt();
                gettinginput = false;

                if (temproomnum < 100 || temproomnum > 1112) {
                    System.out.println("Invalid input");
                    gettinginput = true;
                }
                for (int i = 0; i < rooms.size(); i++) {
                    if (rooms.get(i).getRoomNumber() == temproomnum) {
                        System.out.println(" the room already exist");
                        gettinginput = true;
                    }
                }

            } catch (Exception e) {
                System.out.println("invalid input");
                in.next();
            }
        }

        gettinginput = true;

        while (gettinginput) {

            try {
                System.out.println("How many beds does the room have? (1 - 5: ");
                beds = in.nextInt();
                gettinginput = false;
                if (beds < 1 || beds > 5) {
                    System.out.println("Invalid input ");
                    gettinginput = true;
                }

            } catch (Exception e) {
                System.out.println("invalid input");
                in.next();
            }
        }

        gettinginput = true;
        while (gettinginput) {

            System.out.println("Does the room have a balcony?: ");
            balcony = in.next();    //Needs to be in a try catch 

            switch (balcony) {

                case "yes":
                    balconybool = true;
                    gettinginput = false;
                    break;
                case "Yes":
                    balconybool = true;
                    gettinginput = false;
                    break;
                case "no":
                    balconybool = false;
                    gettinginput = false;
                    break;
                case "No":
                    balconybool = false;
                    gettinginput = false;
                    break;
                default:
                    System.out.println("invalid input");

                    break;
            }

        }
        gettinginput = true;

        while (gettinginput) {
            try {
                System.out.println("How much does the room cost per night? (500 - 1000): ");
                price = in.nextDouble();    //Needs to be in a try catch 
                gettinginput = false;
                if (price < 500 || price > 1000) {
                    System.out.println("Invalid input");
                    gettinginput = true;
                }
            } catch (Exception e) {
                System.out.println("invalid input");
                in.next();

            }
        }

        Room newRoom = new Room(temproomnum, beds, balconybool, price, false);

        rooms.add(newRoom);

    }

    public void addCustomer() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your social security number: ");

        String ssn = in.nextLine();
        System.out.println("Please enter name: ");
        String name = in.nextLine();
        System.out.println("Please enter address: ");
        String address = in.nextLine();

        boolean gettingInput = true;
        String telephone = "";

        while (gettingInput) {
            System.out.println("Please enter your telephone number: ");
            telephone = in.nextLine();
           String pattern1 = "\\d\\d\\d([-])?\\d\\d\\d\\d\\d\\d";
             String pattern2 = "\\d\\d\\d([-])?\\d\\d\\d\\d\\d\\d\\d";      
            if (telephone.matches(pattern1) || telephone.matches(pattern2) ) {
                gettingInput = false;
            } else {
                System.out.println("invalid input");
            }

        }

        Customer newCustomer = new Customer(ssn, name, address, telephone);
        customers.add(newCustomer);
           System.out.println("New customer " + name + " succesfully added. " );

    }


    public Booking createBooking(ArrayList<Room> rooms) {

        Scanner in = new Scanner(System.in);

        Booking tempBooking;

        boolean gettinginput = true;

        int bookingID = -1;

        String indate = "-";
        String outdate = "-";

        double totalprice = -1;

        while (gettinginput) {

            try {
                System.out.println("Booking ID: ");
                bookingID = in.nextInt();
                gettinginput = false;

            } catch (Exception e) {
                System.out.println("invalid input");
                in.next();
            }

            for (Booking booking : bookings) {

                if (booking.getBookingId() == bookingID) {

                    System.out.println("BookingID Already exits");

                    gettinginput = true;

                } else {
                    gettinginput = false;

                }

            }

        }

        System.out.println("Enter checkin date: ");
        indate = in.next();

        System.out.println("Enter checkout date: ");
        outdate = in.next();

        gettinginput = true;

        while (gettinginput) {
            try {
                System.out.println("Total cost for booking?: ");
                totalprice = in.nextDouble();    //Needs to be in a try catch 
                gettinginput = false;
            } catch (Exception e) {
                System.out.println("invalid input");
                in.next();

            }
        }
        tempBooking = new Booking(bookingID, indate, outdate, totalprice);

        for (int i = 0; i < rooms.size(); i++) {
            tempBooking.addRoom(rooms.get(i));
        }
        printBookingInfo(tempBooking);
        bookings.add(tempBooking);
        return tempBooking;
    }

    public void checkInCustomer(Customer customer) {

        ArrayList<Room> bookedrooms = new ArrayList();

        int roomnumber = -1;
        int numberOfrooms = -1;
        int numrooms = 0;

        Scanner sc = new Scanner(System.in);
        boolean booking = true;
        boolean gettinginput = true;

        int allbooked = 0;

        customer.addBooking(createBooking(bookedrooms));

        for (Room room : rooms) {
            if (room.isBooked) {
                allbooked++;
            }
        }

        while (gettinginput) {

            try {
                System.out.println("How many rooms do you want to book? ");
                numberOfrooms = sc.nextInt();
                gettinginput = false;

            } catch (Exception e) {
                System.out.println("invalid input");
                sc.next();
            }
        }

        while (booking == true && numberOfrooms > 0) {

            if (rooms.size() == 0 || allbooked == rooms.size()) {
                System.out.println("There are no more rooms available");
                break;
            }
            System.out.println("Book one of the following rooms:");
            CheckAvailableRooms();

            gettinginput = true;

            while (gettinginput) {

                try {
                    System.out.println("Enter roomnumber: ");
                    roomnumber = sc.nextInt();
                    gettinginput = false;

                } catch (Exception e) {
                    System.out.println("invalid input");
                    sc.next();
                }
            }

            boolean booked = false;

            for (Room room : rooms) {
                if (room.isIsBooked() == true && room.getRoomNumber() == roomnumber) {

                    booked = true;

                }
            }
            if (booked) {
                System.out.println("That room is unavailable, please try again.");
            } else {

                for (Room room : rooms) {
                    if (room.getRoomNumber() == roomnumber) {
                        room.setIsBooked(true);
                        bookedrooms.add(room);

                        numrooms++;
                    }
                }
            }
            if (numrooms == numberOfrooms) {
                booking = false;

            }
        }

    }

    public void checkInCustomer() {

        ArrayList<Room> bookedrooms = new ArrayList();

        int roomnumber = -1;
        int numberOfrooms = -1;
        int numrooms = 0;

        Scanner sc = new Scanner(System.in);
        boolean booking = true;
        boolean gettinginput = true;

        int allbooked = 0;

        String ssnToSearch;

        Customer tempCustomer;

        tempCustomer = new Customer("", "", "", "");

        boolean matchfound = false;

        System.out.println("Enter customer SSN: ");

        ssnToSearch = sc.nextLine();
        System.out.println("Searching for " + ssnToSearch);

        for (Customer customer : customers) {

            if (ssnToSearch.matches(customer.getSsn())) {

                matchfound = true;

                tempCustomer = customer;

                for (Room room : rooms) {
                    if (room.isBooked) {
                        allbooked++;
                    }
                }

                while (gettinginput) {

                    try {
                        System.out.println("How many rooms do you want to book? ");
                        numberOfrooms = sc.nextInt();
                        gettinginput = false;

                    } catch (Exception e) {
                        System.out.println("invalid input");
                        sc.next();
                    }
                }

                while (booking == true && numberOfrooms > 0) {

                    if (rooms.size() == 0 || allbooked == rooms.size()) {
                        System.out.println("There are no more rooms available");
                        break;
                    }
                    System.out.println("Book one of the following rooms:");
                    CheckAvailableRooms();

                    gettinginput = true;

                    while (gettinginput) {

                        try {
                            System.out.println("Enter roomnumber: ");
                            roomnumber = sc.nextInt();
                            gettinginput = false;

                        } catch (Exception e) {
                            System.out.println("invalid input");
                            sc.next();
                        }
                    }

                    boolean booked = false;

                    for (Room room : rooms) {
                        if (room.isIsBooked() == true && room.getRoomNumber() == roomnumber) {

                            booked = true;

                        }
                    }
                    if (booked) {
                        System.out.println("That room is unavailable, please try again.");
                    } else {

                        for (Room room : rooms) {
                            if (room.getRoomNumber() == roomnumber) {
                                room.setIsBooked(true);
                                bookedrooms.add(room);

                                numrooms++;
                            }
                        }
                    }
                    if (numrooms == numberOfrooms) {
                        booking = false;
                        if (matchfound) {

                            tempCustomer.addBooking(createBooking(bookedrooms));
                        }
                    }

                }

            }
        }

        if (matchfound == false) {
            System.out.println("No match found.");

        }

    }

    public void editCustomer() {
        String ssnToSearch;
        Scanner sc = new Scanner(System.in);
        Scanner scEdit = new Scanner(System.in);

        System.out.println("Enter customer SSN: ");
        ssnToSearch = sc.next();
        System.out.println("Searching for " + ssnToSearch);

        // Edit part starts here, after searching booked room, so a edit can happen
        for (Customer customer : customers) {

            if (ssnToSearch.matches(customer.getSsn())) {
                System.out.println("Found a match!");
                System.out.println("Name: " + customer.getName());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("Phone number: " + customer.getTelephoneNumber());
                System.out.println("BOOKINGS");

//                System.out.println("Enter New Name: ");
//                String editName = scEdit.next();
//                customer.
                System.out.println("Enter New Address: ");
                String editAddress = scEdit.next();
                customer.setAdress(editAddress);

                System.out.println("Enter New Phone Number: ");
                String editPhoneNo = scEdit.next();
                customer.setTelephoneNumber(editPhoneNo);
                break;

            } else {
                System.out.println(" The search didn´t succeed, please try again. ");
            }

        }

    }

    public void editRoom() {
    }

    public void searchForCustomer(ArrayList<Room> rooms, ArrayList<Customer> customers, ArrayList<Booking> bookings) {
        String ssnToSearch;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer SSN: ");

        ssnToSearch = sc.next();
        System.out.println("Searching for " + ssnToSearch);

        for (Customer customer : customers) {

            if (ssnToSearch.matches(customer.getSsn())) {
                System.out.println("Found a match!");
                System.out.println("Name: " + customer.getName());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("Phone number: " + customer.getTelephoneNumber());
                System.out.println("BOOKINGS");
                ArrayList<Booking> customerBookings = customer.getBookings();
                for (Booking customerBooking : customerBookings) {

                    System.out.println(customerBooking.bookingId + ": Check-in:" + customerBooking.checkInDate + ". Check-out: " + customerBooking.checkOutDate + ". "
                            + "Price: " + customerBooking.getTotalPrice() + ".");

                }
            }
        }

        sc.close();

    }

    public void searchForCustomer() {
        String ssnToSearch;
        Scanner sc = new Scanner(System.in);

        boolean matchfound = false;

        System.out.println("Enter customer SSN: ");

        ssnToSearch = sc.nextLine();
        System.out.println("Searching for " + ssnToSearch);

        for (Customer customer : customers) {

            if (ssnToSearch.matches(customer.getSsn())) {

                matchfound = true;

                System.out.println("Found a match!");
                System.out.println("Name: " + customer.getName());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("Phone number: " + customer.getTelephoneNumber());

                ArrayList<Booking> customerBookings = customer.getBookings();
                if (customerBookings.size() > 0) {
                    System.out.println("BOOKINGS:");
                    for (Booking customerBooking : customerBookings) {

                        System.out.println(customerBooking.bookingId + ": Check-in:" + customerBooking.checkInDate + ". Check-out: " + customerBooking.checkOutDate + ". "
                                + "Price: " + customerBooking.getTotalPrice() + ".");

                    }
                    System.out.println("");
                } else {
                    System.out.println("No rooms booked.\n");
                }

            }
        }

        if (matchfound == false) {
            System.out.println("No match found.");
        }

    }

    public boolean searchForCustomer(String ssn) {
        boolean matchfound = false;

        for (Customer customer : customers) {

            if (ssn.matches(customer.getSsn())) {

                matchfound = true;

                System.out.println("Found a match!");
                System.out.println("Name: " + customer.getName());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("Phone number: " + customer.getTelephoneNumber());
            }

            if (matchfound == false) {
                System.out.println("No match found.");
            }
        }
        return matchfound;
    }

    public void searchRoom() {

        ArrayList<Room> bookedrooms = new ArrayList();

        int roomnumber = -1;
        Scanner sc = new Scanner(System.in);

        boolean matchfound = false;
        boolean gettinginput = true;

        while (gettinginput) {

            try {
                System.out.println("Enter the roomnumber: ");
                roomnumber = sc.nextInt();
                gettinginput = false;

            } catch (Exception e) {
                System.out.println("invalid input");
                sc.next();
            }
        }

        for (Room room : rooms) {

//            System.out.println("roomnumber " + roomnumber);
//            
//            System.out.println("room.getRoomNumber " + room.getRoomNumber());
//            System.out.println(room.isIsBooked());
            if (room.isIsBooked() == false && room.getRoomNumber() == roomnumber) {
                System.out.println("Match found!");
                printRoomInfo(room);
                matchfound = true;

            }

            if (room.isIsBooked() == true && room.getRoomNumber() == roomnumber) {
                System.out.println("Match found!");
                printRoomInfo(room);
                for (Customer customer : customers) {

                    for (int i = 0; i < customer.getBookings().size(); i++) {
                        for (int j = 0; j < customer.getBookings().get(i).rooms.size(); j++) {
                            if (customer.getBookings().get(i).rooms.get(j).roomNumber == roomnumber) {

                                matchfound = true;

                                System.out.println("Booked by");
                                printCustomerInfo(customer);

                                System.out.println("Booking information:");
                                printBookingInfo(customer.getBookings().get(i));
                            }
                        }
                    }

                }
                matchfound = true;
            }
        }

        if (matchfound == false) {
            System.out.println("No room with that roomnumber found.");
        }

    }

    public void showBookings() {

        for (Booking booking : bookings) {

            printBookingInfo(booking);
        }

    }

    public void showAllCustomers() {

        for (Customer customer : customers) {
            printCustomerInfo(customer);
        }
    }

    public void removeRoom() {
        String roomToSearch;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter room number");
        roomToSearch = sc.next();
        int roomNum = Integer.parseInt(roomToSearch);

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNum) {
                System.out.println(" Match ");
                System.out.println(" Do you want remove this room? ");
                String remove = sc.next();
                if (remove.equalsIgnoreCase("yes")) {
                    rooms.remove(room);
                    System.out.println("The room has been removed. ");
                    break;
                }
            }
        }
    }

    public void editBooking() {

        boolean match = false;

        String ssnToSearch;
        Scanner sc = new Scanner(System.in);
        Scanner scEditBooking = new Scanner(System.in);

        System.out.println("Enter customer SSN: ");
        ssnToSearch = sc.nextLine();
        System.out.println("Searching for " + ssnToSearch);

        // Edit part starts here, after searching booked room, so a edit can happen
        for (Customer customer : customers) {

            if (ssnToSearch.matches(customer.getSsn())) {
                System.out.println("Found a match!");
                System.out.println("Name: " + customer.getName());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("Phone number: " + customer.getTelephoneNumber());
                System.out.println("BOOKINGS:");
                for (Booking booking : customer.getBookings()) {
                    System.out.println(booking.bookingId + ": Check-in:" + booking.checkInDate + ". Check-out: " + booking.checkOutDate + ". "
                            + "Price: " + booking.getTotalPrice() + ".");
                }
                System.out.println(" ");

                System.out.println("Enter booking number");
                int searching = sc.nextInt();
                for (Booking booking : customer.getBookings()) {
                    if (searching == booking.getBookingId()) {

                        System.out.println("Enter New Date: ");
                        String editDate = scEditBooking.nextLine();
                        booking.setCheckOutDate(editDate);

                        System.out.println("Enter new total rooms (not implemented yet): ");
                        String editRooms = scEditBooking.nextLine();
                        booking.setTotalPrice(searching);

                        System.out.println("Enter New Price: ");
                        String editPrice = scEditBooking.nextLine();
                        booking.setTotalPrice(searching);
                    } else {
                        System.out.println("Could not find booking number");
                    }
                }
                match = true;
                break;
            }

        }
        if (!match) {
            System.out.println("No Customer found");
        }

    }

    public void checkOutCustomer() {

        int searchForBookings = 0;
        Scanner sc = new Scanner(System.in);
        boolean resultFound = false;
        boolean getInput = true;

        while (getInput) {

            try {
                System.out.println("What is the booking Id?: ");
                searchForBookings = sc.nextInt();
                getInput = false;

            } catch (Exception e) {

                System.out.println("invalid input");
                searchForBookings = sc.nextInt();

            }
        }

        System.out.println(bookings.size());
        for (Booking booking : bookings) {

            if (searchForBookings == booking.getBookingId()) {

                System.out.println("Do you wish to remove this booking?");

                ArrayList<Room> rooms = new ArrayList<Room>();

                String remove = sc.next();

                if (remove.equalsIgnoreCase("yes") || remove.equalsIgnoreCase("y") || remove.equalsIgnoreCase("ye")) {

                    for (Room room : booking.rooms) {

                        rooms.add(room);

                    }

                    for (int i = 0; i < rooms.size(); i++) {
                        rooms.get(i).setIsBooked(false);
                    }

                    System.out.println("Booking removed!");

                    showMenu();

                } else {
                    System.out.println("Removing booking aborted.");
                    break;

                }

            }

        }

    }

    public ArrayList<Customer> LoadCustomersInArray(String ref) {

        ArrayList<Customer> loadedCustomers = new ArrayList();

        ArrayList lines = new ArrayList();
        boolean reading = true;
        URL url = this.getClass().getClassLoader().getResource(ref);

        int counting = 0;

        if (url == null) {
            System.out.println("Can't find ref: " + ref);
        } else {

            try {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

                    while (reading) {

                        String tempString = in.readLine();

                        if (tempString.matches("END")) {

                            reading = false;
                            break;
                        }
                        if (!tempString.matches("-----")) {
                            lines.add(tempString);
                        } else {
                            counting++;
                        }

                    }

                    in.close();

                }

            } catch (IOException e) {
                System.out.println("file not found");
            }

        }

        for (int i = 0; i < counting; i++) {

            loadedCustomers.add(new Customer(lines.get(0 + i).toString(), lines.get(1 + i).toString(), lines.get(2 + i).toString(), lines.get(3 + i).toString()));

        }

        return loadedCustomers;
    }

    public void loadCustomers(String ref) {

        ArrayList lines = new ArrayList();
        boolean reading = true;
        URL url = this.getClass().getClassLoader().getResource(ref);

        int counting = 0;

        if (url == null) {
            System.out.println("Can't find ref: " + ref);
        } else {

            try {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

                    while (reading) {

                        String tempString = in.readLine();

                        if (tempString.matches("END")) {

                            reading = false;
                            break;
                        }
                        if (!tempString.matches("-----")) {

                            if (tempString.matches("BOOKINGS")) {

                            } else {
                                lines.add(tempString);
                            }

                        } else {
                            counting++;
                        }

                    }

                    in.close();

                }

            } catch (IOException e) {
                System.out.println("file not found");
            }

        }

        for (int i = 0; i < counting; i++) {

            String bookingline = lines.get((4) + (i * 5)).toString();

            String tempstring = "";

            customers.add(new Customer(
                    lines.get(0 + (i * 5)).toString(),
                    lines.get(1 + (i * 5)).toString(),
                    lines.get(2 + (i * 5)).toString(),
                    lines.get(3 + (i * 5)).toString()));

            for (int j = 0; j < bookingline.length(); j++) {

                if (bookingline.charAt(j) != '.') {
                    tempstring = tempstring + bookingline.charAt(j);

                } else {
      
                    for (Booking booking : bookings) {
                        String bookingstring = "" + booking.getBookingId();
                        if (bookingstring.matches(tempstring)) {
                            customers.get(i).addBooking(booking);
                        }
                    }
                    tempstring = "";
                }

            }

        }

    }

    public void loadRooms(String ref) {

        ArrayList lines = new ArrayList();
        boolean reading = true;
        URL url = this.getClass().getClassLoader().getResource(ref);

        int counting = 0;

        if (url == null) {
            System.out.println("Can't find ref: " + ref);
        } else {

            try {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

                    while (reading) {

                        String tempString = in.readLine();

                        if (tempString.matches("END")) {

                            reading = false;
                            break;
                        }
                        if (!tempString.matches("-----")) {
                            lines.add(tempString);
                        } else {
                            counting++;
                        }

                    }

                    in.close();

                }

            } catch (IOException e) {
                System.out.println("file not found");
            }

        }

        for (int i = 0; i < counting; i++) {
            rooms.add(new Room(
                    Integer.parseInt(lines.get(0 + (i * 5)).toString()),
                    Integer.parseInt(lines.get(1 + (i * 5)).toString()),
                    Boolean.parseBoolean(lines.get(2 + (i * 5)).toString()),
                    Double.parseDouble(lines.get(3 + (i * 5)).toString()),
                    Boolean.parseBoolean(lines.get(4 + (i * 5)).toString())
            ));

        }

    }

    public void loadBookings(String ref) {

        ArrayList lines = new ArrayList();
        boolean reading = true;
        URL url = this.getClass().getClassLoader().getResource(ref);

        int counting = 0;

        int numofrooms = 1;

        if (url == null) {
            System.out.println("Can't find ref: " + ref);
        } else {

            try {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

                    while (reading) {

                        String tempString = in.readLine();

                        if (tempString.matches("END")) {

                            reading = false;
                            break;
                        }

                        if (!tempString.matches("-----")) {

                            if (tempString.matches("ROOMS")) {

                            } else {
                                lines.add(tempString);
                            }

                        } else {

                            counting++;

                        }

                    }

                    in.close();

                }

            } catch (IOException e) {
                System.out.println("file not found");
            }

        }

        for (int i = 0; i < counting; i++) {

            String roomline = lines.get((4) + (i * 5)).toString();

            String tempstring = "";

            bookings.add(new Booking(
                    Integer.parseInt(lines.get(0 + (i * 5)).toString()),
                    lines.get(1 + (i * 5)).toString(),
                    lines.get(2 + (i * 5)).toString(),
                    Double.parseDouble(lines.get(3 + (i * 5)).toString())
            ));
            for (int j = 0; j < roomline.length(); j++) {

                if (roomline.charAt(j) != '.') {
                    tempstring = tempstring + roomline.charAt(j);

                } else {
                  
                    for (Room room : rooms) {
                        String roomstring = "" + room.getRoomNumber();
                        if (roomstring.matches(tempstring)) {
                            bookings.get(bookings.size() - 1).addRoom(room);
                        }
                    }

                }

            }

        }

//        for (Booking booking : bookings) {
//            System.out.println(booking.getBookingId());
//        }
    }

    public void writeCustomers(String name) {

        if (name == null) {
            System.out.println("Can't find ref: " + name);
        } else {

            try (BufferedWriter out = new BufferedWriter(new FileWriter("src/" + name + ".txt"))) {

                for (Customer customer : customers) {

                    out.write(customer.getSsn() + "\n");
                    out.write(customer.getName() + "\n");
                    out.write(customer.getAddress() + "\n");
                    out.write(customer.getTelephoneNumber() + "\n");
                    out.write("BOOKINGS\n");
                    for (Booking booking : customer.getBookings()) {
                        out.write(booking.getBookingId() + ".");
                    }
                    if (customer.getBookings().size() == 0) {
                        out.write("-");
                    }
                    out.write("\n");
                    out.write("-----\n");

                }

                out.write("END");
                out.close();
            } catch (IOException ex) {

            }

        }
    }

    public void writeRooms(String name) {

        if (name == null) {
            System.out.println("Can't find ref: " + name);
        } else {

            try (BufferedWriter out = new BufferedWriter(new FileWriter("src/" + name + ".txt"))) {

                for (Room room : rooms) {

                    out.write(room.getRoomNumber() + "\n");
                    out.write(room.getNumberOfBeds() + "\n");
                    out.write(room.isHasBalcony() + "\n");
                    out.write(room.getPricePerNight() + "\n");
                    out.write(room.isIsBooked() + "\n");
                    out.write("-----\n");

                }

                out.write("END");
                out.close();
            } catch (IOException ex) {

            }

        }
    }

    public void writeBookings(String name) {

        if (name == null) {
            System.out.println("Can't find ref: " + name);
        } else {

            try (BufferedWriter out = new BufferedWriter(new FileWriter("src/" + name + ".txt"))) {

                for (Booking booking : bookings) {

                    out.write(booking.getBookingId() + "\n");
                    out.write(booking.getCheckInDate() + "\n");
                    out.write(booking.getCheckOutDate() + "\n");
                    out.write(booking.getTotalPrice() + "\n");
                    out.write("ROOMS\n");
                    for (Room room : booking.getRooms()) {
                        out.write(room.getRoomNumber() + ".");
                    }
                    if (booking.getRooms().size() == 0) {
                        out.write("-");
                    }
                    out.write("\n");
                    out.write("-----\n");

                }

                out.write("END");
                out.close();
            } catch (IOException ex) {

            }

        }
    }

    public Booking createBooking2(ArrayList<Room> rooms) {

        Scanner in = new Scanner(System.in);

        Booking tempBooking;

        boolean gettinginput = true;

        int bookingID = -1;

        String indate = "-";
        String outdate = "-";
        LocalDate checkInDate;
        LocalDate checkOutDate;

        double totalprice = -1;

        while (gettinginput) {

            try {
                System.out.println("Booking ID: ");
                bookingID = in.nextInt();
                gettinginput = false;

            } catch (Exception e) {
                System.out.println("invalid input");
                in.next();
            }

            for (Booking booking : bookings) {

                if (booking.getBookingId() == bookingID) {

                    System.out.println("BookingID Already exits");

                    gettinginput = true;

                } else {
                    gettinginput = false;

                }

            }

        }

        //Put this block in a try-catch or loop to retry if input is wrong
        System.out.println("Enter checkin date (yyyy-mm-dd): ");
        indate = in.next();

        checkInDate = enterDate(indate);

        //Put this block in try-catch or loop to retry if input is wrong or check-out date is earlier then check-in date
        System.out.println("Enter checkout date (yyyy-mm-dd): ");
        outdate = in.next();

        checkOutDate = enterDate(outdate);

        int compareTo = enterDate(outdate).compareTo(enterDate(indate));
        System.out.println("You have booked " + compareTo + " days. ");;

        double calcPrice = 0;
        double priceAllrooms = 0;

        for (Room room : rooms) {
            priceAllrooms = priceAllrooms + room.getPricePerNight();
        }

        calcPrice = priceAllrooms * compareTo;

        //REMOVE COST HERE AND ADD IT AUTOMATICALLY AFTER ALL ROOMS ARE BOOKED
        // DateTimeComparator.getDateOnlyInstance().compare(first, second);
        gettinginput = true;

        while (gettinginput) {
            try {
                System.out.println("Total cost for booking?: ");
                totalprice = in.nextDouble();    //Needs to be in a try catch 
                gettinginput = false;
            } catch (Exception e) {
                System.out.println("invalid input");
                in.next();

            }
        }

        tempBooking = new Booking(bookingID, indate, outdate, totalprice);

        for (int i = 0; i < rooms.size(); i++) {
            tempBooking.addRoom(rooms.get(i));
        }
        printBookingInfo(tempBooking);
        bookings.add(tempBooking);
        return tempBooking;
    }

    public LocalDate enterDate(String inputDate) {

        System.out.println("String passed in: " + inputDate);

        //Convert the String to date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(inputDate, formatter);

        // System.out.println("Converted date: " + localDate);
        return localDate;

    }

} // end of class

