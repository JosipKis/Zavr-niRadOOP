package EventHandling;

import java.util.EventListener;

public interface MainMenuListener extends EventListener {

    void startGameEventOccured(MainMenuEvent event);
}
