/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelcalifornia;

/**
 *
 * @author Helena
 */
public class Room {
    //ID nr som är unik, antal sängar (int), pris (double)
    //balkong eller inte (boolean)
    //attribute boolean tillgängligt eller inte
    //ett attribut kan vara boolean is available
    //constructor
    //getter setter
    int roomNumber;
    int numberOfBeds;
    boolean hasBalcony;
    double pricePerNight;
    boolean isBooked;
    
    public Room (int roomNumber, int numberOfBeds, boolean hasBalcony, double 
            pricePerNight, boolean isBooked){
        this.hasBalcony = hasBalcony;
        this.isBooked = isBooked;
        this.numberOfBeds = numberOfBeds;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isIsBooked() {
        return isBooked;
    }
    
    
    public int getRoomNumber(){
        return roomNumber;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
    
    
    
    
}
