// Ronnie
// Display a list of all rooms

package HotelCalifornia;

import java.util.ArrayList;

public class ShowAllRooms
{
    public static void CheckAllRooms(ArrayList<Room> rooms) //Might have to remove static when calling from another method.
    {
        System.out.println("Total number of rooms: " + rooms.size());
        System.out.println("-------------------------");

        for (Room room : rooms) {
            
            System.out.println("Room " + room.getRoomNumber()); 
            System.out.println("Number of beds: " + room.getNumberOfBeds());

            if (room.isHasBalcony()) {

                System.out.println("Has balcony.");
                
            } else {
                
                System.out.println("Does not have balcony.");
            }

            if(room.isIsBooked())
            {
                System.out.println("Room is " + (char)27 + "[31m" + "BOOKED!");
            }
            else
            {
                System.out.println("Room is " + (char)27 + "[32m" + "AVAILABLE!");
            }

            System.out.println((char)27 + "[39m" + "Price per night: " + room.getPricePerNight() + ".\r\n");

        }
    }

    //Helper method. REMOVE when calling from another method.
    public static void main(String[] args)
    {
        ArrayList<Room> rooms = new ArrayList<Room>();

        Room room1 = new Room(1, 2, false, 1000, false);
        Room room2 = new Room(2, 1, true, 1000, false);
        Room room3 = new Room(3, 1, false, 1000, true);
        Room room4 = new Room(4, 2, true, 1000, false);
        Room room5 = new Room(5, 1, false, 1000, true);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);

        CheckAllRooms(rooms);

    }

}