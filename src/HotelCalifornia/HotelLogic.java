
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelCalifornia;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HotelLogic {

    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    JFrame frame = new JFrame("Pick avaible room");

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

        String choice;
        boolean gettingInput = true;

        Scanner sc = new Scanner(System.in);

        while (gettingInput) {
            System.out.println(""
                    + "1 = Rooms\n"
                    + "2 = Customer\n"
                    + "3 = Booking\n"
                    + "4 = TestMenu\n"
                    + "5 = exit\n"
                    + "Write help for help instruction");

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
                    System.out.println("No test menu yet");
                    break;
                case "5":
                    System.exit(0);
                    break;
                case "help":
                    helpMainMenu();
                    break;
                default:
                    System.out.println("Error: Pick 1,2 or 5 and try again!");
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
                    + "4 = Search for room\n"
                    + "5 = Return to main menu\n"
                    + "Write help for help instruction");

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
                    searchRoom();
                    break;

                case "5":
                    System.out.println("Returning to main menu");
                    gettingInput = false;
                    break;
                case "help":
                    helpRoomMenu();
                    break;

                default:
                    System.out.println("Error: Pick 1 - 5 and try again!");
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
                    + "5 = Edit customer room\n"
                    + "6 = Return to main menu\n"
                    + "write help for help instruction");

            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    showAllCustomers();
                    break;

                case "2":
                    addCustomer();
                    checkInCustomer(customers.get(customers.size() - 1));

                    break;

                case "3":
                    searchForCustomer();
                    break;

                case "4":
                    editCustomer();
                    break;
                case "5":
                    editRoom();
                    break;

                case "6":
                    System.out.println("Returning to main menu");
                    gettingInput = false;
                    break;
                case "help":
                    helpCustomerMenu();

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
                    + "5 = Return to main menu\n"
                    + "write help for help instructions");
            choice = sc.nextLine();

            switch (choice) {

                case "1":
                    showBookings();

                    break;

                case "2":
                    // this.checkInCustomer(customer);
                    System.out.println("Not implemented");
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
                + "In this menu you you will have five (5) diffrent options\n"
                + "You have to write 1, 2, 3, 4 or 5 to access the diffrent menu\n"
                + "\n"
                + "Write 1 for Rooms\n"
                + "Write 2 for Customer\n"
                + "Write 3 for Booking\n"
                + "Write 4 for TestMenu\n"
                + "Write 5 to exit\n";

        JOptionPane.showMessageDialog(frame,
                output,
                "Welcome to help for main menu",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public void helpRoomMenu() {
        String output = "Welcome to help menu\n"
                + "In this menu you you will have five (5) diffrent options\n"
                + "You have to write 1, 2, 3, 4 or 5 to access the diffrent menu\n"
                + "\n"
                + "If you write 1 , you will see all rooms in the hotel\n"
                + "If you write 2 , you will see all rooms thats are free for booking\n"
                + "If you write 3  , you will be avaible to add new rooms\n"
                + "If you write 4 , you can search for a room\n"
                + "\n"
                + "Write 5 to return to first menu\n";

        JOptionPane.showMessageDialog(frame,
                output,
                "Welcome to help for room menu",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public void helpCustomerMenu() {
        String output = "Welcome\n"
                + "In this menu you you will have six (6) diffrent options\n"
                + "You have to write 1, 2, 3, 4, 5 or 6 to access the diffrent menu\n"
                + "\n"
                + "If you write 1 , you will see all customers registred\n"
                + "If you write 2 , you will be avaible to add new customer\n"
                + "If you write 3 , you will be avaible to search for customer\n"
                + "If you write 4 , you can edit customer info\n"
                + "If you write 5 , you will be avaible to edit customer room\n"
                + "\n"
                + "Write 6 to return to first menu\n";
        JOptionPane.showMessageDialog(frame,
                output,
                "Welcome to help for customer menu",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public void helpBookingMenu() {
        String output = "Welcome\n"
                + "In this menu you you will have six (6) diffrent options\n"
                + "You have to write 1, 2, 3, 4, 5 or 6 to access the diffrent menu\n"
                + "\n"
                + "If you write 1 , you will see all bookings\n"
                + "If you write 2 , you will be avaible to check in customer\n"
                + "If you write 3 , you will be avaible to Check out customer\n"
                + "If you write 4 , you can edit booking\n"
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

        String output = "";
        for (int i = 0; i < rooms.size(); i++) {
            String everything = rooms.get(i).toString();

            output += everything + "\n";
        }
        JOptionPane.showMessageDialog(null, output);

        System.out.printf("Checked in: " + "\u001B[32m" + output + "test2 " + "\u001B[0m" + "\n");

//        for (Room room : rooms) {
//
//            if (!room.isBooked) {
//                System.out.println("Room " + room.roomNumber + " is available.");
//            }
//        }
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
                System.out.println("What is the room's number: ");
                temproomnum = in.nextInt();
                gettinginput = false;

            } catch (Exception e) {
                System.out.println("invalid input");
                in.next();
            }
        }

        gettinginput = true;

        while (gettinginput) {

            try {
                System.out.println("How many beds does the room have?: ");
                beds = in.nextInt();
                gettinginput = false;

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
                System.out.println("How much does the room cost per night?: ");
                price = in.nextDouble();    //Needs to be in a try catch 
                gettinginput = false;
            } catch (Exception e) {
                System.out.println("invalid input");
                in.next();

            }
        }

        Room newRoom = new Room(temproomnum, beds, balconybool, price, false);

        rooms.add(newRoom);

    }

    public void editRoom() {
        String ssnToSearch;
        Scanner sc = new Scanner(System.in);
        Scanner scEditRoom = new Scanner(System.in);

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
                System.out.println("BOOKINGS" + customer.bookings);

                System.out.println("Enter room number");
                int searching = sc.nextInt();

                for (Room rooms : rooms) {
                    if (searching == rooms.roomNumber) {

                        System.out.println("Enter new Room number: ");
                        String editDate = scEditRoom.nextLine();
                        rooms.getRoomNumber();

                        System.out.println("Enter new total beds (not implemented yet): ");
                        String editBeds = scEditRoom.nextLine();
                        rooms.setNumberOfBeds(searching);

                        System.out.println("Enter New Price: ");
                        String editPrice = scEditRoom.nextLine();
                        rooms.setPricePerNight(searching);
                    } else {
                        System.out.println("Could not find booking number");
                    }
                    break;
                }
            } else {
                System.out.println(" The search didn´t succeed, please try again. ");
            }

        }
    }

    public void addCustomer() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your social security number: ");

        String ssn = in.nextLine();
        System.out.println("Please enter name: ");
        String name = in.nextLine();
        System.out.println("Please enter address: ");
        String address = in.nextLine();
        System.out.println("Please enter your telephone number: ");
        String telephone = in.nextLine();

        Customer newCustomer = new Customer(ssn, name, address, telephone);
        customers.add(newCustomer);

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

                customer.addBooking(createBooking(bookedrooms));
            }
        }

    }

    public void checkOutCustomer() {

        int searchForBookings;
        Scanner sc = new Scanner(System.in);

        boolean resultFound = false;
        System.out.println("Enter bookingId:");
        searchForBookings = sc.nextInt();
        System.out.println("Searching for " + searchForBookings);

        System.out.println(bookings.size());
        for (Booking booking : bookings) {

            String bookingIdString = String.valueOf(booking.getBookingId());

            if (searchForBookings == booking.getBookingId()) {

                resultFound = true;

                System.out.println("Do you wish to remove this booking?");

                String remove = sc.next();

                ArrayList<Room> rooms = new ArrayList<Room>();

                if (remove.matches("yes") || remove.matches("Yes") || remove.matches("YES")) {

                    for (Room room : booking.rooms) {

                        rooms.add(room);

                    }

                    for (int i = 0; i < rooms.size(); i++) {
                        rooms.get(i).setIsBooked(false);
                    }

                    System.out.println("Booking removed!"
                            + "\nYou Removed: "
                            + remove);

                    showMenu();

                } else {
                    System.out.println("Removing booking aborted.");
                    break;

                }

            }

        }

    }

    public void editCustomer() {
        String ssnToSearch;
        Scanner sc = new Scanner(System.in);
        Scanner scEdit = new Scanner(System.in);

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
                System.out.println("BOOKINGS" + customer.bookings);

//                System.out.println("Enter New Name: ");
//                String editName = scEdit.next();
//                customer.
                System.out.println("Enter New Address: ");
                String editAddress = scEdit.nextLine();
                customer.setAdress(editAddress);

                System.out.println("Enter New Phone Number: ");
                String editPhoneNo = scEdit.nextLine();
                customer.setTelephoneNumber(editPhoneNo);
                break;

            } else {
                System.out.println("The search didn´t succeed," + "could not find: " + ssnToSearch + " please try again. ");
            }

        }

    }

    public void getRoom() {
        System.out.println("getRoom not implemented");
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

    public void editBooking() {
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
                System.out.println("BOOKINGS" + customer.bookings);

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
                break;
            } else {
                System.out.println(" The search didn´t succeed, please try again. ");
            }

        }

    }

} // end of class

