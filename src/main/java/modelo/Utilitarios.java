package modelo;

import java.awt.*;
import javax.swing.*;

public class Utilitarios {
    
    public void LimparTela(JPanel container){
        Component components[] = container.getComponents();
        
        for (Component component : components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
}
