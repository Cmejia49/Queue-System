package Controller;

import Model.Customer.Customer;
import Model.Customer.CustomerQueu;
import Model.Customer.Order;
import Model.Customer.OrderList;

public class CashRegController{

    private OrderList list;
    private CustomerQueu queu;
    public CashRegController(OrderList list, CustomerQueu queu) {
      this.list = list;
      this.queu = queu;
    }
 
    public void addCart(Order item) {
      
        list.addOrder(item);

    }

    public double getTotal(){
        return list.getTotal();
    }  
    public String printOrder(){
        String result = "Your Order : "+ list.toString();
       return result;
    }
    //Delete item From Cart
    public void deleteItem(int id){
        list.delete(id);
    }
    public void addToQueu(Customer customer) {
        queu.addQueu(customer);
        
    }
    public String serving(){
        return "Serving " + queu.peekTop();
    }
    public String served() {
       
        return "Thank you " + queu.removeQueu();
    }
    
}
