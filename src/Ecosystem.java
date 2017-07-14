import ecs100.UI;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * based on Nature of Code by Daniel Shiffman.
 */
public class Ecosystem {

    public static final int DELAY = 15;
    public static final double HEIGHT = 450;
    public static final double WIDTH = 700;
    public static final double TOP = 10;
    public static final double LEFT = 10;

    public static final double RIGHT = LEFT+WIDTH;
    public static final double BOTTOM = TOP+HEIGHT;


    public ArrayList<Entity> entities = new ArrayList<Entity>();


    public Ecosystem() {
        UI.initialise();
        UI.setImmediateRepaint(true);
        UI.setDivider(0);      // expands the graphics area

        // add a bunch of fly objects
        for (int i=0; i< 100; i++) {
            entities.add(new Fly(Math.random()*WIDTH, Math.random()*HEIGHT));
        }

        // add attractive object
        Fly attractive_fly = new Fly(Ecosystem.RIGHT / 2, Ecosystem. BOTTOM / 2);
        entities.add(attractive_fly);

        while (true) {
            UI.clearGraphics();

            for (Entity v: entities) {
                v.check_edges();
                PVector attact_force = attractive_fly.attract(v);
                v.applyForce(attact_force);
                v.update();
                v.draw();
            }

            draw_border();
            UI.sleep(DELAY);
        }
    }

    public static void draw_border() {
        UI.setColor(Color.black);
        UI.drawRect( LEFT, TOP, LEFT+WIDTH, TOP+HEIGHT);
    }

    public static void main(String[] args) {
        new Ecosystem();
    }
}
