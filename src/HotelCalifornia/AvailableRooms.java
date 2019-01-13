// Ronnie
// Display a list of all available rooms

package HotelCalifornia;

import java.util.ArrayList;

public class AvailableRooms
{
    public static void CheckRooms(ArrayList<Room> rooms) //Might have to remove static when calling from another method.
    {
        for (Room room : rooms) {
            
            if(!room.isBooked)
            {
                System.out.println("Room " + room.getRoomNumber() + " is available.");
            }
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

        CheckRooms(rooms);

    }

}