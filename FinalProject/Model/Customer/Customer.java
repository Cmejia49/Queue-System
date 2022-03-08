package Model.Customer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import Model.Customer.*;

public class Customer {
    private int id;
    private String ticketNum;

    public Customer() {
        this.ticketNum =generateTicket();
    }

    public String getTicket(){
        return this.ticketNum;
    }
    public void setTicket(){
        this.ticketNum = generateTicket();
   
    }
    
    public String toString(){
        return ticketNum;
    }

    private String generateTicket(){
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	String[] arr = dateString.split(":");
        int max = 99;
        int min = 1;
        int range = max - min + 1;
        Integer rand = (int)(Math.random() * range) + min;
      
        return arr[0]+arr[2]+id+rand.toString();
    }
}
