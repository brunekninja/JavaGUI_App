import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog extends JFrame implements ActionListener{
    private JPanel panel;
    private JTabbedPane tabs;
    private JList type;
    private JTable detailedlist;
    private JTextField inputName;
    private JComboBox comboType;
    private JTextField price;
    private JButton saveButton;
    private JButton cancelButton;

    public Dialog() throws HeadlessException {
    }

    public Dialog(String title){
        super(title);

        Container cont = getContentPane();

        cont.add(panel);

        // action listeners implementation
        ActionListener cancelButtonListener = new CancelButton();

        // call action listeners and pass them to classes
        cancelButton.addActionListener(cancelButtonListener);

        inputName.addActionListener(this);
        saveButton.addActionListener(this);
        price.addActionListener(this);
        comboType.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){

        System.out.println("Click " + price.getText());

    }
}

class Values {
    private String nameValue;

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public String getNameValue() {
        return this.nameValue;
    }
}



