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
   
   
  public static void printCustomerInfo(Customer c){
  
      System.out.println("SSN:    "+c.getSsn());
      System.out.println("Name:   "+c.getName());
      System.out.println("Adress: "+c.getAddress());
      System.out.println("Phone:  "+c.getTelephoneNumber());
      
      System.out.println("");

  
  }
  
  public static void printBookingInfo(Booking b){
  
      System.out.println("BookingID     "+b.getBookingId());
      System.out.println("CheckIn Date:  "+b.getCheckInDate());
      System.out.println("CheckOut Date: "+b.getCheckOutDate());
      System.out.println("TotalPrice:    "+b.getTotalPrice());
      
      System.out.println("Rooms Booked: \n");
      
      
      if(b.getRooms().size() == 0){
          System.out.println("No rooms Booked.");
      }else{
      
                for (int i = 0; i < b.getRooms().size(); i++) {
          
          printRoomInfo(b.getRooms().get(i));
      }
          
      }
      

 
  }
  
   
   public static void AddTenTestRooms(ArrayList <Room> rooms, boolean print){
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
            
            if(print){  printRoomInfo(rooms.get(i));}
          
        }
   
   }
   
   
   public static void AddThreeTestCustomers(ArrayList <Customer> customers, boolean print){
   
         Customer testCostumer1 = new Customer("19480910-0001","Jackson Browne","Heidelberg Road 17","555-123-987");
         customers.add(testCostumer1);
         
         Customer testCostumer2 = new Customer("19460615-0002","Linda Ronstadt","Tucson Avenue 6","555-568-123");
         customers.add(testCostumer2);
         
         Customer testCostumer3 = new Customer("19451102-0003","John David Souther","Detroit Street 9","555-789-159");
         customers.add(testCostumer3);
         
         
       for (int i = 0; i < 3; i++) {
                  if(print){  printCustomerInfo(customers.get(i));}
       }
       

         
   }
    
    
    public static void main(String[] args) {
       
        HotelLogic myhotelLogic = new HotelLogic();
        
        System.out.println("Test");
        
        //myhotelLogic.addRoom();
        
         ArrayList <Customer> customers;
         ArrayList <Room> rooms;
        
         customers = new ArrayList();
         rooms = new ArrayList();
         
         AddTenTestRooms(rooms, false);
         
   
         AddThreeTestCustomers(customers, false);
         
         Booking testBooking = new Booking(1,"2019-01-11", "2019-01-03",250);
         
         testBooking.addRoom(rooms.get(0));
         testBooking.addRoom(rooms.get(1));
         
     
         
         printBookingInfo(testBooking);
         
      
         
     } // end of main  
        
} // end of class


