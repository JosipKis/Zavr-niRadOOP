package GameCode;

import javax.swing.*;
import java.awt.*;

public class QuestionAreaForGameArea extends JPanel {

    private JTextArea textArea;

    public QuestionAreaForGameArea() {
        createComponents();
        layoutComponents();
    }

    private void createComponents(){
        textArea = new JTextArea();
        textArea.setEditable(false);
        Dimension dim = this.getPreferredSize();
        dim.height = 325;
        dim.width = 775;
        setPreferredSize(dim);
    }

    private void layoutComponents(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(textArea);
    }
}
