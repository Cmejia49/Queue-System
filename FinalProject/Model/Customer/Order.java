package Model.Customer;

public class Order{
    private String name;
    private double price;
    private int quantity;
    private double subtotal;

    public Order(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = price * quantity;
    }
    public double getSubtotal(){
        return this.subtotal;
    }
    public String toString(){
        return "[ " + name +" "+ price +
        " " + quantity + " "+ subtotal + "] ";
    }
}
