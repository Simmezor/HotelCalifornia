
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelCalifornia;

import hotelcalifornia.Customer;
import hotelcalifornia.Room;
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
    
        public  static void showMenu(){
    
     // TODO code application logic here
        
        boolean running = true;
        
        Scanner sc = new Scanner(System.in);
        
        String input;
   
                 System.out.println("Welcome to Hotel California");
                 
                 System.out.println("Here are your options:");
                 

        
        while(running == true){
                 System.out.println("1. Testing print function. \n");
                 
                 System.out.println("Type 'exit' to close the application.");
                 
            input = sc.next();
        
            System.out.println(input);
            
            if(input.matches("exit")){
            running = false;
            break;
            }
        
            if(input.matches("1")){
            
                System.out.println("This is a test print.");
                
            }
            
        }
        
    }
    
    public void getRoom(){}
    public void getRooms(){}
    
    public void getAvailableRooms(){}
    
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

         boolean gettinginput = true;
         
         int temproomnum =-1;
         int beds = -1;
         
         boolean tempbalcony;
         double tempprice;
         
         while(gettinginput) {
                  try{
         System.out.println("Whats the room number: ");    
         temproomnum = in.nextInt();      
         gettinginput =false;
                  }catch( Exception e){
                      System.out.println("invalid input");
                      in.next();
                           
            }
         }
         
                  while(gettinginput) {
                  try{
         System.out.println("Please enter the number of beds you want: ");    
         beds = in.nextInt();    //Needs to be in a try catch 
         gettinginput =false;
                  }catch( Exception e){
                      System.out.println("invalid input");
                      in.next();
                           
            }
         }
         

         System.out.println("Would you like to have a balcony?: ");
         boolean balcony = in.nextBoolean();      //Needs to be in a try catch
         System.out.println("Enter price per night: ");    
         double price = in.nextDouble();    //Needs to be in a try catch
                              
         gettinginput = false;
         
         Room newRoom = new Room(temproomnum,beds,balcony,price,false);     
         
         
         rooms.add(newRoom);
         

     

}
    public void checkInCustomer(){}
    public void checkOutCustomer(){}
    
    public void editBooking(){}
}
