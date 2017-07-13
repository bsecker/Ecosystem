/**
 * Created by Benjamin on 13-Jul-17.
 * Test object.
 */
import ecs100.*;
import java.awt.*;

public class Mover {
    private PVector location;
    private PVector velocity;
    private PVector accelleration;

    double topSpeed;
    double size;

    public Mover(float x, float y) {
        this.location = new PVector(x, y);
        this.velocity = new PVector(0, 0);
        this.accelleration = new PVector(-4, 2);

        this.topSpeed = 4;
        this.size = 15;
    }

    public void update() {
        this.accelleration = PVector.random2d();
        this.accelleration.mult(2);

        this.velocity.add(this.accelleration);
        this.velocity.limit(this.topSpeed);
        this.location.add(this.velocity);

    }

    public void display() {
        UI.setColor(Color.black);
        UI.drawOval(location.getX() - size/2, location.getY() - size/2 , size, size);
    }
}
