package EventHandling;

import java.util.EventObject;

/**
 * Game over event class.
 */
public class GameOverEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public GameOverEvent(Object source) {
        super(source);
    }


}
