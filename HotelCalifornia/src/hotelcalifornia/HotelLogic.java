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
        System.out.println("Please enter your first and last name: ");
        String name = in.next();
        System.out.println("Please write your social security number: ");
        String ssn = in.next();
        System.out.println("Please enter your address: ");
        String address = in.next();
        System.out.println("Please enter your telephone number: ");
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
    
    
    
    
}
