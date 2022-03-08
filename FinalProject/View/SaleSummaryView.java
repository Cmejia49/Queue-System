package View;
import Model.SaleHistory.Sale;
import Model.SaleHistory.SaleStack;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.*;
import java.awt.event.*;

import Model.Invetory.Food;
import Model.Invetory.FoodList;
public class SaleSummaryView extends JPanel implements Observer {
    private SaleStack stack;
    private JFrame app;
    private AdminView adminView;
    private JPanel tblSale,southPnl;
    private JLabel totalValue;
    public SaleSummaryView(SaleStack stack, JFrame app,AdminView adminView) {
        this.stack = stack;
        this.app = app;
        this.adminView = adminView;
        JPanel headerPnl = new JPanel(new GridLayout(1,5));
        JLabel nameLbl = new JLabel("Name" ,JLabel.CENTER);
        JLabel priceLbl = new JLabel("Price" ,JLabel.CENTER);
        JLabel quantityLbl = new JLabel("Quantity" ,JLabel.CENTER);
        JLabel subTotalLbl = new JLabel("Subtotal" ,JLabel.CENTER);
        headerPnl.add(nameLbl);
        headerPnl.add(priceLbl);
        headerPnl.add(quantityLbl);
        headerPnl.add(subTotalLbl);

        tblSale = new JPanel();
         southPnl = new JPanel(new GridLayout(1,3));
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                app.getContentPane().removeAll();
                app.add(adminView);
                app.validate();
                app.repaint();
            }
        });
        JLabel totalLbl = new JLabel("Total:");
        totalValue = new JLabel("");
        southPnl.add(closeBtn);
        southPnl.add(totalLbl);
        southPnl.add(totalValue);
        JScrollPane scrollableTextArea = new JScrollPane(tblSale);  
        setLayout(new BorderLayout());
        add(headerPnl,"North");
        add(scrollableTextArea,"Center");
        add(southPnl,"South");
    }
    @Override
    public void update(Observable o, Object arg) {
        tblSale.removeAll();
        southPnl.remove(totalValue);
        tblSale.setLayout(new GridLayout(stack.size(),3));
        double total = 0;
        Stack<Sale> sale = stack.getStack();
        for (Sale item : sale) {
            total += item.getSubtotal();
            SaleInstance curr = new SaleInstance(item);
            stack.addObserver(curr);
            tblSale.add(curr);
        }
        totalValue = new JLabel(total + "");
        southPnl.add(totalValue);
        southPnl.validate();
        southPnl.repaint();

        tblSale.validate();
        tblSale.repaint();
        
    }
}