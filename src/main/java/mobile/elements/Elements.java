package mobile.elements;

import mobile.elements.element_actions.MobileElementActions;

public class Elements {
    public Elements() {
    }

    public static MobileElementActions elementActions() {
        return new MobileElementActions();
    }
}