package Model.Customer;

import java.util.ArrayList;
import java.util.Observable;

public class OrderList extends Observable {
    
    private ArrayList<Order> list;
    private double total = 0.00;
    public OrderList() {
        list = new ArrayList<Order>();
    }
    
    private void orderListChanged(){
        setChanged();
        notifyObservers();
    }
    
    public void addOrder(Order order){
        list.add(order);
        orderListChanged();
    }
    public Order get(int id){
        return list.get(id);
    }
    public void delete(int id){
        list.remove(id);
        orderListChanged();
    }
    public int size(){
       return list.size();
    }
    public void clear(){
        list.clear();
        orderListChanged();
    }
    public double getTotal(){
        return total;
    }
    public void setTotal(){
        for (Order order : list) {
            this.total+=order.getSubtotal();
        }
        orderListChanged();
    }

   
}   
