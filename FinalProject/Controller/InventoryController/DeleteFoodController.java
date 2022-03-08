package Controller.InventoryController;

import java.awt.event.*;

import Model.Invetory.FoodList;
public class DeleteFoodController implements ActionListener {

    private FoodList list;
    private int index;
    public DeleteFoodController(FoodList list, int index) {
        this.list = list;
        this.index = index;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        list.removeFood(index);
        
    }
    

}
