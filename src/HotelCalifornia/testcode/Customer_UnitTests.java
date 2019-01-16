package hotelcalifornia.testcode;

import hotelcalifornia.Booking;
import hotelcalifornia.Customer;
import java.util.ArrayList;
import java.util.Arrays;

public class Customer_UnitTests {

    // When this is set to true, test will give more information about the test executed
    private boolean verbose = true;

    private ArrayList textOutput;

    private Customer customer;

   public void setVerboseOutput(boolean set) {
        verbose = set;
    }

    public void printVerbose() {

        System.out.println("Expected: " + textOutput.get(0));
        System.out.println("Actual:   " + textOutput.get(1));
        System.out.print("Result:   ");

    }

    public void printVerboseMultiTest() {

        System.out.println("Expected: " + textOutput.get(1));
        System.out.println("Actual:   " + textOutput.get(2));
        System.out.println("Result:   " + textOutput.get(0));

    }

    // @BeforeMethod
    public void setUp() {
        if (verbose == true) {
            System.out.println("Testing: Customer.java");
        }
        textOutput = new ArrayList();

    }

    //@AfterMethod
    public void tearDown() {

    }

    public boolean test_CustomerConstructor_and_getMethods() {
        System.out.println("Running: test_CustomerConstructor_and_getMethods\n");

        boolean result = false;

        String expectedSSN = "000000-0000";
        String expectedName = "John Smith";
        String expectedAdress = "Template Road 1";
        String expectedPhoneNum = "555-555-555";

        customer = new Customer(expectedSSN, expectedName, expectedAdress, expectedPhoneNum);

        if (verbose == true) {
            System.out.println("Expect match with Testdata:\n");
            System.out.println("SSN:      " + "\u001B[36m" + expectedSSN + "\u001B[00m");
            System.out.println("Name:     " + "\u001B[36m" + expectedName + "\u001B[00m");
            System.out.println("Adress:   " + "\u001B[36m" + expectedAdress + "\u001B[00m");
            System.out.println("PhoneNum: " + "\u001B[36m" + expectedPhoneNum + "\u001B[00m");

            System.out.println("");
        }

        if (verbose == true) {
            System.out.println("Actual data:\n");
            System.out.println("SSN:      " + "\u001B[36m" + customer.getSsn() + "\u001B[00m");
            System.out.println("Name:     " + "\u001B[36m" + customer.getName() + "\u001B[00m");
            System.out.println("Adress:   " + "\u001B[36m" + customer.getAddress() + "\u001B[00m");
            System.out.println("PhoneNum: " + "\u001B[36m" + customer.getTelephoneNumber() + "\u001B[00m");
            System.out.println("");
        }

        if (customer.getSsn() == expectedSSN
                && customer.getName() == expectedName
                && customer.getAddress() == expectedAdress
                && customer.getTelephoneNumber() == expectedPhoneNum)
                  {
            result = true;
        } else {
            result = false;
        }

        return result;

    }

    public boolean test_Customer_setMethods() {
        System.out.println("Running: test_Customer_setMethods\n");

        boolean result = false;

        String expectedAdress = "Template Road 1";
        String expectedPhoneNum = "555-555-555";

        customer = new Customer("-","-","-","-");

        if (verbose == true) {
            System.out.println("Expect change from initial data:\n");

            System.out.println("Adress:   " + "\u001B[36m" + customer.getAddress() + "\u001B[00m");
            System.out.println("PhoneNum: " + "\u001B[36m" + customer.getTelephoneNumber() + "\u001B[00m");
            System.out.println("");
        }

        customer.setAdress(expectedAdress);
        customer.setTelephoneNumber(expectedPhoneNum);


        if (verbose == true) {
            System.out.println("New test data:\n");

            System.out.println("Adress:   " + "\u001B[36m" + customer.getAddress() + "\u001B[00m");
            System.out.println("PhoneNum: " + "\u001B[36m" + customer.getTelephoneNumber() + "\u001B[00m");
            System.out.println("");
        }

        if (customer.getAddress()  == expectedAdress && customer.getTelephoneNumber() == expectedPhoneNum ) {
            result = true;
        } else {
            result = false;
        }

        return result;

    }
    
    public boolean test_Customer_addBooking_and_getBookings() {
        System.out.println("Running: test_Customer_addBooking_and_getBookings\n");

        boolean result = false;

        int bookingID = 1;
        String inDate = "2019-01-10";
        String outDate = "2019-01-15";
        double price = 749.99;

       Booking booking = new Booking(bookingID, inDate, outDate, price);

        if (verbose == true) {
            System.out.println("Adding new booking with Testdata:\n");
         
            System.out.println("BookingID:     " + "\u001B[36m" + booking.getBookingId() + "\u001B[00m");
            System.out.println("CheckIn Date:  " + "\u001B[36m" + booking.getCheckInDate() + "\u001B[00m");
            System.out.println("CheckOut Date: " + "\u001B[36m" + booking.getCheckOutDate() + "\u001B[00m");
            System.out.println("TotalPrice:    " + "\u001B[36m" + booking.getTotalPrice() + "\u001B[00m");
            System.out.println("");
        }
        
        
        customer.addBooking(booking);

        if (verbose == true) {
            
            for (int i = 0; i < customer.getBookings().size(); i++) {
                
            System.out.println("Actual data:\n");
            System.out.println("BookingID:     " + "\u001B[36m" + customer.getBookings().get(i).getBookingId() + "\u001B[00m");
            System.out.println("CheckIn Date:  " + "\u001B[36m" + customer.getBookings().get(i).getCheckInDate() + "\u001B[00m");
            System.out.println("CheckOut Date: " + "\u001B[36m" + customer.getBookings().get(i).getCheckOutDate() + "\u001B[00m");
            System.out.println("TotalPrice:    " + "\u001B[36m" + customer.getBookings().get(i).getTotalPrice() + "\u001B[00m");
            System.out.println("");
            }
        }
          for (int i = 0; i < customer.getBookings().size(); i++) {
            
        
        if (booking.getBookingId() == customer.getBookings().get(i).getBookingId()
                && booking.getCheckInDate() == customer.getBookings().get(i).getCheckInDate()
                && booking.getCheckOutDate() == customer.getBookings().get(i).getCheckOutDate()
                && booking.getTotalPrice() == customer.getBookings().get(i).getTotalPrice()) {
            result = true;
        } else {
            result = false;
        }
          }
        return result;

    }
    

}
