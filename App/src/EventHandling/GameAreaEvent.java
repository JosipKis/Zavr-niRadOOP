package EventHandling;

import java.util.EventObject;

/**
 * Game area event class.
 */
public class GameAreaEvent extends EventObject{

    /**
     * Attributes for the game area event class.
     */
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

    /**
     * Constructor for the game area event class.
     * @param source
     */
    public GameAreaEvent(Object source){
        super(source);
    }

    /**
     * Getter for the answer attribute.
     * @return
     */
    public String getAnswer() {
        return answer;
    }
}
