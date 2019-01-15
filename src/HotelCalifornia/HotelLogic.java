
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelCalifornia;


import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author simon
 */
public class HotelLogic {

    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;
   JFileChooser fileChooser = new JFileChooser();
   
   
    String[] checkIn = { "Room 1", "Room 2", "Room 3", "Room 4", "Room 5", "Room 6" };
    JFrame frame = new JFrame("Pick avaible room");


    public HotelLogic() throws FileNotFoundException {

        customers = new ArrayList();
        rooms = new ArrayList();
        bookings = new ArrayList();
    }

    public Customer getCustomer(String ssn) {
        return null;
    }

    public ArrayList getCustomers() {
        return customers;
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
                    + "4 = Remove room\n"
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
                    System.out.println("Remove room not implemented");
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
                    + "1 = Show Cusomers\n"
                    + "2 = Add new Customer\n"
                    + "3 = Remove Customer\n"
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
                    System.out.println("Remove Customer not implemented");
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
                    + "2 = Add new Booking / Check in customer\n"
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
                    System.out.println("Add new Booking / Check in");
                    checkInCustomer();
                    break;

                case "3":
                    System.out.println("Remove Booking");
                    testMenu();
                    break;

                case "4":
                    System.out.println("Edit Booking");
                    testMenu();
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
    

    public void checkInCustomer() {

        String choice;
        boolean asking = true;
        Scanner sc = new Scanner(System.in);
//    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    
        
//        System.out.println("This is the avaible rooms: "
//                + "\nRoom 1"
//                + "\nRoom 2 "
//                + "\nRoom 3 "
//                + "\nRoom 4");
//
//        CheckAvailableRooms();
        

    JFileChooser fc = new JFileChooser();
    JFrame frame2 = new JFrame();
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);
    JTextArea tarea = new JTextArea(10, 10);
    JButton readButton = new JButton("OPEN FILE");
    
    readButton.addActionListener(ev -> {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
    "TEXT FILES", "txt", "text");
        
fc.setFileFilter(filter);

      int returnVal = fc.showOpenDialog(frame);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        try {
          BufferedReader input = new BufferedReader(new InputStreamReader(
              new FileInputStream(file)));
          tarea.read(input, "READING FILE :-)");
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else {
        System.out.println("Operation is CANCELLED :(");
      }
    });

    frame.getContentPane().add(tarea, BorderLayout.CENTER);
    frame.getContentPane().add(readButton, BorderLayout.PAGE_END);
    frame.pack();
    frame.setVisible(true);
  

// Väljer vilken fil man vill läsa

//        JFileChooser chooser = new JFileChooser();
//FileNameExtensionFilter filter = new FileNameExtensionFilter(
//    "TEXT FILES", "txt", "text");
//chooser.setFileFilter(filter);
//
//int returnVal = chooser.showOpenDialog(fileChooser);
//if(returnVal == JFileChooser.APPROVE_OPTION) {
//   System.out.println("You chose to open this file: " +
//        chooser.getSelectedFile().getName());
//   
 
   
   
  // Försök till att läsa en fil
  
//    JTextArea tarea = new JTextArea(10, 10);
//
//   File file = chooser.getSelectedFile();
//          BufferedReader input = null;
//            try {
//                input = new BufferedReader(new InputStreamReader(
//                        new FileInputStream(file)));
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(HotelLogic.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                tarea.read(input, "READING FILE :-)");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//          
//
//  }



          
//            System.out.print("Enter the file name with extension : ");
//
//  int result = fileChooser.showOpenDialog(fileChooser);
//if (result == JFileChooser.APPROVE_OPTION) {
//    File selectedFile = fileChooser.getSelectedFile();
//    System.out.println("Selected file: " + selectedFile.getName());
//}
        

        while (asking == true) {
            
            System.out.println(""
                    + "1 = Check in room\n"
                    + "5 = Return to main menu\n"
                    + "6 = Quit\n");
            choice = sc.nextLine();
            
            switch (choice) {

                case "1":
                    
    String checkIn2 = (String) JOptionPane.showInputDialog(frame, 
        "Wich room you wanna check into?",
        "Rooms avaible",
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        checkIn, 
        checkIn[0]);

   System.out.printf("Checked in: " +  "\u001B[32m" +  checkIn2 + "\u001B[0m" + "\n");
                    break;

                case "5":
                    System.out.println("Returning to main menu");
                    asking = false;
                    break;
                 case "6":
                    System.exit(0);
                    asking = false;
                    break;

                default:
                    System.out.println("Error: Pick 1 or 5 and try again!");
                    break;
            }
        }
        
        
    }

    public void checkOutCustomer() {
    }

    public void editBooking() {
    }

    public void getBookedRoom() {
    }

    public void getRoom() {
    }

} // end of class
