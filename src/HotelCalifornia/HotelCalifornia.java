/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelCalifornia;

import java.applet.Applet;
import java.io.PrintStream;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author simon
 */
public class HotelCalifornia {


    
    
    public static void main(String[] args) {
        
        

       
        HotelLogic myhotel = new HotelLogic();
        
        HotelCaliforniaGUI gui = new HotelCaliforniaGUI();
        gui.setVisible(true);
        
        // Create an instance of javax.swing.JTextArea control

// Now create a new TextAreaOutputStream to write to our JTextArea control and wrap a
// PrintStream around it to support the println/printf methods.
PrintStream out = new PrintStream( new TextAreaOutputStream( gui.jTextArea1 ) );

// redirect standard output stream to the TextAreaOutputStream
System.setOut( out );

// redirect standard error stream to the TextAreaOutputStream
System.setErr( out );


// now test the mechanism

System.out.println( "Hello World" );
                
                
                gui.jTextArea1.append("");
        
        myhotel.showMenu();
 
 {
     //do something
 }
    }


    
}
