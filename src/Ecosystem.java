import ecs100.UI;

/**
 * based on Nature of Code by Daniel Shiffman.
 */
public class Ecosystem {

    public static final int DELAY = 15;

    public Ecosystem() {
        UI.initialise();
        UI.setImmediateRepaint(true);
        UI.setDivider(0);      // expands the graphics area

        Fly mover = new Fly(300, 300);
        PVector wind = new PVector(0.1, 0);


        while (true) {
            UI.clearGraphics();
            mover.applyForce(wind);
            mover.update();
            mover.draw();
            UI.sleep(DELAY);
        }
    }

    public void redraw() {
        ;
    }

    public static void main(String[] args) {
        new Ecosystem();
    }
}
