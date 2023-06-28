package GameCode;

import EventHandling.GameAreaEvent;
import EventHandling.GameAreaListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private Questions questions;
    private GameAreaListener gal;

    public GameArea(){
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
        skipQuestion = new JButton("Preskoči pitanje");
        changeQuestion = new JButton("Promijeni pitanje");
        Font font = new Font("Comic Sans", Font.BOLD, 12);
        questionArea = new JTextArea(15, 60);
        questionArea.setFont(font);
        setQuestionArea(questions.getQuestion());
        questionArea.setEditable(false);
        questionArea.setBorder(BorderFactory.createEtchedBorder());
        System.out.println(questions.getCorrectAnswer()); // delete this; just for testing
        activateGameArea();
    }

    private void componentLayout(){
        setLayout(new MigLayout());
        JPanel powerUps = new JPanel(new MigLayout());
        powerUps.setBorder(BorderFactory.createEtchedBorder());
        powerUps.add(exitGame);
        powerUps.add(Box.createHorizontalStrut(225));
        powerUps.add(fiftyFifty);
        powerUps.add(skipQuestion);
        powerUps.add(changeQuestion);
        add(powerUps, "north, aligny top");
        add(Box.createVerticalStrut(50), "wrap");
        JPanel questionZone = new JPanel(new MigLayout());
        questionZone.add(questionArea);
        add(questionZone, "center");
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
                        JOptionPane.showMessageDialog(null, "Točan odgovor!", "Bravo!", JOptionPane.INFORMATION_MESSAGE);
                        questions.rndQuestionSelector();
                        setQuestionArea(questions.getQuestion());
                        answerA.setText(questions.getAnswA());
                        answerB.setText(questions.getAnswB());
                        answerC.setText(questions.getAnswC());
                        answerD.setText(questions.getAnswD());
                        srcBtn.setBackground(null);
                    }else {
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Netočan odgovor", "Netočno...", JOptionPane.ERROR_MESSAGE);
                    }
                    GameAreaEvent gae = new GameAreaEvent(this, answer);
                    gal.answerBtnPressed(gae);
                }
            });
            answerB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer = answerB.getText();
                    if (answer.equals(questions.getCorrectAnswer())){
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.GREEN);
                        JOptionPane.showMessageDialog(null, "Točan odgovor!", "Bravo!", JOptionPane.INFORMATION_MESSAGE);
                        questions.rndQuestionSelector();
                        setQuestionArea(questions.getQuestion());
                        answerA.setText(questions.getAnswA());
                        answerB.setText(questions.getAnswB());
                        answerC.setText(questions.getAnswC());
                        answerD.setText(questions.getAnswD());
                        srcBtn.setBackground(null);
                    }else {
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Netočan odgovor", "Netočno...", JOptionPane.ERROR_MESSAGE);
                    }
                    GameAreaEvent gae = new GameAreaEvent(this, answer);
                    gal.answerBtnPressed(gae);
                }
            });
            answerC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer = answerC.getText();
                    if (answer.equals(questions.getCorrectAnswer())){
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.GREEN);
                        JOptionPane.showMessageDialog(null, "Točan odgovor!", "Bravo!", JOptionPane.INFORMATION_MESSAGE);
                        questions.rndQuestionSelector();
                        setQuestionArea(questions.getQuestion());
                        answerA.setText(questions.getAnswA());
                        answerB.setText(questions.getAnswB());
                        answerC.setText(questions.getAnswC());
                        answerD.setText(questions.getAnswD());
                        srcBtn.setBackground(null);
                    }else {
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Netočan odgovor", "Netočno...", JOptionPane.ERROR_MESSAGE);
                    }
                    GameAreaEvent gae = new GameAreaEvent(this, answer);
                    gal.answerBtnPressed(gae);
                }
            });
            answerD.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer = answerD.getText();
                    if (answer.equals(questions.getCorrectAnswer())){
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.GREEN);
                        JOptionPane.showMessageDialog(null, "Točan odgovor!", "Bravo!", JOptionPane.INFORMATION_MESSAGE);
                        questions.rndQuestionSelector();
                        setQuestionArea(questions.getQuestion());
                        answerA.setText(questions.getAnswA());
                        answerB.setText(questions.getAnswB());
                        answerC.setText(questions.getAnswC());
                        answerD.setText(questions.getAnswD());
                        srcBtn.setBackground(null);
                    }else {
                        JButton srcBtn = (JButton) e.getSource();
                        srcBtn.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Netočan odgovor", "Netočno...", JOptionPane.ERROR_MESSAGE);
                    }
                    GameAreaEvent gae = new GameAreaEvent(this, answer);
                    gal.answerBtnPressed(gae);
                }
            });
        }

    }

}
