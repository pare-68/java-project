
package controls;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
public class JPasswordBox extends JPasswordField {
    
    public JPasswordBox(int size){
    
        super(size);
        setOpaque(false);
        //setContentAreaFilled(false);
    
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g);
    
    }
    @Override
    protected void paintBorder(Graphics g){
    
        g.setColor(Color.blue);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }
}