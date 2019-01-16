package hotelcalifornia.testcode;

/**
 *
 * @author Simonster
 */
public class UnitTests {

    public static final String ANSI_CYAN = "\u001B[36m"; //Used for output
    public static final String ANSI_RESET = "\u001B[00m"; //Used for output
    public static final String ANSI_RED = "\u001B[31m"; //Use in test?
    public static final String ANSI_GREEN = "\u001B[32m"; //Use in test?    

    public static void testPassed() {
        System.out.println("Result: " + ANSI_GREEN + "Passed" + ANSI_RESET);
        System.out.println("");
    }

    public static void testFailed() {
        System.out.println("Result: " + ANSI_RED + "Failed" + ANSI_RESET);
        System.out.println("");
    }

    public static void test(boolean test) {
        if (test == true) {
            testPassed();
        } else {
            testFailed();
        }
    }

    public static void runUnitTests(boolean verbose) {

        HotelLogic_UnitTests testHotelLogic = new HotelLogic_UnitTests();

        // Setup test classes
        Room_UnitTests testRoom = new Room_UnitTests();

        Customer_UnitTests testCustomer = new Customer_UnitTests();

        Booking_UnitTests testBooking = new Booking_UnitTests();

        // Run tests and set the information flag
                testRoom.setVerboseOutput(verbose);
        testBooking.setVerboseOutput(verbose);
                testCustomer.setVerboseOutput(verbose);
                        testHotelLogic.setVerboseOutput(verbose);

        // Testing Room
        testRoom.setUp();

        test(testRoom.test_RoomConstructor_and_getMethods());

        testRoom.tearDown();

        testRoom.setUp();

        test(testRoom.test_Room_setMethods());

        testRoom.tearDown();

        // Testing Booking
        testBooking.setUp();

        test(testBooking.test_BookingConstructor_and_getMethods());

        testBooking.tearDown();

        testBooking.setUp();

        test(testBooking.test_Booking_setMethods());

        testBooking.tearDown();
        
        
        testBooking.setUp();

        test(testBooking.test_Booking_addRoom_and_getRooms());

        testBooking.tearDown();

        // Testing Customer
        testCustomer.setUp();

        test(testCustomer.test_CustomerConstructor_and_getMethods());

        testCustomer.tearDown();

        testCustomer.setUp();

        test(testCustomer.test_Customer_setMethods());

        testCustomer.tearDown();
        
        testCustomer.setUp();
        
        test(testCustomer.test_Customer_addBooking_and_getBookings());
        
        testCustomer.tearDown();
        
        // Testing HotelLogic
        
        testHotelLogic.setUp();
        
        test(testHotelLogic.testAddCustomer());
        
        testHotelLogic.tearDown();

    } // end of run

}
