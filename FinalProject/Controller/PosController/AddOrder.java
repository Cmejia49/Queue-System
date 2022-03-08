package Controller.PosController;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Customer.Order;
import Model.Customer.OrderList;
import View.MainMenu;

public class AddOrder implements ActionListener{
    private OrderList list;
    private String name;
    private double price;
    private JLabel quantity;
    private JFrame app;
    private MainMenu main;
    public AddOrder(MainMenu main,JFrame app,OrderList list, String name,
     JLabel quantity,double price) {
        this.app = app;
        this.list = list;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.main = main;
    }
    @Override

    public void actionPerformed(ActionEvent e) {
        int qnt = Integer.parseInt(quantity.getText());
        Order order = new Order(name, price, qnt);
        list.addOrder(order);
        app.getContentPane().removeAll();
        app.setSize(1200, 500);
        app.add(main);
        app.validate();
        app.repaint();
     
    }

}
