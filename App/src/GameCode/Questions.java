package GameCode;

import java.io.File;
import java.util.ArrayList;

public class Questions {

    private String question;
    private String answA;
    private String answB;
    private String answC;
    private String answD;
    private String[] questions = new String[]{"Kojim profesionalnim sportom se bavio Ronnie Coleman?", "Koji od ovih vratara u nogometu je osvojio nagradu Ballon d'Or?"};
    private String[][] answerList = new String[][]{{"Nogomet", "Košarka", "Bodybuilding", "Kickboxing"},{"Lev Yashin", "Oliver Khan", "Manuel Neuer", "Gianluigi Buffon"}};

    public Questions() {
        rndQuestionSelector();
    }

    private void rndQuestionSelector(){
        int rnd = (int) (Math.random() * questions.length);
        question = questions[rnd];
        String[] answers = answerList[rnd];
        for (String i: answers){
            answA = answers[0];
            answB = answers[1];
            answC = answers[2];
            answD = answers[3];
        }
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswA() {
        return answA;
    }

    public String getAnswB() {
        return answB;
    }

    public String getAnswC() {
        return answC;
    }

    public String getAnswD() {
        return answD;
    }
}
