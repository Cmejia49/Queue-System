package Model.SaleHistory;

import java.util.Observable;
import java.util.Stack;

import Model.Customer.OrderList;

public class SaleStack extends Observable  {
    private Stack<Sale> stack;
    public SaleStack() {
        this.stack = new Stack<Sale>();
    }
    private void SaleStackChanged(){
        setChanged();
        notifyObservers();
    }


    public void pushSale(Sale sale){
        stack.add(sale);
        SaleStackChanged();
    }

    public void popSale(){
       stack.pop();
       SaleStackChanged();
    }

    public int size(){
        return stack.size();
    }

    public Stack<Sale> getStack(){

        return stack;
    }
 
}
