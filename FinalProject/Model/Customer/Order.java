package Model.Customer;

import java.util.Observable;
import java.util.Observer;

public class Order extends Observable{
    private String name;
    private double price;
    private int quantity;
    private double subtotal;

    public Order(String name, double price, int quantity) {
        orderChanged();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = price * quantity;
    }
    private void orderChanged(){
        setChanged();
        notifyObservers();
}
    public String getName()
    {
        return this.name;
    }
    public double getPrice()
    {
        return this.price;
    }
    public int getQuantity()
    {
        return this.quantity;
    }
    public double getSubtotal(){
        return this.subtotal;
    }
    public String toString(){
        return "[ " + name +" "+ price +
        " " + quantity + " "+ subtotal + "] ";
    }

}
