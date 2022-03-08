package Controller.InventoryController;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Invetory.Food;
import Model.Invetory.FoodList;
import View.AdminView;
public class SaveFoodController implements ActionListener {

    private JFrame app;
    private Food food;
    private AdminView adminView;
    private FoodList list;
    private JTextField nameTxt;
    private JTextField priceTxt;
    private JTextField stockTxt;

    public SaveFoodController(JFrame app , Food food , AdminView adminView, FoodList list,
    JTextField nameTxt, JTextField priceTxt, JTextField stockTxt) {
    
        this.app = app;
        this.food = food;
        this.adminView = adminView;
        this.list = list;
        this.nameTxt = nameTxt;
        this.priceTxt = priceTxt;
        this.stockTxt = stockTxt;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameTxt.getText();
        double price = Double.parseDouble(priceTxt.getText());
        int stock = Integer.parseInt(stockTxt.getText());

        if(food==null){
            Food curr = new Food(name, price, stock);
            list.addFood(curr);
            JOptionPane.showMessageDialog(app, "food Added!");
        }else{
            food.setName(name);
            food.setPrice(price);
            food.setStock(stock);
            JOptionPane.showMessageDialog(app, "Food Data Updated!");
        }

        app.getContentPane().removeAll();
        app.add(adminView);
        app.validate();
        app.repaint();
    }
    
}
