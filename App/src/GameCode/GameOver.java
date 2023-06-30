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
        playAgainBtn = new JButton("Igraj Opet");
        playAgainBtn.setFont(new Font("Helvetica", Font.BOLD, 25));
        mainMenuBtn = new JButton("Glavni Izbronik");
        mainMenuBtn.setFont(new Font("Helvetica", Font.BOLD, 25));
        printResultsBtn = new JButton("Printaj Rezultat");
        printResultsBtn.setFont(new Font("Helvetica", Font.BOLD, 25));
        krajIgreTxt =  new JLabel("KRAJ IGRE!");
        fontZaKrajIgreTxt  = new Font("Comic Sans", Font.BOLD, 75);
        krajIgreTxt.setFont(fontZaKrajIgreTxt);
        setVisible(true);
    }

    private void componentLayout(){
        setLayout(new MigLayout());
        add(krajIgreTxt, "wrap");
        add(playAgainBtn, "wrap, center, height 75, width 250");
        add(mainMenuBtn, "wrap, center, height 75, width 250");
        add(printResultsBtn, "center, height 75, width 250");
    }
}
