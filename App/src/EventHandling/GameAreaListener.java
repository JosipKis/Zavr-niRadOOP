package EventHandling;

import java.util.EventListener;

/**
 * Game area listener interface.
 */
public interface GameAreaListener extends EventListener{

    /**
     * Method that is used as a listener for the buttons pressed
     * in the game area class.
     * @param event
     */
    void gameAreaBtnPressed(GameAreaEvent event);
}
