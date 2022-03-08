package Controller.AuthorizationController;

import java.awt.event.*;

import javax.swing.JFrame;

import View.MainMenu;
public class LogoutController implements ActionListener {

    private MainMenu main;
    private JFrame app;
    public LogoutController(MainMenu main, JFrame app) {
        this.main = main;
        this.app = app;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        app.getContentPane().removeAll();
        app.add(main);
        app.setSize(1200, 500);
        app.validate();
        app.repaint();
        
    }
    
}
