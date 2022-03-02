package Controller;

import Model.Invetory.Food;
import Model.Invetory.FoodList;

public class InventoryController {
    private FoodList list;
    public InventoryController(FoodList list) {

        this.list = list;

    }

    public void addFood(Food food){
        list.addFood(food);
    }

    
    public String print(){
        return list.print();
    }

}
