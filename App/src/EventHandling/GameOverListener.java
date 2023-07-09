package EventHandling;

import java.util.EventListener;

/**
 * Game over listener interface.
 */
public interface GameOverListener extends EventListener {

    /**
     * Method that is used as a listener for the buttons pressed
     * in the game over class.
     * @param event
     */
    void gameOverBtnPressed(GameOverEvent event);
}
