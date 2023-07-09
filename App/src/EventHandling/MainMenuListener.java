package EventHandling;

import java.util.EventListener;

/**
 * Interface for the main menu listener.
 */
public interface MainMenuListener extends EventListener {

    /**
     * Listener for the Main menu button.
     * @param event
     */
    void startGameEventOccured(MainMenuEvent event);
}
