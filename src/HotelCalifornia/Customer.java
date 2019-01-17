/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelCalifornia;

import java.util.ArrayList;

/**
 *
 * @author Helena
 */
public class Customer {
    
    String ssn;
    String name;
    String address;
    String telephoneNumber;
    
    ArrayList<Booking> bookings;
    
    public Customer(String ssn, String name, String address, String telephoneNumber){
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        bookings = new ArrayList();
    }
    
    public String getSsn(){
    return ssn;
    }
    
    public String getName(){
    return name;
    }
    
    public String getAddress(){
    return address;
    }
    
    public String getTelephoneNumber(){
    return telephoneNumber;
    }
    
    public ArrayList<Booking> getBookings (){
    return bookings;
    }
    
    public void setAdress(String newAddress){
    address = newAddress;
    }
    
    public void setTelephoneNumber (String newTel){
    telephoneNumber = newTel;
    }
    
    public void addBooking(Booking b){
        bookings.add(b);
    }
     public void setName(String newName){
    name = newName;
    }
    
    //attribut personnummer, namn, adress, telefon (String)
    //ArrayList av Booking
    //andra attribute
    //Contructor
    //getter setter
    
}
