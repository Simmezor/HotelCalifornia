package hotelcalifornia.testcode;

import hotelcalifornia.Customer;
import hotelcalifornia.HotelLogic;


public class HotelLogic_UnitTests {
    

    boolean verbose;
    HotelLogic testHotelLogic;
    
       public void setVerboseOutput(boolean set) {
        verbose = set;
    }
    
   // @BeforeMethod
    public void setUp() {

        testHotelLogic = new HotelLogic();
       
    }
        //@AfterMethod
    public void tearDown() {
        
      testHotelLogic = null;

    }
    //@test
    public boolean testAddCustomer(){
        
    boolean result = false;    
        
   System.out.println("Running: testAddCustomer");
   
   String expectedSSN = "000000-0000";
   String expectedName = "John Smith";
   String expectedAdress = "Template Road 1";
   String expectedPhoneNum = "555-555-555";
   
        System.out.println("Testdata:");
        System.out.println(expectedSSN);
        System.out.println(expectedName);
        System.out.println(expectedAdress);
        System.out.println(expectedPhoneNum);
   
   testHotelLogic.addCustomer();
   
   Customer testCostumer = (Customer) testHotelLogic.getArrayListCustomers().get(0);
   
        System.out.println("Inputed data:");
        System.out.println(testCostumer.getSsn());
        System.out.println(testCostumer.getName());
        System.out.println(testCostumer.getAddress());
        System.out.println(testCostumer.getTelephoneNumber());
   
   String actualSSN = testCostumer.getSsn();
   String actualName = testCostumer.getName();
   String actualAdress = testCostumer.getAddress();
   String actualPhoneNum = testCostumer.getTelephoneNumber();
   
   if(expectedSSN.matches(actualSSN)  &&
      expectedName.matches(actualName) &&
      expectedAdress.matches(actualAdress) &&
      expectedPhoneNum.matches(actualPhoneNum) ){
   result = true;
   }else{
   result = false;
   }
   return result;

   }

}

       
    }
