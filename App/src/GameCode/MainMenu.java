package GameCode;

import org.jdesktop.xswingx.PromptSupport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    private JButton startButton;
    private JComboBox<String> comboBox;
    private String[] gameThemes = {"Sport", "Video Igre"};
    private JTextField nameField;
    private MainMenuListener mainMenuListener;

    public MainMenu() {
        super("Tko želi biti milijunaš!");
        setSize(800, 600);
        setIconImage(new ImageIcon("App/src/Images/WWTBAMUS2020Logo.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
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

    public void activateMainMenu(){
        if (mainMenuListener != null){
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Game Started...");
                    String name = nameField.getText();
                    String theme = (String) comboBox.getSelectedItem();
                    MainMenuEvent mme = new MainMenuEvent(this, theme, name);
                    mainMenuListener.startGame(mme);
                }
            });
        }
    }
}
