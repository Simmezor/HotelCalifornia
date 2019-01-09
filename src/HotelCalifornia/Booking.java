
package hotelcalifornia;

import java.util.ArrayList;


public class Booking {
    int bookingId;
    String checkInDate;
    String checkOutDate;
    double totalPrice;
    
    ArrayList<Room> rooms;
    
    public Booking(int bookingId,String checkInDate,String checkOutDate,double totalPrice){
    
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        rooms = new ArrayList();
    }
   
    public int getBookingId(){
        return bookingId;
        }
    public String getCheckInDate(){
        return checkInDate;
        }
    public String getCheckOutDate(){
        return checkOutDate;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    public void addRoom(Room R){
        rooms.add(R);
    }
    public void setCheckOutDate(String newDate){
        checkOutDate = newDate;
    }
    public void setTotalPrice(double newPrice){
        totalPrice = newPrice;
    }
    
    
}
