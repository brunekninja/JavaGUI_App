import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Save button class
 */
public class SaveButton extends Dialog implements ActionListener{
    private String name;
    private float price;
    private String type;

    @Override
    public void actionPerformed(ActionEvent e){

        JButton source = (JButton) e.getSource();
        JOptionPane.showMessageDialog(source, source.getText() + " button has been pressed");
    }
}
