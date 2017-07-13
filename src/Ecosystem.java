import ecs100.UI;

/**
 * based on Nature of Code by Daniel Shiffman.
 */
public class Ecosystem {

    public static final int DELAY = 30;

    public Ecosystem() {
        UI.initialise();
        UI.setImmediateRepaint(true);
        UI.setDivider(0);      // expands the graphics area
        Mover mover = new Mover(300, 300);


        while (true) {
            mover.update();
            mover.display();
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
