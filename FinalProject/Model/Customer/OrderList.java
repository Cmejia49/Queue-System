package Model.Customer;

import java.util.ArrayList;

public class OrderList {
    
    private ArrayList<Order> list;
    private double total;
    public OrderList() {
        list = new ArrayList<Order>();
    }

    public void addOrder(Order order){
        list.add(order);
    }
    public void getOrder(int id){
        list.get(id);
    }
    public void delete(int id){
        list.remove(id);
    }
    public int length(){
       return list.size();
    }
    public void clear(){
        list.clear();
    }
    public double getTotal(){
        for (Order order : list) {
            total+=order.getSubtotal();
        }
        return total;
    }
    public String toString(){
        String result = "";
        for (Order order : list) {
            result += order.toString() + ", ";
        }

        return "Ordered Food " + result ;
    }
}   
