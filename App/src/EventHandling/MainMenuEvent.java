package EventHandling;

import java.util.EventObject;

/**
 * Event class for the main menu.
 */
public class MainMenuEvent extends EventObject {

    /**
     * Attributes for the main menu event.
     */
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

    /**
     * Getter for the theme.
     * @return
     */
    public  String getTheme() {
        return theme;
    }

    /**
     * Getter for the name.
     * @return
     */
    public  String getName() {
        return name;
    }

    /**
     * Method that returns the string representation of the main menu event.
     * @return
     */
    @Override
    public String toString() {
        return "Dobrodošli u igru " + name + "! Odabrali ste temu: " + theme + ".";
    }
}
