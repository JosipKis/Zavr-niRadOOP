package GameCode;

import javax.swing.*;

public class MainGameArea extends JFrame {

    private JButton btn5050;
    private JButton btnCall;
    private JButton btnAsk;
    private JButton btnExit;
    private JButton btnAnswerA;
    private JButton btnAnswerB;
    private JButton btnAnswerC;
    private JButton btnAnswerD;
    private JLabel lblQuestion;
    private JLabel lblQuestionNumber;
    private JLabel lblMoney;
    private JTextArea hostMessage;

    public MainGameArea(){
        super("Tko želi biti milijunaš!");
        setSize(800, 600);
        setIconImage(new ImageIcon("App/src/Images/WWTBAMUS2020Logo.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        createComponents();
        layoutComponents();
    }

    private void createComponents(){
        btn5050 = new JButton("50:50");
        btnCall = new JButton("Pozovi");
        btnAsk = new JButton("Pitaj");
        btnExit = new JButton("Završi igru");
        btnAnswerA = new JButton("A");
        btnAnswerB = new JButton("B");
        btnAnswerC = new JButton("C");
        btnAnswerD = new JButton("D");
        lblQuestion = new JLabel("Pitanje");
        lblQuestionNumber = new JLabel("Pitanje broj: ");
        lblMoney = new JLabel("Osvojili ste: ");
        hostMessage = new JTextArea();
    }

    private void layoutComponents(){
        setLayout(null);

        btn5050.setBounds(0, 0, 100, 50);
        add(btn5050);

        btnCall.setBounds(100, 0, 100, 50);
        add(btnCall);

        btnAsk.setBounds(200, 0, 100, 50);
        add(btnAsk);

        btnExit.setBounds(300, 0, 100, 50);
        add(btnExit);

        btnAnswerA.setBounds(0, 50, 100, 50);
        add(btnAnswerA);

        btnAnswerB.setBounds(100, 50, 100, 50);
        add(btnAnswerB);

        btnAnswerC.setBounds(200, 50, 100, 50);
        add(btnAnswerC);

        btnAnswerD.setBounds(300, 50, 100, 50);
        add(btnAnswerD);

        lblQuestion.setBounds(0, 100, 400, 50);
        add(lblQuestion);

        lblQuestionNumber.setBounds(0, 150, 400, 50);
        add(lblQuestionNumber);

        lblMoney.setBounds(0, 200, 400, 50);
        add(lblMoney);

        hostMessage.setBounds(0, 250, 400, 50);
        add(hostMessage);
    }

}
