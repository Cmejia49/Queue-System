package View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;


import Model.Invetory.Food;

public class FoodInstance extends JPanel implements Observer{

    private Food food;
    private JLabel nameLbl,priceLbl,stockLbl;

    public FoodInstance(Food food, ActionListener editAction,
     ActionListener deleteAction) {
        
       this.food = food;
       JButton deleteBtn = new JButton("Delete");
       deleteBtn.addActionListener(deleteAction);
  
       JButton editBtn = new JButton("Edit");
       editBtn.addActionListener(editAction);
       JPanel buttonPnl = new JPanel(new GridLayout(2,1));
       buttonPnl.add(deleteBtn);
       buttonPnl.add(editBtn);
       nameLbl = new JLabel(String.valueOf(food.getName()),JLabel.CENTER);
        priceLbl = new JLabel(String.valueOf(food.getPrice()),JLabel.CENTER);
        stockLbl = new JLabel(String.valueOf(food.getStock()),JLabel.CENTER);
       setLayout(new GridLayout(1,4));
       add(nameLbl);
       add(priceLbl);
       add(stockLbl);
       add(buttonPnl);

    }

    @Override
    public void update(Observable o, Object arg) {
        nameLbl.setText(String.valueOf(food.getName()));
        priceLbl.setText(String.valueOf(food.getPrice()));
        stockLbl.setText(String.valueOf(food.getStock()));

        
    }

}
