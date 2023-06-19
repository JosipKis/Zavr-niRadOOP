package GameCode;

import java.util.EventObject;

public class MainMenuEvent extends EventObject {

    private String theme;
    private String name;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public MainMenuEvent(Object source, String theme, String name) {
        super(source);
        this.theme = theme;
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dobrodošli " + name + " u igru! Odabrali ste temu: " + theme + ".";
    }
}
