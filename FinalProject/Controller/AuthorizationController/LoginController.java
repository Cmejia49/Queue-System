package Controller.AuthorizationController;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Invetory.Drink;
import Model.Invetory.Food;
import Model.Invetory.FoodList;
import Model.SaleHistory.SaleStack;
import View.AdminView;
import View.MainMenu;
public class LoginController implements ActionListener {

    private FoodList list;
    private SaleStack stack;
    private MainMenu main;
    private JFrame app;
    private JTextField userTxt,passTxt;
    public LoginController(MainMenu main ,JFrame app, FoodList list, SaleStack stack, JTextField userTxt, JTextField passTxt) {
        this.app = app;
        this.main = main;
        this.userTxt = userTxt;
        this.passTxt = passTxt;
        this.list = list;
        this.stack = stack;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
   
        if(userTxt.getText().equals("user") && passTxt.getText().equals("pass")){
            app.getContentPane().removeAll();
            AdminView admin = new AdminView(main,list, stack, app);
            list.addObserver(admin);
            list.addFood(new Food("Chicken", 10.00, 2));
            list.removeFood(list.size()-1);
            app.add(admin);
            app.validate();
            app.repaint();
        }else{
            JOptionPane.showMessageDialog(app, "Failed Login!");
        }
        
    }
    
}
