package GameCode;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

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

    public GameArea(){
        createComponents();
        componentLayout();
    }

    private void createComponents(){
        questions = new Questions();
        answerA = new JButton(questions.getAnswA());
        answerB = new JButton(questions.getAnswB());
        answerC = new JButton(questions.getAnswC());
        answerD = new JButton(questions.getAnswD());
        exitGame = new JButton("Izađi iz igre");
        fiftyFifty = new JButton("50:50");
        skipQuestion = new JButton("Preskoči pitanje");
        changeQuestion = new JButton("Promijeni pitanje");
        questionArea = new JTextArea(15, 60);
        setQuestionArea(questions.getQuestion());
        questionArea.setEditable(false);
        questionArea.setBorder(BorderFactory.createEtchedBorder());

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

}
