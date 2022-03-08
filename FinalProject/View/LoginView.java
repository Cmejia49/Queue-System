package View;

import javax.swing.*;
import javax.swing.JPanel;

import Controller.AuthorizationController.LoginController;

import java.awt.*;
import java.awt.event.*;

import Model.Customer.Customer;
import Model.Customer.CustomerQueu;
import Model.Customer.Order;
import Model.Customer.OrderList;
import Model.Invetory.FoodList;
import Model.SaleHistory.SaleStack;

public class LoginView extends JPanel {
 
    private FoodList list;
    private OrderList orderlist;
    private CustomerQueu queu;
    private SaleStack stack;
    private MainMenu main;
    //Component
    private JFrame app;
    private JTextField userTxt,passTxt;
    public LoginView(FoodList list,OrderList orderList, CustomerQueu queu, 
    SaleStack stack, JFrame app,MainMenu main) {
        this.list = list;
        this.orderlist = orderList;
        this.queu = queu;
        this.stack = stack;
        this.app = app;
        this.main = main;
        JLabel userLbl = new JLabel("Username");
        JLabel passLbl = new JLabel("Password");
        JPanel westPnl = new JPanel(new GridLayout(2,1));
        westPnl.add(userLbl);
        westPnl.add(passLbl);
        userTxt = new JTextField();
        passTxt = new JTextField();
        JPanel centerPnl = new JPanel(new GridLayout(2,1));
        centerPnl.add(userTxt);
        centerPnl.add(passTxt);
        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(new LoginController(main,app, list, stack, userTxt, passTxt));
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
              app.getContentPane().removeAll();
             app.add(main);
             app.setSize(1200, 500);
             app.validate();
             app.repaint();
      }  
      });
        JPanel southPnl = new JPanel(new GridLayout(1,2));
        southPnl.add(loginBtn);
        southPnl.add(cancelBtn);
        setLayout(new BorderLayout());
        add(westPnl,"West");
        add(centerPnl,"Center");
        add(southPnl,"South");



        app.setSize(500,300);


    }

}
