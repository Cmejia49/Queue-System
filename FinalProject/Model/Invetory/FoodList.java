package Model.Invetory;

import java.util.ArrayList;
import java.util.Observable;

public class FoodList extends Observable {
    private ArrayList<Food> food;

    public FoodList() {
        food = new ArrayList<Food>();
    }
    private void FoodListChanged(){
        setChanged();
        notifyObservers();
    }

    public void addFood(Food f){
        food.add(f);
        FoodListChanged();
    }

    public void removeFood(int index){
        food.remove(index);
        FoodListChanged();
    }

    public int size(){
        return food.size();
        
    }

    public Food get(int i){
        return food.get(i);
    }

    public void bubbleSort(){
        Food temp = null;  
        int n = food.size();
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(food.get(j-1).getPrice() > food.get(j).getPrice()){  
                                 //swap elements  
                                 temp = food.get(j-1); 
                                 food.set(j-1, food.get(j));  
                                 food.set(j,temp);  
                         }  
                          
                 }  
         }  
         FoodListChanged();
    }

    public void insertionSort(){
        int n = food.size();
        for (int i = 1; i < n; ++i) {
            Food key = food.get(i);
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && food.get(j).getStock() > key.getStock()) {
                food.set(j + 1,food.get(j));
                j = j - 1;
            }
            food.set(j + 1, key) ;
        }
        FoodListChanged();
    }
    public void bubbleSortByName(){
        int n = food.size();
  
        // One by one move boundary of unsorted subarray
        Food temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                // to compare one string with other strings
                if (food.get(i).getName().compareTo(food.get(j).getName()) > 0) {
                    // swapping
                    temp = food.get(i);
                    food.set(i,food.get(j));
                    food.set(j,temp);
                }
            }
            
        }
        FoodListChanged();

    }

}   
