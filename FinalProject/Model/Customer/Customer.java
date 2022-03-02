package Model.Customer;

import java.util.ArrayList;
import Model.Customer.*;

public class Customer {
    private String ticketNum;
    private OrderList order;
    public Customer(String ticketNum, OrderList order) {
        this.ticketNum = ticketNum;
        this.order = order;
    }

    public String getTicket(){
        return this.ticketNum;
    }
    public void setTicket(String ticket){
        this.ticketNum = ticket;
    }
    public String toString(){
        return ticketNum;
    }
}
