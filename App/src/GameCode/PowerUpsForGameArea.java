package GameCode;

import javax.swing.*;
import java.awt.*;

public class PowerUpsForGameArea extends JPanel {

    private JButton btn5050PowerUp;
    private JButton btnChangeQuestionPowerUp;
    private JButton btnSkipQuestionPowerUp;
    private JButton endGameButton;

    public PowerUpsForGameArea(){
        createComponents();
        componentLayout();
    }

    private void createComponents(){
        Dimension dim =this.getPreferredSize();
        dim.height = 50;
        dim.width = 775;
        setPreferredSize(dim);
        btn5050PowerUp = new JButton("50/50");
        btnChangeQuestionPowerUp = new JButton("Promjeni pitanje");
        btnSkipQuestionPowerUp = new JButton("Preskoči pitanje");
        endGameButton = new JButton("Prekini igru");
    }

    private void componentLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Add spacing between components

        add(endGameButton, gbc);

        gbc.gridx++; // Move to the next column
        add(Box.createHorizontalStrut(250), gbc); // Spacer between buttons

        gbc.gridx++; // Move to the next column
        add(btn5050PowerUp, gbc);

        gbc.gridx++; // Move to the next column
        add(btnChangeQuestionPowerUp, gbc);

        gbc.gridx++; // Move to the next column
        add(btnSkipQuestionPowerUp, gbc);
    }

}
