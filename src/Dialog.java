import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Main dialog class extended from JFrame
 * implements all action listeners for use in GUI
 */
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

    private LinkedList data;

    /**
     * Dialog Constructor
     * @throws HeadlessException
     */
    public Dialog() throws HeadlessException {
    }

    /**
     * Main dialog method, setup
     * @param title
     */
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

        DbConn listType = new DbConn();

        listType.runConn();

        // add element from database to list, all other stuff is defined in form XML
        data = listType.data("SELECT * FROM type;", "name");

        // add data to exsiting model of list
        DefaultListModel model = (DefaultListModel) type.getModel();

        // adding data to JList for click actions and searching of data
        for (int x = 0; x < data.size(); x++){
            model.addElement(data.get(x));
        }

    }

    /**
     * event fired on click actions of buttons etc.
     * @param e
     * event
     */
    public void actionPerformed(ActionEvent e){

        System.out.println("Click " + price.getText());

    }
}

/**
 * getter and setter for values
 */
class Values {
    private String nameValue;

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public String getNameValue() {
        return this.nameValue;
    }
}



