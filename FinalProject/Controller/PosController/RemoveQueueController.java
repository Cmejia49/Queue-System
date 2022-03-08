package Controller.PosController;

import java.awt.event.*;

import Model.Customer.CustomerQueu;
public class RemoveQueueController implements ActionListener {

        private CustomerQueu queu;
        public RemoveQueueController(CustomerQueu queu) {
            this.queu = queu;
        }
    @Override
    public void actionPerformed(ActionEvent e) {
      
        queu.remove();
        
    }
    
}
