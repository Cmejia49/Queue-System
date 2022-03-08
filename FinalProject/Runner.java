import Controller.CashRegController;
import Model.Customer.Customer;
import Model.Customer.CustomerQueu;
import Model.Customer.Order;
import Model.Customer.OrderList;
import Model.Invetory.Drink;
import Model.Invetory.Food;
import Model.Invetory.FoodList;
import Model.SaleHistory.SaleStack;
import View.MainMenu;

import java.lang.Math;

import javax.swing.JFrame;
public class Runner extends JFrame{

    public Runner() {
       FoodList list = new FoodList();
       OrderList orderList = new OrderList();
       CustomerQueu queu = new CustomerQueu();
       SaleStack stack = new SaleStack();
       MainMenu  main= new MainMenu(list,orderList,queu,stack,this);
       list.addObserver(main);
       list.addFood(new Food("Chicken", 10.00, 2));
       list.addFood(new Food("Burger", 10.00, 2));
       list.addFood(new Food("Spag", 10.00, 2));
       list.addFood(new Food("Fries", 10.00, 2));
       list.addFood(new Drink("Coke", 10.0, 2, "Small"));
       list.addFood(new Food("BucketMeal", 100.00, 2));
       list.addFood(new Food("CripyFries", 50.00, 2));
       list.addFood(new Food("Carbonara", 70.00, 2));
       list.addFood(new Food("Tuna", 12.00, 2));
       list.addFood(new Drink("Royal", 10.0, 2, "Small"));
       list.addFood(new Food("ChickenInasal", 30.00, 2));
       list.addFood(new Food("CheeseBurger", 25.00, 2));
       list.addFood(new Food("Macarony", 15.00, 2));
       list.addFood(new Food("Lumpia", 10.00, 2));
       list.addFood(new Drink("Sprite", 12.0, 2, "Small"));
       list.addFood(new Food("BurgerSteak", 49.00, 2));
       list.addFood(new Food("Alaking", 49.00, 2));
       list.addFood(new Food("ChickenFillet", 49.00, 2));
       list.addFood(new Food("Dynamite", 10.00, 2));
       list.addFood(new Drink("Mineral", 15.0, 2, "Small"));
       orderList.addObserver(main);
       queu.addObserver(main);
       add(main);
    }

    public static void main(String[] args){
        JFrame app = new Runner();
        app.setTitle("CashRegister with queu system");
        app.setVisible(true);
        app.setSize(1200, 500);
        //app.setResizable(false);
        app.setLocationRelativeTo(null); 
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}