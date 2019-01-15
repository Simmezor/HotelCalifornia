
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelcalifornia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author simon
 */
public class HotelLogic {

    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

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
        System.out.println("CheckIn Date:  " + b.getCheckInDate());
        System.out.println("CheckOut Date: " + b.getCheckOutDate());
        System.out.println("TotalPrice:    " + b.getTotalPrice());

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
                    + "2 = Booking\n"
                    + "3 = Customer\n"
                    + "4 = TestMenu\n"
                    + "5 = exit\n");

            choice = sc.nextLine();

            switch (choice) {

                case "1":
                    roomMenu();
                    break;

                case "2":
                    bookingMenu();
                    break;

                case "3":
                    customerMenu();
                    break;

                case "4":
                    testMenu();
                    break;

                case "5":

                    gettingInput = false;
                    break;

                default:
                    System.out.println("Error: Pick 1 - 5 and try again!");
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
                    + "1 = Show available rooms\n"
                    + "2 = Show all rooms\n"
                    + "3 = Add new room\n"
                    + "4 = Search room\n"
                    + "5 = Return to main menu");

            choice = sc.nextLine();

            switch (choice) {

                case "1":
                    CheckAvailableRooms();

                    break;

                case "2":
                    CheckAllRooms();
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
                    System.out.println("Show Customer not implemented");
                    break;

                case "2":
                    addCustomer();
                    break;

                case "3":
                    searchForCustomer();
                    break;

                case "4":
                    System.out.println("Edit customer not implemented");
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
                    + "2 = Add new Booking\n"
                    + "3 = Remove Booking\n"
                    + "4 = Edit Booking\n"
                    + "5 = Return to main menu");
            choice = sc.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("Show Bookings");
                    testMenu();
                    break;

                case "2":
                    System.out.println("Add new Booking");
                    testMenu();
                    break;

                case "3":
                    System.out.println("Remove Booking not implemented");

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
        checkInCustomer(newCustomer);
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
        while(booking == true){

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
            if (numrooms == numberOfrooms ) {
                booking = false;
                createBooking(bookedrooms);
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
                System.out.println("What is the rooms number: ");
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

    public void checkOutCustomer() {
        System.out.println("checkOutCustomer not implemented");
    }

    public void editBooking() {
        System.out.println("editBooking not implemented");
    }

    public void getBookedRoom() {
        System.out.println("getBooked not implemented");
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
                System.out.println("BOOKINGS");
                ArrayList<Booking> customerBookings = customer.getBookings();
                for (Booking customerBooking : customerBookings) {

                    System.out.println(customerBooking.bookingId + ": Check-in:" + customerBooking.checkInDate + ". Check-out: " + customerBooking.checkOutDate + ". "
                            + "Price: " + customerBooking.getTotalPrice() + ".");

                }
            } 
        }
        
        if (matchfound == false) {
            System.out.println("No match found");
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
                System.out.println("What is the rooms number: ");
                roomnumber = sc.nextInt();
                gettinginput = false;

            } catch (Exception e) {
                System.out.println("invalid input");
                sc.next();
            }
        }

        for (Room room : rooms) {
            if (room.isIsBooked()) {
                bookedrooms.add(room);
            } else {
                if (room.getRoomNumber() == roomnumber) {
                    System.out.println("Match found!");
                    matchfound = true;

                    printRoomInfo(room);
                    return;

                }
            }
        }

        for (Customer customer : customers) {

            for (int i = 0; i < customer.getBookings().size(); i++) {
                for (int j = 0; j < customer.getBookings().get(i).rooms.size(); j++) {
                    if (customer.getBookings().get(i).rooms.get(j).roomNumber == roomnumber) {

                        matchfound = true;
                        System.out.println("Match found!");
                        printRoomInfo(customer.getBookings().get(i).rooms.get(j));

                        System.out.println("Booked by");
                        printCustomerInfo(customer);

                        System.out.println("Booking information:");
                        printBookingInfo(customer.getBookings().get(i));
                    }
                }
            }

        }

        if (matchfound == false) {
            System.out.println("No room with that roomnumber found.");
        }

    }

} // end of class
