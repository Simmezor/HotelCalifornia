package HotelCalifornia.Tests;






/**
 *
 * @author Simonster
 */
public class UnitTests {
       //Assert.assertEquals(actual, expected);
  public static final String ANSI_CYAN  = "\u001B[36m"; //Used for output
  public static final String ANSI_RESET = "\u001B[00m"; //Used for output
  public static final String ANSI_RED   = "\u001B[31m"; //Use in test?
  public static final String ANSI_GREEN = "\u001B[32m"; //Use in test?    
    
    public static void testPassed(){
      System.out.println(ANSI_GREEN+"Passed"+ANSI_RESET);
        System.out.println("");
   }
   
   public static void testFailed(){
         System.out.println(ANSI_RED+"Failed"+ANSI_RESET);
         System.out.println("");
   }
   

    
   public static void runUnitTests(){
   
       Customer_UnitTests customer_test = new Customer_UnitTests();
        
      
                 
      customer_test.setUp();
       
      if (customer_test.test() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      customer_test.tearDown();
   
   } // end of run
    
}
