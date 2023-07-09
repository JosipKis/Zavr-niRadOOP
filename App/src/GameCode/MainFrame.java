package GameCode;

import javax.swing.*;
import java.awt.*;

/**
 * Main class used for determining the look of the application.
 */
public class MainFrame extends JFrame {

    /**
     * ManiFrames attributes.
     */
    private MainMenu mainMenu;

    /**
     * Constructor for the MainFrame class.
     */
    public MainFrame() {
        super("Tko želi biti milijunaš!");
        setSize(800, 600);
        setIconImage(new ImageIcon("App/src/Images/WWTBAMUS2020Logo.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        createComponents();
        componentLayout();
        activateApp();
    }

    /**
     * Method used for creating the components of the MainFrame.
     */
    private void createComponents() {
        mainMenu = new MainMenu();
    }

    /**
     * Method used for setting the layout of the MainFrame.
     */
    private void componentLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(mainMenu, gbc);


    }
    /**
     * Method used for activating the Main Menu of the application.
     */
    private void activateApp(){
        mainMenu.setMainMenuListener(event -> {
            JOptionPane.showMessageDialog(null, event.toString(), "Sretno", JOptionPane.INFORMATION_MESSAGE);
        });
        mainMenu.activateMainMenu();
    }
}
