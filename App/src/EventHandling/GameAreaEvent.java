package EventHandling;

import java.util.EventObject;

public class GameAreaEvent extends EventObject{

    private String answer;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public GameAreaEvent(Object source, String answer) {
        super(source);
        this.answer = answer;
    }

    public GameAreaEvent(Object source){
        super(source);
    }

    public String getAnswer() {
        return answer;
    }
}
