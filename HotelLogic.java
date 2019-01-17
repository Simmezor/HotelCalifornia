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
    
    public void addCustomer(){}
    public void addRoom(){}
    
    public void checkInCustomer(){}
    public void checkOutCustomer(){}
    
    public void editBooking(){}
}
