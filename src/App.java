import javax.swing.*;

/**
 * Main app class
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame dialog = new dialog("Application");

                dialog.setSize(500, 400);
                dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dialog.setVisible(true);
            }
        });
    }
}
