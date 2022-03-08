package Controller.InventoryController;

import java.awt.event.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Model.Invetory.Food;
import Model.Invetory.FoodList;

public class SortController implements ActionListener {
    private JFrame app;
    private FoodList list;
    private JComboBox<String> sortCmb;
    public SortController(JFrame app, FoodList list,
    JComboBox<String> sortCmb) {

        this.app=app;
        this.list = list;
        this.sortCmb =sortCmb;
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String program = sortCmb.getItemAt(sortCmb.getSelectedIndex());
        System.out.println(program);
        if(program.equals("SortByName")){
            list.bubbleSortByName();
        }else if(program.equals("SortByPrice")){
            list.bubbleSort();
        }else if(program.equals("SortByStock")){
            list.insertionSort();
        }
               
    }
}
