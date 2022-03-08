package Model.SaleHistory;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Observable;

import Model.Customer.Order;


public class Sale extends Observable{
    private Order order;
    private LocalDateTime myDateObj ;
    private String formatedDate;
    private final DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Sale(Order order) {
        saleChanged();
       this.order = order;
       this.myDateObj = LocalDateTime.now();
       this.formatedDate = myDateObj.format(myFormatObj);
    }
    private void saleChanged(){
        setChanged();
        notifyObservers();
}
    public String getName()
    {
        return order.getName();
    }
    public double getPrice()
    {
        return order.getPrice();
    }
    public int getQuantity()
    {
        return order.getQuantity();
    }
    public double getSubtotal(){
        return order.getSubtotal();
    }
}
