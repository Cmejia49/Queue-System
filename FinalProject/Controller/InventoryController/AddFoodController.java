package Controller.InventoryController;
import java.awt.event.*;

import javax.swing.JFrame;

import Model.Invetory.FoodList;
import View.AdminView;
import View.FoodDetailView;
public class AddFoodController implements ActionListener{
   
    private JFrame app;
    private FoodList list;
    private AdminView adminView;
    public AddFoodController(JFrame app, FoodList list, AdminView adminView ) {
        this.app = app;
        this.list = list;
        this.adminView = adminView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        app.getContentPane().removeAll();
        FoodDetailView detailView = new FoodDetailView(app,null,list,adminView);
        app.add(detailView);
        app.validate();
        app.repaint();
    }
}
