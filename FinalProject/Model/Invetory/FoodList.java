package Model.Invetory;

import java.util.ArrayList;

public class FoodList {
    private ArrayList<Food> food;

    public FoodList() {
        food = new ArrayList<Food>();
    }

    public void addFood(Food f){
        food.add(f);
    }

    public int size(){
        return food.size();
    }

    public Food get(int i){
        return food.get(i);
    }

    public String print(){
        String result = "";
        for (Food food2 : food) {
            result += food2.toString() + ", ";
        }

        return "Available Food " + result ;
    }
}   
