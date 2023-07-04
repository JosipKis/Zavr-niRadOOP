package GameCode;

import EventHandling.GameOverEvent;
import EventHandling.GameOverListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JPanel {

    private JButton playAgainBtn;
    private JButton mainMenuBtn;
    private JButton printResultsBtn;
    private JLabel krajIgreTxt;
    private Font fontZaKrajIgreTxt;
    private JLabel wonMoneyTxt;
    private GameOverListener gol;
    private GameArea gameArea;


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
        wonMoneyTxt = new JLabel(GameArea.getMoneyWon());
        System.out.println(GameArea.getMoneyWon()); // delete this, just for testing
        wonMoneyTxt.setFont(new Font("Comic Sans", Font.BOLD, 45));
    }

    private void componentLayout(){
        setLayout(new MigLayout());
        add(krajIgreTxt, "wrap");
        add(wonMoneyTxt, "wrap, center");
        add(playAgainBtn, "wrap, center, height 75, width 250");
        add(mainMenuBtn, "wrap, center, height 75, width 250");
        add(printResultsBtn, "center, height 75, width 250");
    }

    public void setGameOverListener(GameOverListener gol){
        this.gol = gol;
    }

    public void activateGameOver(){
        System.out.println("Before click"); // delete this, just for testing
        if (gol != null){
            System.out.println("After click"); // delete this, just for testing
            playAgainBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Pp"); // delete this, just for testing
                    GameOverEvent goe = new GameOverEvent(this);
                    gol.gameOverBtnPressed(goe);
                    gameArea = new GameArea();
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameOver.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(gameArea);
                    frame.repaint();
                    frame.revalidate();
                    System.out.println("New game area should appear"); // delete this, just for testing
                    gameArea.setGameAreaListener(event -> {

                    });
                    gameArea.activateGameArea();
                }
            });
        }else {
            System.out.println("Goll is null");
        }

    }
}
