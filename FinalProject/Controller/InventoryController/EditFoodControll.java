package Controller.InventoryController;


import java.awt.event.*;

import javax.swing.JFrame;

import Model.Invetory.Food;
import Model.Invetory.FoodList;
import View.AdminView;
import View.FoodDetailView;

public class EditFoodControll implements ActionListener {
    
    private Food food;
    private FoodList list;
    private AdminView adminView;
    private JFrame app;
    public EditFoodControll(Food food, FoodList list, AdminView adminView,JFrame app ) {
        this.app = app;
        this.food = food;
        this.list = list;
        this.adminView = adminView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        app.getContentPane().removeAll();
        FoodDetailView detail = new FoodDetailView(app, food, list, adminView);
        app.add(detail);
        app.validate();
        app.repaint();
        
    }
}
