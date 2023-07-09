package GameCode;

import EventHandling.MainMenuEvent;
import EventHandling.MainMenuListener;
import org.jdesktop.xswingx.PromptSupport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Main menu class for the game.
 */
public class MainMenu extends JPanel {

    /**
     * Attributes for the main menu.
     */
    private JButton startButton;
    private JComboBox<String> comboBox;
    private String[] gameThemes = {"Sport", "Video Igre"};
    private JTextField nameField;
    private MainMenuListener mainMenuListener;
    private static String theme;
    private static String name;
    private GameArea gameArea;
    private static JCheckBox infinite5050;

    /**
     * Constructor for the main menu.
     */
    public MainMenu() {
        createComponents();
        componentLayout();
    }

    /**
     * Method that creates the components for the main menu.
     * It also calls 'checkIfFileExists' method.
     */
    private void createComponents() {
        startButton = new JButton("Nova Igra");
        comboBox = new JComboBox<>(gameThemes);
        comboBox.setSelectedIndex(-1);
        nameField = new JTextField();
        infinite5050 = new JCheckBox("Neograničen 50 / 50");
        infinite5050.setEnabled(false);
        infinite5050.setToolTipText("Osvoji Milijun bez pomoći!");
        checkIfFileExists();
    }

    /**
     * Method that sets the layout for the Main Menu part of the application.
     */
    private void componentLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;

        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 20, 0);

        PromptSupport.setPrompt("Unesite svoje ime!", nameField);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, nameField);
        PromptSupport.setBackground(Color.WHITE, nameField);
        nameField.setPreferredSize(new Dimension(300, 75));
        nameField.setFont(new Font("Comic Sans", Font.BOLD, 20));
        add(nameField, gbc);

        gbc.gridy++;
        add(new JLabel("\n"), gbc);

        gbc.gridy++;
        startButton.setPreferredSize(new Dimension(300, 75));
        startButton.setFont(new Font("Comic Sans", Font.BOLD, 40));
        add(startButton, gbc);

        gbc.gridy++;
        comboBox.setToolTipText("Odaberite temu igre!");
        comboBox.setPreferredSize(new Dimension(300, 75));
        comboBox.setFont(new Font("Comic Sans", Font.BOLD, 40));
        add(comboBox, gbc);

        gbc.gridy++;
        add(infinite5050, gbc);
    }

    /**
     * Method that takes Interface method as an argument to create
     * a listener for the event in the Main Menu.
     * @param mnl Interface method.
     */
    public void setMainMenuListener(MainMenuListener mnl){
        this.mainMenuListener = mnl;
    }

    /**
     * Method that activates the Main Menu.
     * It deals with button presses and selections made in the Main Menu.
     */
    public void activateMainMenu(){
        if (mainMenuListener != null){
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    name = nameField.getText();
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Molimo unesite svoje ime!", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    theme = (String) comboBox.getSelectedItem();
                    if (theme == null) {
                        JOptionPane.showMessageDialog(null, "Molimo odaberite temu igre!", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    MainMenuEvent mme = new MainMenuEvent(this, theme, name);
                    mainMenuListener.startGameEventOccured(mme);

                    gameArea = new GameArea();
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MainMenu.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(gameArea);
                    frame.repaint();
                    frame.revalidate();
                    gameArea.setGameAreaListener(event -> {

                    });
                    gameArea.activateGameArea();
                }
            });
        }
    }

    /**
     * Method that returns the theme of the game.
     * @return
     */
    public static String getTheme() {
        return theme;
    }

    /**
     * Method that returns the name of the player.
     * @return
     */
    public static String getThisName(){
        return name;
    }

    /**
     * Method that checks if the file exists.
     * If it does, it enables the checkbox for infinite 50/50 Power up.
     */
    public static void checkIfFileExists() {
        String filePath = "App/src/PrintedScores/Infinite 50-50";
        File file = new File(filePath);
        if (file.exists()){
            infinite5050.setEnabled(true);
            infinite5050.setToolTipText("Čestitam!");
        }
    }

    /**
     * Method that returns the checkbox selection boolean value for infinite 50/50 Power up.
     * @return
     */
    public static JCheckBox getInfinite5050() {
        return infinite5050;
    }
}
