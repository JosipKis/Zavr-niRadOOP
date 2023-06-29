package GameCode;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {

    private JButton playAgainBtn;
    private JButton mainMenuBtn;
    private JButton printResultsBtn;
    private JLabel krajIgreTxt;
    private Font fontZaKrajIgreTxt;


    public GameOver(){
        createComponents();
        componentLayout();
    }

    private void createComponents(){
        playAgainBtn = new JButton();
        playAgainBtn.setSize(200, 75);
        mainMenuBtn = new JButton();
        mainMenuBtn.setSize(200, 75);
        printResultsBtn = new JButton();
        printResultsBtn.setSize(200, 75);
        krajIgreTxt =  new JLabel("KRAJ IGRE!");
        fontZaKrajIgreTxt  = new Font("Comic Sans", Font.BOLD, 50);
        krajIgreTxt.setFont(fontZaKrajIgreTxt);
        setVisible(true);
    }

    private void componentLayout(){
        setLayout(new MigLayout());
        add(krajIgreTxt, "wrap");
        add(playAgainBtn, "wrap");
        add(mainMenuBtn, "wrap");
        add(printResultsBtn);
    }
}
