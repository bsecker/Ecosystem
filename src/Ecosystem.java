import ecs100.UI;

/**
 * based on Nature of Code by Daniel Shiffman.
 */
public class Ecosystem {

    public static final int DELAY = 50;

    public Ecosystem() {
        UI.initialise();
        UI.setImmediateRepaint(true);
        UI.setDivider(0);      // expands the graphics area
        Fly mover = new Fly(300, 300);


        while (true) {
            UI.clearGraphics();
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
