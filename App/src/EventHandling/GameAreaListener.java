package EventHandling;

import java.util.EventListener;

public interface GameAreaListener extends EventListener{

    void answerBtnPressed(GameAreaEvent event);
}
