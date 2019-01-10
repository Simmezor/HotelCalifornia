/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelcalifornia;

import java.util.ArrayList;


/**
 *
 * @author simon
 */
public class HotelCalifornia {


    
   public static void printRoomInfo(Room r){
   
       System.out.println("RoomNumber: "+r.getRoomNumber());
       System.out.println("Beds: "+r.getNumberOfBeds());
       System.out.println("Has Balcony: "+r.isHasBalcony());
       System.out.println("Price: "+r.getPricePerNight());
       System.out.println("Booked: "+r.isIsBooked());
       
       System.out.println("");
       
       
   }
    
    
    public static void main(String[] args) {
       
        HotelLogic myhotelLogic = new HotelLogic();
        
        System.out.println("Test");
        
        //myhotelLogic.addRoom();
        
         ArrayList <Customer> customers;
         ArrayList <Room> rooms;
        
         customers = new ArrayList();
         rooms = new ArrayList();
         
         int numberofbeds = 0;
         double price = 0;
         boolean booked = false;
         boolean balcony = false;
         
         
         for (int i = 0; i < 10; i++) {
             
             if(i % 2 == 0){
             numberofbeds = 1;
             price = 79.49;
             }else{
              numberofbeds = 2;
              price = 129.49;
             }
             
                          if(i % 3 == 0){
             booked = true;
             }else{
            booked = false;
             }
                          
             if(i % 4 == 0){
             balcony = true;
             }else{
            balcony = false;
             }
             
             
            rooms.add(new Room(i+1, numberofbeds,balcony,price, booked ));
            
            printRoomInfo(rooms.get(i));
        }
         
      
         
     } // end of main  
        
} // end of class


