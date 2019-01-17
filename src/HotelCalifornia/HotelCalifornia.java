/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelCalifornia;

import java.io.FileNotFoundException;


/**
 *
 * @author simon
 */
public class HotelCalifornia {


    
    
    public static void main(String[] args) {
        
       
        HotelLogic myhotel = null;
        try {
            myhotel = new HotelLogic();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found - Main window -");
        }
        
        
        System.out.println("Test");
        
        myhotel.showMenu();
    }
    
}
