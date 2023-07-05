package GameCode;

import EventHandling.GameAreaEvent;
import EventHandling.GameAreaListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameArea extends JPanel {

    private JButton answerA;
    private JButton answerB;
    private JButton answerC;
    private JButton answerD;
    private JButton exitGame;
    private JButton fiftyFifty;
    private JButton skipQuestion;
    private JButton changeQuestion;
    private JTextArea questionArea;
    private JTextArea moneyCounter;
    private JTextArea questionCounter;
    private static Questions questions;
    private GameAreaListener gal;
    private GameOver gameOver;
    private static String moneyWon;
    private static boolean ifChangeQuestionUsed;
    private static String guaranteedMoney;
    private JTextArea guaranteedMoneyCntr;

    public GameArea(){
        guaranteedMoney = "0€";
        moneyWon = "0€";
        createComponents();
        componentLayout();
    }

    private void createComponents(){
        questions = new Questions();
        questions.rndQuestionSelector();
        answerA = new JButton(questions.getAnswA());
        answerB = new JButton(questions.getAnswB());
        answerC = new JButton(questions.getAnswC());
        answerD = new JButton(questions.getAnswD());
        exitGame = new JButton("Izađi iz igre");
        fiftyFifty = new JButton("50:50");
        fiftyFifty.setBackground(Color.yellow);
        fiftyFifty.setToolTipText("50/50 uklanja dva kriva odgovora!");
        skipQuestion = new JButton("Preskoči pitanje");
        skipQuestion.setBackground(Color.yellow);
        skipQuestion.setToolTipText("Preskoči pitanje i napreduj na sljedeće cijenovno pitanje!");
        changeQuestion = new JButton("Promijeni pitanje");
        changeQuestion.setBackground(Color.yellow);
        changeQuestion.setToolTipText("Ostani na istom cijenovnom pitanju i promjeni pitanje!");
        questionArea = new JTextArea();
        questionArea.setColumns(60);
        questionArea.setRows(15);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setFont(questionArea.getFont().deriveFont(36f));
        setQuestionArea(questions.getQuestion());
        questionArea.setEditable(false);
        questionArea.setBorder(BorderFactory.createEtchedBorder());
        moneyCounter = new JTextArea("0€");
        moneyCounter.setEditable(false);
        questionCounter = new JTextArea("1 / 15");
        questionCounter.setEditable(false);
        System.out.println(questions.getCorrectAnswer()); // delete this; just for testing
        gameOver = new GameOver();
        questions.setCntr(0);
        ifChangeQuestionUsed = false;
        guaranteedMoney = "0€";
        guaranteedMoneyCntr = new JTextArea("0€");
        guaranteedMoneyCntr.setEditable(false);
    }

    private void componentLayout(){
        setLayout(new MigLayout());
        JPanel powerUps = new JPanel(new MigLayout());
        powerUps.setBorder(BorderFactory.createEtchedBorder());
        powerUps.add(exitGame);
        powerUps.add(Box.createHorizontalStrut(305));
        powerUps.add(fiftyFifty);
        powerUps.add(skipQuestion);
        powerUps.add(changeQuestion);
        add(powerUps, "north, aligny top");
        add(Box.createVerticalStrut(30), "wrap");
        JPanel questionZone = new JPanel(new MigLayout());
        questionZone.add(questionArea, "grow, height 200, width 500");
        add(questionZone, "center, grow");
        add(Box.createHorizontalStrut(70));
        JPanel trackers = new JPanel(new MigLayout());
        trackers.add(new JLabel("Broj Pitanja: "));
        trackers.add(questionCounter, "height 14, width 40");
        trackers.add(new JLabel("\n"), "wrap");
        trackers.add((new JLabel("Osvojeno: ")));
        trackers.add(moneyCounter, "height 14, width 60");
        trackers.add(new JLabel("\n"), "wrap");
        trackers.add(new JLabel("Garantirano    : "));
        trackers.add(guaranteedMoneyCntr, "height 14, width 60");
        add(trackers);
        add(Box.createVerticalStrut(20), "wrap");
        JPanel answers = new JPanel(new MigLayout("center"));
        answers.add(answerA, "height 75, width 200");
        answers.add(answerB, "height 75, width 200");
        answers.add(new JLabel("\n"), "wrap");
        answers.add(answerC, "height 75, width 200");
        answers.add(answerD, "height 75, width 200");
        add(answers, "dock south");
    }

    public void setQuestionArea(String question){
        questionArea.setText(question);
    }

    private void setMoneyCounter(String money){
        moneyCounter.setText(questions.getCurrentMoney() +"€");
    }

    private void setQuestionCounter(String question){
        questionCounter.setText(questions.getNumOfQuestion() +" / 15");
    }

    public void setGameAreaListener(GameAreaListener gal){
        this.gal = gal;
    }

    public void activateGameArea(){
        if (gal != null){
            answerA.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer = answerA.getText();
                    if (answer.equals(questions.getCorrectAnswer())){
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.GREEN);
                        JOptionPane.showMessageDialog(null, "Točan odgovor!", "Game Host", JOptionPane.INFORMATION_MESSAGE);
                        questions.rndQuestionSelector();
                        setQuestionArea(questions.getQuestion());
                        answerA.setText(questions.getAnswA());
                        answerB.setText(questions.getAnswB());
                        answerC.setText(questions.getAnswC());
                        answerD.setText(questions.getAnswD());
                        srcBtn.setBackground(null);
                        if (!answer.equals("null")){
                            questions.setCurrentMoney(questions.moneyPoolList[questions.noRepeats.size()-2]);
                        }
                        moneyWon = questions.getCurrentMoney() +"€";
                        setMoneyCounter(moneyWon);
                        setQuestionCounter(questions.getNumOfQuestion());
                        guaranteedMoneyCntr.setText(setGuaranteedMoney());
                        setGuaranteedMoney();
                        isAMillionaire();
                        System.out.println(getMoneyWon()); // delete this, just for testing
                        answerA.setEnabled(true);
                        answerB.setEnabled(true);
                        answerC.setEnabled(true);
                        answerD.setEnabled(true);
                    }else {
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.RED);
                        moneyWon = setGuaranteedMoney();
                        JOptionPane.showMessageDialog(null, "Nažalost "+ MainMenu.getThisName() +", odgovor nije točan.", "Game Host", JOptionPane.ERROR_MESSAGE);
                        gameOver = new GameOver();
                        activateGameOverInGameArea();
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameArea.this);
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(gameOver);
                        frame.repaint();
                        frame.revalidate();
                        System.out.println(questions.getCurrentMoney() +"€"); // delete this, just for testing
                    }
                    GameAreaEvent gae = new GameAreaEvent(this, answer);
                    gal.gameAreaBtnPressed(gae);
                }
            });
            answerB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer = answerB.getText();
                    if (answer.equals(questions.getCorrectAnswer())){
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.GREEN);
                        JOptionPane.showMessageDialog(null, "Točan odgovor!", "Game Host", JOptionPane.INFORMATION_MESSAGE);
                        questions.rndQuestionSelector();
                        setQuestionArea(questions.getQuestion());
                        answerA.setText(questions.getAnswA());
                        answerB.setText(questions.getAnswB());
                        answerC.setText(questions.getAnswC());
                        answerD.setText(questions.getAnswD());
                        srcBtn.setBackground(null);
                        if (!answer.equals("null")){
                            questions.setCurrentMoney(questions.moneyPoolList[questions.noRepeats.size()-2]);
                        }
                        moneyWon = questions.getCurrentMoney() +"€";
                        setMoneyCounter(moneyWon);
                        setQuestionCounter(questions.getNumOfQuestion());
                        guaranteedMoneyCntr.setText(setGuaranteedMoney());
                        setGuaranteedMoney();
                        isAMillionaire();
                        System.out.println(getMoneyWon()); // delete this, just for testing
                        answerA.setEnabled(true);
                        answerB.setEnabled(true);
                        answerC.setEnabled(true);
                        answerD.setEnabled(true);
                    }else {
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.RED);
                        moneyWon = setGuaranteedMoney();
                        JOptionPane.showMessageDialog(null, "Nažalost "+ MainMenu.getThisName() +", odgovor nije točan.", "Game Host", JOptionPane.ERROR_MESSAGE);
                        gameOver = new GameOver();
                        activateGameOverInGameArea();
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameArea.this);
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(gameOver);
                        frame.repaint();
                        frame.revalidate();
                        System.out.println(questions.getCurrentMoney() +"€"); // delete this, just for testing
                    }
                    GameAreaEvent gae = new GameAreaEvent(this, answer);
                    gal.gameAreaBtnPressed(gae);
                }
            });
            answerC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer = answerC.getText();
                    if (answer.equals(questions.getCorrectAnswer())){
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.GREEN);
                        JOptionPane.showMessageDialog(null, "Točan odgovor!", "Game Host", JOptionPane.INFORMATION_MESSAGE);
                        questions.rndQuestionSelector();
                        setQuestionArea(questions.getQuestion());
                        answerA.setText(questions.getAnswA());
                        answerB.setText(questions.getAnswB());
                        answerC.setText(questions.getAnswC());
                        answerD.setText(questions.getAnswD());
                        srcBtn.setBackground(null);
                        if (!answer.equals("null")){
                            questions.setCurrentMoney(questions.moneyPoolList[questions.noRepeats.size()-2]);
                        }
                        moneyWon = questions.getCurrentMoney() +"€";
                        setMoneyCounter(moneyWon);
                        setQuestionCounter(questions.getNumOfQuestion());
                        guaranteedMoneyCntr.setText(setGuaranteedMoney());
                        setGuaranteedMoney();
                        isAMillionaire();
                        System.out.println(getMoneyWon()); // delete this, just for testing
                        answerA.setEnabled(true);
                        answerB.setEnabled(true);
                        answerC.setEnabled(true);
                        answerD.setEnabled(true);
                    }else {
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.RED);
                        moneyWon = setGuaranteedMoney();
                        JOptionPane.showMessageDialog(null, "Nažalost "+ MainMenu.getThisName() +", odgovor nije točan.", "Game Host", JOptionPane.ERROR_MESSAGE);
                        gameOver = new GameOver();
                        activateGameOverInGameArea();
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameArea.this);
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(gameOver);
                        frame.repaint();
                        frame.revalidate();
                        System.out.println(questions.getCurrentMoney() +"€"); // delete this, just for testing
                    }
                    GameAreaEvent gae = new GameAreaEvent(this, answer);
                    gal.gameAreaBtnPressed(gae);
                }
            });
            answerD.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer = answerD.getText();
                    if (answer.equals(questions.getCorrectAnswer())){
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.GREEN);
                        JOptionPane.showMessageDialog(null, "Točan odgovor!", "Game Host", JOptionPane.INFORMATION_MESSAGE);
                        questions.rndQuestionSelector();
                        setQuestionArea(questions.getQuestion());
                        answerA.setText(questions.getAnswA());
                        answerB.setText(questions.getAnswB());
                        answerC.setText(questions.getAnswC());
                        answerD.setText(questions.getAnswD());
                        srcBtn.setBackground(null);
                        if (!answer.equals("null")){
                            questions.setCurrentMoney(questions.moneyPoolList[questions.noRepeats.size()-2]);
                        }
                        moneyWon = questions.getCurrentMoney() +"€";
                        setMoneyCounter(moneyWon);
                        setQuestionCounter(questions.getNumOfQuestion());
                        guaranteedMoneyCntr.setText(setGuaranteedMoney());
                        setGuaranteedMoney();
                        isAMillionaire();
                        System.out.println(getMoneyWon()); // delete this, just for testing
                        answerA.setEnabled(true);
                        answerB.setEnabled(true);
                        answerC.setEnabled(true);
                        answerD.setEnabled(true);
                    }else {
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.RED);
                        moneyWon = setGuaranteedMoney();
                        JOptionPane.showMessageDialog(null, "Nažalost "+ MainMenu.getThisName() +", odgovor nije točan.", "Game Host", JOptionPane.ERROR_MESSAGE);
                        gameOver = new GameOver();
                        activateGameOverInGameArea();
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameArea.this);
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(gameOver);
                        frame.repaint();
                        frame.revalidate();
                        System.out.println(questions.getCurrentMoney() +"€"); // delete this, just for testing
                        moneyWon = guaranteedMoney;
                    }
                    GameAreaEvent gae = new GameAreaEvent(this, answer);
                    gal.gameAreaBtnPressed(gae);
                }
            });
            exitGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object[] options = new Object[]{"Da", "Ne"};
                    int option = JOptionPane.showOptionDialog(null, "Želite li napustiti igru "+ MainMenu.getThisName() +"?", "Voditelj Igre", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (option == 0) {
                        gameOver = new GameOver();
                        activateGameOverInGameArea();
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameArea.this);
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(gameOver);
                        frame.repaint();
                        frame.revalidate();
                        GameAreaEvent gae = new GameAreaEvent(this);
                        gal.gameAreaBtnPressed(gae);
                        System.out.println(questions.getCurrentMoney() +"€"); // delete this, just for testing
                        moneyWon = questions.getCurrentMoney() +"€";
                    }
                }
            });
            fiftyFifty.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<JButton> lstOfBtns = new ArrayList<>();
                    lstOfBtns.add(answerA);
                    lstOfBtns.add(answerB);
                    lstOfBtns.add(answerC);
                    lstOfBtns.add(answerD);
                    int untilTwo = 0;
                    ArrayList<Integer> btns = new ArrayList<>();
                    while (untilTwo < 2){
                        int rndIndx = ThreadLocalRandom.current().nextInt(1, 4);
                        String selBtn = lstOfBtns.get(rndIndx).getText();
                        if (!selBtn.equals(questions.getCorrectAnswer())){
                            if(!btns.contains(rndIndx)){
                                lstOfBtns.get(rndIndx).setEnabled(false);
                                untilTwo++;
                            }
                        }
                        btns.add(rndIndx);
                    }
                    fiftyFifty.setEnabled(false);
                    fiftyFifty.setBackground(Color.red);
                    fiftyFifty.setForeground(Color.black);
                }
            });
            changeQuestion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    questions.rndQuestionSelector();
                    setQuestionArea(questions.getQuestion());
                    answerA.setText(questions.getAnswA());
                    answerB.setText(questions.getAnswB());
                    answerC.setText(questions.getAnswC());
                    answerD.setText(questions.getAnswD());
                    changeQuestion.setEnabled(false);
                    changeQuestion.setBackground(Color.red);
                    ifChangeQuestionUsed = true;
                }
            });
            skipQuestion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    questions.rndQuestionSelector();
                    setQuestionArea(questions.getQuestion());
                    answerA.setText(questions.getAnswA());
                    answerB.setText(questions.getAnswB());
                    answerC.setText(questions.getAnswC());
                    answerD.setText(questions.getAnswD());
                    skipQuestion.setEnabled(false);
                    skipQuestion.setBackground(Color.red);
                }
            });
        }
    }

    private void activateGameOverInGameArea(){
        gameOver.setGameOverListener(event -> {

        });
        gameOver.activateGameOver();
    }

    public static String getMoneyWon(){
        return moneyWon;
    }

    public static boolean isIfChangeQuestionUsed() {
        return ifChangeQuestionUsed;
    }

    private String setGuaranteedMoney(){
        switch (getMoneyWon()) {
            case "1.000€" -> {
                guaranteedMoney = "1.000€";
                return guaranteedMoney;
            }
            case "16.000€" -> {
                guaranteedMoney = "16.000€";
                return guaranteedMoney;
            }
            case "128.000€" -> {
                guaranteedMoney = "128.000€";
                return guaranteedMoney;
            }
            case "1.000.000€" -> {
                guaranteedMoney = "1.000.000€";
                return guaranteedMoney;
            }
        }
        return guaranteedMoney;
    }

    public void externalSetGMoney(){
        guaranteedMoney = "0€";
    }

    public void isAMillionaire(){
        if (questions.getLenOfNoRepeats() >= 16){
            gameOver = new GameOver();
            activateGameOverInGameArea();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameArea.this);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(gameOver);
            frame.repaint();
            frame.revalidate();
            GameAreaEvent gae = new GameAreaEvent(this);
            gal.gameAreaBtnPressed(gae);
            System.out.println(questions.getCurrentMoney() +"€"); // delete this, just for testing
            moneyWon = questions.getCurrentMoney() +"€";
        }
    }
}
