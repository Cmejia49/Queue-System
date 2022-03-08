package Model.Invetory;

import java.util.Observable;

public class Food extends Observable {

    private String name;
    private double price;
    private int stock;

    public Food(String name, double price, int stock) {
        foodChanged();
        this.name = name;
       this.price = price;
       this.stock = stock;
    }
    private void foodChanged(){
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
    public int getStock()
    {
        return this.stock;
    }
    public void setName(String name)
    {
       this.name = name;
       foodChanged();
    }
    public void setPrice(double price)
    {
       this.price = price;
       foodChanged();
    }
    public void setStock(int stock)
    {
       this.stock = stock;
       foodChanged();
    }
    public String toString(){
        return  name + " " + price + " "+stock + " " ;
    }
}
