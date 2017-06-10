import paneActions.CancelButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class dialog extends JFrame{
    private JPanel panel;
    private JTabbedPane tabs;
    private JList type;
    private JTable detailedlist;
    private JTextField inputName;
    private JComboBox comboType;
    private JTextField price;
    private JButton saveButton;
    private JButton cancelButton;

    public dialog(String title){
        super(title);
        Container cont = getContentPane();

        cont.add(panel);

        ActionListener cancelButtonListener = new CancelButton();
        cancelButton.addActionListener(cancelButtonListener);
    }

}



