package View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Controller.PosController.AddOrder;
import Model.Customer.OrderList;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class InputKeypadView extends JPanel implements ActionListener{

    private JFrame app;
    private String name;
    private double price;
    private OrderList orderList;
    private JButton keypadBtn;
    private JLabel quantityLbl;
    private String quantity = "";
    private MainMenu main;
    public InputKeypadView(MainMenu main , JFrame app, String name, double price,
    OrderList orderlist) {
        this.main = main;
        this.app = app;
        this.name = name;
        this.price = price;
        this.orderList = orderlist;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border margin = new EmptyBorder(10,10,10,10);
 
        quantityLbl = new JLabel("Enter Quantity",SwingConstants.CENTER);
        quantityLbl.setBorder(new CompoundBorder(border, margin));
        JLabel label;
        quantityLbl.setFont(new Font("Verdana", Font.PLAIN, 32));
        JPanel keypadPnl = new JPanel(new GridLayout(4,3,2,2));
        for(int i = 9; i>=0;i--){
            this.keypadBtn = new JButton(""+i);
            keypadBtn.addActionListener(this);
            keypadPnl.add(keypadBtn);
        }
        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(new AddOrder(main,app, orderlist, name, quantityLbl, price));
        keypadPnl.add(saveBtn);
        setLayout(new BorderLayout());
        add(quantityLbl,BorderLayout.PAGE_START);
         add(keypadPnl,"Center");
        

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
            if(quantityLbl.getText().equals("Enter Quantity") && str.equals("0")){
                System.out.println("tt");
                return;
            }else{
                quantity += str;
            }
        

        quantityLbl.setText(quantity);
        
    }

    
}
