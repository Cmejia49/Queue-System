package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.InventoryController.CancelController;
import Controller.InventoryController.SaveFoodController;

import java.awt.*;
import Model.Invetory.Food;
import Model.Invetory.FoodList;

public class FoodDetailView extends JPanel{
        
    private Food food;
    private FoodList list;
    private AdminView admin;
    private JFrame app;

    private JTextField nameTxt, priceTxt, stockTxt;
    
    public FoodDetailView(JFrame app , Food food, FoodList list,
    AdminView adminView) {
        this.food = food;
        this.list = list;
        this.admin = admin;

        JPanel westPnl =new JPanel(new GridLayout(3,1));
        westPnl.add(new JLabel("Name:"));
        westPnl.add(new JLabel("Price: "));
        westPnl.add(new JLabel("Stock: "));

        nameTxt = new JTextField();
        priceTxt = new JTextField();
        stockTxt = new JTextField();
        JPanel centerPnl = new JPanel(new GridLayout(3,1));
        centerPnl.add(nameTxt);
        centerPnl.add(priceTxt);
        centerPnl.add(stockTxt);

        JButton saveBtn = new JButton("save");
        saveBtn.addActionListener(new SaveFoodController(app, food, adminView, list, nameTxt, priceTxt, stockTxt));
        JButton cancelBtn = new JButton("cancel");
        cancelBtn.addActionListener(new CancelController(adminView, app));
        JPanel southPnl = new JPanel(new GridLayout(1,2));
        southPnl.add(saveBtn);
        southPnl.add(cancelBtn);

        setLayout(new BorderLayout());
        add(westPnl,"West");
        add(centerPnl,"Center");
        add(southPnl,"South");
        if(food != null){
            nameTxt.setText(food.getName());
            priceTxt.setText(String.valueOf(food.getPrice()));
            stockTxt.setText(String.valueOf(food.getStock()));
        }
    }
}
