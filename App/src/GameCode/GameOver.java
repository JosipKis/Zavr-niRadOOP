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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Game over class for the game.
 */
public class GameOver extends JPanel {

    /**
     * Attributes for the game over class.
     */
    private JButton playAgainBtn;
    private JButton mainMenuBtn;
    private JButton printResultsBtn;
    private JLabel krajIgreTxt;
    private Font fontZaKrajIgreTxt;
    private JLabel wonMoneyTxt;
    private GameOverListener gol;
    private GameArea gameArea;
    private MainMenu mainMenu;
    private static boolean isPowerUpUsed;

    /**
     * Constructor for the game over class.
     */
    public GameOver(){
        createComponents();
        componentLayout();

    }

    /**
     * Method that creates (initializes) the components for the game over class.
     */
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
        wonMoneyTxt.setFont(new Font("Comic Sans", Font.BOLD, 45));

    }

    /**
     * Method that sets the layout for the game over part of the application.
     */
    private void componentLayout(){
        setLayout(new MigLayout());
        add(krajIgreTxt, "wrap");
        add(wonMoneyTxt, "wrap, center");
        add(playAgainBtn, "wrap, center, height 75, width 250");
        add(mainMenuBtn, "wrap, center, height 75, width 250");
        add(printResultsBtn, "center, height 75, width 250");
    }

    /**
     * Method that takes Interface method as an argument to create
     * a listener for the events in the game over screen.
     * @param gol Interface method.
     */
    public void setGameOverListener(GameOverListener gol){
        this.gol = gol;
    }

    /**
     * Method that activates the buttons in the game over screen.
     * It handles starting a new game, with the same player and theme,
     * going back to the main menu and printing the results.
     */
    public void activateGameOver(){
        if (gol != null) {
            playAgainBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GameArea.setUsed5050(false);
                    GameArea.setUsedChangeQ(false);
                    GameArea.setUsedSkipQ(false);
                    isPowerUpUsed = false;
                    GameOverEvent goe = new GameOverEvent(this);
                    gol.gameOverBtnPressed(goe);
                    gameArea = new GameArea();
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameOver.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(gameArea);
                    frame.repaint();
                    frame.revalidate();
                    gameArea.setGameAreaListener(event -> {

                    });
                    gameArea.activateGameArea();
                }
            });
            mainMenuBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GameArea.setUsed5050(false);
                    GameArea.setUsedChangeQ(false);
                    GameArea.setUsedSkipQ(false);
                    isPowerUpUsed = false;
                    GameOverEvent goe = new GameOverEvent(this);
                    gol.gameOverBtnPressed(goe);
                    mainMenu = new MainMenu();
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameOver.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(mainMenu);
                    frame.repaint();
                    frame.revalidate();
                    mainMenu.setMainMenuListener(event -> {
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

    /**
     * Method that prints the results of the game just played.
     * It prints players name, theme, and the money won.
     * It also prints what power ups were used and the time and date the button was clicked.
     */
    private void printResultOfPreviousGame() {
        String fileName = "rezultat_" + MainMenu.getThisName() + ".txt";
        String filePath = "App/src/PrintedScores/" + fileName;
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.append("\n\n");
            fileWriter.append("Ime igrača: ");
            fileWriter.append(MainMenu.getThisName() + "\n");
            fileWriter.append("Igrana tema: ");
            fileWriter.append(MainMenu.getTheme() +"\n");
            fileWriter.append("Osvojen novac: ");
            fileWriter.append(GameArea.getMoneyWon() + "\n\n");
            if (GameArea.isUsed5050()) {
                fileWriter.append("50 / 50 Power Up je korišten\n");
            }
            if (GameArea.isUsedChangeQ()) {
                fileWriter.append("Promijeni pitanje Power Up je korišten\n");
            }
            if (GameArea.isUsedSkipQ()) {
                fileWriter.append("Preskoči pitanje Power Up je korišten\n");
            }
            if (!isPowerUpUsed) {
                fileWriter.append("Niti jedan Power Up nije korišten za vrijeme ove igre!");
            }
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String formattedDate = dateFormat.format(currentDate);
            fileWriter.append("\n\nDatum i vrijeme: ");
            fileWriter.append(formattedDate);
            fileWriter.append("\n//////////////////////////////////////////////////////////////////////////////");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method that sets the boolean value of isPowerUpUsed.
     * Used to set it to false each time a new game is started.
     * @param isPowerUpUsed
     */
    public static void setIsPowerUpUsed(boolean isPowerUpUsed) {
        GameOver.isPowerUpUsed = isPowerUpUsed;
    }

    /**
     * Method that creates a file in the PrintedScores folder if the player has not used any power ups
     * and has won 1.000.000€. It unlocks the infinite 50 / 50 checkbox in the main menu.
     */
    public static void createInfiniteKey(){
        if (!isPowerUpUsed && GameArea.getMoneyWon().equals("1.000.000€")){
            try{
                String filepath = "App/src/PrintedScores/" + "Infinite 50-50";
                File file = new File(filepath);
                FileWriter fileWriter = new FileWriter(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
