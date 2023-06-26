package EventHandling;

import java.util.EventObject;

public class MainMenuEvent extends EventObject {

    private static String theme;
    private static String name;

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

    public static String getTheme() {
        return theme;
    }

    public static String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dobrodošli u igru " + name + "! Odabrali ste temu: " + theme + ".";
    }
}
