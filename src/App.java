import javax.swing.*;

/**
 * Main app class
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame Dialog = new Dialog("Application");

                Dialog.setSize(500, 400);
                Dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dialog.setVisible(true);
            }
        });
    }
}
