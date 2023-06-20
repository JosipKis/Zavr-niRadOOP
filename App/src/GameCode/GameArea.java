package GameCode;

import javax.swing.*;
import java.awt.*;

public class GameArea extends JPanel {

    private PowerUpsForGameArea powerUpsForGameArea;
    private QuestionAreaForGameArea questionAreaForGameArea;
    private AnsweringButtonsForGameArea answeringButtonsForGameArea;

    public GameArea() {
        createComponents();
        layoutComponents();
    }

    private void createComponents() {
        powerUpsForGameArea = new PowerUpsForGameArea();
        questionAreaForGameArea = new QuestionAreaForGameArea();
        answeringButtonsForGameArea = new AnsweringButtonsForGameArea();
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        add(powerUpsForGameArea, BorderLayout.NORTH);

        add(questionAreaForGameArea, BorderLayout.CENTER);

        add(answeringButtonsForGameArea, BorderLayout.SOUTH);
    }
}
