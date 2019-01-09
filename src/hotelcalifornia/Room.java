
package hotelcalifornia;


public class Room {
   
    int roomNumber;
    int numberOfBeds;
    boolean hasBalcony;
    double pricePerNight;
    boolean isBooked;
    
    public Room(int roomNumber,int numberOfBeds,boolean hasBalcony,double pricePerNight,boolean isBooked){}

    public int getRoomNumber() {
        return roomNumber;
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

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
 
    
}
