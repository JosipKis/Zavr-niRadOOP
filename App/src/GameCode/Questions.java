package GameCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Questions {

    private String question;
    private String answA;
    private String answB;
    private String answC;
    private String answD;
    private String correctAnswer;
    private String theme = MainMenu.getTheme();
    private String[] sportQuestions = new String[]{"Kojim profesionalnim sportom se bavio Ronnie Coleman?", "Koji od ovih vratara u nogometu je osvojio nagradu Ballon d'Or?", "Koliko nagrada Ballon d'Or je osvojio Pelé?", "Od kojeg kluba je Hajduk ispao iz četvrtine finala lige prvaka 1995. godine?", "Koji od ovih nogometnih reprezentacija nikad nije izgubila od Hrvatske reprezentacije?",
                                        "Koji Olimpijac ima najviše osvojenih zlatnih medalja s Olimpisjkih igara?", "Tko drži rekord za najviše zabijenih golova u jednoj sezoni engleske Premier lige?", "Koji od ovih NBA košarkaša ima najviše ukupnih postignutih poena?", "Koja od ovih nogometnih reprezentacija je osvojila prvo službeno FIFA svjetsko prvenstvo?",
                                        "Koji od ovih tenisača ima najviše osvojenih Grand Slam titula?", "Koja hokejaška reprezentacija ima najviše osvojenih hokejških svjetskih prvenstava?", "Koji je od ovih boksača nanio prvi poraz Mohammedu Aliu u njegovoj profesionalnoj karijeri?", "Koji je od ovih svjetskih prvaka Formule 1 prvi osvojio titulu prvaka?",
                                        "Koji od ovih trkača je prvi otrčao 1.6 kilometara ispod 4 minute?", "U kojem gradu je održano najviše ljetnih Olimpijskih igara?", "Koji od ponuđenih nogometaša je prvi osvojio naslov svjetskog prvaka kao igrač reprenzetacije i kao njezin izbornik?", "Koja reprezentacija ima najviše osvojenih svjetskih prvenstava u ragbiju?",
                                        "Koja država ima najviše osvojenih 'Toure de France' titula?", "U kojem od ovih nogometnih klubova Marko Livaja NIJE igrao?", "U nogometu 'offside' pravilo je uvedeno godine:"};
    private String[][] sportAnswerList = new String[][]{{"Nogomet", "Košarka", "Bodybuilding", "Kickboxing"},{"Lev Yashin", "Oliver Kahn", "Manuel Neuer", "Gianluigi Buffon"}, {"5", "2", "0", "1"}, {"Ajax", "Bayern Munchen", "Real Madrid", "Benfica"}, {"Francuska", "Portugal", "Italija", "Njemačka"}, {"Simeone Biles", "Usain Bolt", "Nadia Comanesci", "Michael Phelps"},
                                        {"Alan Shearer", "Cristiano Ronaldo", "Erling Haaland", "Thierry Henry"}, {"Kobe Bryant", "LeBron James", "Michael Jordan", "Shaquille O'Neal"}, {"Brazil", "Urugvaj", "Argentina", "Italija"}, {"Novak Đoković", "Rafael Nadal", "Steffi Graf", "Roger Federer"}, {"Kanada", "Finska", "Rusija/Sovjetski Savez", "Švedska"},
                                        {"Joe Frazier", "Ivan Drago", "George Foreman", "Larry Holmes"}, {"Aryton Senna", "Michael Schumacher", "Lewis Hamilton", "Juan Manuel Fangio"}, {"Usain Bolt", "Roger Bannister", "Sebastian Coe", "Steve Prefontaine"}, {"Tokyo", "Atena", "London", "Los Angeles"}, {"Mário Zagallo", "Diego Maradona", "Johan Cruyff", "Joachim Löw"},
                                        {"SAD", "Novi Zeland", "Australija", "Engleska"}, {"Francuska", "Italija", "SAD", "Španjolska"}, {"Atalanta", "Fiorentina", "Las Palmas", "Empoli"}, {"1933", "1889", "1863", "1971"}};
    private String[] sportCorrectAnswer = new String[]{"Bodybuilding", "Lev Yashin", "0", "Ajax", "Portugal", "Michael Phelps", "Erling Haaland", "LeBron James", "Urugvaj", "Novak Đoković", "Rusija/Sovjetski Savez", "Joe Frazier", "Juan Manuel Fangio", "Roger Bannister", "London", "Mário Zagallo", "Novi Zeland", "Francuska", "Fiorentina", "1863"};
    private String[] videoGamesQuestions = new String[]{"Na kojoj konzoli je originalno izašla igra 'The Last of Us'?", "Tko je tvorac konzole Playstation?"};
    private String[][] videoGameAnswers = new String[][]{{"Playstation 4", "Playstation 3", "Playstation 2", "Xbox 360"}, {"Microsoft", "Sony", "Nintendo", "Acer"}};
    private String[] videoGamesCorrectAnswer = new String[]{"Playstation 3", "Sony"};
    private ArrayList<Integer> noRepeats = new ArrayList<>();

    public Questions() {

    }

    public int rndQuestionSelector() {
        int rnd;
        if (theme.equals("Sport")) {
            while (true){
                rnd = (int) (Math.random() * sportQuestions.length);
                if (!noRepeats.contains(rnd)) {
                    break;
                }else {

                }
            }
            question = sportQuestions[rnd];
            String[] answers = sportAnswerList[rnd];
            answA = answers[0];
            answB = answers[1];
            answC = answers[2];
            answD = answers[3];
            correctAnswer = sportCorrectAnswer[rnd];
        }else {
            while(true){
                rnd = (int) (Math.random() * videoGamesQuestions.length);
                if (!noRepeats.contains(rnd)) {
                    break;
                }
            }
            question = videoGamesQuestions[rnd];
            String[] answers = videoGameAnswers[rnd];
            answA = answers[0];
            answB = answers[1];
            answC = answers[2];
            answD = answers[3];
            correctAnswer = videoGamesCorrectAnswer[rnd];
        }
        noRepeats.add(rnd);
        System.out.println(Arrays.toString(noRepeats.toArray())); // delete this, just for testing
        return rnd;
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
