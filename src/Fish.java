import ecs100.UI;
import java.awt.*;

/**
 * Created by Benjamin on 15-Jul-17.
 */
public class Fish extends Entity{
    double maxforce; // maximum "turning speed"

    public Fish(double x, double y) {
        super(x, y);

        this.topSpeed = 2;
        this.size = 10;
        this.mass = 1;
        this.color = Color.BLUE;
        this.maxforce = 0.05;

    }

    public void draw() {
        UI.setColor(this.color);
        UI.drawOval(location.getX() - size/2, location.getY() - size/2 , size, size);
    }

}
