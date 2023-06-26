package GameCode;

import java.util.ArrayList;

public class Questions {

    private String question;
    private String answA;
    private String answB;
    private String answC;
    private String answD;
    private String correctAnswer;
    private String theme = MainMenu.getTheme();
    private String[] sportQuestions = new String[]{"Kojim profesionalnim sportom se bavio Ronnie Coleman?", "Koji od ovih vratara u nogometu je osvojio nagradu Ballon d'Or?"};
    private String[][] sportAnswerList = new String[][]{{"Nogomet", "Košarka", "Bodybuilding", "Kickboxing"},{"Lev Yashin", "Oliver Kahn", "Manuel Neuer", "Gianluigi Buffon"}};
    private String[] sportCorrectAnswer = new String[]{"Bodybuilding", "Lev Yashin"};
    private String[] videoGamesQuestions = new String[]{"Na kojoj konzoli je originalno izašla igra 'The Last of Us'?", "Tko je tvorac konzole Playstation?"};
    private String[][] videoGameAnswers = new String[][]{{"Playstation 4", "Playstation 3", "Playstation 2", "Xbox 360"}, {"Microsoft", "Sony", "Nintendo", "Acer"}};
    private String[] videoGamesCorrectAnswer = new String[]{"Playstation 3", "Sony"};
    ArrayList<Integer> noRepeats = new ArrayList<>();

    public Questions() {
        rndQuestionSelector();
    }

    private void rndQuestionSelector() {
        if (theme.equals("Sport")) {
            int rnd = (int) (Math.random() * sportQuestions.length);
            noRepeats.add(rnd);
            question = sportQuestions[rnd];
            String[] answers = sportAnswerList[rnd];
            for (String i : answers) {
                answA = answers[0];
                answB = answers[1];
                answC = answers[2];
                answD = answers[3];
            }
            correctAnswer = sportCorrectAnswer[rnd];
        } else {
            int rnd = (int) (Math.random() * videoGamesQuestions.length);
            noRepeats.add(rnd);
            question = videoGamesQuestions[rnd];
            String[] answers = videoGameAnswers[rnd];
            for (String i : answers) {
                answA = answers[0];
                answB = answers[1];
                answC = answers[2];
                answD = answers[3];
            }
            correctAnswer = videoGamesCorrectAnswer[rnd];
        }
    }

    public String getQuestion () {
        return question;
    }

    public String getAnswA () {
        return answA;
    }

    public String getAnswB () {
        return answB;
    }

    public String getAnswC () {
        return answC;
    }

    public String getAnswD () {
        return answD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
