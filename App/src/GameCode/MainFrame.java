package GameCode;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainMenu mainMenu;
    private GameArea gameArea;

    public MainFrame() {
        super("Tko želi biti milijunaš!");
        setSize(800, 600);
        setIconImage(new ImageIcon("App/src/Images/WWTBAMUS2020Logo.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        createComponents();
        componentLayout();
        activateApp();
    }

    private void createComponents() {
        mainMenu = new MainMenu();
        gameArea = new GameArea();
    }

    private void componentLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(mainMenu, gbc);


    }

    private void activateApp(){
        mainMenu.setMainMenuListener(event -> {
            String name = event.getName();
            String theme = event.getTheme();
            System.out.println(name + " " + theme);
            JOptionPane.showMessageDialog(null, "Sretno " + name + "!", "Sretno", JOptionPane.INFORMATION_MESSAGE);
        });
        mainMenu.activateMainMenu();
    }
}
