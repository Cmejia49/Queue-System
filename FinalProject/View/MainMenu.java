package View;

import Model.Customer.Customer;
import Model.Customer.CustomerQueu;
import Model.Customer.Order;
import Model.Customer.OrderList;
import Model.Invetory.FoodList;
import Model.SaleHistory.SaleStack;

import javax.swing.*;

import Controller.PosController.AddQueuController;
import Controller.PosController.RemoveQueueController;
import Controller.PosController.DeleteOrder;
import Controller.PosController.FoodBtnAction;

import java.awt.*;
import java.util.*;
import java.awt.event.*;  
public class MainMenu extends JPanel implements Observer{
    private FoodList list;
    private OrderList orderlist;
    private CustomerQueu queu;
    private SaleStack stack;
    private MainMenu main = this;
    //Component
    private JPanel tblOrder,southPnl,queuContainer,northPnl,
    headerPnl,pnlWest;
    private JFrame app;
    private JLabel nameLbl,priceLbl, quantityLbl, 
    subTotalLbl,totalLbl,totalValue,queuValue,queuLbl,spacer;
    private String name;
    private JButton btn , loginBtn,addQueuBtn,servedBtn;
    
    public MainMenu(FoodList list,OrderList orderList, CustomerQueu queu, SaleStack stack, JFrame app) {
        this.list = list;
        this.orderlist = orderList;
        this.queu = queu;
        this.stack = stack;
        this.app = app;
        northPnl = new JPanel(new GridLayout(1,10));
        this.headerPnl = new JPanel(new GridLayout(1,5));
        this.nameLbl = new JLabel("Name" ,JLabel.CENTER);
        this.priceLbl = new JLabel("Price" ,JLabel.CENTER);
        this.quantityLbl = new JLabel("Quantity" ,JLabel.CENTER);
        this.subTotalLbl = new JLabel("Subtotal" ,JLabel.CENTER);
        JLabel s = new JLabel(" ");
        headerPnl.add(nameLbl);
        headerPnl.add(priceLbl);
        headerPnl.add(quantityLbl);
        headerPnl.add(subTotalLbl);
        headerPnl.add(s);
        this.queuContainer = new JPanel(new GridLayout(2,2));
        queuLbl = new JLabel("in Queu");
        queuValue = new JLabel("");
       queuContainer.add(queuLbl);
       queuContainer.add(queuValue);
       spacer = new JLabel(" ");
       northPnl.add(queuContainer);
       northPnl.add(spacer);
       northPnl.add(headerPnl);
        this.name = " ";
        this.loginBtn = new JButton("Admin Login");
        loginBtn.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){  
            LoginView login = new LoginView(list, orderList, queu, stack, app,main);
            app.getContentPane().removeAll();
           app.add(login);
           app.validate();
           app.repaint();
    }  
    });
        this.addQueuBtn = new JButton("Add To queu");
        addQueuBtn.addActionListener(new AddQueuController(queu,orderList,stack));
        
        this.servedBtn = new JButton("Served");
        servedBtn.addActionListener(new RemoveQueueController(queu));
        
        this.totalLbl = new JLabel("Total");
       this.totalValue = new JLabel("0");
       this.southPnl = new JPanel(new GridLayout(1,5,2,5));
       southPnl.add(loginBtn);
       southPnl.add(addQueuBtn);
       southPnl.add(servedBtn);
       southPnl.add(totalLbl);
       southPnl.add(totalValue);
       pnlWest = new JPanel();
       setLayout(new BorderLayout());
       tblOrder = new JPanel();
       JScrollPane scrollableTextArea = new JScrollPane(tblOrder);  
       add(pnlWest,"West");
       add(northPnl,"North");
       add(scrollableTextArea, "East");
       add(southPnl,"South");

    }
    @Override
    public void update(Observable o, Object arg) {
      pnlWest.removeAll();
      pnlWest.setLayout(new GridLayout(list.size()/5,5,5,5));
      for(int i = 0;i<list.size();i++){
        name = list.get(i).getName();
        btn = new JButton(i+" "+name);
        btn.addActionListener(new FoodBtnAction(this,app,orderlist,list)); 
          btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, btn.getMinimumSize().height));
          pnlWest.add(btn);        
       }
       pnlWest.validate();
       pnlWest.repaint();
      tblOrder.removeAll();
      queuContainer.removeAll();
      northPnl.removeAll();
      southPnl.remove(totalValue);
      int listSize = orderlist.size();
      southPnl.setLayout(new GridLayout(1,3));
      tblOrder.setLayout(new GridLayout(listSize, 1));
      double total = 0;
      for(int i = 0;i<listSize;i++){
        Order order = orderlist.get(i);
        total +=order.getSubtotal();
        DeleteOrder deleteAction = new DeleteOrder(orderlist,i);
        OrderInstance curr = new OrderInstance(order, deleteAction);
        order.addObserver(curr);
        tblOrder.add(curr);
      }
      tblOrder.validate();
      tblOrder.repaint();

      totalValue = new JLabel(total + "");
      southPnl.add(totalValue);
      southPnl.validate();
      southPnl.repaint();


      northPnl.setLayout(new GridLayout(1,10));
      queuContainer.setLayout(new GridLayout(1,10));  
      queuContainer.add(queuLbl);
      Queue<Customer> q = queu.getQueue();
      int count = 0;
 
        for (Customer curr: q) {
          count++;
         queuValue = new JLabel(curr.getTicket());
         queuContainer.add(queuValue);
         if(count >3){
           return;
         }
     
        }
    
  
      northPnl.add(queuContainer);
      northPnl.add(spacer);
      northPnl.add(headerPnl);
      queuContainer.validate();
      queuContainer.repaint();
    }

}

