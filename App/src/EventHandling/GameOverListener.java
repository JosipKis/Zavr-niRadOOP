package EventHandling;

import java.util.EventListener;

public interface GameOverListener extends EventListener {

    void gameOverBtnPressed(GameOverEvent event);
}
