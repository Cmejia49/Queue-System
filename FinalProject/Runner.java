import Controller.CashRegController;
import Controller.InventoryController;
import Model.Customer.Customer;
import Model.Customer.CustomerQueu;
import Model.Customer.Order;
import Model.Customer.OrderList;
import Model.Invetory.Drink;
import Model.Invetory.Food;
import Model.Invetory.FoodList;
import java.lang.Math;
public class Runner{

    
    static String generateTicket(){
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        Integer rand = (int)(Math.random() * range) + min;
      
        return "A"+rand.toString();
    }
    public static void main(String[] args){
     
       FoodList food = new FoodList();
       InventoryController inventory = new InventoryController(food);

       inventory.addFood(new Food("Chicken", 10.00, 2));
       inventory.addFood(new Food("Burger", 10.00, 2));
       inventory.addFood(new Food("Spag", 10.00, 2));
       inventory.addFood(new Food("Fries", 10.00, 2));
       inventory.addFood(new Drink("Coke", 10.0, 2, "Small"));

       System.out.println(inventory.print()); 
        OrderList order = new OrderList();
        CustomerQueu queu = new CustomerQueu();
       CashRegController pos = new CashRegController(order, queu);

       pos.addCart(new Order("Chicken", 10.00, 2));

       pos.addCart(new Order("Burger", 10.00, 2));

       String ticket = generateTicket();

       System.out.println(ticket +" "+ pos.printOrder());

       System.out.println("Your Total:" +pos.getTotal());

       pos.addToQueu(new Customer(ticket, order));

       System.out.println(pos.serving());

       System.out.println("Next Customer pls");

       System.out.println(pos.served());

       pos.addCart(new Order("Spag", 10.00, 2));

       pos.addCart(new Order("Fries", 10.00, 2));

       ticket = generateTicket();

       System.out.println(ticket +" "+ pos.printOrder());

       System.out.println("Your Total:" +pos.getTotal());

       pos.addToQueu(new Customer(ticket, order));

       System.out.println(pos.serving());

       System.out.println("Next Customer pls");

       System.out.println(pos.served());
    }

}