package Controller.PosController;

import java.awt.event.*;

import javax.swing.JFrame;

import Model.Customer.OrderList;
import Model.Invetory.FoodList;
import View.InputKeypadView;
import View.MainMenu;
public class FoodBtnAction implements ActionListener{

    private JFrame app;
    private OrderList orderList;
    private FoodList list;
    private MainMenu main;
    public FoodBtnAction(MainMenu main,JFrame app,OrderList orderList, FoodList list ) {
        this.app = app;
        this.orderList = orderList;
        this.list = list;
        this.main = main;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
        String[] c = str.split(" ",2);
        System.out.println(c[0]);
        int index = Integer.parseInt(c[0]);
        System.out.println(index);
        double price = list.get(index).getPrice();
        
        app.getContentPane().removeAll();
        System.out.println("here");
        InputKeypadView keypad = new InputKeypadView(main,app, c[1], price,orderList);
        app.add(keypad);
        app.setSize(450, 450);
        app.validate();
        app.repaint();
        
    }
    
}
