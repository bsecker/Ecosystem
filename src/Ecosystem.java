import com.sun.org.apache.regexp.internal.RE;
import ecs100.UI;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * based on Nature of Code by Daniel Shiffman.
 */
public class Ecosystem {

    public static final int DELAY = 15;
    public static final double WIDTH = 900;
    public static final double HEIGHT = 600;
    public static final double TOP = 10;
    public static final double LEFT = 10;

    public static final double RIGHT = LEFT+WIDTH;
    public static final double BOTTOM = TOP+HEIGHT;


    public ArrayList<Entity> entities = new ArrayList<Entity>();


    public Ecosystem() {
        UI.initialise();
        UI.setWindowSize((int)RIGHT+30, (int) BOTTOM+10);
        UI.setImmediateRepaint(true);
        UI.setDivider(0);      // expands the graphics area

        // add a bunch of fly objects
        for (int i=0; i< 30; i++) {
            entities.add(new Fly(Math.random()*WIDTH, Math.random()*HEIGHT));
        }

        // add attractive object
        Fly attractive_fly = new Fly(Ecosystem.RIGHT / 2, Ecosystem. BOTTOM / 2);
        attractive_fly.setColor(Color.RED);
        entities.add(attractive_fly);

        // add repelling object
        Fly stinky_fly = new Fly(Math.random()*WIDTH, Math.random()*HEIGHT);
        stinky_fly.setColor(Color.BLUE);
        stinky_fly.size = 10;
        stinky_fly.repel_strength = 50;
        entities.add(stinky_fly);

        while (true) {
            UI.clearGraphics();

            for (Entity v: entities) {
                v.check_edges();

                PVector attact_force = attractive_fly.attract(v);
                v.applyForce(attact_force);

                PVector repel_force = stinky_fly.repel(v);
                v.applyForce(repel_force);

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
