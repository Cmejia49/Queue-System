package View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import Model.SaleHistory.Sale;

public class SaleInstance extends JPanel implements Observer {
    
    private Sale sale;
    private JLabel nameLbl, priceLbl, quantityLbl, subTotalLbl;
    public SaleInstance(Sale sale) {
        this.sale = sale;
        nameLbl = new JLabel(String.valueOf(sale.getName()),JLabel.CENTER);
        priceLbl = new JLabel(String.valueOf(sale.getPrice()),JLabel.CENTER);
        quantityLbl = new JLabel(String.valueOf(sale.getQuantity()),JLabel.CENTER);
        subTotalLbl = new JLabel(String.valueOf(sale.getSubtotal()),JLabel.CENTER);
        setLayout(new GridLayout(1, 4));
        add(nameLbl);
        add(priceLbl);
        add(quantityLbl);
        add(subTotalLbl);
    }

    @Override
    public void update(Observable o, Object arg) {
        nameLbl.setText(sale.getName());
        priceLbl.setText("$"+sale.getPrice());
        quantityLbl.setText(""+sale.getQuantity());
        subTotalLbl.setText(""+sale.getSubtotal());

        
    }
    
}
