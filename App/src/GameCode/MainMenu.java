package GameCode;

import EventHandling.MainMenuEvent;
import EventHandling.MainMenuListener;
import org.jdesktop.xswingx.PromptSupport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {

    private JButton startButton;
    private JComboBox<String> comboBox;
    private String[] gameThemes = {"Sport", "Video Igre"};
    private JTextField nameField;
    private MainMenuListener mainMenuListener;
    private static String theme;
    private GameArea gameArea;

    public MainMenu() {
        createComponents();
        componentLayout();
    }

    private void createComponents() {
        startButton = new JButton("Nova Igra");
        comboBox = new JComboBox<>(gameThemes);
        comboBox.setSelectedIndex(-1);
        nameField = new JTextField();
    }

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
    }

    public void setMainMenuListener(MainMenuListener mnl){
        this.mainMenuListener = mnl;
    }

    public void activateMainMenu(){
        if (mainMenuListener != null){
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
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
                        String answer = event.getAnswer();
                        System.out.println("Selected answer: "+ answer);
                    });
                    gameArea.activateGameArea();
                }
            });
        }
    }

    public static String getTheme() {
        return theme;
    }
}
