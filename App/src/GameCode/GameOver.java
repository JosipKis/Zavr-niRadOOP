package GameCode;

import EventHandling.GameOverEvent;
import EventHandling.GameOverListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameOver extends JPanel {

    private JButton playAgainBtn;
    private JButton mainMenuBtn;
    private JButton printResultsBtn;
    private JLabel krajIgreTxt;
    private Font fontZaKrajIgreTxt;
    private JLabel wonMoneyTxt;
    private GameOverListener gol;
    private GameArea gameArea;
    private MainMenu mainMenu;


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
        if (gol != null) {
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
            mainMenuBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("MainMenu"); // delete this, just for testing
                    GameOverEvent goe = new GameOverEvent(this);
                    gol.gameOverBtnPressed(goe);
                    mainMenu = new MainMenu();
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameOver.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(mainMenu);
                    frame.repaint();
                    frame.revalidate();
                    System.out.println("New main menu should appear"); // delete this, just for testing
                    mainMenu.setMainMenuListener(event -> {
                        String name = event.getName();
                        String theme = event.getTheme();
                        System.out.println(name + " " + theme);
                        JOptionPane.showMessageDialog(null, event.toString(), "Sretno", JOptionPane.INFORMATION_MESSAGE);
                    });
                    mainMenu.activateMainMenu();
                }
            });
            printResultsBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printResultOfPreviousGame();
                }
            });
        }
    }

    private void printResultOfPreviousGame(){
        String fileName = "rezultat.txt";
        String filePath = "App/src/PrintedScores/" + fileName;
        File file = new File(filePath);
        if (file.exists()) {
            int count = 1;
            String baseName;
            String extension = "";

            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex != -1) {
                baseName = fileName.substring(0, dotIndex);
                extension = fileName.substring(dotIndex);
            } else {
                baseName = fileName;
            }

            do {
                fileName = baseName + "_" + count + extension;
                filePath = "App/src/PrintedScores/"+ fileName;
                file = new File(filePath);
                count++;
            } while (file.exists());
        }
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.append(GameArea.getMoneyWon());
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
