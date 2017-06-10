import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cancel button class actions
 */
public class CancelButton implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        JButton source = (JButton) e.getSource();
        JOptionPane.showMessageDialog(source, source.getText() + " button has been pressed");
    }
}
