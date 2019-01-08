
package hotelcalifornia;

import java.util.ArrayList;
import java.util.Scanner;



public class HotelLogic {
    // Vi skapar en arraylist av typen Customer
    
    ArrayList<Customer> customers;
    // Vi skapar en arraylist av typen Room
    ArrayList<Room> rooms;
    
    //constructor
    public HotelLogic(){
    customers = new ArrayList<Customer>();
    rooms = new ArrayList<Room>(); 
    }
    
    //en metod per backlog
    //addCustomer
    //public Customer(String ssn, String name, String address, String telephoneNumber){
    
    public void addCustomer(){
         Scanner in = new Scanner(System.in);
         System.out.println("Please enter your social security number: ");    
         String ssn = in.next();
         System.out.println("Please enter name: ");
         String name = in.next();
         System.out.println("Please enter address: ");    
         String address = in.next();
         System.out.println("Please enter your telephone number: ");    
         String telephone = in.next();
               
         Customer newCustomer = new Customer(ssn,name,address,telephone);
         customers.add(newCustomer);
       
    }
    
    //public Room(int roomNumber,int numberOfBeds,boolean hasBalcony,double pricePerNight,boolean isBooked)
     public void addRoom(){
         Scanner in = new Scanner(System.in);
         System.out.println("Whats the room number: ");    
         int roomNumber = in.nextInt();
         System.out.println("Please enter the number of beds you want: ");    
         int beds = in.nextInt();    //Needs to be in a try catch
         System.out.println("Would you like to have a balcony?: ");
         boolean balcony = in.nextBoolean();      //Needs to be in a try catch
         System.out.println("Enter price per night: ");    
         double price = in.nextDouble();    //Needs to be in a try catch
                                 
         Room newRoom = new Room(roomNumber,beds,balcony,price,false);
         rooms.add(newRoom);
     }
         
     
    
    //showMenu-metoden
    //loop + switch-case
}
