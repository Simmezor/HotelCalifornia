package HotelCalifornia.Tests;




import java.util.ArrayList;
import java.util.Arrays;


public class Booking_UnitTests {
        
    
    // When this is set to true, test will give more information about the test executed
    private boolean verbose = true;
    
    private ArrayList textOutput;
    
    public void setVerboseOutput(){
    verbose = true;
    }
    
    public void printVerbose(){
       
      System.out.println("Expected: " + textOutput.get(0));
      System.out.println("Actual:   " + textOutput.get(1) ); 
      System.out.print("Result:   "); 
    
    }
    
        public void printVerboseMultiTest(){
       
      System.out.println("Expected: " + textOutput.get(1));
      System.out.println("Actual:   " + textOutput.get(2) ); 
      System.out.println("Result:   " +  textOutput.get(0)); 
 
    
    }
        
     

   // @BeforeMethod
    public void setUp() {
       if(verbose == true) { System.out.println("Testing: Projekt_testIHD");}
       textOutput = new ArrayList();

    }
    
        //@AfterMethod
    public void tearDown() {

    }

    //@test
    public boolean test(){
    if(verbose == true) { System.out.println("Running: test");}
    
   return false;

   }




}
