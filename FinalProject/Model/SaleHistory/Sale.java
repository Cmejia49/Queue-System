package Model.SaleHistory;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Model.Customer.Order;


public class Sale {
    private int id;
    private Order order;
    private LocalDateTime myDateObj ;
    private String formatedDate;
    private final DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public Sale(int id, Order order) {
       this.id = id;
       this.order = order;
       this.myDateObj = LocalDateTime.now();
       this.formatedDate = myDateObj.format(myFormatObj);
    }

    public String toString(){
        return "[ " + id +" "+order+" "+formatedDate+ " ]";
    }
}
