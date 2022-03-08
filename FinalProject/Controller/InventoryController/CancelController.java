package Controller.InventoryController;

import java.awt.event.*;

import javax.swing.JFrame;

import View.AdminView;
public class CancelController implements ActionListener {

    private JFrame app;
    private AdminView adminView;
    public CancelController(AdminView adminView, JFrame app) {
        this.app = app;
        this.adminView = adminView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        app.getContentPane().removeAll();
        app.add(adminView);
        app.validate();
        app.repaint();
        
    }
    
}
