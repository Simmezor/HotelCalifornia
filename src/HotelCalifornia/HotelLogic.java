
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author simon
 */
public class HotelLogic {

    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    JFrame frame = new JFrame("");

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

        System.out.println("Room:    " + "\u001B[36m" + r.getRoomNumber() + "\u001B[00m");
        System.out.println("Beds:    " + "\u001B[36m" + r.getNumberOfBeds() + "\u001B[00m");
        System.out.println("Balcony: " + "\u001B[36m" + r.isHasBalcony() + "\u001B[00m");
        System.out.println("Price:   " + "\u001B[36m" + r.getPricePerNight() + "\u001B[00m");
        System.out.println("Booked:  " + "\u001B[36m" + r.isIsBooked() + "\u001B[00m");

    }

    public static void printCustomerInfo(Customer c) {

        System.out.println("SSN:    " + c.getSsn());
        System.out.println("Name:   " + c.getName());
        System.out.println("Adress: " + c.getAddress());
        System.out.println("Phone:  " + c.getTelephoneNumber());

        System.out.println("");

    }

    public static void printBookingInfo(Booking b) {

        System.out.println("BookingID       " + b.getBookingId());
        System.out.println("Check-in Date:  " + b.getCheckInDate());
        System.out.println("Check-out Date: " + b.getCheckOutDate());
        System.out.println("Total Price:    " + b.getTotalPrice());

        System.out.println("Rooms Booked:");

        if (b.getRooms().size() == 0) {
            System.out.println("No rooms Booked.");
        } else {

            for (int i = 0; i < b.getRooms().size(); i++) {

                System.out.println("Room " + b.getRooms().get(i).getRoomNumber());
            }

        }
        System.out.println("");
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

    public void showMenu() {

        showLogo();

        loadRooms("Rooms.txt");
        loadBookings("Bookings.txt");
        loadCustomers("Customers.txt");

        String choice;
        boolean gettingInput = true;

        Scanner sc = new Scanner(System.in);

        while (gettingInput) {

            System.out.println("\n"
                    + "1 = Rooms\n"
                    + "2 = Customer\n"
                    + "3 = Booking\n"
                    + "4 = exit\n"
                    + "Write help for instructions\n"
            );

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

                    gettingInput = false;

                    writeCustomers("Customers");
                    writeBookings("Bookings");
                    writeRooms("Rooms");
                    break;

                case "help":
                    helpMainMenu();
                    break;

                default:
                    System.out.println("Error: Pick 1 - 4 and try again!");
                    break;
            }
        }

    }

    public void roomMenu() {

        String choice;
        boolean gettingInput = true;

        Scanner sc = new Scanner(System.in);
        while (gettingInput == true) {
            System.out.println("\n"
                    + "1 = Show all rooms\n"
                    + "2 = Show available rooms\n"
                    + "3 = Add new room\n"
                    + "4 = Remove room\n"
                    + "5 = Edit Room\n"
                    + "6 = Search for room\n"
                    + "7 = Return to main menu\n"
                    + "Write help for instructions\n"
            );

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
                case "help":
                    helpRoomMenu();

                    break;
                default:
                    System.out.println("Error: Pick 1 - 7 and try again!");
                    break;
            }
        }
    }

    public void customerMenu() {

        String choice;
        boolean gettingInput = true;

        Scanner sc = new Scanner(System.in);

        while (gettingInput == true) {

            System.out.println("\n"
                    + "1 = Show Customers\n"
                    + "2 = Add new Customer\n"
                    + "3 = Edit customer\n"
                    + "4 = Search Customer\n"
                    + "5 = Return to main menu\n"
                    + "Write help for instructions\n"
            );

            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    showAllCustomers();
                    break;

                case "2":
                    addCustomer();

                    break;

                case "3":
                    editCustomer();
                    break;

                case "4":
                    searchForCustomer();
                    break;

                case "5":
                    System.out.println("Returning to main menu");
                    gettingInput = false;
                    break;
                case "help":
                    helpCustomerMenu();

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

            System.out.println("\n"
                    + "1 = Show Bookings\n"
                    + "2 = Check in\n"
                    + "3 = Check out\n"
                    + "4 = Edit Booking\n"
                    + "5 = Return to main menu\n"
                    + "Write help for instructions\n"
            );

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
                case "help":
                    helpBookingMenu();

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

    // Help instruction for each menu
    public void helpMainMenu() {
        String output = "Welcome to help menu\n"
                + "In this menu you you will have four (4) different options\n"
                + "You have to write 1, 2, 3, or 4 \n"
                + "and press enter to access the different menus\n"
                + "\n"
                + "Write 1 for Rooms\n"
                + "Write 2 for Customer\n"
                + "Write 3 for Booking\n"
                + "Write 4 to exit\n";

        JOptionPane.showMessageDialog(frame,
                output,
                "Welcome to help for main menu",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public void helpRoomMenu() {
        String output = "Welcome to help menu\n"
                + "In this menu you you will have seven (7) different options\n"
                + "You have to write 1, 2, 3, 4, 5, 6, or 7 \n"
                + "and press enter to access the different menus\n"
                + "\n"
                + "If you write 1, you will see all rooms in the hotel\n"
                + "If you write 2, you will see all rooms that are free for booking\n"
                + "If you write 3, you will be able to add new rooms\n"
                + "If you write 4, you will be able to remove old rooms\n"
                + "If you write 5, you will be able to edit existing rooms\n"
                + "If you write 6, you can search for a room\n"
                + "\n"
                + "Write 7 to return to the first menu\n";

        JOptionPane.showMessageDialog(frame,
                output,
                "Welcome to help for room menu",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public void helpCustomerMenu() {
        String output = "Welcome to help menu\n"
                + "In this menu you you will have five (5) different options\n"
                + "You have to write 1, 2, 3, 4, or 5 \n"
                + "and press enter to access the different menus\n"
                + "\n"
                + "If you write 1 , you will see all customers registered\n"
                + "If you write 2 , you will be able to add new customers\n"
                + "If you write 3 , you will be able to edit customer information\n"
                + "If you write 4 , you will be able to search for customers\n"
                + "\n"
                + "Write 5 to return to first menu\n";
        JOptionPane.showMessageDialog(frame,
                output,
                "Welcome to help for customer menu",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public void helpBookingMenu() {
        String output = "Welcome to help menu\n"
                + "In this menu you you will have five (5) different options\n"
                + "You have to write 1, 2, 3, 4, or 5 to access the different menu\n"
                + "\n"
                + "If you write 1 , you will see all bookings\n"
                + "If you write 2 , you will be able to check in customers\n"
                + "If you write 3 , you will be able to check out customers\n"
                + "If you write 4 , you will be able to edit bookings\n"
                + "\n"
                + "Write 5 to return to first menu\n";
        JOptionPane.showMessageDialog(frame,
                output,
                "Welcome to help for booking menu",
                JOptionPane.INFORMATION_MESSAGE);

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

        boolean gettingInput = true;
        System.out.println("Please enter your social security number: ");
        String ssn = in.nextLine();

        String name = "";

        while (gettingInput) {
            System.out.println("Please enter name: ");
            name = in.nextLine();
            String pattern1 = "[a-öA-Ö\\s]{2,100}";

            if (name.matches(pattern1)) {
                gettingInput = false;
            } else {
                System.out.println("invalid input");
            }
        }
        System.out.println("Please enter address: ");
        String address = in.nextLine();

        String telephone = "";
        gettingInput = true;
        while (gettingInput) {
            System.out.println("Please enter your telephone number, use format XXX-XXX XX XX: ");
            telephone = in.nextLine();
            telephone = telephone.replaceAll("\\s+","");
            String pattern1 = "\\d\\d\\d([-])?\\d\\d\\d\\d\\d\\d";
            String pattern2 = "\\d\\d\\d([-])?\\d\\d\\d\\d\\d\\d\\d";
            if (telephone.matches(pattern1) || telephone.matches(pattern2)) {
                gettingInput = false;
            } else {
                System.out.println("invalid input");
            }
        }
        Customer newCustomer = new Customer(ssn, name, address, telephone);
        customers.add(newCustomer);
        System.out.println("New customer " + name + " succesfully added. ");

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
                    if (!room.isBooked) {
                        allbooked++;
                    }
                }

                while (gettinginput) {

                    try {
                        System.out.println("How many rooms do you want to book? ");
                        numberOfrooms = sc.nextInt();

                        if (allbooked >= numberOfrooms) {
                            gettinginput = false;
                        } else {
                            System.out.println("There are not enough rooms available");
                        }

                    } catch (Exception e) {
                        System.out.println("invalid input");
                        sc.next();
                    }

                }

                while (booking == true && numberOfrooms > 0) {

                    if (rooms.size() == 0) {
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
        Scanner in = new Scanner(System.in);

        boolean gettingInput = true;

        boolean matchfound = false;

        System.out.println("Enter customer SSN: ");
        ssnToSearch = in.nextLine();
        System.out.println("Searching for " + ssnToSearch);

        for (Customer customer : customers) {

            if (ssnToSearch.matches(customer.getSsn())) {

                matchfound = true;

                System.out.println("Found a match!");
                System.out.println("Name: " + customer.getName());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("Phone number: " + customer.getTelephoneNumber());

                System.out.println(" ");

                System.out.println("Enter New Address: ");
                String editAddress = in.nextLine();
                customer.setAdress(editAddress);

                while (gettingInput) {
                    System.out.println("Please enter new telephone number: ");
                    String telephone = in.nextLine();
                    String pattern1 = "\\d\\d\\d([-])?\\d\\d\\d\\d\\d\\d";
                    String pattern2 = "\\d\\d\\d([-])?\\d\\d\\d\\d\\d\\d\\d";
                    if (telephone.matches(pattern1) || telephone.matches(pattern2)) {
                        gettingInput = false;
                        customer.setTelephoneNumber(telephone);
                    } else {
                        System.out.println("invalid input");
                    }

                }

                break;

            }
            if (!matchfound) {
                System.out.println("No match found for " + ssnToSearch + ", please try again. ");
            }

        }

    }

     public void editRoom() {

        Scanner in = new Scanner(System.in);

        boolean gettinginput = true;

        boolean matchfound = false;

     
        
        
        int searching =  -1;
        
            while (gettinginput) {

            try {
                System.out.println("Enter room number (100 - 1112): ");
                searching = in.nextInt();
                gettinginput = false;

                if (searching < 100 || searching > 1112) {
                    System.out.println("Invalid input");
                    gettinginput = true;
                }


            } catch (Exception e) {
                System.out.println("Invalid input");
                in.next();
            }
        }
        
        
        

        for (Room room : rooms) {
            if (searching == room.roomNumber) {

                System.out.println("Room found!");

                printRoomInfo(room);

                matchfound = true;

                while (gettinginput) {

                    try {
                        System.out.println("Enter new total beds (1 - 5):");
                        int beds = in.nextInt();

                        if (beds < 1 || beds > 5) {
                            System.out.println("Invalid input ");
                            gettinginput = true;
                        }
                        gettinginput = false;

                        room.setNumberOfBeds(beds);

                    } catch (Exception e) {
                        System.out.println("invalid input");
                        in.next();
                    }
                }

                gettinginput = true;

                while (gettinginput) {
                    try {
                        System.out.println("Enter new cost per night? (500 - 1000): ");
                        double price = in.nextDouble();

                        if (price < 500 || price > 1000) {
                            System.out.println("Invalid input");
                            gettinginput = true;
                        }else{
                          gettinginput = false;
                          room.setPricePerNight(price);
                        }

                      

                

                    } catch (Exception e) {
                        System.out.println("invalid input");
                        in.next();

                    }
                }
            }
        }

        if (!matchfound) {
            System.out.println("Could not find a room with roomnumber " + searching);
        }

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
        boolean bookingmatch = false;
        String ssnToSearch;
        int searching = -1;
        Scanner sc = new Scanner(System.in);

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

                boolean gettinginput = true;

                while (gettinginput) {

                    try {
                        System.out.println("Enter booking ID:");
                        searching = sc.nextInt();

                        gettinginput = false;

                    } catch (Exception e) {
                        System.out.println("invalid input");
                        sc.next();
                    }
                }

                for (Booking booking : customer.getBookings()) {
                    if (searching == booking.getBookingId()) {

                        bookingmatch = true;

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate checkindate = LocalDate.parse(booking.getCheckInDate(), formatter);

                        LocalDate checkoutdate = enterCheckOut(checkindate);
                        booking.setCheckOutDate(checkoutdate.toString());

                        double calcPrice;
                        double priceAllrooms = 0;

                        for (Room room : booking.rooms) {
                            priceAllrooms = priceAllrooms + room.getPricePerNight();
                        }

                        calcPrice = priceAllrooms * compareTo(checkoutdate, checkindate);

                        System.out.println("Total cost: " + calcPrice);

                        booking.setTotalPrice(calcPrice);

                    }
                }
                match = true;
                break;
            }

        }
        if (!bookingmatch && match) {
            System.out.println("Could not find booking ID: " + searching);
        }

        if (!match) {
            System.out.println("No Customer found");
        }

    }

    public void checkOutCustomer() {

        int searchForBookings = 0;
        Scanner sc = new Scanner(System.in);
        boolean removebool = false;
        boolean matchfound = false;
        boolean getInput = true;

        int customerindex = 0;
        int bookingindex = 0;

        while (getInput) {

            try {
                System.out.println("What is the booking Id?: ");
                searchForBookings = sc.nextInt();
                getInput = false;

            } catch (Exception e) {

                System.out.println("invalid input");
                sc.next();

            }
        }
        for (int n = 0; n < customers.size(); n++) {
            for (int i = 0; i < customers.get(n).getBookings().size(); i++) {
                if (customers.get(n).getBookings().get(i).bookingId == searchForBookings) {
                    System.out.println("Match found!");
                    matchfound = true;
                    System.out.println("Do you wish to remove this booking?");

                    String remove = sc.next();

                    if (remove.equalsIgnoreCase("yes") || remove.equalsIgnoreCase("y") || remove.equalsIgnoreCase("ye")) {
                        removebool = true;

                        customerindex = n;
                        bookingindex = i;

                    } else {
                        System.out.println("Remove booking aborted");
                    }
                }
            }

            //  booking.getRooms().clear();
        }

        if (removebool) {
            customers.get(customerindex).getBookings().remove(bookingindex);

            for (Booking booking : bookings) {
                for (Room room1 : rooms) {
                    for (Room room2 : booking.rooms) {
                        if (room1.getRoomNumber() == room2.getRoomNumber()) {
                            room1.setIsBooked(false);
                        }
                    }
                }
            }
            System.out.println("Booking removed!");
        }
        if (!matchfound) {
            System.out.println("No current booking with that ID exist");
        }
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
                    tempstring = "";
                }

            }

        }

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

    public Booking createBooking(ArrayList<Room> rooms) {

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
                    break;

                } else {
                    gettinginput = false;

                }

            }

        }

        checkInDate = enterCheckIn();
        checkOutDate = enterCheckOut(checkInDate);

        double calcPrice;
        double priceAllrooms = 0;

        for (Room room : rooms) {
            priceAllrooms = priceAllrooms + room.getPricePerNight();
        }

        calcPrice = priceAllrooms * compareTo(checkOutDate, checkInDate);
        System.out.println("Total cost: " + calcPrice);

        totalprice = calcPrice;

        tempBooking = new Booking(bookingID, checkInDate.toString(), checkOutDate.toString(), totalprice);

        for (int i = 0; i < rooms.size(); i++) {
            tempBooking.addRoom(rooms.get(i));
        }
        printBookingInfo(tempBooking);
        bookings.add(tempBooking);
        return tempBooking;
    }

    public boolean dateFormatterCheckIn(String inputDate) {
        //Convert the String to date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(inputDate, formatter);
        LocalDate dateNow = LocalDate.now();
        boolean valid = false;

        if (!localDate.isBefore(dateNow)) {
            valid = true;
        } else {
            System.out.println("Invalid date, that date has passed. Please try again ");
        }

        return valid;

    }

    public boolean dateFormatterCheckOut(String inputDate, LocalDate checkindate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(inputDate, formatter);

        boolean valid = false;

        if (!localDate.isBefore(checkindate) && !localDate.isEqual(checkindate)) {

            valid = true;
        } else {
            System.out.println("Invalid date, date is before the check in date. Please try again ");
        }

        return valid;

    }

    public LocalDate enterCheckIn() {
        Scanner in = new Scanner(System.in);
        String indate = "";
        boolean gettingInput = true;
        while (gettingInput) {

            System.out.println("Enter checkin date, use format yyyy-mm-dd. ");
            indate = in.next();

            // check if the indate has the correct format and is not in the past
            if (matchesPatternDate(indate) && (dateFormatterCheckIn(indate))) {
                gettingInput = false;
            }

        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(indate, formatter);
        return localDate;
    }

    public LocalDate enterCheckOut(LocalDate checkindate) {
        Scanner in = new Scanner(System.in);
        String indate = "";
        boolean gettingInput = true;
        while (gettingInput) {

            System.out.println("Enter checkin date, use format yyyy-mm-dd. ");
            indate = in.next();

            // check if the indate has the correct format and is not in the past
            if (matchesPatternDate(indate) && (dateFormatterCheckOut(indate, checkindate))) {
                gettingInput = false;
            }

        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(indate, formatter);
        return localDate;
    }

    public boolean matchesPatternDate(String indate) {

        boolean valid = false;
        String pattern;
        pattern = "\\d\\d\\d\\d-\\d\\d-\\d\\d";

        if (!indate.matches(pattern)) {
            System.out.println("Invalid date format. Please try again ");

        } else {
            valid = true;

        }

        return valid;
    }

    public int compareTo(LocalDate one, LocalDate two) {

        int compareTo = 0;

        compareTo = ((one.getYear() - two.getYear()) * 365 + (one.getDayOfYear() - two.getDayOfYear()));

        System.out.println("You have booked " + compareTo + " days. ");

        return compareTo;
    }

} // end of class

