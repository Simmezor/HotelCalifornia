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
    
      public void addRoom(){
         Scanner in = new Scanner(System.in);

         boolean gettinginput = true;
         
         int temproomnum =-1;
         int beds = -1;
         
         String balcony = "-1";
         boolean balconybool = false;
         double price = -0;
         
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
         gettinginput = true;
                  while(gettinginput) {
                  try{
         System.out.println("How many beds does the room have?: ");    
         beds = in.nextInt();    //Needs to be in a try catch 
         gettinginput =false;
                  }catch( Exception e){
                      System.out.println("invalid input");
                      in.next();
                           
            }
         }
                  
                    gettinginput = true;
                   while(gettinginput) {
                
         System.out.println("Does the room have a balcony?: ");    
         balcony = in.next();    //Needs to be in a try catch 
         
          switch(balcony){

              case "yes":
                 balconybool = true;
                    gettinginput =false;
                    break;
              case "Yes":
                 balconybool = true;
                    gettinginput =false;
                   break;
              case "no":
                 balconybool = false;
                    gettinginput =false;
                   break;
              case "No":
                 balconybool = false;
                    gettinginput =false;
                   break;
              default:
                  System.out.println("invalid input");

                   break;
          }
              
            
         }
                    gettinginput = true;

                                    while(gettinginput) {
                  try{
         System.out.println("What is the price for the room?: ");    
         price = in.nextDouble();    //Needs to be in a try catch 
         gettinginput =false;
                  }catch( Exception e){
                      System.out.println("invalid input");
                      in.next();
                           
            }
         }
         
                              
         
         Room newRoom = new Room(temproomnum,beds,balconybool,price,false);     
         
         
         rooms.add(newRoom);
         

     

}
    public void addRoom(){}
    
    public void checkInCustomer(){}
    public void checkOutCustomer(){}
    
    public void editBooking(){}
}
