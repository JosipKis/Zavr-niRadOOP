package GameCode;

import javax.swing.*;

/**
 * Main class for the game.
 */
public class Main {

    /**
     * Main method that starts the gui and the game.
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
