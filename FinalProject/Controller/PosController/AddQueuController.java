package Controller.PosController;
import java.awt.event.*;
import java.util.Iterator;

import Model.Customer.Customer;
import Model.Customer.CustomerQueu;
import Model.Customer.Order;
import Model.Customer.OrderList;
import Model.SaleHistory.Sale;
import Model.SaleHistory.SaleStack;
public class AddQueuController implements ActionListener {

    private CustomerQueu queue;
    private OrderList orderList;
    private SaleStack stack;
    public AddQueuController(CustomerQueu queue, OrderList orderList,SaleStack stack) {
        this.queue = queue;
        this.orderList = orderList;
        this.stack = stack;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Customer customer = new Customer();
        
        int orderSize = orderList.size();
        for(int i = 0; i<orderSize;i++){
            Order order = orderList.get(i);
            Sale sale = new Sale(order);
            stack.pushSale(sale);
        }
        queue.addQueu(customer);
        orderList.clear();
    }
    
}
