package Model.Invetory;

public class Drink extends Food{

    private String size;
    public Drink(String name, double price, int quantity,String size) {
        super(name, price, quantity);
        //TODO Auto-generated constructor stub
        this.size = size;
    }
    public String getSize()
    {
        return this.size;
    }
}
