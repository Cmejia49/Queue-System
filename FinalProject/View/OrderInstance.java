package View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import Model.Customer.Order;
import java.awt.*;
public class OrderInstance extends JPanel implements Observer {

    private Order order;
    private JButton deleteBtn;
    private JLabel nameLbl, priceLbl, quantityLbl, subTotalLbl;
    public OrderInstance(Order order, ActionListener deleteAction) {
        this.order = order;
        deleteBtn = new JButton("Delete");
        nameLbl = new JLabel(String.valueOf(order.getName()),JLabel.CENTER);
        priceLbl = new JLabel(String.valueOf(order.getPrice()),JLabel.CENTER);
        quantityLbl = new JLabel(String.valueOf(order.getQuantity()),JLabel.CENTER);
        subTotalLbl = new JLabel(String.valueOf(order.getSubtotal()),JLabel.CENTER);
        deleteBtn.addActionListener(deleteAction);
        setLayout(new GridLayout(1, 5));
        add(nameLbl);
        add(priceLbl);
        add(quantityLbl);
        add(subTotalLbl);
        add(deleteBtn);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        nameLbl.setText(order.getName());
        priceLbl.setText("$"+order.getPrice());
        quantityLbl.setText(""+order.getQuantity());
        subTotalLbl.setText(""+order.getSubtotal());
        
    }
    
}
