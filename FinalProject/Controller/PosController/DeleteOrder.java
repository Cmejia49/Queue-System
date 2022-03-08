package Controller.PosController;

import Model.Customer.OrderList;
import java.awt.event.*;
public class DeleteOrder implements ActionListener{
    
    private OrderList list;
    private int index;
    public DeleteOrder(OrderList list,int index) {
        this.list = list;
        this.index = index;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    
        list.delete(index);
    }
}
