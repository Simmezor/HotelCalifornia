/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelCalifornia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author simon
 */
public class HotelLogic {
    
        private ArrayList <Customer> customers;
        private ArrayList <Room> rooms;
        
        
     public  HotelLogic(){
      customers = new ArrayList();
        rooms = new ArrayList();
         
     }  
    
    public Customer getCustomer(String ssn){
        return null;
    }
    public ArrayList getCustomers(){
         return customers;
    }
    
    public static void showMenu(){
  
       String choice;
       boolean gettingInput = true;
       
       Scanner sc = new Scanner(System.in);
       
       while(gettingInput){  
            System.out.println(""  
                + "1 = Rooms\n"
                + "2 = Booking\n"
                + "3 = Customer\n"
                + "4 = TestMenu\n"
                + "5 = exit\n");
            
            choice = sc.nextLine();

            switch (choice)
            {

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
         
    public static void roomMenu(){
            
        String choice;
        boolean gettingInput = true;

        Scanner sc = new Scanner(System.in);
        while(gettingInput == true){  
            System.out.println(""
                    + "1 = Show available rooms\n"
                    + "2 = Add new room\n"
                    + "3 = Remove room\n"
                    + "4 = Check in customer\n"
                    + "5 = Check out customer\n"
                    + "6 = Return to main menu");

            choice = sc.nextLine();

            switch (choice){

            case "1":
                System.out.println("Show free rooms");
                testMenu();
            break;

            case "2":
                System.out.println("Add new room");
                testMenu();
            break;

            case "3":
                System.out.println("Remove room");
                testMenu();
            break;

            case "4":
                System.out.println("Check in customer");
                testMenu();
                break;

            case "5":
                System.out.println("Check out customer");
                testMenu();
                break;
            case "6":
                System.out.println("Returning to main menu");
                gettingInput = false;
            break;    

            default:
            System.out.println("Error: Pick 1 - 6 and try again!");
            break;
            }
        }
    }
        
    public static void customerMenu(){
        
        String choice;
        boolean gettingInput = true;
        
        Scanner sc = new Scanner(System.in);
        
        while(gettingInput == true){

            System.out.println(""
                    + "1 = Show Cusomers\n"
                    + "2 = Add new Customer\n"
                    + "3 = Remove Customer\n"
                    + "4 = Edit customer\n"
                    + "5 = Return to main menu");

            choice = sc.nextLine();

            switch (choice){
            case "1":
                System.out.println("Show Customer");
                testMenu();
            break;

            case "2":
                System.out.println("Add new Customer");
                testMenu();
            break;

            case "3":
                System.out.println("Remove Customer");
                testMenu();
            break;

            case "4":
                System.out.println("Edit customer");
                testMenu();
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
        
    public static void bookingMenu(){
        
        String choice;
        boolean asking = true;
        Scanner sc = new Scanner(System.in);
        
        while(asking == true){
            
            System.out.println(""
                    + "1 = Show Bookings\n"
                    + "2 = Add new Booking\n"
                    + "3 = Remove Booking\n"
                    + "4 = Edit Booking\n"
                    + "5 = Return to main menu");
        choice = sc.next();
      
        switch (choice){

            case "1":
                System.out.println("Show Bookings");
                testMenu();
            break;

            case "2":
                System.out.println("Add new Booking");
                testMenu();
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
    
    public static void testMenu(){
        System.out.println("\n" +"\u001B[32m" + "Working master" + "\u001B[0m" + "\n");
    }
    
    public void getRoom(){}
    public void getRooms(){}
    
    public void CheckAvailableRooms(ArrayList<Room> rooms) 
    {
        for (Room room : rooms) {
            
            if(!room.isBooked)
            {
                System.out.println("Room " + room.roomNumber + " is available.");
            }
        }
    }
    
    
        public void CheckAvailableRooms()
    {
        for (Room room : rooms) {
            
            if(!room.isBooked)
            {
                System.out.println("Room " + room.roomNumber + " is available.");
            }
        }
    }
    
    public void addCustomer(){}
    public void addRoom(){}
    
    public void checkInCustomer(){}
    public void checkOutCustomer(){}
    
    public void editBooking(){}
}
