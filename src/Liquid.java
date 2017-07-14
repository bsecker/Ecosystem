import ecs100.UI;

import java.awt.*;

/**
 * Created by Benjamin on 15-Jul-17.
 * Liquid of the ecosystem.
 */
public class Liquid {
    private static final double drag_coefficient = 1;
    private static Color water_color;

    public Liquid(Color c) {
        water_color = c;
    }

    public static double getDrag_coefficient() {
        return drag_coefficient;
    }


}
