/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelcalifornia;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    
    // vi skapar en arraylist av typen Customer
    ArrayList<Customer> customers;
    // vi skapar en arraylist av typen Room
    ArrayList<Room> rooms;
    
    //constructor
    public HotelLogic(){
    customers = new ArrayList();
    
    }
    
//    public void addCustomer(Customer c){
//        customers.add(c);
//    }
    
    public void addCustomer(){
        Scanner in = new Scanner(System.in);
        System.out.println("First and last name: ");
        String name = in.next();
        System.out.println("Social security number: ");
        String ssn = in.next();
        System.out.println("Address: ");
        String address = in.next();
        System.out.println("Telephone number: ");
        String telephoneNumber = in.next();
        
        Customer newCustomer = new Customer(ssn, name, address, telephoneNumber);
        
        customers.add(newCustomer);
       
    }
    
   public ArrayList<Customer> getCustomers(){
   return customers;
   }
    
    
    //en metod per backlog (kan vara fler)
    //namn på metoderna ska visa vad de gör
    //metod för show menu
    //menu = loop + switch case
    
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
    
    
}
