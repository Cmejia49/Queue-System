package View;

import javax.swing.*;

import Controller.AuthorizationController.LogoutController;
import Controller.InventoryController.AddFoodController;
import Controller.InventoryController.DeleteFoodController;
import Controller.InventoryController.EditFoodControll;
import Controller.InventoryController.SortController;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import Model.SaleHistory.Sale;
import Model.SaleHistory.SaleStack;
import Model.Customer.Order;
import Model.Invetory.Food;
import Model.Invetory.FoodList;

public class AdminView extends JPanel implements Observer {
     
    private FoodList list;

    private SaleStack stack;
    private JFrame app;
    private JPanel tblFoodList;
    private JComboBox sortCmb;
    private AdminView admin = this;
    private MainMenu main;
    public AdminView(MainMenu main,FoodList list,SaleStack stack, JFrame app) {
        this.list = list;
        this.stack = stack;
        this.app = app;
        this.main = main;
        String[] sort = {"SortByName","SortByPrice","SortByStock"};
        sortCmb = new JComboBox<String>(sort);
        JButton sortBtn = new JButton("Sort");
        sortBtn.addActionListener(new SortController(app, list,sortCmb));
        JPanel tblHeader = new JPanel(new GridLayout(2, 4));
        tblHeader.add(sortCmb);
        tblHeader.add(sortBtn);
        tblHeader.add(new JLabel(""));
        tblHeader.add(new JLabel(""));
        tblHeader.add(new JLabel("Item Name", JLabel.CENTER));
        tblHeader.add(new JLabel("Item Price", JLabel.CENTER));
        tblHeader.add(new JLabel("Item Stock", JLabel.CENTER));
        tblHeader.add(new JLabel(" ", JLabel.CENTER));
        JButton addFoodbBtn = new JButton("Add Menu");
        addFoodbBtn.addActionListener(new AddFoodController(app, list, this));
        
        JButton saleSummaryBtn = new JButton("Sale Summary");
        saleSummaryBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                app.getContentPane().removeAll();
             
               SaleSummaryView saleSummaryView = new SaleSummaryView(stack, app, admin);
                stack.addObserver(saleSummaryView);
                //Activate the observer
                stack.pushSale(new Sale(new Order("chicken", 10.0, 10)));
                stack.popSale();
                //end activation
                app.add(saleSummaryView);
                app.validate();
                app.repaint();
        }  
        });
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(new LogoutController(main, app));
        JPanel southPnl = new JPanel(new GridLayout(1,3));
        southPnl.add(addFoodbBtn);
        southPnl.add(saleSummaryBtn);
        southPnl.add(logoutBtn);
        setLayout(new BorderLayout());
        tblFoodList = new JPanel();
        JScrollPane scrollableTextArea = new JScrollPane(tblFoodList);  
        add(tblHeader,"North");
        add(scrollableTextArea,"Center");
        add(southPnl,"South");
    }
    @Override
    public void update(Observable o, Object arg) {
        
       int listSize = list.size();
       tblFoodList.removeAll();
       tblFoodList.setLayout(new GridLayout(listSize, 2));
        for(int i = 0;i<listSize;i++){
                Food food = list.get(i);
                DeleteFoodController deleteAction = new DeleteFoodController(list, i);
                EditFoodControll editAction = new EditFoodControll(food, list,this, app);
                FoodInstance curr = new FoodInstance(food, editAction, deleteAction);
                food.addObserver(curr);
                tblFoodList.add(curr);
           }
           tblFoodList.validate();
           tblFoodList.repaint();
        
    }

}
