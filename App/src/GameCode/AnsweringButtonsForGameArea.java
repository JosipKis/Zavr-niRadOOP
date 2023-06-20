package GameCode;

import javax.swing.*;
import java.awt.*;

public class AnsweringButtonsForGameArea extends JPanel {

    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;

    public AnsweringButtonsForGameArea() {
        createComponents();
        layoutComponents();
    }

    private void createComponents() {
        buttonA = new JButton("A");
        buttonA.setPreferredSize(new Dimension(225, 75));
        buttonB = new JButton("B");
        buttonB.setPreferredSize(new Dimension(225, 75));
        buttonC = new JButton("C");
        buttonC.setPreferredSize(new Dimension(225, 75));
        buttonD = new JButton("D");
        buttonD.setPreferredSize(new Dimension(225, 75));
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;

        gbc.insets = new Insets(5, 5, 5, 5);
        add(buttonA, gbc);

        gbc.gridx++;
        add(buttonB, gbc);

        gbc.gridx--;
        gbc.gridy++;
        add(buttonC, gbc);

        gbc.gridx++;
        add(buttonD, gbc);
    }

}
